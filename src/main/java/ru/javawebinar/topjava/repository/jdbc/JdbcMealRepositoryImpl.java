package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import javax.activation.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * User: gkislin
 * Date: 26.08.2014
 */

@Repository
public class JdbcMealRepositoryImpl implements MealRepository {
    private static final RowMapper<Meal> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Meal.class);

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public JdbcMealRepositoryImpl(javax.sql.DataSource dataSource) {
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("meals")
                .usingGeneratedKeyColumns("id");

    }

    @Override
    public Meal save(Meal meal, int userId) {
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", meal.getId())
                .addValue("calories", meal.getCalories())
                .addValue("description",meal.getDescription())
                .addValue("datetime",meal.getDateTime())
                .addValue("user_id",userId);
        if (meal.isNew()) {
            Number newKey = jdbcInsert.executeAndReturnKey(map);
            meal.setId(newKey.intValue());
        } else {
            namedJdbcTemplate.update("UPDATE meals SET calories=:calories, description:=description, " +
                    "datetime = :datetime, user_id = : user_id WHERE id =:id", map);
        }
        return meal ;
    }

    @Override
    public boolean delete(int id, int userId) {
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("userId",userId);
        return namedJdbcTemplate.update("DELETE FROM meals WHERE id=:id AND userId=:userId",map)!=0;
    }

    @Override
    public Meal get(int id, int userId) {
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("userId",userId);
        List<Meal> list = namedJdbcTemplate.query("SELECT * FROM meals " +
                        "WHERE id=:id AND user_id=:userId",map, ROW_MAPPER);
        return DataAccessUtils.singleResult(list);
    }

    @Override
    public List<Meal> getAll(int userId) {
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("userId",userId);
        return namedJdbcTemplate.query("SELECT * FROM meals " +
                "WHERE user_id=:userId",map, ROW_MAPPER);

    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        SqlParameterSource map = new MapSqlParameterSource()
                .addValue("startDate", Timestamp.valueOf(startDate))
                .addValue("endDate",Timestamp.valueOf(endDate))
                .addValue("userId",userId);
        return namedJdbcTemplate.query("SELECT * FROM meals WHERE dateTime>=:startDate AND dateTime<endDate AND user_id=:userId" +
                        " ORDER BY datetime DESC",map,ROW_MAPPER);
    }
}

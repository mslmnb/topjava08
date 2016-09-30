package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Formatter;

/**
 * User: gkislin
 * Date: 26.08.2014
 */

@Repository
public class JdbcMealRepositoryImpl implements MealRepository {

    private static final RowMapper<Meal> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Meal.class);

    public static void main(String[] args) {
        ApplicationContext appCntx = new ClassPathXmlApplicationContext("classpath:spring/spring-app.xml", "classpath:spring/spring-db.xml");
        DataSource dataSource = appCntx.getBean(DataSource.class);
        JdbcMealRepositoryImpl mealRepository = new JdbcMealRepositoryImpl(dataSource);
        mealRepository.jdbcTemplate = appCntx.getBean((JdbcTemplate.class));
        mealRepository.namedParameterJdbcTemplate = appCntx.getBean((NamedParameterJdbcTemplate.class));
        //System.out.println("сохранен " + mealRepository.save(new Meal(null,LocalDateTime.now(),"ggggg123",11253),100000));
        //System.out.println("сохранен " + mealRepository.save(new Meal(null,LocalDateTime.now(),"ggggg123",11253),100000));
        //System.out.println("сохранен " + mealRepository.save(new Meal(null,LocalDateTime.now(),"ggggg123",11253),100001));
        //System.out.println("удален " + mealRepository.delete(100006,100000));
        //System.out.println("удален " + mealRepository.delete(100007,100001));

        //System.out.println("Еда 100012: " + mealRepository.get(100012,100000));

/*        System.out.println("Еда пользователя 100000: ");
        System.out.println(mealRepository.getAll(100000));
        System.out.println("Еда пользователя 100001: ");
        System.out.println(mealRepository.getAll(100001));
        mealRepository.delete(100004,100000);
        System.out.println("Еда пользователя 100001 после удаления: ");
        System.out.println(mealRepository.getAll(100002));
*/
        System.out.println(mealRepository.getBetween(LocalDateTime.MIN,LocalDateTime.MAX,2222));
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertMeal;

    public JdbcMealRepositoryImpl(DataSource dataSource) {
        this.insertMeal = new SimpleJdbcInsert(dataSource)
                .withTableName("meals")
                .usingGeneratedKeyColumns("id");

    }

    @Override
    public Meal save(Meal meal, int userId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", meal.getId())
                .addValue("user_id", userId)
                .addValue("datetime", meal.getDateTime())
                .addValue("description", meal.getDescription())
                .addValue("calories", meal.getCalories());

        if (meal.isNew()) {
            Number newId = insertMeal.executeAndReturnKey(map);
            meal.setId(newId.intValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE meals SET user_id=:user_id, datetime=:datetime, " +
                            "description=:description, calories=:calories WHERE id=:id",map);
        }

        return meal;
    }

    @Override
    public boolean delete(int id, int userId) {
        return jdbcTemplate.update("DELETE FROM meals WHERE id = ? AND user_id = ?", id, userId)!=0;
    }

    @Override
    public Meal get(int id, int userId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("userId", userId);
        List<Meal> list = namedParameterJdbcTemplate.query("SELECT * FROM meals WHERE id = :id AND user_id = :userId ", sqlParameterSource, ROW_MAPPER);
        return DataAccessUtils.singleResult(list);
    }

    @Override
    public List<Meal> getAll(int userId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("userId", userId);
        return namedParameterJdbcTemplate.query("SELECT * FROM meals WHERE user_id=:userId", sqlParameterSource,ROW_MAPPER);
    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("startDate",startDate.format(dateFormatter))
                .addValue("endDate",endDate.toString())
                .addValue("userId",userId);
        namedParameterJdbcTemplate.query("SELECT * FROM meals WHERE (datetime BETWEEN '" + startDate.format(dateFormatter) +
                    "' AND '" + endDate.format(dateFormatter) + "'",sqlParameterSource,ROW_MAPPER);
        return null;
    }
}

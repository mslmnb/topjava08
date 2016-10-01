package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.DbPopulator;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by Gala on 30.09.2016.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)

public class MealServiceTest {
    @Autowired
    protected DbPopulator dbPopulator;

    @Autowired
    protected MealService mealService;

    protected final static ModelMatcher matcher = new ModelMatcher();

    @Test
    public void get() throws Exception {

        Meal newMeal = mealService.save(new Meal(LocalDateTime.now(),"пример", 222),100000);
        Meal meal = mealService.get(newMeal.getId(),100000);
        matcher.assertEquals(newMeal, meal);


    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getBetweenDates() throws Exception {

    }

    @Test
    public void getBetweenDateTimes() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void save() throws Exception {

    }

}
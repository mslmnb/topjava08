package ru.javawebinar.topjava.web.meal;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.web.meal.MealRestController.REST_URL;

/**
 * GKislin
 * 06.03.2015.
 */
@RestController
@RequestMapping(MealRestController.REST_URL)

public class MealRestController extends AbstractMealController {
    static final String REST_URL = "/rest/meals";

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Meal get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MealWithExceed> getAll() {
        return super.getAll();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Meal meal, @PathVariable("id") int id) {
        super.update(meal, id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createWithLocation(@RequestBody Meal meal) {
        Meal created =  super.create(meal);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()  // создаем URI для созданного Meal, котрый потом добавляем в заголовок ответа
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();


        return ResponseEntity.created(uriOfNewResource).body(created); //<-- должны вернуть 201 (код created)
        //return new ResponseEntity<>(created, HttpStatus.CREATED);        // упрощенный вариант
    }

    @GetMapping(value="/between", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MealWithExceed> getBetween(@RequestParam("startDate") LocalDate startDate,
                                           @RequestParam("startTime") LocalTime startTime,
                                           @RequestParam("endDate") LocalDate endDate,
                                           @RequestParam("endTime") LocalTime endTime) {
        return super.getBetween(startDate, startTime, endDate, endTime);
    }
}

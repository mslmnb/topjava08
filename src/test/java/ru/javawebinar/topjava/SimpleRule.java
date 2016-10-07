package ru.javawebinar.topjava;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Mussulmanbekova_GE on 06.10.2016.
 */
public class SimpleRule implements TestRule{
    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(TestRule.class);

    @Override
    public Statement apply(Statement baseStatement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                LOG.info(description+ "!!!!! " +LocalDateTime.now().toString());
                baseStatement.evaluate();
            }
        };
    }
}

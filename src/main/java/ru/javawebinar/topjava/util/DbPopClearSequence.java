package ru.javawebinar.topjava.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

/**
 * Created by Mussulmanbekova_GE on 28.09.2016.
 */
public class DbPopClearSequence extends ResourceDatabasePopulator {
    private static final ResourceLoader RESOURCE_LOADER = new DefaultResourceLoader();

    @Autowired
    private DataSource dataSource;

    public DbPopClearSequence(String scriptLocation) {
        super(RESOURCE_LOADER.getResource(scriptLocation));
    }

    public void execute() {
        DatabasePopulatorUtils.execute(this, dataSource);
    }
}

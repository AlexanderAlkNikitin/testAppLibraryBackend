package com.anikitin.library.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import static org.junit.Assert.*;

/**
 * Created by anikitin on 28.09.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class JpaConfigTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private DataSource dataSource;
    @Test
    public void entityManagerFactory() throws Exception {
        assertNotNull(entityManagerFactory.createEntityManager().getMetamodel());
    }

    @Test
    public void getDataSource() throws Exception {
        assertEquals("library",dataSource.getConnection().getSchema());
    }

}
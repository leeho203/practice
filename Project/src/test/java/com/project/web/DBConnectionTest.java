package com.project.web;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/*.xml" })
public class DBConnectionTest {

    @Autowired
    private DataSource ds;
   
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    public void dataSourceTest() throws SQLException {
        try (Connection con = ds.getConnection()) {
            assertNotNull(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sqlSessionFactoryTest() {
        assertNotNull(sqlSessionFactory);
    }

    @Test
    public void sqlSessionTest() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            assertNotNull(sqlSession);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
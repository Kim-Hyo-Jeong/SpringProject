package com.example.myapp.jdbc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/example/myapp/jdbc/application-config.xml")
@Log4j
public class OracleJDBCTests {

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("����̹� �ε� ����");
        } catch (ClassNotFoundException e) {
            log.error("����̹� �ε� ����", e);
        }
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test(timeout = 3000)
    public void testConnection() {
        try (Connection con = jdbcTemplate.getDataSource().getConnection()) {
            log.info("DB ���� ����: " + con);
            assertNotNull(con);
        } catch (Exception e) {
            log.error("DB ���� ����", e);
            fail(e.getMessage());
        }
    }
}

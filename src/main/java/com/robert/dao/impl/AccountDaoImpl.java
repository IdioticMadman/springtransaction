package com.robert.dao.impl;

import com.robert.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

/**
 * Created by robert on 2017/7/18.
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AccountDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void in(String account, Double money) {
        String sql = "UPDATE account SET money = money+? WHERE name = ?";
        jdbcTemplate.update(sql, money, account);
    }

    public void out(String account, Double money) {
        String sql = "UPDATE account SET money = money-? WHERE name = ?";
        jdbcTemplate.update(sql, money, account);
    }
}

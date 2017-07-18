package com.robert.dao;

/**
 * Created by robert on 2017/7/18.
 */
public interface AccountDao {

    void in(String account, Double money);

    void out(String account, Double money);
}

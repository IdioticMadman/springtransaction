package com.robert.service.impl;

import com.robert.dao.AccountDao;
import com.robert.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by robert on 2017/7/18.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = ArithmeticException.class)
    public void transfer(String out, String in, Double money) {
        accountDao.out(out, money);
        int i = 1 / 0;
        accountDao.in(in, money);
    }
}

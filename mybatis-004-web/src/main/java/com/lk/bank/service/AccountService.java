package com.lk.bank.service;

import com.lk.bank.exceptions.MoneyNotEnoughException;
import com.lk.bank.exceptions.TransferException;

public interface AccountService {
    void transfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, TransferException;
}

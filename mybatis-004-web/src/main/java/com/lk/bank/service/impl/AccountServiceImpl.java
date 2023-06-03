package com.lk.bank.service.impl;

import com.lk.bank.dao.AccountDao;
import com.lk.bank.dao.impl.AccountDaoImpl;
import com.lk.bank.exceptions.MoneyNotEnoughException;
import com.lk.bank.exceptions.TransferException;
import com.lk.bank.pojo.Account;
import com.lk.bank.service.AccountService;
import com.lk.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao =new AccountDaoImpl();


    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException {

        //添加事务控制代码
        SqlSession sqlSession = SqlSessionUtil.openSession();

        //1.判断转出账户的余额是否充足（select）
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance()<money){
            //2.如果余额不充足就提示用户
            throw new MoneyNotEnoughException("对不起，余额不足");
        }
        //3.如果转出账户余额充足，更新转出账户余额（update）
        //先更新内存中java对象account的余额
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance()-money);
        toAct.setBalance(toAct.getBalance()+money);
        int count =accountDao.updateByActno(fromAct);
        count +=accountDao.updateByActno(toAct);
        if (count !=2 ){
            throw new TransferException("转账异常，未知原因");
        }

        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
}

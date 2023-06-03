package com.lk.bank.dao;

import com.lk.bank.pojo.Account;

public interface AccountDao {
    /**
     * 根据账号查询账户信息
     * @param actno 账号
     * @return 账户信息
     */
    Account selectByActno(String actno);


    /**
     * 更新账户信息
     * @param act 被更新的账户对象
     * @return 1表示更新成功，其他值表示失败
     */
    int updateByActno(Account act);
}

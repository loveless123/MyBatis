package com.lk.bank.web;

import com.lk.bank.exceptions.MoneyNotEnoughException;
import com.lk.bank.exceptions.TransferException;
import com.lk.bank.service.AccountService;
import com.lk.bank.service.impl.AccountServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    private AccountService accountService =new AccountServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));
        //调用service的转账方法完成转账（调业务层）
        try {
            accountService.transfer(fromActno,toActno,money);
            response.sendRedirect(request.getContextPath()+"/success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect(request.getContextPath()+"/error1.html");
        } catch (TransferException e) {
            response.sendRedirect(request.getContextPath()+"/error2.html");
        }
    }
}

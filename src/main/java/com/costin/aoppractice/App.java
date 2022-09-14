package com.costin.aoppractice;

import com.costin.aoppractice.config.AppConfig;
import com.costin.aoppractice.dao.Account;
import com.costin.aoppractice.dao.AccountDAO;
import com.costin.aoppractice.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        accountDAO.addAccount(new Account("contul lui costin"), true);

        accountDAO.addAccount(new Account("celalalt cont al lui costin"), true);


        //        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
//
//        membershipDAO.addAccount("abonat_puternic");

        List<Account> accounts = null;

        try {
            boolean tripWire = false;
            accounts = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\nMain Program caught exception: " + e);
        }

        System.out.println("The result from MAIN: " + accounts);

        context.close();
    }

}

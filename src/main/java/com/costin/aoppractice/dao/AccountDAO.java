package com.costin.aoppractice.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private String name;
    private List<Account> accounts;

    public void addAccount(Account account, boolean valid) {
        System.out.println(getClass() + ": Adding the account to database...");
        if(valid) {
            if(accounts == null) {
                accounts = new ArrayList<>();
            }
            accounts.add(account);
        }
    }

    public List<Account> findAccounts(boolean tripWire) throws Exception {
        if (tripWire) {
            throw new RuntimeException("cacat pe varza nu merge");
        }
        return this.accounts;
    }

    public String getName() {
        System.out.println(getClass() + ": in getter...");
        return name;
    }
    public void setName(String name) {
        System.out.println(getClass() + ": in setter...");
        this.name = name;
    }

}

package com.costin.aoppractice.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public int addAccount(String membershipType) {
        System.out.println(getClass() + ": Adding the account to database...");
        return 100;
    }

}

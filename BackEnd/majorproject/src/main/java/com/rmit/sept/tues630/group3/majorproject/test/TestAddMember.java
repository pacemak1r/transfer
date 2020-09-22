package com.rmit.sept.tues630.group3.majorproject.test;

import com.rmit.sept.tues630.group3.majorproject.model.Account;
import com.rmit.sept.tues630.group3.majorproject.services.TeamManagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Collection;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestAddMember {

    TeamManagement add = new TeamManagement();
    Collection<Account> teamMembers = new ArrayList<>();
    Account member1;
    Account member2;
    Account member3;
    @BeforeEach
    public void setup(){
        member1 = new Account("Alan","Du", "2215518450", "000", "0474880181", "banking",20.00,4);
        member2 = new Account("Tommy","Ao", "caramel", "000", "0484135441", "banking",20.00,4);
        member3 = new Account("Alan","Du", "2215518450", "000", "0474880181", "banking");

        add.addWorker(member1);
        add.addWorker(member2);



    }
    @Test
    public void Test_Success_AddMembers(){
        Account member4 = new Account("Oscar","Ling", "oscarling", "222", "0541225487", "banking",15.00,3);
        add.addWorker(member4);
        Assertions.assertEquals(3 ,add.getAllWorker().size());
    }

    @Test
    public void Test_Fail_AddMembers(){
        add.addWorker(member3);
        Assertions.assertFalse(add.getAllWorker().size()== 3 );
    }

}
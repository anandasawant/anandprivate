package com.week2.casestudy.service;

import com.week2.casestudy.domain.BankAccount;
import com.week2.casestudy.exception.InvalidAcHlNameException;
import com.week2.casestudy.exception.InvalidAmountException;

import java.util.List;

public interface BankService {

    void createNewAccount(BankAccount ba);//done

    int updateAccountDetails(BankAccount ba);//done

    boolean activateAccount(Long acNum);//done

    boolean deActivateAccount(Long acNum);//done

    double withdraw(Long acNum, double amt)throws InvalidAmountException;//done

    double deposit(Long acNum, double amt)throws InvalidAmountException;//done

    int transferMoney(Long srcAc, Long dstAc, double amt)throws InvalidAmountException;;

    List <BankAccount>findAccountByAcNum(Long acNum);//done

    List<BankAccount> findAllBankAccounts();//done

    List<BankAccount> namesStartsWith(String prefix)throws InvalidAcHlNameException;//done
}

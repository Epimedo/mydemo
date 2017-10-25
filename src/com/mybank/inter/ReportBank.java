package com.mybank.inter;
import com.mybank.domain.*;
public class ReportBank{
  protected Bank Bank;

public Bank getBank() {
	return Bank;
}
public void Report(Bank bank)
{
	Bank = bank;
	System.out.println("Report");
	System.out.println("======");
    for(int i=0;i<Bank.getNumberOfCustomers();i++)
    {
    	Customer customer = bank.getCustomer(i);
    	System.out.print(customer.getFname() + " ");
    	System.out.println(customer.getLname());
    	System.out.println("Customer's accounts");
    	for(int j = 0;j<customer.getNumberOfAccounts();j++)
    	{
    		if(customer.getAccount(j).getClass().equals(ChekingAccount.class))
    		{
    			System.out.println("Checking Account's balance:");
    			System.out.println(customer.getAccount(j).getBalance());
    		}
    		if(customer.getAccount(j).getClass().equals(SavingAccount.class))
    		{
    			System.out.println("SAving Account's balance:");
    			System.out.println(customer.getAccount(j).getBalance());
    		}
    		System.out.println("Account's balance");
    		System.out.println(customer.getAccount(j).getBalance());
    	}
    }
}
}

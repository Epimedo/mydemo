package com.mybank.domain;

import org.apache.commons.lang.builder.EqualsBuilder;

public class SavingAccount extends Account {
	private double Factor=1.7;
	public SavingAccount(double balance)
	{
		super(balance);
	}
	public SavingAccount(double balance,double anFactor)
	{
		super(balance);
		Factor = anFactor;
	}
   public void deposit(double input)
   {
	   super.deposit(input*Factor);
   }
   public boolean equals(Object obj)
  	{
  		if(this == obj)
  			return true;
  		if(obj == null || this.getClass()!=obj.getClass())
  			return false;
  		SavingAccount account = (SavingAccount)obj;
  		return new EqualsBuilder().append(balance, account.balance).append(Factor, account.Factor).isEquals();
  	}
}

package com.mybank.domain;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
public class Account {
	protected double balance;
	public Account()
	{
		super();
	}
	public Account(double abalance) {
		super();
		balance = abalance;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double input)
	{
		balance +=input;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void withdrow(double output) throws OverdraftException
	{
		if(output<balance) {
			balance-=output;
			return;
		}
		throw new OverdraftException("Not enough money",output-balance);
	}
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null || this.getClass()!=obj.getClass())
			return false;
		Account account = (Account)obj;
		return new EqualsBuilder().append(balance, account.balance).isEquals();
	}
	 public int hashCode()
	    {
	    	return new HashCodeBuilder(9,19).append(balance).toHashCode();
	    }
}

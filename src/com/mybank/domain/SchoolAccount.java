package com.mybank.domain;

import com.mybank.inter.Pupils;

public class SchoolAccount extends Account {

	public SchoolAccount(double abalance) {
		super((abalance>100)?0:abalance);
	}
	public void deposit(double input)
	{
		if(balance + input>100)
		{
			System.out.println("Account's limit is exceeded" + " " + "Pls remeber that it is school account");
			return;
		}
		balance+=input;
	}
	public void withdrow(double output) throws OverdraftException
	{
		if(output>balance)
			throw new OverdraftException("Not enough mony",output - balance);
		balance-=output;
	}

}

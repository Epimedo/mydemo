package com.mybank.domain;
import Main.*;
import org.apache.commons.lang.builder.EqualsBuilder;

public class ChekingAccount extends Account{
    private int overdraft;
    public int getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(int overdraft) {
		this.overdraft = overdraft;
	}
	public void withdrow(double output) throws OverdraftException
	{
		if(balance-output>overdraft) {
			balance-=output;
			if(balance<0)
				throw new OverdraftException("No overdraft protection", (-1)*balance);
			return;
		}
		throw new OverdraftException("Not enough money",balance+(-1)*overdraft - output);
	}
    public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null || this.getClass()!=obj.getClass())
			return false;
		ChekingAccount account = (ChekingAccount)obj;
		return new EqualsBuilder().append(balance, account.balance).append(overdraft, account.overdraft).isEquals();
	}
}

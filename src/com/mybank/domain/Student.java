package com.mybank.domain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.mybank.inter.Individuals;
import com.mybank.inter.Pupils;

import Main.*;
public class Student extends Customer implements Pupils,Individuals  {

	private String PlaceOfEducation;
	public Student(Account anaccount, String fname, String lname) {
		super(anaccount, fname, lname);
	}
    public void setAccount(Account account)
    {
    	if(account.getClass().equals(ChekingAccount.class))
    		{
    		  System.out.println("Students can't use cheking account");
    		return;
    		}
    	super.setAccount(account);
    }
    public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null || this.getClass()!=obj.getClass())
			return false;
		Student customer = (Student)obj;
		if(new EqualsBuilder().append(PlaceOfEducation,customer.PlaceOfEducation).append(Fname, customer.Fname).append(Lname,customer.Lname).append(accounts.size(),customer.getNumberOfAccounts()).isEquals())
		{
		for(int i =0;i<accounts.size();i++)
		if(!accounts.get(i).equals(customer.getAccount(i)))
		return false;
		return true;
		}
	    return false;
	}
	public void setPlaceOfEducation(String placeOfEducation) {
		PlaceOfEducation = placeOfEducation;
	}
	@Override
	public int hashCode()
	{
		int HashSum = 0;
		for(int i =0;i<accounts.size();i++)
			HashSum+=accounts.get(i).hashCode();
		return new HashCodeBuilder(9,19).append(Fname).append(Lname).append(PlaceOfEducation).toHashCode()+HashSum;
	}
	@Override
	public void getPlaceOfEducation() {
		System.out.println(PlaceOfEducation);
		
	}
    
}

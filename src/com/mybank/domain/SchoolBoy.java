package com.mybank.domain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.mybank.inter.Pupils;

import Main.*;
public class SchoolBoy extends Customer implements Pupils {
    private String PlaceOfEducation;
	public SchoolBoy(Account anaccount, String fname, String lname,String placeofeducation) {
		super(anaccount, fname, lname);
		PlaceOfEducation = placeofeducation;
	}
	public void setPlaceOfEducation(String placeOfEducation) {
		PlaceOfEducation = placeOfEducation;
	}
	public void setAccount(Account account)
	{
		if(!account.getClass().equals(SchoolAccount.class))
		{
			System.out.println("School customer can have only school account");
			return;
		}
		super.setAccount(account);
	}
	@Override
	public void getPlaceOfEducation() {
		System.out.println(PlaceOfEducation);
		
	}
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null || this.getClass()!=obj.getClass())
			return false;
		SchoolBoy customer = (SchoolBoy)obj;
		if(new EqualsBuilder().append(PlaceOfEducation,customer.PlaceOfEducation).append(Fname, customer.Fname).append(Lname,customer.Lname).append(accounts.size(),customer.getNumberOfAccounts()).isEquals())
		{
		for(int i =0;i<accounts.size();i++)
		if(!accounts.get(i).equals(customer.getAccount(i)))
		return false;
		return true;
		}
	    return false;
	}
	@Override
	public int hashCode()
	{
		int HashSum = 0;
		for(int i =0;i<accounts.size();i++)
			HashSum+=accounts.get(i).hashCode();
		return new HashCodeBuilder(9,19).append(Fname).append(Lname).append(PlaceOfEducation).toHashCode()+HashSum;
	}
}

package com.mybank.domain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.mybank.inter.LegalEntities;
import com.mybank.inter.State;

/**
 * для создания государственных учериждени различных сфер деятельности
 */
import Main.*;
public class PublicOffice extends Customer implements LegalEntities,State {
    private String iFounder;
    
    private String Orbit;
	public PublicOffice(Account anaccount, String fname, String lname,String aFounder,String orbit) {
		super(anaccount, fname, lname);
		iFounder = aFounder;
		Orbit=orbit;
	}
	@Override
	public String getFounder() {
		return iFounder;
	}
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null || this.getClass()!=obj.getClass())
			return false;
		PublicOffice customer = (PublicOffice)obj;
		if(new EqualsBuilder().append(Orbit,customer.Orbit).append(iFounder,customer.iFounder).append(Fname, customer.Fname).append(Lname,customer.Lname).append(accounts.size(),customer.getNumberOfAccounts()).isEquals())
		{
		for(int i =0;i<accounts.size();i++)
		if(!accounts.get(i).equals(customer.getAccount(i)))
		return false;
		return true;
		}
	    return false;
	}
	public void setOrbit(String orbit) {
		Orbit = orbit;
	}
	@Override
	public String getOrbit() {
		return Orbit;
	}
	@Override
	public int hashCode()
	{
		int HashSum = 0;
		for(int i =0;i<accounts.size();i++)
			HashSum+=accounts.get(i).hashCode();
		return new HashCodeBuilder(9,19).append(Fname).append(Lname).append(iFounder).append(Orbit).toHashCode()+HashSum;
	}
	}

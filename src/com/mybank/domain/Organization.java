package com.mybank.domain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.mybank.inter.LegalEntities;

/**
 * для создания обычных коммерческих организаций
 */
import Main.*;
public class Organization extends Customer implements LegalEntities {
	 private String iFounder;
		public Organization(Account anaccount, String fname, String lname,String aFounder) {
			super(anaccount, fname, lname);
			iFounder = aFounder;
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
			Organization customer = (Organization)obj;
			if(new EqualsBuilder().append(iFounder,customer.iFounder).append(Fname, customer.Fname).append(Lname,customer.Lname).append(accounts.size(),customer.getNumberOfAccounts()).isEquals())
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
			return new HashCodeBuilder(9,19).append(Fname).append(Lname).append(iFounder).toHashCode()+HashSum;
		}
		}

package com.mybank.domain;

import java.awt.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
/** Объект банка,имеет несколько ползователей разного типа
 * 
 * @author Halavin Egor
 *
 */
public class Bank {
	public static ArrayList<Customer> getCustomers() {
		return customers;
	}
	public static void setCustomers(ArrayList<Customer> customers) {
		Bank.customers = customers;
	}
	private static ArrayList<Customer> customers = new ArrayList<Customer>(10);
	public Bank(){}
	public static void addCustomer(Customer customer)
	{
		customers.add(customer);
	}
	public int getNumberOfCustomers() {
		return customers.size();
	}
    public Customer getCustomer(int i)
    {
    	return customers.get(i);
    }
    @Override
    public boolean equals(Object obj)
    {
    	if(this==obj)
    		return true;
    	if(obj==null || this.getClass()!=obj.getClass())
    		return false;
    	Bank bank = (Bank) obj;
    	if(new EqualsBuilder().append(customers.size(),bank.getNumberOfCustomers()).isEquals())
    	    {
    		   for(int i=0;i<customers.size();i++)
    	       if(!customers.get(i).equals(bank.getCustomer(i)))
    	    	   return false;
    		   return true;
    	    }	
    	return false;
    }
    @Override
    public int hashCode()
    {
    	int HashSum = 0;
    	for(int i=0;i<customers.size();i++)
    	{
    		HashSum+=getCustomer(i).hashCode();
    	}
    	return new HashCodeBuilder(9,19).append(customers.size()).append(customers).toHashCode();
    }
}

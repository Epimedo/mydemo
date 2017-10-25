package com.mybank.domain;

import java.awt.List;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.mybank.inter.Individuals;
/** Создает объект пользователя
 * @param NumberOfAccounts - число аккаунтов пользователя 
 * @param Fname -  имя пользователя
 * @param Lname - фамилия пользователя
 * @param accounts -массив аккаунтов пользователя(имеет несколько типов аакаунта)
 */
public class Customer implements Individuals {
   public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
protected ArrayList<Account> accounts = new ArrayList<Account>(10);
   protected String Fname;
   protected String Lname;
   public Customer()
   {
	   super();
   };
public Customer(Account anaccount, String fname, String lname) {
	super();
	accounts.add(anaccount);
	Fname = fname;
	Lname = lname;
}
public Account getAccount(int i) {
	return accounts.get(i);
}
public void setAccount(Account anaccount) {
	accounts.add(anaccount);
}
public String getFname() {
	return Fname;
}
public void setFname(String fname) {
	Fname = fname;
}
public String getLname() {
	return Lname;
}
public void setLname(String lname) {
	Lname = lname;
}
public boolean equals(Object obj)
{
	if(this == obj)
		return true;
	if(obj == null || this.getClass()!=obj.getClass())
		return false;
	Customer customer = (Customer)obj;
	if(new EqualsBuilder().append(Fname, customer.Fname).append(Lname,customer.Lname).append(accounts.size(),customer.getNumberOfAccounts()).isEquals())
	{
	for(int i =0;i<accounts.size();i++)
	if(!accounts.get(i).equals(customer.getAccount(i)))
	return false;
	return true;
	}
    return false;
}
public int getNumberOfAccounts() {
	return accounts.size();
}
public int hashCode()
{
	int HashSum = 0;
	for(int i =0;i<accounts.size();i++)
		HashSum+=accounts.get(i).hashCode();
	return new HashCodeBuilder(9,19).append(Fname).append(Lname).toHashCode()+HashSum;
}
public <T extends Object,Y extends Object> void CopyClass(T in,Y out)
{
	Class<?> inClass = in.getClass();
	Field[] inF = inClass.getDeclaredFields();
    Class<?> outClass = out.getClass();
    Field[] outF = outClass.getDeclaredFields();
    for(Field outfield: outF)
    {
    	try {
    	Field infield = inClass.getDeclaredField(outfield.getName());
    	if(outfield.getType().equals(infield.getType()))
    	{
    	    outfield.set(out,infield.get(in));
    	}
    	}
    	catch(NoSuchFieldException e)
    	{
    		System.out.println(e);
    	}
    	catch( IllegalAccessException e)
    	{
    		System.out.println(e);
    	}
    	
    }
}
}

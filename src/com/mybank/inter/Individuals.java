package com.mybank.inter;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * для выделения физических лиц
 * @author Headbrothers
 *
 */
import com.mybank.domain.*;
@XmlRootElement
public interface Individuals {
	String getFname();
	String getLname();
	void setAccount(Account account);
	Account getAccount(int i);
	void setLname(String lname);
	void setFname(String fname);
	int getNumberOfAccounts();
	int hashCode();
	boolean equals(Object a);
}

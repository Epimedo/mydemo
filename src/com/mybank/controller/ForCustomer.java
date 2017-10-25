package com.mybank.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import com.mybank.domain.Customer;

public class ForCustomer {
 private static Customer customer;
 private static ControlCommand contrl;

public static Customer getCustomer() {
	return customer;
}

public static void setCustomer(Customer customer) {
	ForCustomer.customer = customer;
}
 public static void readXMLCommand()
 {
	 try {
		Reader reader = new FileReader("cutcommand.xml");
		contrl = (ControlCommand) Unmarshaller.unmarshal(ControlCommand.class, reader);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MarshalException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ValidationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 public static void writeXMLAnswer()
 {
	CommandPoint.setAccount(customer.getAccount((int)contrl.getValue()));
 }
}

package com.mybank.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;

import com.mybank.domain.Account;

public class ForAccount {
	private Writer file;
public ForAccount(Account ac)
{
	try {
		file = new FileWriter("account.xml");
		Marshaller.marshal(ac,file);
	} catch (IOException e) {
		e.getMessage();
	} catch (MarshalException e) {
		e.getMessage();
	} catch (ValidationException e) {
		e.getMessage();
	}
	
}
}

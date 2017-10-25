package com.mybank.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import com.mybank.domain.Account;
import com.mybank.domain.OverdraftException;

public class CommandPoint {
    private static Account account;
    private static ControlCommand contrl;
	public static Account getAccount() {
		return account;
	}

	public static void setAccount(Account account) {
		CommandPoint.account = account;
	}
    public static void readXMLCommand()
    {
    	
		try {
			Reader reader;
			reader = new FileReader("command.xml");
			contrl = (ControlCommand) Unmarshaller.unmarshal(ControlCommand.class,reader);
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
    public static void writeXMLResult()
    {
    	switch(contrl.getNameCommand())
    	{
    	case "getBalance": 
    	contrl.setValue(account.getBalance());;
    	break;
    	case "deposit": 
    	account.deposit(contrl.getValue());
    	contrl.setValue(account.getBalance());
    	break;
    	case "withdrow":
    		try {
				account.withdrow(contrl.getValue());
				contrl.setValue(account.getBalance());
			} catch (OverdraftException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	break;
    	}
    	try {
    		Writer writer = new FileWriter("command.xml");
			Marshaller.marshal(contrl, writer);
		} catch (MarshalException | ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

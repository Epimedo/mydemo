package com.mybank.domain;

public class OverdraftException extends Exception {
	private double iDeficit;
	public OverdraftException(String message,double deficit)
	{
		super(message);
		iDeficit=deficit;
	}
    public double getDeficit()
    {
    	return iDeficit;
    }
}

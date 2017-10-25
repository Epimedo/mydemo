package com.mybank.controller;

public class ControlCommand {
private String NameCommand;
private double value;
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}
public ControlCommand() {};
public String getNameCommand() {
	return NameCommand;
}
public void setNameCommand(String nameCommand) {
	NameCommand = nameCommand;
}
}

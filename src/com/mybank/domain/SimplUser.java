package com.mybank.domain;

import com.mybank.inter.Individuals;
/**
 * ������� ������ �����
 * @author Headbrothers
 *
 */
public class SimplUser extends Customer implements Individuals {
	public SimplUser(int i,Account anaccount, String fname, String lname) {
		super(anaccount, fname, lname);
	}
}

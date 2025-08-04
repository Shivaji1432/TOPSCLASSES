package com;

import java.util.regex.Pattern;

public class Validation {
	public static boolean checkEamil(String email)
	{
		String regEx = "^[a-zA-Z0-9_-]+@[a-zA-Z]+\\.[a-z]{2,4}$";
		
		Pattern p = Pattern.compile(regEx);
		
		boolean b =  p.matcher(email).matches();
		
		return b;
	}
	public static boolean checkpass(String pass)
	{
		String regEx = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$";
		
		Pattern p = Pattern.compile(regEx);
		
		boolean b =  p.matcher(pass).matches();
		
		return b;
	}
}

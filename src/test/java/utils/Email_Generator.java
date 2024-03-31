package utils;

import java.util.Random;

public class Email_Generator {
	public static String email_generator() {
		String email = "anil"+ System.currentTimeMillis() + "@gmail.com";
		return email;
	}
}

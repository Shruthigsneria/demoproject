package demo;

import org.testng.annotations.Test;

public class LoginTest {
	@Test
	public void loginscript() {
		
		System.out.println(System.getProperty("browser"));
		System.out.println(System.getProperty("url"));
		System.out.println(System.getProperty("username"));
		System.out.println(System.getProperty("password"));
		
	}

}

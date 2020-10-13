package com.TestCase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.pages.SavariPage;
import com.utilities.WrapperClass;

public class SavaariTest extends WrapperClass {
	@Test
	public void f() throws InterruptedException, ParseException, IOException {
		launchBrowser("chrome browser", "https://www.savaari.com/");

		SavariPage sp = new SavariPage(driver);
		
		//sp.selectTrip("One Way");
		sp.from(0, 0);
		Thread.sleep(2000);
		sp.to(0, 1);
		sp.selectDate("16/10/2020");
		sp.selectTime("5:30 PM ");
		sp.selectCar();
		screenshot("G:\\selenium\\savaari2\\screenshot repository.PNG");
	}
}

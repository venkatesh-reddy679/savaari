package com.pages;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utilities.WrapperClass;

public class SavariPage {
	WebDriver driver;
	String sheetName = "Savaari";
	ExcelPage ep = new ExcelPage(driver);

	@FindBy(xpath = "//*[contains(text(),'One Way')]")
	WebElement oneWay;

	@FindBy(xpath = "//*[contains(text(),'Round Trip')]")
	WebElement roundTrip;

	@FindBy(xpath = "//input[@id='fromCityList']")
	WebElement fromCity;

	@FindBy(xpath = "//*[@placeholder='Start typing city - e.g. Mysore']")
	WebElement toCity;

	@FindBy(xpath = "//span[@class='ng-tns-c11-1 ui-calendar']")
	WebElement calender;

	@FindBy(xpath = "//a[@class='ui-datepicker-next ui-corner-all']/span[@class='fa fa-angle-right']")
	WebElement front;
	
	@FindBy(xpath="//select[@id='pickUpTime']")
	WebElement time;
	
	@FindBy(xpath = "//button[@class='book-button btn']")
	WebElement select;
	

	public SavariPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void selectTrip(String trip) {

		if (trip.equalsIgnoreCase("One Way")) {
			oneWay.click();

		} else {
			roundTrip.click();

		}

	}

	public void from(int rowNum, int cellNum) throws FileNotFoundException, InterruptedException {

		String value = ep.getCellValue(sheetName, rowNum, cellNum);

		fromCity.sendKeys(value);
		Thread.sleep(2000);
		fromCity.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

	}

	public void to(int rowNum, int cellNum) throws FileNotFoundException, InterruptedException {

		String value = ep.getCellValue(sheetName, rowNum, cellNum);

		toCity.sendKeys(value);
		Thread.sleep(2000);
		toCity.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

	}

	public void selectDate(String date) throws ParseException, InterruptedException {

		calender.click();
		Thread.sleep(2000);
		String date1 = date.substring(0, 2);

		driver.findElement(By.linkText(date1)).click();

	}

	

	public void selectTime(String timeSlot) {
		Select select = new Select(time);
		select.selectByVisibleText(timeSlot);

	}
	
	public void selectCar() throws InterruptedException {
		Thread.sleep(1000);
		select.click();
		Thread.sleep(2000);
		
	}
	
	public void carName() {
		
		
		
		
	}



}

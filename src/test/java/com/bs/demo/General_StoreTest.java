package com.bs.demo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class General_StoreTest extends OptimizeBaseClass {
	
	@Test
	public void DropDownsTest() throws InterruptedException {
		//Scroll and Select Canada option from dropDown
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Canada\"));"));
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Canada']")).click();
	    
	    //Type name in a text field
	    //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anjali");
	    //driver.hideKeyboard();
	    
	    //Select radio option 
	    driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
	    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	    Thread.sleep(3000);
	    
	    //spy toast message and get the text  tagname: android.widget.Toast (//tagname) for ios
	    String toastMsg=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	    System.out.println("The toast message: "+toastMsg);  //The toast message: Please enter your name
	    Assert.assertEquals(toastMsg,"Please enter your name");
	    
	}
	
	

}

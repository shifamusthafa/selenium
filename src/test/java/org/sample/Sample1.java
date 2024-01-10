package org.sample;

import org.base.BaseClass;

public class Sample1 extends BaseClass {
	public static void main(String[] args) {
		launchBrowser();
		launchUrl("https://www.gmail.com/");
		windowMaximize();
		
	//WebElement email =	driver.findElement(By.id("email"));
		PageObjectModel1 p = new PageObjectModel1();//created object
		//methods calling
		passText("selenium", p.getEmail());

	
		
		}

}

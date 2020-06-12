package com.resources;

import org.testng.annotations.DataProvider;

import com.configuration.Config;

public class TestData {
	@DataProvider(name="multipleUsers")
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] =Config.getStringValue("email");
		data[0][1] =Config.getStringValue("password");
		data[1][0] =Config.getStringValue("incorrectEmail");
		data[1][1] =Config.getStringValue("incorrectPassword");
		return data;
	}
	

}

package com.masteringselenium.config;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public interface DriverSetup {

	MutableCapabilities getDesiredCapabilities();

	WebDriver getWebDriverObject(MutableCapabilities capabilities);
}

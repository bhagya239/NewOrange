package com.reports;

import java.io.File;

import com.CyberSuccess.baseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator extends baseClass{
	

	public static void generateReport() {
		
		extentReports=new ExtentReports();
		
//		String configFilePath=System.getProperty("user.dir")+"src\\main\\java\\com\\reports\\extentConfig.xml";		
		
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/target/ExtentReport/ExtentReport.html");
		
		extentReports.attachReporter(sparkReporter);
		
		extentReports.setSystemInfo("env", "Test");
		
		extentReports.setSystemInfo("user", "cyber success");
		
		extentReports.setSystemInfo("browser", "chrome");
		
		
		
	}
	
	public static ExtentTest createTest(String methodName) {
		
		return extentReports.createTest(methodName);
	}
		
	
	

}

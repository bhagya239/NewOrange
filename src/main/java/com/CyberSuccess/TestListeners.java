/*
 * package com.CyberSuccess;
 * 
 * import java.io.IOException; import java.time.LocalDateTime; import
 * java.time.format.DateTimeFormatter; import org.testng.ISuiteListener; import
 * org.testng.ITestContext; import org.testng.ITestListener; import
 * org.testng.ITestResult; import com.aventstack.extentreports.Status; import
 * com.reports.ExtentReportGenerator;
 * 
 * public class TestListeners extends baseClass implements ITestListener,
 * ISuiteListener {
 * 
 * public void onStart(ITestContext context) {
 * 
 * System.out.println("Sute Execution Started.....:");
 * 
 * ExtentReportGenerator.generateReport();
 * 
 * }
 * 
 * public void onFinish(ITestContext context) {
 * 
 * System.out.println("Sute Execution Completed.....:");
 * 
 * extentReports.flush();
 * 
 * driver.quit(); }
 * 
 * public void onTestStart(ITestResult result) {
 * 
 * System.out.println("Method : " + result.getMethod().getMethodName() +
 * " started successfully");
 * 
 * extentTest=ExtentReportGenerator.createTest(result.getMethod().getMethodName(
 * ));
 * 
 * }
 * 
 * public void onTestFailure(ITestResult result) {
 * 
 * extentTest.log(Status.FAIL,result.getMethod().getMethodName()+
 * " Exception: "+ result.getThrowable().getMessage());
 * 
 * //
 * extentTest.log(Status.FAIL,result.getThrowable().getStackTrace().toString());
 * 
 * System.out.println("Method : " + result.getMethod().getMethodName() +
 * " failed......");
 * 
 * String timeStamp=
 * LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH_mm")); try {
 * String
 * snapShotPath=takeScreenShot(result.getMethod().getMethodName()+timeStamp);
 * 
 * // extentTest.log(Status.FAIL,snapShotPath );
 * 
 * extentTest.addScreenCaptureFromPath(snapShotPath);
 * 
 * } catch (IOException e) { e.printStackTrace(); } }
 * 
 * public void onTestSkipped(ITestResult result) {
 * 
 * extentTest.log(Status.SKIP, result.getMethod().getMethodName());
 * 
 * System.out.println("Method : " + result.getMethod().getMethodName() +
 * " Skipped......"); }
 * 
 * 
 * public void onTestPassed(ITestResult result) {
 * 
 * extentTest.log(Status.PASS, result.getMethod().getMethodName());
 * 
 * System.out.println("Method : " + result.getMethod().getMethodName() +
 * " Passed......"); } }
 */
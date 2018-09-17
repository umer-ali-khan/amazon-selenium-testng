/**
 * 
 */
package com.amazon.auto.testng.reports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author Umar Khan
 *
 */
public class CreateTestNGReport implements ITestListener {

	@Override
	public void onStart(ITestContext testContext) {

		System.out.println("+ Start test :: " + testContext.getName());

	}

	@Override
	public void onTestStart(ITestResult testResult) {

		System.out.println(" Starting test :: " + testResult.getName());

	}

	@Override
	public void onTestSuccess(ITestResult testResult) {

		System.out.println(" Test passed: " + testResult.getName());

	}

	@Override
	public void onTestFailure(ITestResult testResult) {

		System.out.println(" Test failed: " + testResult.getName());

	}

	@Override
	public void onTestSkipped(ITestResult testResult) {

		System.out.println(" Test ignored: " + testResult.getName());

	}

	@Override
	public void onFinish(ITestContext testResult) {

		System.out.println("- End test :: " + testResult.getName());

	}

	/* (non-Javadoc)
	 * @see org.testng.ITestListener#onTestFailedButWithinSuccessPercentage(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}



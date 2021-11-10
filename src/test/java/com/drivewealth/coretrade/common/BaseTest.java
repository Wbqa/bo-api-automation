package com.drivewealth.coretrade.common;

import com.qmetry.qaf.automation.testng.TestNGTestCase;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.Reporter;

public class BaseTest extends TestNGTestCase {

    protected ISuite getTestSuite() {
        return Reporter.getCurrentTestResult().getTestContext().getSuite();
    }

    protected ITestContext getTestCaseContext() {
        return context;
    }

    protected void setTestCaseAttribute(String key, Object obj) {
        context.setAttribute(key,obj);
    }

    protected Object getTestCaseAttribute(String key) {
        return context.getAttribute(key);
    }

    protected void setSuiteAttribute(String key, Object obj) {
        getTestSuite().setAttribute(key,obj);
    }

    protected Object getSuiteAttribute(String key) {
        return getTestSuite().getAttribute(key);
    }
}

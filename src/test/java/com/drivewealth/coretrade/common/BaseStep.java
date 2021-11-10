package com.drivewealth.coretrade.common;
import com.qmetry.qaf.automation.util.JSONUtil;
import com.qmetry.qaf.automation.util.PropertyUtil;
import org.testng.ISuite;
import org.testng.Reporter;

import java.util.Map;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class BaseStep {

    private PropertyUtil stepContext;

    public BaseStep() {
        stepContext = getBundle();
    }

    protected ISuite getTestSuite() {
        return Reporter.getCurrentTestResult().getTestContext().getSuite();
    }

    protected void setSuiteAttribute(String key, Object obj) {
        getTestSuite().setAttribute(key,obj);
    }

    protected Object getSuiteAttribute(String key) {
        return getTestSuite().getAttribute(key);
    }

    protected void setStepAttribute(String key, Object obj) {
        stepContext.setProperty(key,obj);
    }

    protected Object getStepAttribute(String key) {
        return stepContext.getProperty(key);
    }

    protected Map<String, Object> getStepData(String stepNo, String stepData) {
         return JSONUtil.getJsonObjectFromFile(stepData,Map.class);
    }
}

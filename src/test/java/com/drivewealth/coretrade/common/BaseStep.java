package com.drivewealth.coretrade.common;

import com.drivewealth.coretrade.util.JsonUtil;
import com.qmetry.qaf.automation.testng.TestNGTestCase;
import com.qmetry.qaf.automation.util.JSONUtil;
import com.qmetry.qaf.automation.util.PropertyUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.testng.ISuite;
import org.testng.Reporter;

import java.io.File;
import java.util.Map;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;

public class BaseStep extends TestNGTestCase {
    private final Log logger = LogFactoryImpl.getLog(getClass());

    private final PropertyUtil stepContext;

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

    protected String getStepData(String stepNo, String stepData) {
        try {
            File file = new File(stepData);
            if (file.exists()) {
                Map<String, Object> stepsMap = JSONUtil.getJsonObjectFromFile(stepData, Map.class);

                if (!stepsMap.containsKey(stepNo)) {
                    logger.error("Step Data Json not found for stepNo " + stepNo);
                    return null;
                } else {
                    file = new File(stepsMap.get(stepNo).toString());
                    if (file.exists()) {
                        Object obj = JSONUtil.getJsonObjectFromFile(file.getAbsolutePath(),Object.class);
                        return JsonUtil.toJson(obj);
                    }

                    return JsonUtil.toJson(stepsMap.get(stepNo));
                }
            } else {
                return stepData;
            }

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package com.drivewealth.coretrade.steps;

import com.drivewealth.coretrade.common.BaseStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;

public class AccountSteps extends BaseStep {
    private final Log logger = LogFactoryImpl.getLog(getClass());

    @QAFTestStep(description = "{stepNo}: User with account {data}")
    public void fetchAccount(String stepNo, String stepData) {
        logger.debug("StepNo --> " + stepNo + "-" + stepData);
        logger.debug(getStepData(stepNo,stepData));
    }
}

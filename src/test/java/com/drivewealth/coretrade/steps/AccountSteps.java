package com.drivewealth.coretrade.steps;

import com.drivewealth.coretrade.common.BaseStep;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.util.JSONUtil;

import java.util.Map;

public class AccountSteps extends BaseStep {

    @QAFTestStep(description = "{stepNo}: User with account {data}")
    public void fetchAccount(String stepNo, String stepData) {
        System.out.println(stepNo + "-" + stepData);
        System.out.println(getStepData(stepNo,stepData));
    }
}

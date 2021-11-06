package com.drivewealth.test.bdd;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.TestNGTestCase;

public class UserAccountTest extends TestNGTestCase  {

    @QAFTestStep(description = "^User with account {accountNo}$")
    public void getUserWithAccount(long accountNo) {
        System.out.println("Account# --> " + accountNo);
    }

    @QAFTestStep(description = "^Fetch account details {num}$")
    public void fetchUserAccountDetails(int accountNo) {
        System.out.println("Account Details fetched # --> " + accountNo);
    }

    @QAFTestStep(description = "^Verify user account number matches with {0}$")
    public void verifyUserAccount(int accountNo) {
        System.out.println("Account successfully matched");
    }
}

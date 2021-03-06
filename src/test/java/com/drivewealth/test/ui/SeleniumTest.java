package com.drivewealth.test.ui;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.verifyLinkWithPartialTextPresent;
import static com.drivewealth.steps.StepsLibrary.searchFor;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class SeleniumTest extends WebDriverTestCase {

	@Test
	public void testGoogleSearch() {
		get("/");
		searchFor("qaf github infostretch");
		verifyLinkWithPartialTextPresent("qaf");
	}
}

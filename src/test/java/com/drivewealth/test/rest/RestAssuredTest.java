package com.drivewealth.test.rest;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.TestNGTestCase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

@MetaData("{'story':'Testing Backend testcases', 'module':'coretrade', 'storyId':'JIRA-111'}")
public class RestAssuredTest extends TestNGTestCase {
 
    @MetaData("{'status':'InProgress', 'testCaseId':'TST-11223', 'issueId':'JIRA-112'}")
	@Test
	public void testMe() {
		System.out.println("testMe() method executed.. " + context);
		Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://www.google.com")
                .then()
                .extract().response();	
		System.out.println(response.asString());
	}
}

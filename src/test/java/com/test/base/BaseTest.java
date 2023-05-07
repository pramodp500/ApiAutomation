package com.test.base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import com.actions.AssertAction;
import com.endpoints.APIConstants;
import com.module.PayloadModule;

public class BaseTest {

    // Common Functionality

    protected RequestSpecification requestSpecification;
    protected Response response;
    protected ValidatableResponse validatableResponse;
    protected AssertAction assertActions = new AssertAction();
    protected PayloadModule payloadModule = new PayloadModule();


    // Before any Method

    @BeforeMethod
    protected void setUpBeforeMethod(){
        requestSpecification =
                // RestAssured.given().baseUri().contentType();
                new RequestSpecBuilder()
                        .setBaseUri(APIConstants.BASE_URL)
                        .addHeader("Content-Type", "application/json")
                        .build().log().all();
    }




}

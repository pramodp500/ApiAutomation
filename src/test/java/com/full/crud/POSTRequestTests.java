package com.full.crud;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.endpoints.APIConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


	public class POSTRequestTests extends BaseTest {


	    @Test
	    public void test_postCreateBooking(){

	        // URl, Header, Cookie, Auth
	        // PAYLOAD
	        // Method - POST
	        // Response Validation
	        requestSpecification.basePath(APIConstants.CREATE_GET_POST_URL_BOOKING);
	        try {
	            response = RestAssured.given().spec(requestSpecification)
	                    .when().body(payloadModule.createPayload()).post();
	        }catch (JsonProcessingException e){
	            System.out.println(e.getMessage());
	        }

	        validatableResponse = response.then().log().all();
	        String responseString = response.asString();
	        System.out.println(responseString);

	        JsonPath jsonPath = new JsonPath(responseString);
	        String bookingid = jsonPath.getString("bookingid");
	        // Status (Hamcret from the Rest Assured)
	        validatableResponse.statusCode(200);

	        // Time Verficaiton (Hamcrets) from the Rest Assured)
	        //validatableResponse.body(Matchers.lessThan(5000L));

	        // TestNG
	        Assert.assertNotNull(bookingid);
	    }


	}



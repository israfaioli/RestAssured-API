package common;

import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class Base {
	
	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/api";
		RestAssured.basePath = "/v1";
		RestAssured.port = 443;
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setContentType(ContentType.JSON);
		RestAssured.requestSpecification = requestSpecBuilder.build();
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}

}

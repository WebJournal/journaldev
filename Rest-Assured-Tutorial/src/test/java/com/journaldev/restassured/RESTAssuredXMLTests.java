package com.journaldev.restassured;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RESTAssuredXMLTests {


	@Test
	public void post_xml_test() {
		Response response = given().
				contentType(ContentType.XML)
				.accept(ContentType.XML)
				.body("<empRequest>\n" + 
						"	<id>1</id>\n" + 
						"	<name>PK</name>\n" + 
						"</empRequest>")
				.when()
				.post("http://localhost:8080/My-Jersey-Project/rest/emp/getEmp");
		System.out.println("POST Response\n" + response.asString());
		// tests
		Assert.assertEquals(response.getStatusCode(),200);
		response.then().body("empResponse.id", Matchers.is("1"));
		response.then().body("empResponse.name", Matchers.is("PK"));
	}
	
	@Test
	public void post_xml_error_test() {
		Response response = given().
				contentType(ContentType.XML)
				.accept(ContentType.XML)
				.body("<empRequest>\n" + 
						"	<id>2</id>\n" + 
						"	<name>PK</name>\n" + 
						"</empRequest>")
				.when()
				.post("http://localhost:8080/My-Jersey-Project/rest/emp/getEmp");
		System.out.println("POST Error Response\n" + response.asString());
		// tests
		response.then().body("errorResponse.errorId", Matchers.is("2"));
		response.then().body("errorResponse.errorCode", Matchers.is("Wrong ID"));
		Assert.assertEquals(response.getStatusCode(),500);
	}

}

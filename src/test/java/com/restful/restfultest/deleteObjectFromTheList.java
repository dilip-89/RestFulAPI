package com.restful.restfultest;

import com.restful.utils.ExtentTestNGReportBuilder;
import com.restful.utils.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.restfulapi.addObjectSerialization.Data;
import org.restfulapi.addObjectSerialization.addObjectInputDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class deleteObjectFromTheList extends ExtentTestNGReportBuilder {

    private final PropertyReader propertyReader = new PropertyReader("application.properties");

    private final String addObjectsAPI = "/objects";

    public String id;

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = propertyReader.get("Get_List_Of_Objects");
    }

    @Test(priority = 1, description = "Adding a Object to the List and Verifying the status Code")
    public void verifySuccessfullyAddingObject() {

        addObjectInputDTO addObjectinput = new addObjectInputDTO("Apple LMacBook Pro 16",new Data(2019,1841.99,
                "Intel Core i5","1 TB"));

        id = RestAssured.given().contentType(ContentType.JSON).when().and()
                .body(addObjectinput).when().post(addObjectsAPI).then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().path("id");

    }

    @Test(priority = 2, dependsOnMethods = {"verifySuccessfullyAddingObject"}, description = "Adding a Object to the List and Verifying the status Code")
    public void verifySuccessfullyDeleteObject() {
        RestAssured.given().contentType(ContentType.JSON).when().and()
                .when().delete(addObjectsAPI + "/" + id).then().assertThat().statusCode(HttpStatus.SC_OK)
                .body("message",equalTo("Object with id = "+ id + " has been deleted."));

    }
}

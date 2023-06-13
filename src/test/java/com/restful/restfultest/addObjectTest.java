package com.restful.restfultest;

import com.google.gson.annotations.SerializedName;
import com.restful.utils.ExtentTestNGReportBuilder;
import com.restful.utils.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.restfulapi.addObjectSerialization.Data;
import org.restfulapi.addObjectSerialization.addObjectInputDTO;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class addObjectTest extends ExtentTestNGReportBuilder {

    private final PropertyReader propertyReader = new PropertyReader("application.properties");
    public String id;
    private final String addObjectsAPI = "/objects";

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = propertyReader.get("Get_List_Of_Objects");
    }

    @AfterClass
    public void cleanUp() {
        RestAssured.given().contentType(ContentType.JSON).when().and().delete(addObjectsAPI + "/" + id).
                then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test(priority = 1, description = "Adding a Object to the List and Verifying the Response")
    public void verifySuccessfullyAddingObject() {

        addObjectInputDTO addObjectinput = new addObjectInputDTO("Apple IMacBook Pro 16",new Data(2019,1841.99,
                "Intel Core i5","1 TB"));

        id = RestAssured.given().contentType(ContentType.JSON).when().and()
                .body(addObjectinput).when().post(addObjectsAPI).then().assertThat().statusCode(HttpStatus.SC_OK)
                .body("name",equalTo("Apple IMacBook Pro 16"), "data.year",equalTo(2019)
                        , "data.price",equalTo(1841.99), "data.CPUmodel",equalTo("Intel Core i5")
                        , "data.Harddisksize",equalTo("1 TB")).extract().path("id");


    }

    @Test(priority = 2, description = "Verifying the Added Object is available in the Get Request")
    public void verifySuccessfullyAddedObjectPresentInGet() {

        addObjectInputDTO addObjectinput = new addObjectInputDTO("Apple IMacBook Pro 16",new Data(2019,1841.99,
                "Intel Core i5","1 TB"));

        id = RestAssured.given().contentType(ContentType.JSON).when().and()
                .body(addObjectinput).when().post(addObjectsAPI).then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().path("id");

        RestAssured.given().contentType(ContentType.JSON).when().and().when().get(addObjectsAPI + "/" + id).then()
                .assertThat().statusCode(HttpStatus.SC_OK);
    }
}

package com.restful.restfultest;

import com.restful.utils.ExtentTestNGReportBuilder;
import com.restful.utils.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.restfulapi.updateObjectSerialization.data;
import org.restfulapi.updateObjectSerialization.updateObjectInputDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class updateObjectTest extends ExtentTestNGReportBuilder {

    private final PropertyReader propertyReader = new PropertyReader("application.properties");
    private final String updateObjectsAPI = "/objects/ff80818188b305f60188b3e292f70068";

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = propertyReader.get("Get_List_Of_Objects");
    }

    @Test(priority = 1, description = "Update a Object to the List and Verifying the Response")
    public void verifySuccessfullyUpdatingObject() {

        updateObjectInputDTO updateObjectinput = new updateObjectInputDTO("Apple IMacBook Pro 16",new data(2019,1841.99
                ,"Intel Core i5","1 TB","Gold"));

        RestAssured.given().contentType(ContentType.JSON).when().and()
                .body(updateObjectinput).when().put(updateObjectsAPI).then().assertThat().statusCode(HttpStatus.SC_OK)
                .body("name",equalTo("Apple IMacBook Pro 16"), "data.year",equalTo(2019)
                        , "data.price",equalTo(1841.99), "data.CPUmodel",equalTo("Intel Core i5")
                        , "data.Harddisksize",equalTo("1 TB"),"data.color",equalTo("Gold"));


    }
}

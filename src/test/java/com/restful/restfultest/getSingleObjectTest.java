package com.restful.restfultest;

import com.restful.utils.ExtentTestNGReportBuilder;
import com.restful.utils.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class getSingleObjectTest extends ExtentTestNGReportBuilder {

    private final PropertyReader propertyReader = new PropertyReader("application.properties");

    private final String singleObjectAPI = "/objects/7";

    private double price = 1849.99;

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = propertyReader.get("Get_List_Of_Objects");
    }

    @Test(priority = 1, description = "Get Single Object By ID")
    public void verifySingleObject() {
        RestAssured.given().contentType(ContentType.JSON).get(singleObjectAPI).then().assertThat().statusCode(HttpStatus.SC_OK)
                .body("id", equalTo("7"),"name", equalTo("Apple MacBook Pro 16")
                        ,"data.year", equalTo(2019),"data.price", equalTo(String.valueOf(price))
                        ,"CPUmodel", equalTo("Intel Core i9"),"Harddisksize", equalTo("1 TB"));

    }
}

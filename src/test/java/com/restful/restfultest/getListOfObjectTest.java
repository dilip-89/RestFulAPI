package com.restful.restfultest;

import com.restful.utils.ExtentTestNGReportBuilder;
import com.restful.utils.Helper.objectSize;
import com.restful.utils.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.restfulapi.getListOfObjectdeserialization.list;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.hamcrest.CoreMatchers.equalTo;

public class getListOfObjectTest extends ExtentTestNGReportBuilder {

    private final PropertyReader propertyReader = new PropertyReader("application.properties");

    private final String listOfObjectsAPI = "/objects";

    private final objectSize objectlenght = new objectSize();

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = propertyReader.get("Get_List_Of_Objects");
    }

    @Test(priority = 1, description = "Get List Of Objects By ID")
    public void verifyListOfObject() {

        list[] listOfObjects = RestAssured.given().contentType(ContentType.JSON)
                .queryParam("id", 3).queryParam("id", 5).queryParam("id",10)
                .get(listOfObjectsAPI).as(list[].class);

        for (int i = 0; i < objectlenght.getListOfObjectLength(); i++) {

            RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON)
                    .queryParam("id", 3).queryParam("id", 5).queryParam("id",10);
            Response response = httpRequest.get(listOfObjectsAPI);


            response.then().assertThat().statusCode(HttpStatus.SC_OK).body("[" + i + "].id", equalTo(listOfObjects[i].getid())
                    ,"[" + i + "].name", equalTo(listOfObjects[i].getname()));
            if (Objects.nonNull(listOfObjects[i].getdata().color))
            {
                response.then().assertThat().statusCode(HttpStatus.SC_OK)
                        .body("[" + i + "].data.color", equalTo(listOfObjects[i].getdata().getColor())
                                , "[" + i + "].data.capacityGB", equalTo(listOfObjects[i].getdata().getCapacityGB()));
            }
            if (Objects.nonNull(listOfObjects[i].getdata().Capacity))
            {
                response.then().assertThat().statusCode(HttpStatus.SC_OK)
                        .body("[" + i + "].data.Capacity", equalTo(listOfObjects[i].getdata().getCapacity())
                                , "[" + i + "].data.Screensize", equalTo(String.valueOf(listOfObjects[i].getdata().getScreen_size())));
            }
        }

    }
}



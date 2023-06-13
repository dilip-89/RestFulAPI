package com.restful.utils.Helper;

import com.restful.utils.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

public class objectSize {

    private final PropertyReader propertyReader = new PropertyReader("application.properties");

    private final String objectURL = propertyReader.get("List_Of_Objects");

public int getListOfObjectLength() {

    return RestAssured.given().contentType(ContentType.JSON)
            .queryParam("id", 3).queryParam("id", 5).queryParam("id",10)
            .get(objectURL).then().assertThat().statusCode(HttpStatus.SC_OK).extract().jsonPath().getList("$").size();
}
}

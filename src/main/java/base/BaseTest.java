package base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  @BeforeMethod
  public void setup() {
    RequestSpecification spec = RestAssured
        .given()
        .baseUri("https://petstore.swagger.io/v2")
        .contentType(ContentType.JSON);
    RestAssured.requestSpecification = spec;
  }
}

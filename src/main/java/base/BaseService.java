package base;

import static io.restassured.RestAssured.given;

import dto.OrderModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseService {
  private static String BASE_URI = System.getProperty("base.uri", "https://petstore.swagger.io/v2");

  static {
    RequestSpecification spec = RestAssured
        .given()
        .baseUri(BASE_URI)
        .contentType(ContentType.JSON);
    RestAssured.requestSpecification = spec;
  }

  public Response post(String endpoint, OrderModel orderModel) {
    return given()
        .body(orderModel)
        .when()
        .post(endpoint);
  }

  public Response delete(String endpoint, int id) {
    return given()
        .pathParams("orderId", id)
        .when()
        .delete(endpoint);
  }


}

package base;

import static io.restassured.RestAssured.given;

import dto.OrderModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

  static {
    RequestSpecification spec = RestAssured
        .given()
        .baseUri("https://petstore.swagger.io/v2")
        .contentType(ContentType.JSON);
    RestAssured.requestSpecification = spec;
  }

  protected static Response post(String endpoint, OrderModel orderModel) {
    return given()
        .body(orderModel)
        .when()
        .post(endpoint);
  }

  protected static Response delete(String endpoint, int id) {
    return given()
        .pathParams("orderId", id)
        .when()
        .delete(endpoint);
  }


}

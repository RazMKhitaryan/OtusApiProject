package base;

import static io.restassured.RestAssured.given;

import dto.OrderModel;
import io.restassured.response.Response;

public class BaseService {
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

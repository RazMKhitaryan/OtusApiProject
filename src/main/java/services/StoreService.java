package services;

import base.BaseService;
import dto.OrderModel;
import io.restassured.response.Response;

public class StoreService extends BaseService {

  public static Response postOrder(OrderModel orderModel) {
    return post(getPath() + "/order", orderModel);
  }

  public static Response deleteOrder(int orderId) {
    return delete(getPath() + "/order/{orderId}", orderId);
  }

  private static String getPath() {
    return "/store";
  }
}

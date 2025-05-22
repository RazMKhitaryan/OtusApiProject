package helpers;

import dto.OrderModel;
import services.StoreService;
import utils.DateUtils;

public abstract class OrderHelper {

  public static int createOrder() {
    StoreService storeService = new StoreService();
    OrderModel orderModel = OrderModel
        .builder()
        .id(1)
        .petId(15)
        .quantity(3)
        .shipDate(DateUtils.getCurrentDateTime())
        .status("placed")
        .complete(true)
        .build();
    return storeService.postOrder(orderModel).as(OrderModel.class).getId();
  }

}

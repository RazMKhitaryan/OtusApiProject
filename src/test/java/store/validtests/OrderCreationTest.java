package store.validtests;

import dto.OrderModel;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.StoreService;
import utils.DateUtils;

public class OrderCreationTest {
  private StoreService storeService;

  //check valid order creation response json validation with pojo class
  @Test(description = "pet order response json validation")
  public void petOrderWithAllParams() {
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
    OrderModel responseModel = storeService.postOrder(orderModel).as(OrderModel.class);
    Assert.assertEquals(responseModel, orderModel, "the order were not created successfully");
  }

  //check valid order creation response json validation with pojo class without ship date
  @Test(description = "pet order creation json validation without ship date")
  public void petOrderTestWithoutShipDate() {
    storeService = new StoreService();
    OrderModel orderModel = OrderModel
        .builder()
        .id(2)
        .petId(3)
        .quantity(2)
        .status("placed")
        .complete(true)
        .build();
    Response response = storeService.postOrder(orderModel);
    response.then()
        .statusCode(HttpStatus.SC_OK);
    OrderModel responseModel = response.as(OrderModel.class);
    Assert.assertEquals(responseModel, orderModel, "the order were not created successfully");
  }
}
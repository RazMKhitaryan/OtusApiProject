import base.BaseTest;
import dto.DeleteOrderModel;
import dto.OrderModel;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import services.StoreService;

public class StoreTest extends BaseTest {

  @Test(description = "pet order response json verification")
  public void petOrderWithAllParams() {
    OrderModel orderModel = OrderModel
        .builder()
        .id(1)
        .petId(15)
        .quantity(3)
        .shipDate("2025-05-16T19:39:51.091+0000")
        .status("placed")
        .complete(true)
        .build();
    OrderModel responseModel = StoreService.postOrder(orderModel).as(OrderModel.class);
    Assert.assertEquals(responseModel, orderModel, "the order were not created successfully");
  }

  @Test(description = "pet order creation without ship date")
  public void petOrderTestWithoutShipDate() {
    OrderModel orderModel = OrderModel
        .builder()
        .id(2)
        .petId(3)
        .quantity(2)
        .status("placed")
        .complete(true)
        .build();
    Response response = StoreService.postOrder(orderModel);
    response.then()
        .statusCode(HttpStatus.SC_OK);
    OrderModel responseModel = response.as(OrderModel.class);
    Assert.assertEquals(responseModel, orderModel, "the order were not created successfully");
  }


  @Test(description = "pet order delete with valid id")
  public void deletePetOrderWithValidOrderId() {
    int orderId = 1;
    SoftAssert softAssert = new SoftAssert();
    Response response = StoreService.deleteOrder(orderId);
    response.then()
        .statusCode(HttpStatus.SC_OK);
    DeleteOrderModel deleteOrderModel = response.as(DeleteOrderModel.class);
    softAssert.assertEquals(deleteOrderModel.getCode(), HttpStatus.SC_OK, "status code is not " + HttpStatus.SC_OK);
    softAssert.assertEquals(deleteOrderModel.getType(), "unknown", "type is not unknown");
    softAssert.assertEquals(deleteOrderModel.getMessage(), String.valueOf(orderId), "message is not 2");
    softAssert.assertAll();
  }

  @Test(description = "pet order delete with invalid id")
  public void deletePetOrderWithInvalidOrderId() {
    SoftAssert softAssert = new SoftAssert();
    Response response = StoreService.deleteOrder(4);
    response.then()
        .statusCode(HttpStatus.SC_NOT_FOUND);
    DeleteOrderModel deleteOrderModel = response.as(DeleteOrderModel.class);
    softAssert.assertEquals(deleteOrderModel.getCode(), HttpStatus.SC_NOT_FOUND, "status code is not " + HttpStatus.SC_NOT_FOUND);
    softAssert.assertEquals(deleteOrderModel.getType(), "unknown", "type is not unknown");
    softAssert.assertEquals(deleteOrderModel.getMessage(), "Order Not Found", "the message were wrong");
    softAssert.assertAll();
  }
}
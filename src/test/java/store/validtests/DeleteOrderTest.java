package store.validtests;

import dto.DeleteOrderModel;
import helpers.OrderHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import services.StoreService;

public class DeleteOrderTest {
  int orderId;

  @BeforeMethod // precondition, create order for delete in test
  public void createOrder() {
    orderId = OrderHelper.createOrder();
  }

  //check valid order delete response json validation with pojo class
  @Test(description = "pet order delete with valid id")
  public void deletePetOrderWithValidOrderId() {
    StoreService storeService = new StoreService();
    SoftAssert softAssert = new SoftAssert();
    Response response = storeService.deleteOrder(orderId);
    response.then()
        .statusCode(HttpStatus.SC_OK);
    DeleteOrderModel deleteOrderModel = response.as(DeleteOrderModel.class);
    softAssert.assertEquals(deleteOrderModel.getCode(), HttpStatus.SC_OK, "status code is not " + HttpStatus.SC_OK);
    softAssert.assertEquals(deleteOrderModel.getType(), "unknown", "type is not unknown");
    softAssert.assertEquals(deleteOrderModel.getMessage(), String.valueOf(orderId), "message is not 2");
    softAssert.assertAll();
  }
}

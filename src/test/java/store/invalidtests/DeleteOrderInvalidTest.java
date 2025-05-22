package store.invalidtests;

import dto.DeleteOrderModel;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import services.StoreService;

public class DeleteOrderInvalidTest {

  //check invalid order delete response json validation with pojo class
  @Test(description = "pet order delete with invalid id")
  public void deletePetOrderWithInvalidOrderId() {
    StoreService storeService = new StoreService();
    SoftAssert softAssert = new SoftAssert();
    Response response = storeService.deleteOrder(4);
    response.then()
        .statusCode(HttpStatus.SC_NOT_FOUND);
    DeleteOrderModel deleteOrderModel = response.as(DeleteOrderModel.class);
    softAssert.assertEquals(deleteOrderModel.getCode(), HttpStatus.SC_NOT_FOUND, "status code is not " + HttpStatus.SC_NOT_FOUND);
    softAssert.assertEquals(deleteOrderModel.getType(), "unknown", "type is not unknown");
    softAssert.assertEquals(deleteOrderModel.getMessage(), "Order Not Found", "the message were wrong");
    softAssert.assertAll();
  }
}

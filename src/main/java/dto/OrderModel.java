package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {

  @JsonProperty("id")
  private int id;

  @JsonProperty("petId")
  private int petId;

  @JsonProperty("quantity")
  private int quantity;

  @JsonProperty("shipDate")
  private String shipDate;

  @JsonProperty("status")
  private String status;

  @JsonProperty("complete")
  private boolean complete;
}

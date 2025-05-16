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
public class DeleteOrderModel {

  @JsonProperty("code")
  private int code;

  @JsonProperty("type")
  private String type;

  @JsonProperty("message")
  private String message;
}

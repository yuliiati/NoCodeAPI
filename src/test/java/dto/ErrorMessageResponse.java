package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageResponse {

   private String message;
   private String code;
   private String instance;
   private String status;
   private String title;
   private String type;
   private String source;

}

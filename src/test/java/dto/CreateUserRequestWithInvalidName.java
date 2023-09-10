package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class CreateUserRequestWithInvalidName {
    private String full_name;
    private String email;
    private String password;
    private boolean generate_magic_link;
}

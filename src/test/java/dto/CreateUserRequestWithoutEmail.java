package dto;

import lombok.*;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor@Builder
public class CreateUserRequestWithoutEmail {
    private String full_name;
    private String password;
    private boolean generate_magic_link;
}

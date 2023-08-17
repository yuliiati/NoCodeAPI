package tests;

import dto.ValidUserRequest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class CreateUserTest extends BaseTest{
    String endpoint = "/users";
    @Test
    public void successfulCreateUser() {
   
        ValidUserRequest requestBody = ValidUserRequest.builder()
                .email("hkkdsddffdsdasjh@gmail.com")
                .full_name("SFGGJSH")
                .password("123456")
                .generate_magic_link(false)
                .build();

        Response response = postRequest(endpoint, 201, requestBody);

    }
}

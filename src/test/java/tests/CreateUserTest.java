package tests;

import dto.ErrorMessageResponse;
import dto.SuccessCreateUserRequest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CreateUserTest extends BaseTest{

    String endpoint = "/users";
    @Test @Description("Successful create user")
    public void successfulCreateUser() {
        SuccessCreateUserRequest requestBody = SuccessCreateUserRequest.builder()
                .email("hhhtp@gmail.com")
                .full_name("Error")
                .password("123456")
                .generate_magic_link(false)
                .build();
        Response response = postRequest(endpoint, 200, requestBody);
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("email"));
        deleteCreatedUser(endpoint, "hhhtp@gmail.com");
    }

    @Test @Description("Create user without email")
    public void CreateUserWithoutEmail() {
        SuccessCreateUserRequest requestBody = SuccessCreateUserRequest.builder()
                .full_name("Jojo")
                .password("123456")
                .generate_magic_link(false)
                .build();
        ErrorMessageResponse response = postRequest(endpoint, 400, requestBody)
                .body().jsonPath().getObject("", ErrorMessageResponse.class);
        assertEquals("Bad Request", response.getCode());
        assertEquals("Something went wrong, please try again.", response.getMessage());
    }


    @Test @Description("Create user with invalid name")
    public void createUserWithInvalidName() {
        SuccessCreateUserRequest requestBody = createTestUser("Qaaaa@gmail.com", "   _67465365&&$&$&%§§$$$$$$$$$$$$$$$$$$$$$", "111333", false);
        Response response = postRequest(endpoint, 400, requestBody);//assert
        System.out.println(requestBody.getFull_name());
        String responseBody = response.getBody().asString();
        assertFalse(responseBody.contains("full_name"));
        deleteCreatedUser(endpoint, "Qaaaa@gmail.com");
    }

    @Test @Description("Create user with empty password")
    public void createUserWithEmptyPassword() {
        SuccessCreateUserRequest requestBody = createTestUser("Qaaaa@gmail.com", "Tom Test", " ", false);
        Response response = postRequest(endpoint, 400, requestBody);//201 bug
        System.out.println(requestBody);
        String responseBody = response.getBody().asString();
        assertFalse(responseBody.contains("password"));
        deleteCreatedUser(endpoint, "Qaaaa@gmail.com");

    }

    @Test @Description("Create user with empty body")
    public void createUserWithEmptyBody() {
        SuccessCreateUserRequest requestBody = createTestUser("", "", "", false);
        ErrorMessageResponse errorResponse = postRequest(endpoint, 400, requestBody)
                .body().jsonPath().getObject("", ErrorMessageResponse.class);
        assertEquals("Bad Request", errorResponse.getCode());
        assertEquals("Something went wrong, please try again.", errorResponse.getMessage());
    }

    @Test @Description("Create user with invalid name")
    public void createUserWithoutAtInEmail() {
        SuccessCreateUserRequest requestBody = createTestUser("QaaaaAtgmail.com", "Tom Test", "123456", false);
        Response createResponse = postRequest(endpoint, 200, requestBody); //bug
        assertThat(createResponse.getStatusCode(), Matchers.equalTo(200));
        ErrorMessageResponse errorResponse = postRequest(endpoint, 400, requestBody)
                .body().jsonPath().getObject("", ErrorMessageResponse.class);
        assertEquals("Bad Request", errorResponse.getMessage());
        deleteCreatedUser(endpoint, "QaaaaAtgmail.com");
    }

    @AfterEach
    @Test
    public void deleteCreatedUser(String endpoint, String userEmail) {
        deleteRequest(endpoint + userEmail, 200);
    }








}

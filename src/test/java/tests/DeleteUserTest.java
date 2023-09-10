package tests;

import dto.ErrorMessageResponse;
import dto.SuccessCreateUserRequest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteUserTest extends BaseTest{

    String endpoint = "/users/";
    private static final String TEST_EMAIL = "hhhtp@gmail.com";
    private static final String TEST_FULL_NAME = "Qa_aQ";
    private static final String TEST_PASSWORD = "123456";
    private static final boolean TEST_GENERATE_MAGIC_LINK = false;
    @Test @Description("Successful delete user")
    public void successDeleteUser() {
        SuccessCreateUserRequest requestBody = createTestUser(TEST_EMAIL, TEST_FULL_NAME, TEST_PASSWORD, TEST_GENERATE_MAGIC_LINK);
        Response createResponse = postRequest(endpoint, 200, requestBody); //bug
        assertThat(createResponse.getStatusCode(), Matchers.equalTo(200));
        Response deleteResponse = deleteRequest(endpoint + TEST_EMAIL, 200);
        assertThat(deleteResponse.getStatusCode(), Matchers.equalTo(200));
    }

    @Test @Description("Delete user after delete")
    public void deleteUserAfterDelete() {
        SuccessCreateUserRequest requestBody = createTestUser(TEST_EMAIL, TEST_FULL_NAME, TEST_PASSWORD, TEST_GENERATE_MAGIC_LINK);
        Response createResponse = postRequest(endpoint, 200, requestBody);
        assertThat(createResponse.getStatusCode(), Matchers.equalTo(200));

        Response deleteResponse = deleteRequest(endpoint + TEST_EMAIL, 200);
        assertThat(deleteResponse.getStatusCode(), Matchers.equalTo(200));

        Response deleteAgainResponse = deleteRequest(endpoint + TEST_EMAIL, 404);
        assertThat(deleteAgainResponse.getStatusCode(), Matchers.equalTo(404));
        String expectedErrorMessage = "User with email: hhhtp@gmail.com not found";
        ErrorMessageResponse errorMessage = deleteAgainResponse.as(ErrorMessageResponse.class);
        String actualErrorMessage = errorMessage.getMessage();

        assertThat(actualErrorMessage, Matchers.equalTo(expectedErrorMessage));
        System.out.println(deleteAgainResponse.asString());
    }

    @Test @Description("Get deleted user")
    public void getUserAfterDelete() {
        SuccessCreateUserRequest requestBody = createTestUser(TEST_EMAIL, TEST_FULL_NAME, TEST_PASSWORD, TEST_GENERATE_MAGIC_LINK);
        Response createUserResponse = postRequest(endpoint, 200, requestBody); //bug
        assertThat(createUserResponse.getStatusCode(), Matchers.equalTo(200));

        Response deleteUserResponse = deleteRequest(endpoint + TEST_EMAIL, 200);
        assertThat(deleteUserResponse.getStatusCode(), Matchers.equalTo(200));

        Response getUserResponse = getRequest(endpoint + TEST_EMAIL, 400);

        String errorCode = getUserResponse.jsonPath().getString("code");
        String errorMessage = getUserResponse.jsonPath().getString("message");

        assertThat(getUserResponse.getStatusCode(), Matchers.equalTo(400));

        assertEquals("Bad Request", errorCode);
        assertEquals("Something went wrong, please try again.", errorMessage);

    }

}

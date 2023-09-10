package tests;

import static io.restassured.RestAssured.given;

public class RegistrationTest {

//    @Test
//    public void successRegistration() {
//        ValidUserRequest requestBody = new ValidUserRequest("eve.holt@reqres.in", "pistol");
//        SuccessRegistrationResponse response = given().baseUri("https://reqres.in")
//                .body(requestBody)
//                .when().log().all()
//                .contentType(ContentType.JSON)
//                .post("/api/register")
//                .then().log().all()
//                .statusCode(200).extract().body()
//                .jsonPath().getObject("", SuccessRegistrationResponse.class);
//        System.out.println(response.getToken());
//        //all fields not empty
//        assertFalse(response.getToken().isEmpty());
////        assertFalse(response.getId().);
//        assertNotNull(response.getId());
//    }
}
/*
    @Test
    public void registerWithoutPassword() {
        RegistrationRequest requestBody = new RegistrationRequest("eve.holt@reqres.in", "");
        UnsuccessfulRegistrationResponse response = given().baseUri("https://reqres.in")
                .body(requestBody)
                .when().log().all()
                .contentType(ContentType.JSON)
                .post("/api/register")
                .then().log().all()
                .statusCode(400).extract().body()
                .jsonPath().getObject("", UnsuccessfulRegistrationResponse.class);
        System.out.println(response.getError());

        //check that error message text is Missing password
        assertEquals("Missing password", response.getError());
    }

    @Test
    public void registerWithoutEmail() {
        RegistrationRequest requestBody = new RegistrationRequest("", "pistol");
        UnsuccessfulRegistrationResponse response = given().baseUri("https://reqres.in")
                .body(requestBody)
                .when().log().all()
                .contentType(ContentType.JSON)
                .post("/api/register")
                .then().log().all()
                .statusCode(400).extract().body()
                .jsonPath().getObject("", UnsuccessfulRegistrationResponse.class);
        System.out.println(response.getError());

        //check that error message text is Missing email or username
        assertEquals("Missing email or username", response.getError());
    }

    @Test
    public void registerWithEmptyFields() {
        RegistrationRequest requestBody = new RegistrationRequest("", "");
        UnsuccessfulRegistrationResponse response = given().baseUri("https://reqres.in")
                .body(requestBody)
                .when().log().all()
                .contentType(ContentType.JSON)
                .post("/api/register")
                .then().log().all()
                .statusCode(400).extract().body()
                .jsonPath().getObject("", UnsuccessfulRegistrationResponse.class);
        System.out.println(response.getError());

        //check that error message text is Missing email or username
        assertEquals("Missing email or username", response.getError());
    }
    //veryloooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong

    @Test
    public void registerWithInvalidData() {
        RegistrationRequest requestBody = new RegistrationRequest("eve111.holt@reqres.in", "pistol");
        UnsuccessfulRegistrationResponse response = given().baseUri("https://reqres.in")
                .body(requestBody)
                .when().log().all()
                .contentType(ContentType.JSON)
                .post("/api/register")
                .then().log().all()
                .statusCode(400).extract().body()
                .jsonPath().getObject("", UnsuccessfulRegistrationResponse.class);
        System.out.println(response.getError());

        //check that error message text is Note: Only defined users succeed registration
        assertEquals("Note: Only defined users succeed registration", response.getError());
    }

    @Test
    public void registerWithInvalidPassword() {
        RegistrationRequest requestBody = new RegistrationRequest("eve.holt@reqres.in", "pistol111");
        UnsuccessfulRegistrationResponse response = given().baseUri("https://reqres.in")
                .body(requestBody)
                .when().log().all()
                .contentType(ContentType.JSON)
                .post("/api/register")
                .then().log().all()
                .statusCode(400).extract().body()
                .jsonPath().getObject("", UnsuccessfulRegistrationResponse.class);
        System.out.println(response.getError());

        //check that error message text is Note: Only defined users succeed registration
        assertEquals("Note: Only defined users succeed registration", response.getError());
    }
}*/
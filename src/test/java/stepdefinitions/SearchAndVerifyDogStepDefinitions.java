package stepdefinitions;
/*
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
*/

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import javax.swing.text.AbstractDocument;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;


public class SearchAndVerifyDogStepDefinitions {
    private RequestSpecification request;
    private Response response;


    @Given("client is on the home page")
    public void client_is_on_the_home_page() {
        String baseUri = "https://dog.ceo/api/breed/";
        String loginPath = "hound/images";
/*
        sessionToken = given()
                .baseUri(baseUri)
                .basePath(loginPath)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract().body().asString();
*/
        request = given()
                .baseUri(baseUri)
                .basePath(loginPath);
//        System.out.println(request.toString());
    }

    @When("the clients wants to look at random dogs")
    public void the_clients_wants_to_look_at_random_dogs() {
        response = request.when().get();
    }

    @Then("a successful message must be received")
    public void a_successful_message_must_be_received() {
        String responseString = response
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON)
                .extract().asString();
        System.out.println("Response string is: " + responseString);
    }

}

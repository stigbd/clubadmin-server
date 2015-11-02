package stigbd.clubmemberservice.rest;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class MemberAPIStepsIT {

    final Logger logger = Logger.getLogger(MemberAPIStepsIT.class.getName());
    final Client client = ClientBuilder.newClient(new ClientConfig());

    private String url;
    private String statusCode;
    private String headerLocation;
    private String inputJsonString;
    private String responseJsonString;
    private Map<String, String> inputMap;

    @Given("^the following member-information$")
    public void the_following_member_information(Map<String,String> arg1) throws Throwable {

        inputMap = arg1;
        Gson gson = new Gson();
        inputJsonString = gson.toJson(inputMap);
        logger.log(Level.INFO, "json_structure = " + inputJsonString);
    }

    @When("^the client posts the input to \"([^\"]*)\"$")
    public void the_client_posts_the_input_to(String arg1) throws Throwable {
        url = arg1;
        Response response = client.target(url)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(inputJsonString, MediaType.APPLICATION_JSON));
        statusCode = Integer.toString(response.getStatus());
        headerLocation = response.getLocation().toString();
    }

    @Then("^a \"([^\"]*)\" status should be returned$")
    public void a_status_should_be_returned(String arg1) throws Throwable {
        assertEquals(arg1, statusCode);
    }

    @When("^the client gets the member by header location$")
    public void the_client_gets_the_member_by_header_location() throws Throwable {
        Response response = client.target(headerLocation)
                .request(MediaType.APPLICATION_JSON)
                .get();
        statusCode = Integer.toString(response.getStatus());
        responseJsonString = response.readEntity(String.class);
    }

    @Then("^the saved member matches the inputs$")
    public void the_saved_member_matches_the_inputs() throws Throwable {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> responseMap = gson.fromJson(responseJsonString, type);
        for (String field : inputMap.keySet()) {
            assertEquals(responseMap.get(field), inputMap.get(field));
        }
    }

    @Then("^the saved member has an id$")
    public void the_saved_member_has_an_id() throws Throwable {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> responseMap = gson.fromJson(responseJsonString, type);
        assertNotNull(responseMap.get("id"));
        assertTrue(responseMap.get("id").length() > 0);
    }

    @Given("^the following member-information exists$")
    public void the_following_member_information_exists(Map<String,String> arg1) throws Throwable {
        inputMap = arg1;
        url = "http://localhost:8080/ClubMemberService/";
        Gson gson = new Gson();
        inputJsonString = gson.toJson(inputMap);
        Response response = client.target(url)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(inputJsonString, MediaType.APPLICATION_JSON));
        statusCode = Integer.toString(response.getStatus());
        headerLocation = response.getLocation().toString();
    }

    @When("^the client puts the following updated information")
    public void the_client_puts_the_following_updated_information(Map<String,String> arg1) throws Throwable {
        url = headerLocation;
        inputMap = arg1;
        Gson gson = new Gson();
        inputJsonString = gson.toJson(inputMap);
        Response response = client.target(url)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(inputJsonString, MediaType.APPLICATION_JSON));
        statusCode = Integer.toString(response.getStatus());
    }

    @Then("^the member should contain the updated information$")
    public void the_member_should_contain_the_updated_information() throws Throwable {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> responseMap = gson.fromJson(responseJsonString, type);
        for (String field : inputMap.keySet()) {
            assertEquals(responseMap.get(field), inputMap.get(field));
        }
    }

    @When("^the client deletes the member")
    public void the_client_deletes_the_member() throws Throwable {
        url = headerLocation;
        Response response = client.target(url)
                .request(MediaType.APPLICATION_JSON)
                .delete();
        statusCode = Integer.toString(response.getStatus());
        responseJsonString = response.readEntity(String.class);
    }
}

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class RestAssuredTests {
	
	private static final String urlGet = "https://reqres.in/api/users?page=2";
	private static final String urlPost = "https://reqres.in/api/users";

	@Test
	void getMethod() {

		Response response = get(urlGet); //Using a dummy API from this URL

		System.out.println(response.getBody().asString()); //Print API Body
		System.out.println(response.getStatusCode()); //Print Status code 
		
		given()
			.get(urlGet)
			.then()
			.statusCode(200) //Asserting the status code
			.body("data.id[1]", equalTo(8)) //Checking ID of the 1st index from the body
			.body("data.first_name", hasItems("Michael", "Lindsay", "Rachel")); //Checking 1st names from the body

	}
	
	@Test
	void postMethod() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Fugetron");
		request.put("job", "Automation QA");
		
		System.out.println(request); //Print in JSON format
		
		given()
			.body(request.toJSONString())
			.when()
			.post(urlPost)
			.then()
			.statusCode(201); //Asserting the status code
	
	}

}

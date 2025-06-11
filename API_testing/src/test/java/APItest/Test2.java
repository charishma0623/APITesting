package APItest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test2 {
	@Test
	public void main() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		//System.out.println(response.getBody().asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		String email = response.jsonPath().getString("data[0].email");
		System.out.println(email);
		//Assert.assertEquals(email,"janet.weaver@reqres.in");
		int totalpages = response.jsonPath().getInt("total_pages");
		System.out.println("total pages: "+totalpages);
	}

}

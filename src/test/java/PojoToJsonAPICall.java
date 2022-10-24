
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

import io.restassured.RestAssured ;
public class PojoToJsonAPICall {

	public static void main(String[] args) {
	//apache common lang3 api	dynamic data create.
	String randomString=RandomStringUtils.randomAlphabetic(2);
	String randomInt= RandomStringUtils.randomNumeric(5);

	//Random class for dynamic data create 
	Random rd= new Random();
	
	System.out.println(randomInt);
	System.out.println(randomString);
	
		DataPojo dp= new DataPojo();
		dp.setName("MR"+randomString.toLowerCase()+" "+randomString.toLowerCase());
		dp.setJob(randomString);
		dp.setSalary(rd.nextInt(1000));
		//api 
		RestAssured.baseURI = "https://reqres.in/";
		RestAssured.basePath = "/api/users";
		RestAssured
		.given()
			.contentType("application/json; charset=utf-8")
			.log()
			.all()
			.body(dp)
		.when()
			.post()
		.then()
			.statusCode(201)
			.log()
			.all()
			.extract()
			.body()
			.asPrettyString();
	
	}

	
}

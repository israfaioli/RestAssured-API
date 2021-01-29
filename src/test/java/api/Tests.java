package api;

import model.Activity;
import org.junit.Test;

import common.Base;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static utils.Helpers.getIntegerNumber;
import static utils.Helpers.getNewTitle;

public class Tests extends Base {

	private static final Integer randomId = getIntegerNumber(4);
	private static final String randomTitle = getNewTitle();
	private static final Integer alteredId = 13;

	@Test
	public void validateActivityContractClasses() {
		given()
		.when()
				.get("/Activities")
		.then()
				.statusCode(200)
				.body("id[0]", isA(Integer.class))
				.body("title[0]", isA(String.class))
				.body("dueDate[0]", isA(String.class))
				.body("completed[0]", isA(Boolean.class))
		;
	}
	
	@Test
	public void getAllActivities() {
		given()
		.when()
				.get("/Activities")
		.then()
				.statusCode(200)
				.body("$.size()", is(30))
				.body("id[11]", is(12))
				.body("title[11]", is("Activity 12"))
				.body("dueDate[11]", containsString("2021-01-29"))
				.body("completed[11]", is(true))
		;
	}

	@Test
	public void postNewActivity() {
		Activity activity = Activity.builder()
				.id(randomId)
				.title(randomTitle)
				.dueDate("2022-01-28T23:47:49.422Z")
				.completed(false)
				.build();

		given()
				.body(activity)
		.when()
				.post("/Activities")
		.then()
				.statusCode(200)
				.body("id", is(randomId))
				.body("title", is(randomTitle))
				.body("dueDate", containsString("2022-01-28"))
				.body("completed", is(false))
		;
	}

	@Test
	public void putExistentActivity() {
		Activity activity = Activity.builder()
				.id(13)
				.title(randomTitle)
				.dueDate("2022-01-28T23:47:49.422Z")
				.completed(false)
				.build();

		given()
				.body(activity)
				.pathParam("id", alteredId)
		.when()
				.put("/Activities/{id}")
		.then()
				.statusCode(200)
				.body("id", is(13))
				.body("title", is(randomTitle))
				.body("dueDate", containsString("2022-01-28"))
				.body("completed", is(false))
		;
	}

	@Test
	public void deleteExistentActivity() {
		Activity activity = Activity.builder()
				.id(randomId)
				.title(randomTitle)
				.dueDate("2022-01-28T23:47:49.422Z")
				.completed(false)
				.build();

		Integer excludedId = given()
				.body(activity)
				.when()
				.post("/Activities")
				.then().extract().path("id");

		given()
				.pathParam("id", excludedId)
		.when()
				.delete("/Activities/{id}")
		.then()
				.statusCode(200)
		;

	}

}

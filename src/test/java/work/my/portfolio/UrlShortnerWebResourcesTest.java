package work.my.portfolio;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import work.my.portfolio.entity.Shortner;
import work.my.portfolio.service.ShortnerClientService;

@QuarkusTest
@TestHTTPEndpoint(UrlShortnerWebResources.class)
class UrlShortnerWebResourcesTest {

	@InjectMock
	@RestClient
	private ShortnerClientService service;

	@Test
	void test_getInputPage() {
		given()
				.when()//
				.get()// TestHTTPEndpointで設定してるので引数不要
				.then()
				.contentType(ContentType.HTML)
				.statusCode(200)
				.body(containsString("<title>UrlShortner</title>"));
	}

	@Test
	void test_onConvertButtonClicked() {
		when(service.getShortnerByLongUrl(anyString())).thenReturn(new Shortner("test", "test"));
		given()
		.when()//
		.formParam("longUrl", "https://www.test.com")//
		.post()//
		.then()
		.contentType(ContentType.HTML)
		.statusCode(200)
		.body(containsString("<title>UrlShortner Output</title>"));
	}

	@Test
	void test_createShortUrlForExternalService() {
		when(service.getShortnerByLongUrl(anyString())).thenReturn(new Shortner("shortUrl", "longUrl"));
		given()
		.when()//
		.body("https://www.test.com")//
		.post("/external")//
		.then()
		.contentType(ContentType.TEXT)
		.statusCode(200)
		.body(containsString("shortUrl"));
	}

}

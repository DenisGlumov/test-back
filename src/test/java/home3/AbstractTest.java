package home3;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest {

    static Properties prop = new Properties();
    private static InputStream configFile;
    private static String apiKey;
    private static String baseUrl;
    protected static ResponseSpecification responseSpecification;
    protected static RequestSpecification requestSpecification;
    protected static RequestSpecification requestSpecificationShoppingList;

    @BeforeAll
    static  void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resources/general.properties");
        prop.load(configFile);

        apiKey = prop.getProperty("apiKey");
        baseUrl = prop.getProperty("base_url");

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .build();

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .build();

        requestSpecificationShoppingList = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .addQueryParam("hash", "4cff46e48bc0b34aa67e096741b1339d9f05d2c4")
                .addQueryParam("username", "88c3f9fa-a337-4a33-9057-ec74b43a0ac9")
                .build();


    }

    public static String getApikey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }
}

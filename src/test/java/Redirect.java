import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Redirect {
    @Test
    public void redirect() {

        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        System.out.println(response.getHeader("Location"));
    }

    @Test
    public void longRedirect() {
        String location = "https://playground.learnqa.ru/api/long_redirect";
        int status = 0;
        while (status != 200) {
            Response response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .get(location)
                    .andReturn();

            String tempLocation = response.getHeader("Location");
            location = tempLocation;
            status = response.getStatusCode();
            if (status != 200)
                System.out.println(tempLocation);
        }
    }
}

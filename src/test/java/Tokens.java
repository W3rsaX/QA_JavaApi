import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class Tokens {
    @Test
    public void tokens() throws InterruptedException {
        JsonPath responseAddTask = RestAssured
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String token = responseAddTask.get("token");
        int time = (int) responseAddTask.get("seconds") * 1000;

        JsonPath responseGetStatus = RestAssured
                .given()
                .param("token", token)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();



        String status = responseGetStatus.get("status");
        System.out.println(status);

        Thread.sleep(time);

        JsonPath responseGetRes = RestAssured
                .given()
                .param("token", token)
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        status = responseGetRes.get("status");
        System.out.println(status);

        String result = responseGetRes.get("result");
        System.out.println(result);

    }
}

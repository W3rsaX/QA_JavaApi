import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class JsonParsing {
    @Test
    public void jsonParsing(){

        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();

        ArrayList answer = response.get("messages");
        System.out.println(answer.get(1));

    }
}

package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeserializeDto() throws IOException {
        String json = "{\"id\":\"238f3e41-13d8-4704-9900-59c1e18b6c0a\",\"beer-name\":\"BeerName\",\"beer-style\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"created-date\":\"2020-09-03T12:22:46.2141206+02:00\",\"last-updated-date\":\"2020-09-03T12:22:46.2151199+02:00\"}";
        BeerDto dto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(dto);
    }
}

package com.profile.test.integration;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = "spring.flyway.locations=classpath:db/migration")
@AutoConfigureMockMvc
public class PriceIT {

    public static final String PATH_JSON_FILES = "src/test/resources/__files/prices/";

    @Autowired
    private MockMvc mvc;

    @Test
    void getPricesTest_whenNotExists_shouldReturnNotFound() throws Exception {
        mvc.perform(
                        get("/api/v1/price?date=2021-06-14T10:00:00.000+01:00&productId=35455&brandId=1"))
                .andExpect(status().isNotFound());
    }

    @ParameterizedTest
    @MethodSource("pricesSource")
    void getPrices_whenExists_shouldReturnPrice(String date, String productId, String brandId, String responseJson) throws Exception {
        var result = mvc.perform(
                        get("/api/v1/price?date={date}&productId={productId}&brandId={brandId}", date, productId, brandId))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertJsonResponse(result, PATH_JSON_FILES + responseJson);
    }

    private Stream<Arguments> pricesSource() {
        return Stream.of(
                Arguments.of("2020-06-14T10:00:00.000+01:00", "35455", "1", "response1.json"),
                Arguments.of("2020-06-14T16:00:00.000+01:00", "35455", "1", "response2.json"),
                Arguments.of("2020-06-14T21:00:00.000+01:00", "35455", "1", "response3.json"),
                Arguments.of("2020-06-15T10:00:00.000+01:00", "35455", "1", "response4.json"),
                Arguments.of("2020-06-16T21:00:00.000+01:00", "35455", "1", "response5.json")
        );
    }

    private void assertJsonResponse(String response, String jsonFileExpected) throws IOException, JSONException {
        File file = new File(jsonFileExpected);
        String expected = Files.readString(file.toPath(), StandardCharsets.UTF_8);
        JSONAssert.assertEquals(expected, response, JSONCompareMode.STRICT);
    }
}

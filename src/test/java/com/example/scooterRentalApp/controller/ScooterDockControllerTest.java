package com.example.scooterRentalApp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ScooterDockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ifGetScootersRequestContainsDockIdWhichNotExistShouldReturnHttpCode409AndError() throws Exception {
        mockMvc
                .perform(get("/scooter-dock/{scooterDockId}/scooters", 9999))
                .andExpect(status().is(409))
                .andExpect(content().json("{\n" +
                        "\t\"errorCode\": \"ERR008\",\n" +
                        "\t\"errorMsg\": \"Dok o podanym id nie istnieje.\",\n" +
                        "\t\"status\": \"ERROR\"\n" +
                        "}"));
    }

    @Test
    public void ifGetScootersRequestIsCorrectShouldReturnHttpCode200AndInitialScooterList() throws Exception {
        mockMvc
                .perform(get("/scooter-dock/{scooterDockId}/scooters", 1))
                .andExpect(status().is(200))
                .andExpect(content().json(
                        "[{"
                        + "   \"id\": 6,"
                        + "   \"modelName\": \"RTT-43z\","+
                        "\t\"maxSpeed\": 20,\n" +
                        "\t\"rentalPrice\": 15.50\n" +
                        "},\n" +
                        "{\n" +
                        "\t\"id\": 7,\n" +
                        "\t\"modelName\": \"V-SPEED-1\",\n" +
                        "\t\"maxSpeed\": 35,\n" +
                        "\t\"rentalPrice\": 29.99\n" +
                        "},\n" +
                        "{\n" +
                        "\t\"id\": 8,\n" +
                        "\t\"modelName\": \"V-SPEED-2\",\n" +
                        "\t\"maxSpeed\": 40,\n" +
                        "\t\"rentalPrice\": 39.99\n" +
                        "},\n" +
                        "{\n" +
                        "\t\"id\": 5,\n" +
                        "\t\"modelName\": \"ERE-321\",\n" +
                        "\t\"maxSpeed\": 25,\n" +
                        "\t\"rentalPrice\": 19.99\n" +
                        "}]")
                );
    }
}





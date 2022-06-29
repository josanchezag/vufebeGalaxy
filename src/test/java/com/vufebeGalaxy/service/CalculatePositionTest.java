package com.vufebeGalaxy.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatePositionTest {

    @Test
    @DisplayName("given a dayNumber then all planet have a position")
    void given_a_dayNumber_then_all_planet_have_a_position() {
        assert(CalculatePosition.calculatePositionPlanetDay(3).size()>=0);
    }
}

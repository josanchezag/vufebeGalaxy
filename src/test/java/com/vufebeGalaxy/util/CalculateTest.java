package com.vufebeGalaxy.util;

import com.vufebeGalaxy.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculateTest {

    @Test
    @DisplayName("given 2 Points then distance between is positive")
    void given_2_points_then_distance_between_is_positive(){
        assert(Calculate.calculateDistanceP2P(new Point(1,1),new Point(10,20))>=0);
    }
}

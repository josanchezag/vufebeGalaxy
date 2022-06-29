package com.vufebeGalaxy.util;

import com.vufebeGalaxy.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class TriangleTest {
    private Triangle tritest;
    @BeforeEach
    void setup(){
        this.tritest=new Triangle(new Point(1,1),new Point(3,3),new Point(6,1));
    }

    @Test
    @DisplayName("given triangle then perimeter positive")
    void given_triangle_then_perimeter_positive(){
        assert(tritest.calculatePerimeter()>0);
    }
    @Test
    @DisplayName("given triangle then validate point into area")
    void given_triangle_then_validate_point_true(){
        assertFalse(tritest.pointIntoTriangle(new Point(5,-5)));
    }
    @Test
    @DisplayName("given triangle then validate point out area")
    void given_triangle_then_validate_point_false(){
        assert(tritest.pointIntoTriangle(new Point(3,2)));
    }
}

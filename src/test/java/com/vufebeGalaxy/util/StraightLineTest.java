package com.vufebeGalaxy.util;

import com.vufebeGalaxy.model.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StraightLineTest {
    private StraightLine linetest;
    @BeforeEach
    void setup(){
        this.linetest=new StraightLine();
    }

    @Test
    @DisplayName("given StraightLine then Slop is a number")
    void given_StraightLine_then_Slop_is_a_nume(){
        assertDoesNotThrow(()->linetest.calculateSlop(new Point(1,1),new Point(5,5)));
    }@Test
    @DisplayName("given StraightLine then slop is infinity")
    void given_StraightLine_then_Slop_is_infinity(){
        linetest.calculateSlop(new Point(5,1),new Point(5,5));
        assertFalse(this.linetest.getM()>0);
    }
}

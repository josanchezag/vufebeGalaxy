package com.vufebeGalaxy.service.impl;

import com.vufebeGalaxy.model.Day;
import com.vufebeGalaxy.model.Point;
import com.vufebeGalaxy.model.conts.Constants;
import com.vufebeGalaxy.service.CalculatePosition;
import com.vufebeGalaxy.util.StraightLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ImplWeatherTest {
    private ImplWeather weathertest;
    @BeforeEach
    void setup(){
        this.weathertest=new ImplWeather(new StraightLine());
    }

    @Test
    @DisplayName("given a positions planet then obstains a sunny day")
    void given_a_positions_planet_then_obstains_a_sunny_day() throws Exception {
        List<Point> points= new ArrayList<Point>();
        points.add(new Point(1,1));
        points.add(new Point(3,3));
        points.add(new Point(6,6));
        this.weathertest.getLine().calculateStraightLineEquation(points.get(0),points.get(1));
        assert(Constants.SUNNY
                .equals(this.weathertest
                        .validateSunnyDay(points)));
    }
    @Test
    @DisplayName("given a positions planet then obstains a raining day")
    void given_a_positions_planet_then_obstains_a_raining_day() throws Exception {
        List<Point> points= new ArrayList<Point>();
        points.add(new Point(0,5));
        points.add(new Point(-3,-3));
        points.add(new Point(3,-3));
        this.weathertest.getLine().calculateStraightLineEquation(points.get(0),points.get(1));
        assert(Constants.RAINING
                .equals(this.weathertest
                        .validateRainingDay(points)));
    }
    @Test
    @DisplayName("given a positions planet then obstains a optimize day")
    void given_a_positions_planet_then_obstains_a_optimize_day() throws Exception {
        List<Point> points= new ArrayList<Point>();
        points.add(new Point(0,5));
        points.add(new Point(5,0));
        points.add(new Point(10,-5));
        this.weathertest.getLine().calculateStraightLineEquation(points.get(0),points.get(1));
        assert(Constants.OPTIMIZE
                .equals(this.weathertest
                        .validateOptimizeDay(points)));
    }
}

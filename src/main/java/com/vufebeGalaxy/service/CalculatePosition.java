package com.vufebeGalaxy.service;


import com.vufebeGalaxy.model.Point;
import com.vufebeGalaxy.model.enums.EnumPlanet;
import com.vufebeGalaxy.util.Calculate;

import java.util.ArrayList;
import java.util.List;

public class CalculatePosition {

    public static List<Point> calculatePositionPlanetDay(Integer nDay) throws Exception {
        List<Point> points=new ArrayList<Point>(3);
        for(EnumPlanet planet:EnumPlanet.values()) {
            var angle = Calculate.caculateAnglePlanetPositionByDay(nDay, planet.getAngularVelocity());
            switch (Calculate.validateQuadrantCartesianPlane(angle, planet.getOrientation())) {
                case 1:
                    points.add(new Point(Calculate.roundInto2Decimal(Math.sin(angle) * planet.getSunDistance()),
                            Calculate.roundInto2Decimal(Math.cos(angle) * planet.getSunDistance()))
                    );
                    break;
                case 2:
                    points.add(new Point(Calculate.roundInto2Decimal(Math.sin(angle) * planet.getSunDistance()),
                            -1 * Calculate.roundInto2Decimal(Math.cos(angle) * planet.getSunDistance()))
                    );
                    break;
                case 3:
                    points.add(new Point(Calculate.roundInto2Decimal(-1 * Math.sin(angle) * planet.getSunDistance()),
                            -1 * Calculate.roundInto2Decimal(Math.cos(angle) * planet.getSunDistance()))
                    );
                    break;
                case 4:
                    points.add(new Point(Calculate.roundInto2Decimal(-1 * Math.sin(angle) * planet.getSunDistance()),
                            Calculate.roundInto2Decimal(Math.cos(angle) * planet.getSunDistance()))
                    );
                    break;
            }
        }
        return points;
    }
}

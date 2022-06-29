package com.vufebeGalaxy.util;

import com.vufebeGalaxy.model.Point;

public class Calculate {

    public static double roundInto2Decimal(double num){
        return Math.round(num*100.0)/100.0;
    }

    public static double calculateDistanceP2P(Point p1, Point p2){
        return Math.sqrt(Math.pow(Math.abs(p2.getX()-p1.getX()),2)+Math.pow(Math.abs(p2.getY()-p1.getY()),2));
    }
    /**
    @Description: Return the Angle in radians depending the day number
    * */
	public static double caculateAnglePlanetPositionByDay(Integer nDay,double angularVelocity){
        return nDay*Math.toRadians(angularVelocity);
    }

    public static Integer validateQuadrantCartesianPlane(double angle,String orientation) {
        if ("+".equals(orientation)){
            if(angle>=0&&angle<=90) return 1;
            else if (angle>90&&angle<=180) return 2;
            else if (angle>180&&angle<=270) return 3;
            else  return 4;
        }
        else {
            if(angle>=0&&angle<=90) return 4;
            else if (angle>90&&angle<=180) return 3;
            else if (angle>180&&angle<=270) return 2;
            else  return 1;
        }
    }



}

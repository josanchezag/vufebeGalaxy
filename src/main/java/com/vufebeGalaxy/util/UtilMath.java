package com.vufebeGalaxy.util;

import com.vufebeGalaxy.model.Position;

public class UtilMath {
	public static double graArad(double angle)
	{
	return angle*Math.PI/180.0;

	}
	public static double caculateAngleInRadiansByDay(Integer nDay,double angularVelocity){
        return nDay*angularVelocity*Math.PI/180;
    }
    public static Integer validateQuadrantCartesianPlane(double angle) {
        if(angle>=0&&angle<=90) return 1;
        else if (angle>90&&angle<=180) return 2;
        else if (angle>180&&angle<=270) return 3;
        else  return 4;
    }

}

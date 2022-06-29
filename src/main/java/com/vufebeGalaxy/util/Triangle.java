package com.vufebeGalaxy.util;

import com.vufebeGalaxy.model.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Triangle {
    private Point p1;
    private Point p2;
    private Point p3;

    public double calculatePerimeter(){
        return Calculate.calculateDistanceP2P(p1,p2)+Calculate.calculateDistanceP2P(p1,p3)+Calculate.calculateDistanceP2P(p2,p3);
    }

    public boolean pointIntoTriangle(Point p){
        double l1=Calculate.calculateDistanceP2P(p1,p2);
        double l2=Calculate.calculateDistanceP2P(p1,p3);
        double l3=Calculate.calculateDistanceP2P(p2,p3);
        double l4=Calculate.calculateDistanceP2P(p1,p);
        double l5=Calculate.calculateDistanceP2P(p2,p);
        double l6=Calculate.calculateDistanceP2P(p3,p);
        return (l1>=l4&&l1>=l5)&&
                (l2>=l6&&l2>=l4)&&
                (l3>=l5&&l3>=l6)
                ?true:false;
    }

}

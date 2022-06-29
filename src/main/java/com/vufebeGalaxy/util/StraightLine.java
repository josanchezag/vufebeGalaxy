package com.vufebeGalaxy.util;

import java.util.Objects;

import com.vufebeGalaxy.model.Point;


public class StraightLine {
	
	private double b;
	private double m;
	
	public double getB() {
		return b;
	}
	
	public double getM() {
		return m;
	}
	
	public StraightLine(double b, double m) {
		this.b = b;
		this.m = m;
	}
	
	public StraightLine() {

		this.b = 0;
		this.m = 0;
	}
	
	public void calculateStraightLineEquation(Point p1, Point p2) {
		calculateSlop(p1,p2);
		calculateB(p1);
	}
	
	public void calculateSlop (Point p1, Point p2){
		try {
			this.m = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
		}
		catch(Exception e){
			throw  e;
		}
    }
	
	public void calculateB (Point p){
        this.b= p.getY()-(this.m*p.getX());
    }
	
	public boolean validatePointinLine(Point p) {
		return Objects.equals(p.getY(), ((this.m*p.getX())+this.b))?true:false;
	}
	
	

}

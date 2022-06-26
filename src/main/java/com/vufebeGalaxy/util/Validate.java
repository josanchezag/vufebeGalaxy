package com.vufebeGalaxy.util;

import com.vufebeGalaxy.model.Position;

public class Validate {
	public static boolean validateInsideTriangle(Position s, Position a, Position b, Position c) {
		double as_x = s.getX()-a.getX(); 
		double as_y = s.getY()-a.getY(); 
		boolean s_ab = (b.getX()-a.getX())*as_y-(b.getY()-a.getY())*as_x > 0?true:false; 
		if((c.getX()-a.getX())*as_y-(c.getY()-a.getY())*as_x > 0 == s_ab) return false; 
		if((c.getX()-b.getX())*(s.getY()-b.getY())-(c.getY()-b.getY())*(s.getX()-b.getX()) > 0 != s_ab) return false; 
		return true; 
		}

	

}

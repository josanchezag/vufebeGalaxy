package com.vufebeGalaxy.model;

import com.vufebeGalaxy.model.enums.EnumPlanet;

import lombok.Data;

@Data
public class PlanetPosition {
	private EnumPlanet planet;
	private Point position;
	
	public void calculatePositionByDay(Integer day){
		
	}

}

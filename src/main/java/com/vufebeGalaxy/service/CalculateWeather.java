package com.vufebeGalaxy.service;

import java.util.List;

import com.vufebeGalaxy.model.Position;
import com.vufebeGalaxy.model.conts.Constants;
import com.vufebeGalaxy.service.interfaces.IWeather;

public class CalculateWeather{
	
	public String calculateWeather(List<Position> position) {
		
		return Constants.SUNNY;
	}


}

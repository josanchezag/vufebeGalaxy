package com.vufebeGalaxy.service.interfaces;

import java.util.List;


import com.vufebeGalaxy.model.Position;

@FunctionalInterface
public interface IWeather {
	public String calculateWeatherAtDay(List<Position> positions) throws Exception;

}

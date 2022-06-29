package com.vufebeGalaxy.service.interfaces;

import java.util.List;


import com.vufebeGalaxy.model.Day;
import com.vufebeGalaxy.model.Point;

@FunctionalInterface
public interface IWeather {
	public Day calculateWeatherAtDay(Integer nDay, List<Point> positions) throws Exception;

}

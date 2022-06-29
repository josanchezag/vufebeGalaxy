package com.vufebeGalaxy.service.impl;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import com.vufebeGalaxy.model.Day;
import com.vufebeGalaxy.model.Point;
import com.vufebeGalaxy.model.conts.Constants;
import com.vufebeGalaxy.service.interfaces.IWeather;
import com.vufebeGalaxy.util.StraightLine;
import com.vufebeGalaxy.util.Triangle;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImplWeather implements IWeather {
	private StraightLine line;

	@Override
	public Day calculateWeatherAtDay(Integer nDay,List<Point> positions) throws Exception {
		Triangle spacePlanets;
		if(positions.size()<2) {
			throw new Exception("Is necesary more than 2 poinst to calculate the LineStreigth");
		}
		else if (positions.size()>3)
			throw new Exception("Is necesary less than 4 poinst to calculate the LineStreigth");

		this.line.calculateStraightLineEquation(positions.get(0),positions.get(1));
		positions.add(Constants.SUN_POINT);
		if(!"".equals(validateSunnyDay(positions)))
			return new Day(nDay,Constants.SUNNY,0);
		else if(!"".equals(validateOptimizeDay(positions)))
			return new Day(nDay,Constants.OPTIMIZE,0);
		else if(!"".equals(validateRainingDay(positions)))
		{
			spacePlanets= new Triangle(positions.get(0),positions.get(1),positions.get(2));
			return new Day(nDay,Constants.RAINING,spacePlanets.calculatePerimeter());

		}

		else
		{
			spacePlanets= new Triangle(positions.get(0),positions.get(1),positions.get(2));
			return new Day(nDay,Constants.SIMPLE,spacePlanets.calculatePerimeter());
		}



	
	}
	
	public String validateSunnyDay(List<Point> positions) throws Exception {

		for(Point p:positions) {
			if(!line.validatePointinLine(p))
				return "";
		}
		return Constants.SUNNY;
		
	}
	
	public String validateOptimizeDay(List<Point> positions) throws Exception {
		
		if(!line.validatePointinLine(Constants.SUN_POINT)) {
			for(Point p:positions) {
				if(!line.validatePointinLine(p))
					return "";
			}	
			return Constants.OPTIMIZE;
		}
		else
			return "";
		
	}

	public String validateRainingDay(List<Point> positions) throws Exception {
		Triangle triangle=new Triangle(positions.get(0),positions.get(1),positions.get(2));
		var ban= triangle.pointIntoTriangle(Constants.SUN_POINT);
		return ban?Constants.RAINING:"";

	}

}

package com.vufebeGalaxy.service.interfaces;

import java.util.List;

import com.vufebeGalaxy.model.Position;
import com.vufebeGalaxy.model.conts.Constants;
import com.vufebeGalaxy.util.StraightLine;
import com.vufebeGalaxy.util.Validate;

public class ImplWeather implements IWeather{
	private StraightLine line=new StraightLine();

	@Override
	public String calculateWeatherAtDay(List<Position> positions) throws Exception {
		
		if(positions.size()<2) {
			throw new Exception("Is necesary more than 2 poinst to calculate the LineStreigth");
		}
		else if (positions.size()>3)
			throw new Exception("Is necesary less than 4 poinst to calculate the LineStreigth");
		
		this.line.calculateStraightLineEquation(positions.get(0),positions.get(1));
		if(!"".equals(validateSunnyDay(positions)))
			return Constants.SUNNY; 
		else if(!"".equals(validateOptimizeDay(positions)))
			return Constants.OPTIMIZE;
		else if(!"".equals(validateRainingDay(positions)))
			return Constants.RAINING;
		else 
			return Constants.RAINING;
	
	}
	
	public String validateSunnyDay(List<Position> positions) throws Exception {
		
		
		positions.add(new Position(0.0,0.0));
		for(Position p:positions) {
			if(!line.validatePointinLine(p))
				return "";
		}
		return Constants.SUNNY;
		
	}
	
	public String validateOptimizeDay(List<Position> positions) throws Exception {
		
		if(!line.validatePointinLine(new Position(0.0,0.0))) {
			for(Position p:positions) {
				if(!line.validatePointinLine(p))
					return "";
			}	
			return Constants.OPTIMIZE;
		}
		else
			return "";
		
	}

	public String validateRainingDay(List<Position> positions) throws Exception {
		
		
		String result=Validate.validateInsideTriangle(
				new Position(0.0,0.0),
				positions.get(0),
				positions.get(1),
				positions.get(2))?Constants.RAINING:"";
		return result;
	}

}

package com.vufebeGalaxy.controller;

import com.vufebeGalaxy.model.Point;
import com.vufebeGalaxy.model.conts.Constants;
import com.vufebeGalaxy.model.enums.EnumPlanet;
import com.vufebeGalaxy.service.CalculatePosition;
import com.vufebeGalaxy.service.impl.ImplWeather;
import com.vufebeGalaxy.util.StraightLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vufebeGalaxy.repository.IDayRepository;

import java.lang.invoke.ConstantBootstraps;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vufebeGalaxy.model.Day;

@RestController
@RequestMapping("/clima")
public class DayRestController {
	
	@Autowired
    IDayRepository dayRepository;

    

    @GetMapping
    public Optional<Day> getDay(@RequestParam(value = "dia", required = true) Integer id){
    		return dayRepository.findById(id);		
    }
    @GetMapping("/all")
    public List<Day> getAll(){
		return dayRepository.findAll();
		}

	@GetMapping("/allsunniesdays")
	public Integer getAllSunniesDays(){


		return dayRepository.findAll()
				.stream()
				.filter(weather-> Constants.SUNNY.equals(weather.getDsClima()))
				.collect(Collectors.toList())
				.size();
	}

	@GetMapping("/allrainsDays")
	public Integer allRainsDays(){

		return dayRepository.findAll()
				.stream()
				.filter(weather-> Constants.RAINING.equals(weather.getDsClima()))
				.collect(Collectors.toList())
				.size();
	}

	@GetMapping("/alloptimezadays")
	public Integer allOptimezaDays(){
		return dayRepository.findAll()
				.stream()
				.filter(weather-> Constants.OPTIMIZE.equals(weather.getDsClima()))
				.collect(Collectors.toList())
				.size();
	}

	@GetMapping("/rainiestDay")
	public Day allRainiestDays(){
		List <Day> respDay=dayRepository.findAll()
				.stream()
				.sorted(Comparator.comparingDouble(Day::getPerimeter))
				.collect(Collectors.toList());
		return respDay.size()>0?respDay.get(respDay.size()-1):new Day();
	}

    @PostMapping("/calculate")
    public List<Day> saveDaysWeather(@RequestParam(value = "dias", required = false) Integer dias){
		this.deleteAll();
    	List<Day> days=new ArrayList<Day>();
		List<Point> positions;
		try{
			for (int i=0;i<dias;i++) {
				positions=new ArrayList<Point>();
				positions=CalculatePosition.calculatePositionPlanetDay(i+1);
				ImplWeather weather=new ImplWeather(new StraightLine());
				days
						.add(weather.calculateWeatherAtDay((i+1),positions));

			}
		}
		catch(Exception e){e.printStackTrace();}

		return dayRepository.saveAll(days);
		}

    @DeleteMapping()
    public String deleteAll()
    {
    	try {
        	dayRepository.deleteAll();
    	}
    	catch(Exception e){
    		return e.getMessage();
    	}

		return "Conteo reiniciado";
    }

}

package com.vufebeGalaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vufebeGalaxy.repository.IDayRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/calculate")
    public List<Day> saveDaysWeather(@RequestParam(value = "dias", required = false) Integer dias){
    	List<Day> days=new ArrayList<Day>();
    	for (int i=0;i<dias;i++) {
    		String dsClima="Lluvia";
    		days.add(new Day(i+1,dsClima));
    	}
		return dayRepository.saveAll(days);
		}

    @DeleteMapping()
    public boolean deleteAll()
    {
    	try {
        	dayRepository.deleteAll();
    	}
    	catch(Exception e){
    		return false;
    	}

		return true;
    }

}

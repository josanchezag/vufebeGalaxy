package com.vufebeGalaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vufebeGalaxy.repository.IDayRepository;
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

}

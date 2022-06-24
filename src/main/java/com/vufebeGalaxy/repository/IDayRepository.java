package com.vufebeGalaxy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.vufebeGalaxy.model.Day;

public interface IDayRepository extends JpaRepository<Day, Integer> {

}

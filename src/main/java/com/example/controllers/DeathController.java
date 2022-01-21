package com.example.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Death;
import com.example.model.VillagersRequest;

@RestController
public class DeathController {

	@PostMapping(value = "/deaths/{startDeathYear}")
	public BigDecimal getDeaths(@PathVariable int startDeathYear, @RequestBody VillagersRequest villagersRequest) {
		Death death = new Death(startDeathYear);
		return death.averageDeaths(villagersRequest.getVillagers());
	}
}

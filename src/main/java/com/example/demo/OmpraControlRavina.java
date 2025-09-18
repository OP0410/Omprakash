package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OmpraControlRavina {
	@Autowired
	OmpraRepo repo;
	@GetMapping("/ompra")
	public List<Ompra> show()
	{
		return this.repo.findAll();
	}
	@PostMapping("/")
	public Ompra add(@RequestBody Ompra o)
	{
		return this.repo.save(o);
	}
	@GetMapping("/ompra/{id}")
	public Ompra showById(@PathVariable("id") int id) {
	    return this.repo.findById(id)
	            .orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(
	                    HttpStatus.NOT_FOUND, "Ompra with id " + id + " not found"
	            ));
	}

}


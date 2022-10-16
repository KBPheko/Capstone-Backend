package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Movie;
import com.service.MovieService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("movie")
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@PostMapping(value = "store", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeMovie(@RequestBody Movie mv) {
		return movieService.storeMovie(mv);
	}
	
	@PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateMovieRecord(@RequestBody Movie mv) {
		return movieService.updateMovieRecord(mv);
	}
	
	@GetMapping(value = "findMovies")
	public List<Movie> getAllMovie(){
		return movieService.getAllMovies();
	}
	
	@GetMapping(value = "findMovie/{mid}")
	public String findMovie(@PathVariable("mid") int mid) {
		return movieService.findMovie(mid);
	}
	
	@DeleteMapping(value = "deleteMovie/{mid}")
	public String deleteMovie(@PathVariable("mid") int mid) {
		return movieService.deleteMovieRecord(mid);
	}
}

package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Movie;
import com.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	public String storeMovie(Movie movie) {
		
		movieRepository.save(movie);
		return "Movie record stored successfully";
	}
	
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public String findMovie(int mid) {
		Optional<Movie> result = movieRepository.findById(mid);
		
		if (result.isPresent()){
			Movie mv = result.get();
			return mv.toString();
		} else {
			return "Movie unavailable, mid ("+ mid+ ") does not exist";
		}
	}
	
	public String deleteMovieRecord(int mid) {
		Optional<Movie> result = movieRepository.findById(mid);
		
		if (result.isPresent()){
			Movie mv = result.get();
			movieRepository.delete(mv);
			return "Movie record deleted successfully";
		} else {
			return "Movie unavailable, mid ("+ mid+ ") does not exist";
		}
	}
	
	public String updateMovieRecord(Movie mv) {
		Optional<Movie> result = movieRepository.findById(mv.getMid());
		
		if (result.isPresent()){
			Movie mv1 = result.get();
			mv1.setMovietitle(mv.getMovietitle());
			mv1.setTicketprice(mv.getTicketprice());
			mv1.setLanguage(mv.getLanguage());
			mv1.setDescription(mv.getDescription());
			mv1.setShowtime(mv.getShowtime());
			mv1.setGenre(mv.getGenre());
			mv1.setImageurl(mv.getImageurl());
			
			movieRepository.saveAndFlush(mv1);
			return "Movie records updated successfully";
		} else {
			return "Movie unavailable, mid ("+ mv.getMid()+ ") does not exist";
		}
	}
}

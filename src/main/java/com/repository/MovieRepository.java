package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	@Query("select m from Movie m where concat(m.movietitle, ' ',m.language, ' ', m.genre) LIKE %?1%")
	public List<Movie> findMovieByKeyword(@Param("keyword") String keyword);
}

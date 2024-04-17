package com.hendisantika.springbootjpaoptimisticlocking.controller;

import org.springframework.web.bind.annotation.RestController;

import com.hendisantika.springbootjpaoptimisticlocking.repository.MovieRepository;

import jakarta.transaction.Transactional;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.hendisantika.springbootjpaoptimisticlocking.domain.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MovieController {


    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("movie")
    public ResponseEntity<Movie> get() {

        Optional<Movie> movie = movieRepository.findById(1);

        if (movie.isEmpty()) {
            return new ResponseEntity<Movie>(new Movie(), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Movie>(new Movie(), HttpStatus.FOUND);
        }
    }

    @PostMapping("movie")
    @Transactional
    public ResponseEntity<Movie> inc() {
        Optional<Movie> movie = movieRepository.findById(1);
        Movie work;
        if (movie.isEmpty()) {
            work = new Movie("Title", 2);
        } else {
            work = movie.get();
            work.setVersion(2);
        }
        movieRepository.save(work);

        return new ResponseEntity<Movie>(work, HttpStatus.OK);
    }
    
}

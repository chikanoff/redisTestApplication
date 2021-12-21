package by.chikanoff.redisTest.controller;

import by.chikanoff.redisTest.beans.Movie;
import by.chikanoff.redisTest.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/movies")
@RequiredArgsConstructor
public class MovieController {
    @Autowired
    private MovieRepository repository;

    @PostMapping(value = "/add")
    public void add(@RequestBody Movie movie) {
        repository.save(movie);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") final String id) {
        repository.deleteById(id);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Movie> get(@PathVariable("id") final String id) {
        Movie movie = repository.findById(id).get();
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Movie>> get() {
        List<Movie> movies = new ArrayList<>();
        repository.findAll().forEach(movies::add);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

}

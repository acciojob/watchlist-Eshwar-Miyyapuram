package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService obj_service;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        obj_service.addMovieToService(movie);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){

        Movie current=obj_service.searchMovie_name(name);
        if(current!=null)
        {
            return new ResponseEntity<>(current,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.OK);
        }

    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        obj_service.addDirectorToService(director);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){

        Director current=obj_service.searchDirector_name(name);
        if(current!=null)
        {
            return new ResponseEntity<>(current,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.OK);
        }

    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie name")String movie_name,
                                                       @RequestParam("director name")String director_name){
            obj_service.addMovieDirectortoService(movie_name, director_name);
            return new ResponseEntity<>("Success",HttpStatus.OK);

    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String name){
        List<String> list=obj_service.getMovies_directorName(name);

        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> list=obj_service.list_of_all_movies_service();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorname")String name){

        obj_service.deleteMovies_directorinService(name);

        return new ResponseEntity<>("Success",HttpStatus.OK);

    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        obj_service.deleteAlldirectorsinservice();

        return new ResponseEntity<>("Success",HttpStatus.OK);
    }


}

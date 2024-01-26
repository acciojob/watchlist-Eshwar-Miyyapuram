package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        try{
            movieService.addMovie(movie);
            return new ResponseEntity<>("Success",HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>("Failed",HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        try{
            movieService.addDirector(director);
            return new ResponseEntity<>("Success",HttpStatus.OK);
        }catch(Exception e){
        return new ResponseEntity<>("Failed",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie")String movie, @RequestParam("director") String director){
        try{
            movieService.addmovdir(movie,director);
            return new ResponseEntity<>("Success",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Failed",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name")String movieName){
        try{
            Movie movie=movieService.getMovieByName(movieName);
            return new ResponseEntity<>(movie,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name")String directorName){
        try{
            Director director=movieService.getDirectorByName(directorName);
            return new ResponseEntity<>(director,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        try{
            return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director")String directorName){
        try{
            List<String> list=movieService.getMoviesByDirectorName(directorName);
            return new ResponseEntity<>(list,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director")String directorName){
        try{
            movieService.deleteDirectorByName(directorName);
            return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        try{
            movieService.deleteAllDirectors();
            return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
        }
    }





}

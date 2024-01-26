package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movierepo;

    public void addMovie(Movie movie){
        movierepo.addMovie(movie);
    }

    public void addDirector(Director director){
        movierepo.addDirector(director);
    }

    public void addmovdir(String movie,String director){
        movierepo.addmovdir(movie,director);
    }

    public Movie getMovieByName(String movieName){
        Movie movie=movierepo.getMovieByName(movieName);
        if(movie!=null) {
            return movie;
        }

        throw new NullPointerException();
    }


    public Director getDirectorByName(String directorName){
        Director director=movierepo.getDirectorByName(directorName);
        if(director!=null) {
            return director;
        }

        throw new NullPointerException();
    }

    public List<String> findAllMovies(){
        List<String>list=movierepo.findAllMovies();
        return list;
    }

    public List<String> getMoviesByDirectorName(String directorName){
        List<String>list=movierepo.getMoviesByDirectorName(directorName);
        return list;
    }

    public void deleteDirectorByName(String directorName){
        movierepo.deleteDirectorByName(directorName);
    }

    public void deleteAllDirectors(){
        movierepo.deleteAllDirectors();
    }


}

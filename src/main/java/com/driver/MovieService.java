package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository obj_repo;

    public void addMovieToService(Movie movie){

        obj_repo.addMovieToDB(movie);
    }

    public Movie searchMovie_name(String name){
        return obj_repo.searchMovieinDB(name);
    }

    public void addDirectorToService(Director director){
         obj_repo.addDirectorToDB(director);
    }

    public Director searchDirector_name(String name){
        return obj_repo.searchDirectorinDB(name);
    }

    public void addMovieDirectortoService(String movie_name,String director_name){
        obj_repo.addMovieDirectorToDB(movie_name,director_name);
    }

    public List<String> getMovies_directorName(String name) {
        return obj_repo.getMovies_directorName(name);
    }

    public List<String> list_of_all_movies_service(){
        return obj_repo.list_of_all_movies_DB();
    }

    public void deleteMovies_directorinService(String name){

        obj_repo.deleteMovies_directorinDB(name);

    }
    public void deleteAlldirectorsinservice(){
        obj_repo.deleteAlldirectorsinDb();
    }
}

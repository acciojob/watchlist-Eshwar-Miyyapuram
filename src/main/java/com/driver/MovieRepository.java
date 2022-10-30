package com.driver;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MovieRepository {

    HashSet<Movie> movie_list = new HashSet<>();
    HashSet<Director> director_list = new HashSet<>();

    HashMap<Movie, Director> movie_director_map = new HashMap<>();


    public void addMovieToDB(Movie movie) {


        if(!movie_list.contains(movie))
            movie_list.add(movie);
    }

    public Movie searchMovieinDB(String movie_name) {

        for (Movie curr_movie : movie_list) {
            if (curr_movie.getName().equals(movie_name)) {
                return curr_movie;
            }
        }
        return null;
    }
    public void addDirectorToDB(Director director) {


        if(!director_list.contains(director))
        director_list.add(director);
    }

    public Director searchDirectorinDB(String director_name) {

        for(Director curr_director:director_list)
        {
            if(curr_director.getName().equals(director_name))
            {
                return curr_director;
            }
        }
        return null;
    }

    public void addMovieDirectorToDB(String movie_name,String director_name){
        Movie currentMovie=searchMovieinDB(movie_name);
        Director currentDirector=searchDirectorinDB(director_name);


        if(currentMovie!=null)
        movie_director_map.put(currentMovie,currentDirector);
    }

    public List<String> getMovies_directorName(String name){
        List<String> listOfMovies=new ArrayList<>();

        for(Map.Entry<Movie,Director> e: movie_director_map.entrySet()){
            if(e.getValue().getName().equals(name)){
                listOfMovies.add(e.getKey().getName());
            }
        }

        return listOfMovies;
    }

    public List<String> list_of_all_movies_DB(){
        List<String> listOfMovies=new ArrayList<>();

        for(Movie movie:movie_list){
            listOfMovies.add(movie.getName());
        }
        return listOfMovies;
    }


    public void deleteMovies_directorinDB(String name){

        Director director=searchDirectorinDB(name);


        if(director!=null) {

            for (Map.Entry<Movie, Director> e : movie_director_map.entrySet()) {
                if (e.getValue().getName().equals(name)) {
                    Movie movie=e.getKey();
                    if(movie!=null) {
                        movie_list.remove(movie);
                        movie_director_map.remove(movie);
                    }
                }
            }

            director_list.remove(director);
        }
        }

        public void deleteAlldirectorsinDb(){

        for(Map.Entry<Movie,Director> e:movie_director_map.entrySet()) {
            Movie curr_movie = e.getKey();
            Director curr_director = e.getValue();
            if (curr_director != null) {
                movie_list.remove(curr_movie);
            }
        }
        movie_director_map.clear();
        for(Movie movie:movie_list)
        {
            movie_director_map.put(movie,null);
        }
        director_list.clear();
        }

}



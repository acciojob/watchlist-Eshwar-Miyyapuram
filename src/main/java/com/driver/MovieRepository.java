package com.driver;


import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MovieRepository {

    HashMap<String,Movie> movieDB;
    HashMap<String,Director> directorDB;
    HashMap<Movie,Director> movdirDB;

    public MovieRepository() {
        movieDB=new HashMap<>();
        directorDB=new HashMap<>();
        movdirDB=new HashMap<>();
    }

    public void addMovie(Movie movie){
        if(!movieDB.containsKey(movie.getName())){
        if(movie!=null){
            movieDB.put(movie.getName(),movie);
            return;
        }}
        throw new NullPointerException();
    }
    public void addDirector(Director director){
        if(!directorDB.containsKey(director.getName())){
        if(director!=null){
            directorDB.put(director.getName(),director);
            return;
        }}
        throw new NullPointerException();
    }
    public void addmovdir(String movie,String director){
        if(movieDB.containsKey(movie)&&directorDB.containsKey(director)){
            movdirDB.put(movieDB.get(movie),directorDB.get(director));
            return;
        }
        throw new NullPointerException();
    }


    public Movie getMovieByName(String movieName){
        if(movieDB.containsKey(movieName)){
            return movieDB.get(movieName);
        }
        return null;
    }

    public Director getDirectorByName(String directorName){
        if(directorDB.containsKey(directorName)){
            return directorDB.get(directorName);
        }
        return null;
    }

    public List<String> findAllMovies(){
        List<String>list=new ArrayList<>();
        for(String movie:movieDB.keySet()){
            list.add(movie);
        }
        return list;
    }

    public List<String> getMoviesByDirectorName(String directorName){
        List<String>list=new ArrayList<>();

        if(directorDB.containsKey(directorName)){
            for(Map.Entry<Movie,Director>e:movdirDB.entrySet()){

                String dirName=e.getValue().getName();
                String movName=e.getKey().getName();

                if(dirName.equals(directorName)){
                    list.add(movName);
                }
            }
            return list;
        }

        throw new NullPointerException();
    }

    public void deleteDirectorByName(String directorName){

        if(directorDB.containsKey(directorName)){
            List<String> removeMovies=getMoviesByDirectorName(directorName);
            for(String movie:removeMovies){
                movdirDB.remove(movieDB.get(movie));
                movieDB.remove(movie);
            }
            directorDB.remove(directorName);
            return;
        }
        throw new NullPointerException();
    }


    public void deleteAllDirectors(){
        List<String> deleteDirectorlist=new ArrayList<>();

        for(String director: directorDB.keySet()){
            deleteDirectorlist.add(director);
        }

        for(String director:deleteDirectorlist){
            deleteDirectorByName(director);
        }
    }
}

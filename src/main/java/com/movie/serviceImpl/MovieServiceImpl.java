package com.movie.serviceImpl;

import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;
import com.movie.service.MovieService;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MovieServiceImpl implements MovieService {

    Set<Movie> database =new LinkedHashSet<>();
    int id=0;
    @Override
    public String createMovie(Movie movie) {
        boolean flag=false;
        for(Movie movie1:database){
            if(movie1.getTitle().equals(movie.getTitle())){
                flag=true;
            }
        }
        if(!flag){
            Movie movie1 =new Movie();
            id++;
            movie1.setId(id);
            movie1.setTitle(movie.getTitle());
            movie1.setGenre(movie.getGenre());
            movie1.setReleaseDate(movie.getReleaseDate());
            movie1.setCast(movie.getCast());
            database.add(movie1);
            return "Movie Added Successfully";
        }else {
            return "Movie Not Added ";
        }

    }

    @Override
    public Movie getMovieById(int id) {

        for(Movie movie1:database){
            if(movie1.getId() == id){
                return movie1;
            }
        }
        throw new MovieNotFoundException("Movie Not Found With This Id : " + id);
    }

    @Override
    public  Set<Movie> getAllMovies() {
        return database;
    }



    @Override
    public String deleteMovie(int id) {
        for(Movie movie:database){
           if(movie.getId() == id){
               database.remove(movie);
               return "MOVIE DELETED SUCCESSFULLY WITH ID : " + id;
           }
        }
        throw new MovieNotFoundException("Movie Not Found With This Id : " + id);
    }

    @Override
    public Set<Movie> searchMovie(String st) {
        String string=st.toLowerCase();
        Set<Movie> searchedMovie= new LinkedHashSet<>();
        for(Movie movie:database){
            movie.getReleaseDate().getYear();
            if(movie.getTitle().toLowerCase().contains(string)){
                searchedMovie.add(movie);
            }else if(movie.getGenre().toLowerCase().contains(string)){
                searchedMovie.add(movie);
            }else if(movie.getReleaseDate().toString().toLowerCase().contains(string)){
                searchedMovie.add(movie);
            }else if(movie.getCast().toLowerCase().contains(string)){
                searchedMovie.add(movie);
            }
        }
        return searchedMovie;
    }


    @Override
    public String updateMovie(Movie movie) {

        for(Movie movie1:database){
            if(movie.getId()==movie1.getId()){
                movie1.setTitle(movie.getTitle());
                movie1.setGenre(movie.getGenre());
                movie1.setReleaseDate(movie.getReleaseDate());
                movie1.setCast(movie.getCast());
                break;
            }
        }
        return "Movie Updated Successfully";
    }


}

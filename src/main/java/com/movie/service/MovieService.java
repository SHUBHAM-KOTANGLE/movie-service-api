package com.movie.service;

import com.movie.model.Movie;

import java.util.List;
import java.util.Set;

public interface MovieService {

    String createMovie(Movie movie);

    Movie getMovieById(int id);

    Set<Movie> getAllMovies();

    String updateMovie(Movie movie);

    String deleteMovie(int id);

    Set<Movie> searchMovie(String string);





}

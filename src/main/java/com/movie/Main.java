package com.movie;

import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;
import com.movie.service.MovieService;
import com.movie.serviceImpl.MovieServiceImpl;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MovieService movieService =new MovieServiceImpl();
        System.out.println();

        Movie movie2 = new Movie();
        movie2.setTitle("Inception");
        movie2.setGenre("Science Fiction, Action, Thriller");
        movie2.setReleaseDate(LocalDate.of(2010, Month.JULY, 16));
        movie2.setCast("Leonardo DiCaprio, Joseph Gordon-Levitt, Ellen Page, Tom Hardy, Ken Watanabe");

        Movie movie = new Movie();
        movie.setTitle("The Shawshank Redemption");
        movie.setGenre("Drama");
        movie.setReleaseDate(LocalDate.of(1994, Month.SEPTEMBER, 23));
        movie.setCast("Tim Robbins, Morgan Freeman, Bob Gunton, William Sadler");

        Movie movie3 = new Movie();
        movie3.setTitle("The Dark Knight");
        movie3.setGenre("Action, Crime, Drama");
        movie3.setReleaseDate(LocalDate.of(2008, Month.JULY, 18));
        movie3.setCast("Christian Bale, Heath Ledger, Aaron Eckhart, Michael Caine");

        Movie movie4 = new Movie();
        movie4.setTitle("Pulp Fiction");
        movie4.setGenre("Crime, Drama");
        movie4.setReleaseDate(LocalDate.of(1994,Month.OCTOBER, 14));
        movie4.setCast("John Travolta, Uma Thurman, Samuel L. Jackson, Bruce Willis");


        //CREATE
        movieService.createMovie(movie);
        movieService.createMovie(movie2);
        movieService.createMovie(movie3);
        movieService.createMovie(movie4);
        System.out.println();

        //GET ALL
        Set<Movie> allMovies = movieService.getAllMovies();
        allMovies.forEach(System.out::println);
        System.out.println();


        //GET BY ID
        try {
            Movie movieById=movieService.getMovieById(1);
            System.out.println("MOVIE BY ID "+movieById.toString());
        }catch (MovieNotFoundException e){
            String message = e.getMessage();
            System.out.println(message);
        }
        System.out.println();


        // DELETE MOVIE
        String string = movieService.deleteMovie(2);
        System.out.println(string);
        System.out.println();


        //GET ALL
        Set<Movie> allMoviesAfterDeleted = movieService.getAllMovies();
        allMoviesAfterDeleted.forEach(System.out::println);
        System.out.println();


        //SEARCH MOVIE
        Set<Movie> searchedMovies =movieService.searchMovie("10");
        System.out.println("Searched Movies : " );
        for(Movie movie1:searchedMovies){
            System.out.println("Searched Movies : " + movie1.toString());
        }
        System.out.println();


        //UPDATE MOVIE
        Movie updatemovie = new Movie();
        updatemovie.setId(3);
        updatemovie.setTitle("The Dark Knight9846");
        updatemovie.setGenre("Action, Crime, Drama54354");
        updatemovie.setReleaseDate(LocalDate.of(2008, Month.JULY, 18));
        updatemovie.setCast("Christian Bale, Heath Ledger, Aaron Eckhart, Michael Caine");
        String updatedMovie = movieService.updateMovie(updatemovie);
        System.out.println(updatedMovie);
        System.out.println();



        //GET ALL
        Set<Movie> allMoviesAfterUpdate = movieService.getAllMovies();
        allMoviesAfterDeleted.forEach(System.out::println);

    }
}
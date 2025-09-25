package com.example.bestoftheyear.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bestoftheyear.model.Movie;
import com.example.bestoftheyear.model.Song;



@Controller
@RequestMapping ("/")
public class HomeController {


    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Michael");
        return "home";
    }

    private List<Movie> getBestMovies() {
        List<Movie> listaFilm = new ArrayList<>();

        listaFilm.add(new Movie(1, "Il Signore degli Anelli"));
        listaFilm.add(new Movie(2, "Avatar"));
        listaFilm.add(new Movie(3, "Django"));

        return listaFilm;
    }

    private List<Song> getBestSongs() {
        List<Song> listaCanzoni = new ArrayList<>();
        
        listaCanzoni.add(new Song(1, "Bohemian Rapsody"));
        listaCanzoni.add(new Song(2, "Don't Stop Me Now"));
        listaCanzoni.add(new Song(3, "Ti Amo"));

        return listaCanzoni;
    }

    // Path per /movies
    @GetMapping("/movies")
    public String showMovies(Model model) {
        String titles = "";
        List<Movie> movies = getBestMovies();
        for (int i = 0; i < movies.size(); i++) {
            titles += movies.get(i).getTitle();
            if (i < movies.size() - 1) {
                titles += ", ";
            }
        }
        model.addAttribute("titles", titles);
        return "movies";
    }

    // Path per /songs
    @GetMapping("/songs")
    public String showSongs(Model model) {
        String titles = "";

        List<Song> songs = getBestSongs();
        for (int i = 0; i < songs.size(); i++) {
            titles += songs.get(i).getTitle();
            if (i < songs.size() - 1) {
                titles += ", ";
            }
        }

        model.addAttribute("titles", titles);
        return "songs";
    }
    
    // Path per /movies/{id}
    @GetMapping("/movies/{id}")
    public String showMovieById(@PathVariable Integer id, Model model) {
        String title = "Not found";
        for (Movie m : getBestMovies()) {
            if (m.getId().equals(id)) {
                title = m.getTitle();
                break;
            }
        }

        model.addAttribute("title", title);
        return "movie-detail";
    }

    // Path per /songs/{id}
    @GetMapping("/songs/{id}")
    public String showSongById(@PathVariable Integer id, Model model) {
        String title = "Not found";
        for (Song s : getBestSongs()) {
            if (s.getId().equals(id)) {
                title = s.getTitle();
                break;
            }
        }

        model.addAttribute("title", title);
        return "song-detail";
    }

    // Metodi privati per ottenere le liste di oggetti
    private List<Movie> listBestMovies() {
        return List.of(
            new Movie((int) 1L, "The Shawshank Redemption"),
            new Movie((int) 2L, "The Godfather"),
            new Movie((int) 3L, "The Dark Knight")
        );
    }

    private List<Song> listBestSongs() {
        return List.of(
            new Song((int) 1L, "Bohemian Rhapsody"),
            new Song((int) 2L, "Stairway to Heaven"),
            new Song((int) 3L, "Hotel California")
        );
    }

}

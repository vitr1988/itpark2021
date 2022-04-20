package lesson43.controller;

import lesson43.dto.GenreDto;
import lesson43.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class GenrePageController {

    private final GenreService genreService;

    @GetMapping("/genres")
    public String allGenres() {
        return "genre/genres";
    }

    @GetMapping("/genre/add")
    public String newGenre() {
        return "genre/genre";
    }

    @GetMapping("/genre/edit")
    public String currentGenre(@RequestParam("code") String genreCode, Model model) {
        GenreDto currentGenre = genreService.getByCode(genreCode)
                .orElseThrow(() -> new IllegalArgumentException("Non existed genre"));
        model.addAttribute("genre", currentGenre);
        return "genre/genre";
    }

    @PostMapping("/genre/save")
    public String saveGenre(GenreDto genre) {
        genreService.save(genre);
        return "redirect:/genres";
    }
}

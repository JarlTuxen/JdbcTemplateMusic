package dk.kea.jdbctemplatemusic.controller;

import dk.kea.jdbctemplatemusic.model.MusicData;
import dk.kea.jdbctemplatemusic.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MusicDataController {

    @Autowired
    private MusicRepository musicRepository;

    @GetMapping("/")
    public String index(){
        return "redirect:/musikdata";
    }

    @GetMapping("/musikdata")
    public String showMusic(Model model){

        //tilføj alle titler til viewmodel, så de kan bruges af Thymeleaf i html
        model.addAttribute("albums", musicRepository.findAll());
        model.addAttribute("avgYear", musicRepository.avgYear());
        model.addAttribute("minYear", musicRepository.minYear());
        model.addAttribute("maxYear", musicRepository.maxYear());
        return "musikdata";
    }

    //fra anchor i index
    @GetMapping("/create")
    public String showCreate(){
        //vis create-siden
        return "create";
    }

    //fra form action
    @PostMapping("/create")
    public String createMusicData(@RequestBody MusicData musicData){
        //gem nyt produkt
        musicRepository.insert(musicData);

        //tilbage til produktlisten
        return "redirect:/";
    }

    //vis update side for musikData ud fra parameter i url
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") int updateId, Model model) {
        //find musikData med idalbum = updateId i databasen
        MusicData updateMusicData = musicRepository.findById(updateId);

        //tilføj produkt til viewmodel, så det kan bruges i Thymeleaf
        model.addAttribute("musicdata", updateMusicData);

        //fortæl Spring hvilken HTML-side, der skal vises
        return "update";
    }

    @PostMapping("/update")
    public String updateMusicDat(@RequestBody MusicData musicData){

        //kald opdater i repository
        musicRepository.update(musicData);

        //rediriger til oversigtssiden
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        //slet fra repository
        musicRepository.deleteById(id);

        //returner til index-siden
        return "redirect:/";
    }

}

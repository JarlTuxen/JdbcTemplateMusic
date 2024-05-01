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
        return "createmusic";
    }

    //fra form action
    @PostMapping("/create")
    public String createMusicData( @RequestParam("artist") String artist,
                                   @RequestParam("title") String title,
                                   @RequestParam("year") int year,
                                   @RequestParam("company") String company){
        //gem nyt produkt
        musicRepository.insert(new MusicData(artist, title, year, company));

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
        return "updatemusic";
    }

    @PostMapping("/update")
    public String updateMusicData(@RequestParam("idalbum") int idalbum,
                                  @RequestParam("artist") String artist,
                                  @RequestParam("title") String title,
                                  @RequestParam("year") int year,
                                  @RequestParam("company") String company){
        //lav musicData
        MusicData musicData = new MusicData(idalbum, artist, title, year, company);

        //kald opdater i repository
        musicRepository.update(musicData);

        //rediriger til oversigtssiden
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int deleteId){
        //slet fra repository
        musicRepository.deleteById(deleteId);

        //returner til index-siden
        return "redirect:/";
    }

}

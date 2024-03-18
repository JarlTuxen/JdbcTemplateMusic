package dk.kea.jdbctemplatemusic.controller;

import dk.kea.jdbctemplatemusic.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("albums", musicRepository.getAll());
        model.addAttribute("avgYear", musicRepository.avgYear());
        return "musikdata";
    }

}

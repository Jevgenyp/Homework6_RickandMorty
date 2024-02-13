package com.example.example4sem6_rikky_and_morty_rest.controller;

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Result;
import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    @GetMapping("/")
    public String getCharacters(Model model)
    {
        Characters allCharacters = serviceApi.getAllCharacters();
        model.addAttribute("characters", allCharacters.getResults());
        return "characters";
    }

    @GetMapping("/character/{id}")
    public String getCharacter(@PathVariable("id") Integer id, Model model)
    {
        Result character = serviceApi.getCharacter(id);
        model.addAttribute("character", character);
        return "character";
    }
}
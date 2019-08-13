package ca.digitalarts.controller;

import ca.digitalarts.dao.AlgorithmBuilder;
import ca.digitalarts.dao.GameBuilder;
import ca.digitalarts.dao.impl.AlgorithmBuilderImpl;
import ca.digitalarts.dao.impl.GameBuilderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Controller
public class AbstractRestController {

    GameBuilder games = new GameBuilderImpl();
    AlgorithmBuilder algorithm = new AlgorithmBuilderImpl();


    @GetMapping("/login")
    public void login(Model model) throws IOException, GeneralSecurityException {
        model.addAttribute("games", games.buildGame());
    }

    @GetMapping("/bet")
    public void bet(@RequestParam(name = "games", required = false) String game, Model model) {
        model.addAttribute("game", game);
        model.addAttribute("bet", algorithm.betAnswer());
    }
}

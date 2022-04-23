package site.metacoding.managerpage.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.game.Game;
import site.metacoding.managerpage.service.GameService;
import site.metacoding.managerpage.web.api.dto.game.NewGameDto;

@RequiredArgsConstructor
@Controller
public class GameController {
    private final GameService gameService;
    private final HttpSession session;

    @GetMapping("/gameList")
    public String gameList(Model model) {
        List<Game> games = gameService.게임목록가져오기();
        model.addAttribute("games", games);
        return "/GameList";
    }

    @PostMapping("/create")
    public String addGame(NewGameDto newGameDto) {
        gameService.게임등록하기(newGameDto);
        return "redirect:/gameList";
    }

}

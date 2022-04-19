package site.metacoding.managerpage.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.game.Game;
import site.metacoding.managerpage.domain.game.GameRepository;
import site.metacoding.managerpage.service.GameService;
import site.metacoding.managerpage.web.api.ResponseDto;
import site.metacoding.managerpage.web.api.dto.game.NewDto;

@RequiredArgsConstructor
@Controller
public class GameController {
    private final GameService gameService;
    private final HttpSession session;

    @GetMapping("/gameList")
    public String gameList(Model model) {
        List<Game> game = gameService.게임정보();
        model.addAttribute("gameList", game);
        return "/GameList";
    }

    @PostMapping("/create")
    public String addGame(Model model, Game game) {
        gameService.등록하기(game);
        List<Game> gameUp = gameService.게임정보();
        model.addAttribute("gameList", gameUp);
        return "/GameList";
    }

}

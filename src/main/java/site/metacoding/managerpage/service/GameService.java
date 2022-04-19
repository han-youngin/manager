package site.metacoding.managerpage.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.game.Game;
import site.metacoding.managerpage.domain.game.GameRepository;
import site.metacoding.managerpage.web.api.dto.game.NewDto;

@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;

    // 게임 목록
    public List<Game> 게임정보() {
        List<Game> gameList = gameRepository.findAll();
        System.out.println(gameList);
        return gameList;
    }

    // 게임 등록하기
    @Transactional
    public void 등록하기(Game game) {
        gameRepository.save(game);
    }
}

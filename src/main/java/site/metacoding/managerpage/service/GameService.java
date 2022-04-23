package site.metacoding.managerpage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.game.Game;
import site.metacoding.managerpage.domain.game.GameRepository;
import site.metacoding.managerpage.util.FileUpload;
import site.metacoding.managerpage.web.api.dto.game.NewGameDto;

@RequiredArgsConstructor
@Service
public class GameService {

    @Value("${file.path}")
    private String uploadFolder;

    private final GameRepository gameRepository;

    public List<Game> 게임목록가져오기() {
        List<Game> games = gameRepository.findAll();
        return games;
    }

    // 게임 등록하기
    @Transactional
    public void 게임등록하기(NewGameDto newGameDto) {
        String file = null;
        if (!newGameDto.getImg().isEmpty()) {
            file = FileUpload.write(uploadFolder, newGameDto.getImg());
        }
        Game gameEntity = newGameDto.toEntity(file);
        gameRepository.save(gameEntity);
    }
}

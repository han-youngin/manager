package site.metacoding.managerpage.web.api.dto.game;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.managerpage.domain.game.Game;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewGameDto {
    private String name;
    private MultipartFile img;
    private String url;

    public Game toEntity(String img) {
        Game game = new Game();
        game.setName(name);
        game.setImage(img);
        game.setUrl(url);
        return game;
    }
}

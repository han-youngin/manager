package site.metacoding.managerpage.web.api.dto.game;

import java.sql.Blob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.managerpage.domain.game.Game;
import site.metacoding.managerpage.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewDto {
    private Integer id;
    private String gamename;
    private Blob image;

    public Game toEntity(User principal) {
        Game game = new Game();
        game.setId(id);
        game.setGamename(gamename);
        game.setImage(image);
        return game;
    }
}

package site.metacoding.managerpage.web.api.dto.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.managerpage.domain.game.Game;
import site.metacoding.managerpage.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewDto {
    private String gamename;

    public Game toEntity(User principal) {
        Game game = new Game();
        game.setGamename(gamename);
        return game;
    }
}

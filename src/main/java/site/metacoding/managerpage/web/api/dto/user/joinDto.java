package site.metacoding.managerpage.web.api.dto.user;

import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.managerpage.domain.manager.Manager;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class joinDto {
    private String username;
    private String password;
    private String email;

    public Manager toEntity() {
        Manager manager = new Manager();
        manager.setUsername(username);
        manager.setPassword(password);
        manager.setEmail(email);
        return manager;
    }
}

package site.metacoding.managerpage.web.api;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.objenesis.instantiator.basic.FailingInstantiator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.manager.Manager;
import site.metacoding.managerpage.service.ManagerService;
import site.metacoding.managerpage.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@RestController
public class LoginApiController {
    private final ManagerService managerService;
    private final HttpSession session;

    @PostMapping("/login")
    public ResponseDto<?> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        Manager managerEntity = managerService.로그인(loginDto);

        if (managerEntity == null) {
            return new ResponseDto<>(-1, "로그인실패", null);
        }

        if (loginDto.getRemember().equals("on")) {
            response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() + "; path=/");
        }

        session.setAttribute("principal", managerEntity);
        return new ResponseDto<String>(1, "로그인성공", null);
    }
}

package site.metacoding.managerpage.web;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.manager.Manager;
import site.metacoding.managerpage.service.ManagerService;
import site.metacoding.managerpage.web.api.dto.user.LoginDto;
import site.metacoding.managerpage.web.api.dto.user.joinDto;

@RequiredArgsConstructor
@Controller
public class ManagerController {
    private final ManagerService managerService;
    private final HttpSession session;

    // 로그인 데이터 전송
    @PostMapping("/login")
    public String login(LoginDto loginDto, HttpServletResponse response) {
        System.out.println(loginDto);
        Manager managerEntity = managerService.로그인(loginDto);
        if (managerEntity != null) {
            session.setAttribute("principal", managerEntity);
            if (loginDto.getRemember() != null && loginDto.getRemember().equals("on")) {
                response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername());
            }
            return "redirect:/";
        } else {
            return "redirect:/login-form";
        }
    }

    // 회원가입
    @PostMapping("/join")
    public String Join(joinDto joinDto, HttpServletResponse response) {
        System.out.println(joinDto);
        managerService.회원가입(joinDto);
        return "redirect:/login-form";
    }

    @GetMapping("/")
    public String main() {
        return "/ManagerMain";
    }

    @GetMapping("/new")
    public String newGame() {
        return "NewGame";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "/LoginForm";
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "/joinForm";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}

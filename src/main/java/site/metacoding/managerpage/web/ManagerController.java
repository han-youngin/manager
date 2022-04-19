package site.metacoding.managerpage.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.manager.Manager;
import site.metacoding.managerpage.service.ManagerService;
import site.metacoding.managerpage.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@Controller
public class ManagerController {
    private final ManagerService managerService;
    private final HttpSession session;

    // 로그인 페이지
    @GetMapping("/login-form")
    public String loginForm(HttpServletRequest request, Model model) {
        if (request.getCookies() != null) {
            Cookie[] cookies = request.getCookies();

            for (Cookie cookie : cookies) {
                System.out.println("쿠키값:" + cookie.getName());
                if (cookie.getName().equals("remember")) {
                    model.addAttribute("remember", cookie.getValue());
                }
            }
        }
        return "loginForm";
    }

    // 로그인 데이터 전송
    @PostMapping("/login")
    public String login(LoginDto loginDto, HttpServletResponse response) {
        Manager managerEntity = managerService.로그인(loginDto);
        if (managerEntity != null) {
            session.setAttribute("principal", managerEntity);
            if (loginDto.getRemember() != null && loginDto.getRemember().equals("on")) {
                response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername());
            }
            return "/";
        } else {
            return "redirect:/login-form";
        }
    }

    @GetMapping("/")
    public String main() {
        return "/ManagerMain";
    }

    @GetMapping("/new")
    public String newGame() {
        return "NewGame";
    }
}

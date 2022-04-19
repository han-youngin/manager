package site.metacoding.managerpage.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.http.Cookie;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.user.User;
import site.metacoding.managerpage.service.UserService;
import site.metacoding.managerpage.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final HttpSession session;

    // 유저 정보 불러오기
    @GetMapping("/userInfo")
    public String userList(Model model) {
        List<User> user = userService.유저정보();
        model.addAttribute("userList", user);
        return "/UserList";
    }

    // 유저 정보 상세보기
    @GetMapping("/userInfo/{id}")
    public String useInfo(Model model, @PathVariable Integer id) {
        User userInfo = userService.유저상세보기(id);
        model.addAttribute("userInfo", userInfo);
        return "/UserInfo";
    }

}

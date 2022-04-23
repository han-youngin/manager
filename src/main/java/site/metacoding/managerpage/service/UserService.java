package site.metacoding.managerpage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.user.User;
import site.metacoding.managerpage.domain.user.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> 유저정보() {
        List<User> userList = userRepository.findAll();
        System.out.println(userList);
        return userList;
    }

    public User 유저상세보기(Integer id) {
        Optional<User> userOp = userRepository.findById(id);
        if (userOp.isPresent()) {
            return userOp.get();
        } else {
            throw new RuntimeException("아이디를 찾을 수 없습니다.");
        }
    }

}

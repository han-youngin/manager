package site.metacoding.managerpage.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.managerpage.domain.manager.Manager;
import site.metacoding.managerpage.domain.manager.ManagerRepository;
import site.metacoding.managerpage.web.api.dto.user.LoginDto;
import site.metacoding.managerpage.web.api.dto.user.joinDto;

@RequiredArgsConstructor
@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    public Manager 로그인(LoginDto loginDto) {
        Manager managerEntity = managerRepository.mLogin(loginDto.getUsername(), loginDto.getPassword());
        return managerEntity;
    }

    @Transactional
    public void 회원가입(joinDto joinDto) {
        managerRepository.save(joinDto.toEntity());
    }

    // public Manager 로그인(LoginDto loginDto) {
    // System.out.println(loginDto);
    // Manager managerEntity = managerRepository.mLogin(loginDto.getUsername(),
    // loginDto.getPassword());
    // System.out.println("로그인:" + managerEntity);
    // return managerEntity;
    // }
}

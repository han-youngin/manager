package site.metacoding.managerpage.domain.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    @Query(value = "SELECT * FROM User WHERE username = :username AND password =:password", nativeQuery = true)
    Manager mLogin(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT * FROM User WHERE username = :username", nativeQuery = true)
    Manager mUsernameSameCheck(@Param("username") String username);

    @Query(value = "SELECT * FROM User WHERE nickname = :nickname", nativeQuery = true)
    Manager mNicknameSameCheck(@Param("nickname") String nickname);
}

package site.metacoding.managerpage.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.managerpage.domain.ranking.Ranking;
import site.metacoding.managerpage.domain.rpg.Rpg;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, length = 12)
    private String username;

    @Column(unique = true, nullable = false, length = 12)
    private String nickname;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(unique = true, nullable = false, length = 30)
    private String email;

    @Column(nullable = false)
    private Integer coin;

    @OneToOne
    @JoinColumn(name = "rpgId")
    private Rpg rpg;

    @OneToOne
    @JoinColumn(name = "rankingId")
    private Ranking ranking;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime updateDate;
}
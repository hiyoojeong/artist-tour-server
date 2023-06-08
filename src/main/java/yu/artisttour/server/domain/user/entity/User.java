package yu.artisttour.server.domain.user.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import yu.artisttour.server.domain.report.entity.Report;
import yu.artisttour.server.util.Timestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "`user`")
@Getter
@Setter
public class User extends Timestamp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "id", nullable = false, length = 50)
    private String id;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;

    @Column(name = "activated")
    @ColumnDefault("true")
    private Boolean activated;

}

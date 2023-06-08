package yu.artisttour.server.util;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Timestamp {

    @CreatedDate
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @CreatedDate
    @Column(name = "agree_date")
    private LocalDateTime agreeDate;

}

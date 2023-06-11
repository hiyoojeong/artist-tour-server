package yu.artisttour.server.domain.subscribe.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import yu.artisttour.server.domain.artist.entity.Artist;
import yu.artisttour.server.domain.user.entity.User;
import yu.artisttour.server.util.Timestamp;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "subscribe")
@Getter
@Setter
public class Subscribe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscribe_id")
    private Long subscribeId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "artist_id")
    private Artist artist;

}

package yu.artisttour.server.domain.artist.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import yu.artisttour.server.domain.place.entity.Place;
import yu.artisttour.server.domain.subscribe.entity.Subscribe;
import yu.artisttour.server.domain.user.entity.User;
import yu.artisttour.server.util.Timestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "artist")
@Getter
public class Artist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Long artistId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "maker_id", referencedColumnName = "user_id")
    private User maker;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "activated")
    @ColumnDefault("true")
    private Boolean activated;

    @JsonManagedReference
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Subscribe> subscribes;

    @JsonManagedReference
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Place> places;
}

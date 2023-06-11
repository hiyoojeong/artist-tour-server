package yu.artisttour.server.domain.place.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import yu.artisttour.server.domain.artist.entity.Artist;
import yu.artisttour.server.domain.user.entity.User;
import yu.artisttour.server.util.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "place")
@Getter
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long placeId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "artist_id")
    private Artist artist;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "maker_id", referencedColumnName = "user_id")
    private User maker;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "date")
    private Date date;

    @Column(name = "content")
    private String content;

    @Column(name = "activated")
    @ColumnDefault("true")
    private Boolean activated;
}

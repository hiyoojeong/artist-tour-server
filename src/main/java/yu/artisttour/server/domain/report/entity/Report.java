package yu.artisttour.server.domain.report.entity;

import lombok.Getter;
import lombok.Setter;
import yu.artisttour.server.domain.user.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "report")
@Getter
@Setter
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "reported", referencedColumnName = "id")
    private User reported;

    @Column(name = "reporter", nullable = false, length = 50)
    private String reporter;

    @Column(name = "flag", nullable = false)
    private int flag;

    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "footprint_id")
    private Long footprintId;

}

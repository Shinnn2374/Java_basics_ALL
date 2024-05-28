import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="Subscriptions")
@Getter
@Setter
public class Subscription {
    @EmbeddedId
    private StudentCourseIdKey id;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(insertable = false,
            updatable = false
    )
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(insertable = false,
            updatable = false
    )
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
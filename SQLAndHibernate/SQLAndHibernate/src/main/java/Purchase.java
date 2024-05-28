import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="PurchaseList")
@Getter
@Setter
public class Purchase
{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(columnDefinition = "int unsigned")
        private Integer id;

        @ManyToOne(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY
        )
        @JoinColumn(name = "student_name",
                referencedColumnName = "name"
        )
        private Student student;

        @ManyToOne(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY
        )
        @JoinColumn(name = "course_name",
                referencedColumnName = "name"
        )
        private Course course;

        private Integer price;

        @Column(name = "subscription_date")
        private Date subscriptionDate;
    }


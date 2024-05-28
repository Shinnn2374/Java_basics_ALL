import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Students")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int unsigned")
    private Integer id;

    @Column(length = 45, unique = true)
    private String name;

    @Column(columnDefinition = "int unsigned")
    private Integer age;

    @Column(name = "registration_date")
    private Date registrationDate;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinTable(name = "Subscriptions",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private List<Course> courses;
}


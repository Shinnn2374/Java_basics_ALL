import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Courses")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int unsigned")
    private Integer id;

    @Column(length = 500, unique = true)
    private String name;

    @Column(columnDefinition = "int unsigned")
    private Integer duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition =
            "enum('DESIGN','PROGRAMMING','MARKETING','MANAGEMENT','BUSINESS')"
    )
    private CourseType type;

    @Column(length = 500)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Teacher teacher;

    @Column(name = "students_count",
            columnDefinition = "int unsigned"
    )
    private Integer studentsCount;

    @Column(columnDefinition = "int unsigned")
    private Integer price;

    @Column(name = "price_per_hour")
    private Float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Subscriptions",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private List<Student> students;
}


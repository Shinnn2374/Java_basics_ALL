import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Teachers")
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int unsigned")
    private Integer id;

    @Column(length = 45, unique = true)
    private String name;

    @Column(columnDefinition = "int unsigned")
    private Integer salary;

    @Column(columnDefinition = "int unsigned")
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "teacher_id")
    private Set<Course> courses;
}

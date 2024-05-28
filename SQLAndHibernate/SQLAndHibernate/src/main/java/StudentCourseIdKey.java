import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
public class StudentCourseIdKey implements Serializable {
    @Column(name = "student_id",
            columnDefinition = "int unsigned"
    )
    private Integer studentId;

    @Column(name = "course_id",
            columnDefinition = "int unsigned"
    )
    private Integer courseId;
}


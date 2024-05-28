import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="LinkedPurchaseList")
@Getter
@Setter
public class LinkedPurchase {
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

    private Integer price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    LinkedPurchase() {
        setId(new StudentCourseIdKey());
    }

    LinkedPurchase(Purchase purchase) {
        this();

        getId().setStudentId(purchase.getStudent().getId());
        getId().setCourseId(purchase.getCourse().getId());
        setPrice(purchase.getPrice());
        setSubscriptionDate(purchase.getSubscriptionDate());
    }

    public static LinkedPurchase newLinkedPurchase(Purchase purchase) {
        return new LinkedPurchase(purchase);
    }
}


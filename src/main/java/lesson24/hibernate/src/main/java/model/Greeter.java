package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(
                name = "getGreeterByTarget",
                query = "select p from Greeter p where target = :name"
        )
})
public class Greeter {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String identifier;


    @Column(columnDefinition = "TEXT")
    private String greeting;

//    @Type(type = "TEXT")
    private String target;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "responsible_ID")
    private Responsible responsible;

}

package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
public class Place {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String identifier;

    @ToString.Include
    private String name;

    @ManyToOne
    @JoinColumn(name = "responsible_ID")
    private Responsible responsible;
}

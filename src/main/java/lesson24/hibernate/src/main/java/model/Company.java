package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
public class Company {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String identifier;

    @ToString.Include
    private String name;

    @ManyToMany(mappedBy = "companies")
    private Set<Responsible> responsibles = new LinkedHashSet<>();
}

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
@ToString
@Entity
public class Responsible {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String identifier;

    private String name;

    @OneToMany(mappedBy = "responsible", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Place> places = new LinkedHashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "Responsible_companies",
            joinColumns = @JoinColumn(name = "responsible_identifier"),
            inverseJoinColumns = @JoinColumn(name = "companies_identifier"))
    private Set<Company> companies = new LinkedHashSet<>();
}

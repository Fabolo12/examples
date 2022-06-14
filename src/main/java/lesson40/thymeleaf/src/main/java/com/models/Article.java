package com.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Article {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String identifier;

    @Size(min = 5, max = 100)
    private String author;

    @Size(min = 5, max = 1000)
    private String content;

    @Size(min = 5, max = 100)
    private String title;

    private String vip;
    @ManyToMany
    private List<Category> categories;
}

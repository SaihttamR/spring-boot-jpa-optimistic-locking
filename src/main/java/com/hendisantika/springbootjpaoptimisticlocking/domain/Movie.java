package com.hendisantika.springbootjpaoptimisticlocking.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-jpa-optimistic-locking
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-21
 * Time: 03:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String title;

    private Integer rating;


    public Movie() {
        // empty constructor for (de)serialization
    }

    public Movie(String title, Integer rating) {
        this.title = title;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public Movie setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public Movie setVersion(Integer version) {
        this.version = version;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getRating() {
        return rating;
    }

    public Movie setRating(Integer rating) {
        this.rating = rating;
        return this;
    }
}

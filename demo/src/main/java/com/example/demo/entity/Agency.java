package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agency")
public class Agency {
    @Id
    @Column(name = "agency_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "pass")
    private String pass;

    @Column(name = "agency_name", unique = true)
    private String name;

    @Column(name = "picture")
    private String picture;

    @Column(name = "agency_description")
    private String description;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trip> trips;

}

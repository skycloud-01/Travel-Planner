package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private long id;

    @Column(name = "destination")
    private String destination;

    @Column(name = "address", unique = true)
    private String address;

    @Column(name = "hotel_name")
    private String hotelName;

    @Column(name = "price")
    private String price;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "description")
    private String description;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

}

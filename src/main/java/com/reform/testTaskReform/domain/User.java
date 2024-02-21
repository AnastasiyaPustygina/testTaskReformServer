package com.reform.testTaskReform.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@NamedEntityGraph(name = "user-entity-graph", attributeNodes = {@NamedAttributeNode("routes")})
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "avg_speed")
    private double avgSpeed;

    @OneToMany(targetEntity = Route.class, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    List<Route> routes;
}

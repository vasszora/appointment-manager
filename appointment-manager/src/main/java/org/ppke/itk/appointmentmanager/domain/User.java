package org.ppke.itk.appointmentmanager.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String username;
    private String email;

    @OneToMany(mappedBy = "user_id")
    private List<Appointment> appointments = new ArrayList<>();
}

// @Data
// @AllArgsConstructor
// @Entity
// public class User {
// @Id
// @GeneratedValue(strategy = GenerationType.AUTO)
// @Column(name = "id", nullable = false)
// private Integer id;
// private String name;
// private String email;
// private String phoneNumber;
// }

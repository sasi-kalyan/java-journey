package io.expense.tracker.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "user_table")
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String dob;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String mobile;
    @Column(nullable = true)
    private String altMobile;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Expense> expenses;
}

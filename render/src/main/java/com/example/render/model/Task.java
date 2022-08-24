package com.example.render.model;

import com.example.render.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String taskName;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus = TaskStatus.RENDERING;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
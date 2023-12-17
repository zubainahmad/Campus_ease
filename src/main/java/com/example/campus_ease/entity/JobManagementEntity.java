package com.example.campus_ease.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JobManagementEntity {
    @Id
    @GeneratedValue
    private Long id;

    private ArrayList<String> appliedStudents;
}

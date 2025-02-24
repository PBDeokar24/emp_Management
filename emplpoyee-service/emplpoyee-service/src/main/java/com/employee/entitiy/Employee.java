package com.employee.entitiy;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "employee", schema = "emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="emp_id")
    private Long emp_id;
    @Column(name="emp_name")
    private String emp_name;
    @Column(name="manager")
    private String manager;
    @Column(name="salary")
    private Integer salary;

}

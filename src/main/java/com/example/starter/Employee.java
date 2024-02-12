package com.example.starter;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.util.Objects;

@Entity
class Employee{
    @Id @GeneratedValue
    private Long Id;
    private String name;
    private String role;


    Employee(String name,String role){
        this.name = name;
        this.role = role;
    }

    public Employee() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(!(o instanceof Employee)){
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(this.Id, employee.Id) && Objects.equals(this.name, employee.name)
                && Objects.equals(this.role, employee.role);

    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
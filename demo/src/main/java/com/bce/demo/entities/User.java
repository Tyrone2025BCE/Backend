package com.bce.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="usuario")



public class User {

    @Id
@GeneratedValue

private int id;
private String name;
private String addres;
private String phone;



}

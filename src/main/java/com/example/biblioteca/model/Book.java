package com.example.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
//en esta carpeta van las clases que son entidades

@Entity //esta clase es una tabla de una base de datos
@Data //genera los setters y getters para los atributos de la clase
@NoArgsConstructor //genera un constructor vacío
@AllArgsConstructor //genera un constructor con todos los parametros
@ToString //genera un metodo ToString
@EqualsAndHashCode // genera los metodos correspondientes


public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indica que idBook es una variable autoincremental
    private int idbook;

    private String author;
    private int year;
    private String name;



}

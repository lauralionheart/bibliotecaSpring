package com.example.biblioteca.repository;

//peticiones a la base de datos (lo que seria el modelo en mi idioma)

import com.example.biblioteca.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;   //jparepository es una interfaz que se comunica con la tabla (el primer elemento es la entidad, y el segundo es el tipo de dato del primer atributo de nuestra entidad


public interface BookRepository extends JpaRepository<Book,Integer> {
//JpaRepository tiene metodos crud (create,read,update y delete)



}

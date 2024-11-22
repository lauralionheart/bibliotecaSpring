package com.example.biblioteca.service;




import com.example.biblioteca.model.Book;

import java.util.List;

public interface IBookService {


    public List<Book> showBooks();  //ArrayList de tipo libro que se encargará de mostrar los libros
    public Book searchBookById(Integer id);  //Devolvera un libro mediante su id
    public void saveBook(Book book); // Guarda un libro
    public void deleteBook(Book book); //Borra un libro


}

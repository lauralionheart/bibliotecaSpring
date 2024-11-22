package com.example.biblioteca.service;

//esta carpeta hace las peticiones mediante el repositorio

import com.example.biblioteca.model.Book;
import com.example.biblioteca.repository.BookRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //cuando esta clase representa un servicio (maneja las solicitudes del usuario)

public class BookService implements IBookService {


    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> showBooks(){

        List<Book> books = bookRepository.findAll();
        return books;

    }


    @Override
    public Book searchBookById(Integer id){

        Book book = bookRepository.findById(id).orElse(null); // el orElse es necesario en este metodo, si no hay una id pues retorna null

        return book;
    }


    @Override
    public void saveBook(Book book){

        bookRepository.save(book);


    }


    @Override
    public void deleteBook(Book book){

        bookRepository.delete(book);


    }


}

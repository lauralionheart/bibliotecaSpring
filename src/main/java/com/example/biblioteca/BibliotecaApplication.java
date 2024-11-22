package com.example.biblioteca;

import com.example.biblioteca.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;
import com.example.biblioteca.model.Book;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner { //ejecuta codigo cuando se haya cargado spring, y tiene diferentes metodos

	@Autowired

	private IBookService bookService;




	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}







	@Override
	public void run(String... args) throws Exception {

		bookSystem();




	}


	private void bookSystem(){

		boolean exit = false;
		Scanner scan = new Scanner(System.in);

		while(!exit){

			int option = showMenu(scan);
			exit = executeOptions(scan,option);





		}

	}


	private int showMenu(Scanner scan){

		System.out.println("""
				
				*** BookSystem ***
				
				1.Show books
				2.Search book
				3.Add book
				4.Delete book
				5.Modify book
				6.Exit
				7.Choose an option:\s    
				""");

		return Integer.parseInt(scan.nextLine());

	}

	private boolean executeOptions(Scanner scan, int option){

		boolean exit = false;

		switch(option){

			case 1->{

				System.out.println("  ***  Book List:  ***  ");

				List<Book> books = bookService.showBooks();

				books.forEach(book -> System.out.println(book.toString()) );

			}

			case 2->{

				System.out.println("Inserte la ID del libro que desea ver: ");

				var id = Integer.parseInt(scan.nextLine());
				Book book = bookService.searchBookById(id);

				if (book != null) {

					System.out.println(book);
				}else{

					System.out.println("El libro no existe");
				}


			}


			case 3->{

				System.out.println("Introduce el nombre del autor: ");

				var author = scan.nextLine();

				System.out.println("Introduce el año en el que se publicó: ");

				var year = Integer.parseInt(scan.nextLine());

				System.out.println("Introduce el titulo del libro: ");

				var bookName = scan.nextLine();

				Book book = new Book();
				book.setName(bookName);
				book.setAuthor(author);
				book.setYear(year);

				bookService.saveBook(book);

				System.out.println("Libro guardado con éxito");

			}



			case 4-> {

				System.out.println("Introduce la id del libro que quieres eliminar");

				var idEliminado = Integer.parseInt(scan.nextLine());

				Book bookEliminado = bookService.searchBookById(idEliminado);

				bookService.deleteBook(bookEliminado);

				System.out.println("Libro eliminado con éxito");
			}

			case 5->{

				System.out.println("Introduce la id del libro que quieres modificar:");

				var id = Integer.parseInt(scan.nextLine());


				Book bookEditar = bookService.searchBookById(id);

				if(bookEditar != null) {

					System.out.println("Introduce el nombre del autor: ");

					var author = scan.nextLine();

					System.out.println("Introduce el año en el que se publicó: ");

					var year = Integer.parseInt(scan.nextLine());

					System.out.println("Introduce el titulo del libro: ");

					var bookName = scan.nextLine();

					bookEditar.setName(bookName);
					bookEditar.setAuthor(author);
					bookEditar.setYear(year);

					bookService.saveBook(bookEditar);
				}

			}


			case 6->{

				System.out.println("Chao queride, hasta otra!");
				exit = true;


			}



		}

		return exit;

	}

}

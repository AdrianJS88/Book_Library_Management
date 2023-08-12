package com.application.courselibrary;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.entity.Book;
import com.application.courselibrary.entity.Category;
import com.application.courselibrary.entity.Publisher;
import com.application.courselibrary.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourselibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run( CourselibraryApplication.class, args );}
@Bean
		public CommandLineRunner initialCreate (BookService bookService){
			return (args) -> {
				Book book1 = new Book("abc","book name","prima carte");
				Author author1= new Author("TESTA NAME ","TEST DESCRIPION");
				Category category1 = new Category("bussniess books");
				Publisher publisher1 = new Publisher("first publisher");
				book1.addAuthor( author1 );
				book1.addCategory( category1 );
				book1.addPublisher( publisher1 );
				bookService.createBook( book1 );


				Book book2 = new Book("abc2","book name","prima carte");
				Author author2= new Author("TESTA2 NAME ","TEST DESCRIPION");
				Category category2 = new Category("bussniess2 books");
				Publisher publisher2 = new Publisher("first2 publisher");
				book2.addAuthor( author2 );
				book2.addCategory( category2 );
				book2.addPublisher( publisher2 );
				bookService.createBook( book2 );

				Book book3 = new Book("abc23","book3 name","3prima carte");
				Author author3= new Author("TESTA23 NAME ","3TEST DESCRIPION");
				Category category3 = new Category("bussniess3 books");
				Publisher publisher3 = new Publisher("first23 publisher");
				book3.addAuthor( author3 );
				book3.addCategory( category3 );
				book3.addPublisher( publisher3 );
				bookService.createBook( book3 );
			};


		}
	}

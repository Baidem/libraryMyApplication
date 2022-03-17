package com.baidem.libraryMyApplication.service;


import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.baidem.libraryMyApplication.model.Book;

public class LibraryService {
	
	private List<Book> books;
	Scanner scanner;

	

	public LibraryService() {
		super();
		this.books = new LinkedList<Book>();
		this.scanner = new Scanner(System.in); 
		
		Book livre1 = new Book("Titre1", "Auteur1", "description1", LocalDate.of(2000, 1, 1), false);
		Book livre2 = new Book("Titre2", "Auteur2", "description2", LocalDate.of(2000, 1, 1), false);
		
		books.add(livre1);
		books.add(livre2);

	}

	public void run( ) {
		
		System.out.println("Bienvenue dans ma bibliothèque");
		
		Scanner scanner = new Scanner(System.in);

		String answer = null;
		
		do {
			displayMenu();
			answer = scanner.nextLine();

			if (answer.equals("1")) {
				printList();				
			} else if (answer.equals("2")) {
				addBook();
			}
			
			
		} while (!answer.equals("quit"));
		
		
		scanner.close();
	
	}
	
	public void addBook() {
		System.out.println("Ajouter un livre");
		System.out.println("-----------------");
		System.out.println("Titre :");
		String title = scanner.nextLine();
		System.out.println("Auteur :");
		String author = scanner.nextLine();
		System.out.println("Description :");
		String description = scanner.nextLine();
		System.out.println("Date de parution : AAAA-MM-JJ");
		LocalDate releaseDate = LocalDate.parse(scanner.nextLine());
		Book book = new Book(title, author, description, releaseDate, false);
		books.add(book);
		System.out.println("Ajout de " + book.getTitle());
		enterToContinu();
		
	}
	
	public void printList() {
		System.out.println("Liste des livres");
		if (books.size() > 0) {
			int count = 1;
			
			for (Book book : books) {
				System.out.println(count + " - " + book.getTitle());
				count++;
			}
			enterToContinu();
			
			} else {
			System.out.println("La liste est vide.");
		
			enterToContinu();
		}
		
	}
	
	public void enterToContinu() {
		System.out.println("entrée pour continuer");
		scanner.nextLine();
	}
	
	public void displayMenu() {
		System.out.println("---------------");
		System.out.println("     MENU");
		System.out.println("---------------"); 
		System.out.println("1. Liste de livres");
		System.out.println("2. Ajouter un livre");
		System.out.println("");
		System.out.println("");
		System.out.println("'quit' pour quitter");
		System.out.println("Faites un choix");

	}
	
	
	
}

package com.baidem.libraryMyApplication.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.baidem.libraryMyApplication.model.Book;
import com.baidem.libraryMyApplication.model.Loan;

public class LibraryService {

	private List<Book> books;
	Scanner scanner;

	public LibraryService() {
		super();
		this.books = new LinkedList<Book>();
		this.scanner = new Scanner(System.in);

		Book livre1 = new Book("Titre", "Auteur", "description", LocalDate.of(2000, 1, 1), false);
		Book livre2 = new Book("La vie de Toto", "Mon Oncle", "Les meilleurs blagues de Toto", LocalDate.of(2000, 1, 1),
				false);

		books.add(livre1);
		books.add(livre2);

	}

	public void run() {

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
			} else if (answer.equals("3")) {
				loanBook();
			} else if (answer.equals("4")) {
				removeBook();
			}

		} while (!answer.equals("quit"));

		scanner.close();

	}

	public void removeBook() {
		System.out.println("Effacer un livre");
		System.out.println("----------------");
		printList();
		if (BorrowableQuantity() > 0) {
			System.out.println("Choisir l'index du livre à supprimer :");
			int index = scanner.nextInt();
			scanner.nextLine();
			String answer = null;
			System.out.print("Supprimer : ");
			printBookTitle(index);
			System.out.println("'oui' pour confirmer");
			System.out.println("'non' pour annuler");
			answer = scanner.nextLine();
			if (answer.equals("oui")) {
				this.books.remove(index);
				System.out.println("Livre supprimé.");
			} else {
				System.out.println("Annulé.");
			}
			enterToContinu();
		}
	}

	public void loanBook() {
		String answer = null;
		int index;

		do {
			System.out.println("Emprunter un livre");
			System.out.println("------------------");

			if (BorrowableQuantity() > 0) { // liste des livres empruntables > 0
				printBorrowableList();
				System.out.println("Choisir l'index du livre :");
				index = scanner.nextInt();
				scanner.nextLine();
				if (index < 0 || index > (this.books.size() - 1)) {
					System.out.println("*erreur de saisie*");
					answer = "menu";
				} else {
					if (this.books.get(index).getLoaned()) {
						System.out.println("Livre non disponible");
						answer = "menu";
					} else {
						confirmLoanMenu(index);
						answer = scanner.nextLine();

						if (answer.equals("oui")) {
							loanABook(index);
							answer = "menu";
						}
					}
				}

			} else {
				System.out.println("Pas de livres de disponible");
				answer = "menu";
			}
		} while (!answer.equals("menu"));
		enterToContinu();
	}

	public void loanABook(int index) {
		System.out.println("Nom de l'emprunteur :");
		String name = scanner.nextLine();
		Loan loan = new Loan(name);
		this.books.get(index).addLoan(loan);
		System.out.println(name + " emprunte " + this.books.get(index).getTitle());
	}

	public void confirmLoanMenu(int index) {
		System.out.print("Confirmer l'emprunt de : ");
		printBookTitle(index);
		System.out.println("'oui' pour confirmer");
		System.out.println("'menu' pour revenir au MENU ");

	}

	public void printBookTitle(int index) {
		System.out.println(books.get(index).getTitle());
	}

	public int BorrowableQuantity() {
		int count = 0;

		for (Book book : books) {
			if (!book.getLoaned()) {
				count++;
			}
		}
		return count;

	}

	public void printBorrowableList() {
		System.out.println("Livres disponible");
		int count = 0;

		for (Book book : books) {
			if (!book.getLoaned()) {
				System.out.println(count + " - " + book.getTitle());
			}
			count++;
		}
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
		// exception date fail
		LocalDate releaseDate = LocalDate.parse(scanner.nextLine());
		Book book = new Book(title, author, description, releaseDate, false);
		books.add(book);
		System.out.println("Ajout de " + book.getTitle());
		enterToContinu();

	}

	public void printList() {
		System.out.println("Liste des livres");
		if (books.size() > 0) {
			int count = 0;

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
		System.out.println("Touche entrée pour continuer");
		scanner.nextLine();
	}

	public void displayMenu() {
		System.out.println("---------------");
		System.out.println("     MENU");
		System.out.println("---------------");
		System.out.println("1. Liste de livres");
		System.out.println("2. Ajouter un livre");
		System.out.println("3. Emprunter un livre");
		System.out.println("4. Supprimer un livre");
		System.out.println("'quit' pour quitter");
		System.out.println("Faire un choix");

	}

}

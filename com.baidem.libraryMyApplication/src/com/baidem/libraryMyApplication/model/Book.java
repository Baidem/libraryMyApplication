package com.baidem.libraryMyApplication.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Book {

	private String title;
	private String author;
	private String description;
	private LocalDate releaseDate;
	private Boolean loaned;
	private List<Loan> loans;
	
	
	
	public Book(String title, String author, String description, LocalDate releaseDate, Boolean loaned) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.releaseDate = releaseDate;
		this.loaned = loaned;
		this.loans = new LinkedList<Loan>();
	}



	public String getTitle() {
		return title;
	}



	public String getAuthor() {
		return author;
	}



	public String getDescription() {
		return description;
	}



	public LocalDate getReleaseDate() {
		return releaseDate;
	}



	public Boolean getLoaned() {
		return loaned;
	}



	public List<Loan> getLoans() {
		return loans;
	}



	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", description=" + description + ", releaseDate="
				+ releaseDate + ", loaned=" + loaned + ", loans=" + loans + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(author, description, loaned, loans, releaseDate, title);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(description, other.description)
				&& Objects.equals(loaned, other.loaned) && Objects.equals(loans, other.loans)
				&& Objects.equals(releaseDate, other.releaseDate) && Objects.equals(title, other.title);
	}
	
	
	
	
	
	
	
	
}

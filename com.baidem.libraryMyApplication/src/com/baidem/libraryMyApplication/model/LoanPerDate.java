package com.baidem.libraryMyApplication.model;

import java.time.LocalDate;

public class LoanPerDate {

	
	private LocalDate loanStart;
	private LocalDate loanEnd;
	private String title;
	private String loaner;
	
	
	public LoanPerDate(LocalDate loanStart, LocalDate loanEnd, String title, String loaner) {
		super();
		this.loanStart = loanStart;
		this.loanEnd = loanEnd;
		this.title = title;
		this.loaner = loaner;
	}


	public LocalDate getLoanStart() {
		return loanStart;
	}


	public LocalDate getLoanEnd() {
		return loanEnd;
	}


	public String getTitle() {
		return title;
	}


	public String getLoaner() {
		return loaner;
	}


	@Override
	public String toString() {
		return "LoanPerDate [loanStart=" + loanStart + ", loanEnd=" + loanEnd + ", title=" + title + ", loaner="
				+ loaner + "]";
	}


	


	
	
	
	
}

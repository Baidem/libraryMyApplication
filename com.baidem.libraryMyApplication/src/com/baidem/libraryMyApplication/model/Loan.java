package com.baidem.libraryMyApplication.model;

import java.time.LocalDate;
import java.util.Objects;

public class Loan {

	private LocalDate loanStart;
	private LocalDate loanEnd;
	private String loaner;
	
	
	public Loan(LocalDate loanStart, LocalDate loanEnd, String loaner) {
		super();
		this.loanStart = loanStart;
		this.loanEnd = loanEnd;
		this.loaner = loaner;
	}


	public LocalDate getLoanStart() {
		return loanStart;
	}


	public LocalDate getLoanEnd() {
		return loanEnd;
	}


	public String getLoaner() {
		return loaner;
	}


	@Override
	public String toString() {
		return "Loan [loanStart=" + loanStart + ", loanEnd=" + loanEnd + ", loaner=" + loaner + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(loanEnd, loanStart, loaner);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return Objects.equals(loanEnd, other.loanEnd) && Objects.equals(loanStart, other.loanStart)
				&& Objects.equals(loaner, other.loaner);
	}

	
	
	
	
	
}

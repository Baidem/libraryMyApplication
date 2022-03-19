package com.baidem.libraryMyApplication.model;

import java.time.LocalDate;
import java.util.Objects;

public class Loan {

	private String loaner;
	private LocalDate loanStart;
	private LocalDate loanEnd;
	
	
	public Loan(String loaner) {
		super();
		this.loaner = loaner;
		this.loanStart = LocalDate.now();
		this.loanEnd = null;
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

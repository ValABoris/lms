package com.gcit.library.hbm.entities;
// default package
// Generated Feb 12, 2015 3:39:38 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * TblBook generated by hbm2java
 */
@Entity
@Table(name = "tbl_book", catalog = "library")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="title", scope=TblBook.class)
public class TblBook implements java.io.Serializable {

	private Integer bookId;
	private TblPublisher tblPublisher;
	private String title;
	private Set<TblBookLoans> tblBookLoans = new HashSet<TblBookLoans>(0);
	private Set<TblBookCopies> tblBookCopies = new HashSet<TblBookCopies>(0);
	private Set<TblAuthor> tblAuthors = new HashSet<TblAuthor>(0);
	private Set<TblGenre> tblGenres = new HashSet<TblGenre>(0);

	public TblBook() {
	}

	public TblBook(String title) {
		this.title = title;
	}
	
	public TblBook(TblPublisher tblPublisher, String title, Set<TblBookLoans> tblBookLoans,
			Set<TblBookCopies> tblBookCopies, Set<TblAuthor> tblAuthors,
			Set<TblGenre> tblGenres) {
		this.tblPublisher = tblPublisher;
		this.title = title;
		this.tblBookLoans = tblBookLoans;
		this.tblBookCopies = tblBookCopies;
		this.tblAuthors = tblAuthors;
		this.tblGenres = tblGenres;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bookId", unique = true, nullable = false)
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "tblBooks"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pubId", referencedColumnName = "publisherId")
	public TblPublisher getTblPublisher() {
		return this.tblPublisher;
	}

	public void setTblPublisher(TblPublisher tblPublisher) {
		this.tblPublisher = tblPublisher;
	}

	@Column(name = "title", nullable = false, length = 45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnoreProperties({"tblBook"})
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblBook")
	public Set<TblBookLoans> getTblBookLoans() {
		return this.tblBookLoans;
	}

	public void setTblBookLoans(Set<TblBookLoans> tblBookLoans) {
		this.tblBookLoans = tblBookLoans;
	}

	@JsonIgnoreProperties({"tblBook"})
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tblBook")
	public Set<TblBookCopies> getTblBookCopies() {
		return this.tblBookCopies;
	}

	public void setTblBookCopies(Set<TblBookCopies> tblBookCopies) {
		this.tblBookCopies = tblBookCopies;
	}

	@JsonIgnoreProperties({"tblBooks"})
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_book_authors", catalog = "library", joinColumns = { @JoinColumn(name = "bookId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "authorId", nullable = false, updatable = false) })
	public Set<TblAuthor> getTblAuthors() {
		return this.tblAuthors;
	}

	public void setTblAuthors(Set<TblAuthor> tblAuthors) {
		this.tblAuthors = tblAuthors;
	}

	@JsonIgnoreProperties({"tblBooks"})
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tbl_book_genres", catalog = "library", joinColumns = { @JoinColumn(name = "bookId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "genre_id", nullable = false, updatable = false) })
	public Set<TblGenre> getTblGenres() {
		return this.tblGenres;
	}

	public void setTblGenres(Set<TblGenre> tblGenres) {
		this.tblGenres = tblGenres;
	}
	
}

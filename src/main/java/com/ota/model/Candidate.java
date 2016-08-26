package com.ota.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
@Table(name = "candidate")
public class Candidate {
	@Id
	@Column(name = "username")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "percentageacheived")
	private int grade;
	@Column(name = "attemptedquestions")
	private int attemptedQuestions;
	@Column(name = "correctquestions")
	private int correctQuestions;
	@Column(name = "marksobtained")
	private int marksObtained;
	@Column(name = "testexamid")
	private int testExamId;
	// private TestExam testExam;

	public Candidate() {

	}

	public Candidate(String username, String password, String name) {

		this.username = username;
		this.password = password;
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getAttemptedQuestions() {
		return attemptedQuestions;
	}

	public void setAttemptedQuestions(int attemptedQuestions) {
		this.attemptedQuestions = attemptedQuestions;
	}

	public int getCorrectQuestions() {
		return correctQuestions;
	}

	public void setCorrectQuestions(int correctQuestions) {
		this.correctQuestions = correctQuestions;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public int getTestExamId() {
		return testExamId;
	}

	public void setTestExamId(int testExamId) {
		this.testExamId = testExamId;
	}

	// public TestExam getTestExam() {
	// return testExam;
	// }
	//
	// public void setTestExam(TestExam testExam) {
	// this.testExam = testExam;
	// }

}

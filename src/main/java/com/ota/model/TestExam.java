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
@Table(name = "TESTEXAM")
public class TestExam {
	@Id
	@Column(name = "testid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testId;
	// private ArrayList<TestQuestions> testQuestions;
	@Column(name = "testdescription")
	private String testDescription;

	public TestExam() {

	}
	//
	// public TestExam(int testId, ArrayList<TestQuestions> testQuestions) {
	// this.testId = testId;
	// this.testQuestions = testQuestions;
	// }

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	// public ArrayList<TestQuestions> getTestQuestions() {
	// return testQuestions;
	// }
	//
	// public void setTestQuestions(ArrayList<TestQuestions> testQuestions) {
	// this.testQuestions = testQuestions;
	// }

	public String getTestDescription() {
		return testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
}

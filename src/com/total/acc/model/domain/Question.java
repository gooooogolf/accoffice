package com.total.acc.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACC_QUESTION")
public class Question  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8359286041401958089L;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;

	@Column(name = "SEQ")
	private int seq;
	
	@Column(name = "QUESTION", columnDefinition = "TEXT")
	private String question;
	
	@Column(name = "ANSWER", columnDefinition = "TEXT")
	private String answer;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int id, int seq, String question, String answer) {
		super();
		this.id = id;
		this.seq = seq;
		this.question = question;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", seq=" + seq + ", question=" + question
				+ ", answer=" + answer + "]";
	}

	
}

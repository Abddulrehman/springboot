package com.onlineapi.models;

import org.hibernate.annotations.ValueGenerationType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String message;
	private Long time_posted_epoch;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTime_posted_epoch() {
		return time_posted_epoch;
	}

	public void setTime_posted_epoch(Long time_posted_epoch) {
		this.time_posted_epoch = time_posted_epoch;
	}

}

package com.socialmediablogapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {

	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private int posted_by;

	    private String message_text;
	    private long time_posted_epoch;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getPosted_by() {
			return posted_by;
		}
		public void setPosted_by(int posted_by) {
			this.posted_by = posted_by;
		}
		public String getMessage_text() {
			return message_text;
		}
		public void setMessage_text(String message_text) {
			this.message_text = message_text;
		}
		public long getTime_posted_epoch() {
			return time_posted_epoch;
		}
		public void setTime_posted_epoch(long time_posted_epoch) {
			this.time_posted_epoch = time_posted_epoch;
		}
		@Override
		public String toString() {
			return "Message [id=" + id + ", posted_by=" + posted_by + ", message_text=" + message_text
					+ ", time_posted_epoch=" + time_posted_epoch + "]";
		}
	    
		
	    
}

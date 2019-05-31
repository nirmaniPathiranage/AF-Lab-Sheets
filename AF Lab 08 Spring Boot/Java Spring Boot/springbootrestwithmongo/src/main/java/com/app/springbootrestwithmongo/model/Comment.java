package com.app.springbootrestwithmongo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "comment")

public class Comment {

	@Id
	private String ID;

	@Field(value = "message")
	private String message;

	@Field(value = "type")
	private String type;

	@Field(value = "createdAt")
	private Date createdAt;

	@Field(value = "updatedAt")
	private Date updatedAt;

//	public Comment(String iD, String message, String type, Date createdAt, Date updatedAt) {
//		super();
//		ID = iD;
//		this.message = message;
//		this.type = type;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//	}
//
//	public String getID() {
//		return ID;
//	}
//
//	public void setID(String iD) {
//		ID = iD;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public Date getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Date getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

}

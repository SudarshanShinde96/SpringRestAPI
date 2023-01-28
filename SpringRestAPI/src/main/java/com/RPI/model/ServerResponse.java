package com.RPI.model;

import java.util.List;

public class ServerResponse {
private String message;
private int status;
private List<Student> sList;
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public List<Student> getsList() {
	return sList;
}
public void setsList(List<Student> sList) {
	this.sList = sList;
}
}
package com.ngcusdirlogin;

public class User1 {
	private float responseTime;
	private String readingDateAndTime;
	
	public User1(float responseTime, String readingDateAndTime) {
		super();
		this.responseTime = responseTime;
		this.readingDateAndTime = readingDateAndTime;
	}

	public float getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(float responseTime) {
		this.responseTime = responseTime;
	}

	public String getReadingDateAndTime() {
		return readingDateAndTime;
	}

	public void setReadingDateAndTime(String readingDateAndTime) {
		this.readingDateAndTime = readingDateAndTime;
	}

	@Override
	public String toString() {
		return "User1 [responseTime=" + responseTime + ", readingDateAndTime=" + readingDateAndTime + "]";
	}
	
}

package com.bitacademy.jblog.exception;

public class FileUploadServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public FileUploadServiceException() {
		super("FileUploadServiceException");
	}
	
	public FileUploadServiceException(String message) {
		super(message);
	}
}

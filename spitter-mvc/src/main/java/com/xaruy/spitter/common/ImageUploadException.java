package com.xaruy.spitter.common;

public class ImageUploadException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImageUploadException(String msg) {
		super(msg);
	}
	
	public ImageUploadException(String msg, Exception e) {
		super(msg, e);
	}
	
	public String getMessage(){
		return super.getMessage();
	}

}

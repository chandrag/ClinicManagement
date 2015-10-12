package com.icare.exceptions;

public class MedicineServiceException extends Exception {

	private static final long serialVersionUID = 6545384616484849700L;

	public MedicineServiceException() {
		super();
	}

	public MedicineServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MedicineServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public MedicineServiceException(String message) {
		super(message);
	}

	public MedicineServiceException(Throwable cause) {
		super(cause);
	}

}

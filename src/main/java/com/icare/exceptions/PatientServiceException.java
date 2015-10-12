package com.icare.exceptions;

public class PatientServiceException extends Exception {

	private static final long serialVersionUID = -6899987933938576162L;

	public PatientServiceException() {
	}

	public PatientServiceException(String message) {
		super(message);
	}

	public PatientServiceException(Throwable cause) {
		super(cause);
	}

	public PatientServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PatientServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

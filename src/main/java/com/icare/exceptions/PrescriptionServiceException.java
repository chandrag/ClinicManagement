package com.icare.exceptions;

public class PrescriptionServiceException extends Exception {

	private static final long serialVersionUID = 7167320255444130959L;

	public PrescriptionServiceException() {
	}

	public PrescriptionServiceException(String message) {
		super(message);
	}

	public PrescriptionServiceException(Throwable cause) {
		super(cause);
	}

	public PrescriptionServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public PrescriptionServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

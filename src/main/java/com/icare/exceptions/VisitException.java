package com.icare.exceptions;

public class VisitException extends Exception {

	private static final long serialVersionUID = -3489794226940595256L;

	public VisitException() {
		super();
	}

	public VisitException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VisitException(String message, Throwable cause) {
		super(message, cause);
	}

	public VisitException(String message) {
		super(message);
	}

	public VisitException(Throwable cause) {
		super(cause);
	}

}

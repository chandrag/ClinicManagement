package com.icare.exceptions;

public class AppointmentException extends Exception {

	private static final long serialVersionUID = 5012091008532521848L;

	public AppointmentException() {
		super();

	}

	public AppointmentException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public AppointmentException(String message, Throwable cause) {
		super(message, cause);

	}

	public AppointmentException(String message) {
		super(message);

	}

	public AppointmentException(Throwable cause) {
		super(cause);

	}

}

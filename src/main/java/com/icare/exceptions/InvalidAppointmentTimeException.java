package com.icare.exceptions;

public class InvalidAppointmentTimeException extends Exception {

	private static final long serialVersionUID = -5914073138514954585L;

	public InvalidAppointmentTimeException() {
		super();
	}

	public InvalidAppointmentTimeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidAppointmentTimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidAppointmentTimeException(String message) {
		super(message);
	}

	public InvalidAppointmentTimeException(Throwable cause) {
		super(cause);
	}

}

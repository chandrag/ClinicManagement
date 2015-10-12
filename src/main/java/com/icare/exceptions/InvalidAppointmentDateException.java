package com.icare.exceptions;

public class InvalidAppointmentDateException extends AppointmentException {

	private static final long serialVersionUID = -8446712621398243304L;

	public InvalidAppointmentDateException() {
		super();
	}

	public InvalidAppointmentDateException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidAppointmentDateException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidAppointmentDateException(String message) {
		super(message);
	}

	public InvalidAppointmentDateException(Throwable cause) {
		super(cause);
	}

}

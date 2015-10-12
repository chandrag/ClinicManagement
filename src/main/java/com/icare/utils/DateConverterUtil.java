package com.icare.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateConverterUtil {

	static final Logger LOGGER = LoggerFactory.getLogger(DateConverterUtil.class);

	public static String toString(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	public static Date toDate(String stringDate, String pattern)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.parse(stringDate);
	}

	public static boolean validateAppointmentTime(Date date) {
		LOGGER.info("Validating Appointment Time...");
		boolean resp = false;
		Date currentDate = new Date();
		long diff = date.getTime() - currentDate.getTime();
		long diffInMin = 0;
		if (diff > 0) {
			diffInMin = diff / (1000 * 60);
		}
		if (diffInMin > 25) {
			resp = true;
		}
		LOGGER.debug("Appointment Validation Result : {}", resp);
		return resp;
	}

	public static boolean validateAppointmentDate(Date date) {
		LOGGER.info("Validating Appointment Date : {}", date);
		Calendar appointmentCal = Calendar.getInstance();
		appointmentCal.setTime(date);
		int appointmentDay = appointmentCal.get(Calendar.DAY_OF_MONTH);
		int appointmentMonth = appointmentCal.get(Calendar.MONTH);
		int appointmentYear = appointmentCal.get(Calendar.YEAR);

		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		boolean resp = false;
		if (year == appointmentYear && month == appointmentMonth
				&& day <= appointmentDay) {
			resp = true;
		}
		LOGGER.debug("Validation Result : {}", resp);
		return resp;
	}

	public static Date getDateByDays(int noOfDays) {
		Calendar calendar = Calendar.getInstance();
		Date today = new Date();
		calendar.setTime(today);
		calendar.add(Calendar.DAY_OF_MONTH, noOfDays);
		return calendar.getTime();
	}

}

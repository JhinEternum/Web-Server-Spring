package br.com.transcendance.api.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	public static Date convertToDateViaInstant(LocalDate dateToConvert) {
		return java.util.Date.from(dateToConvert.atStartOfDay()
				.atZone(ZoneId.systemDefault())
				.toInstant());
	}

}

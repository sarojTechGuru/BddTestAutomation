package com.UI.Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

	public static String timeStamp() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		String timestamp=LocalDateTime.now().format(formatter);
		return timestamp;
	}
}

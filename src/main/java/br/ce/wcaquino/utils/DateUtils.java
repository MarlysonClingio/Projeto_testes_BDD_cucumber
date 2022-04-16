package br.ce.wcaquino.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Date obterDataDiferencaDeDias(int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, dias);
		return calendar.getTime();
	}

}
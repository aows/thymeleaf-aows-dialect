package ws.otero.adrian.thymeleaf;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author adrian otero (http://adrian.otero.ws)
 * 
 */
public class HotDateUtils {

	public HotDateResult formatCalendar(Calendar date) {
		return formatDate(date.getTime());
	}

	public HotDateResult formatDate(Date date) {

		final long diff = new Date().getTime() - date.getTime();

		if (diff < 0) {
			throw new IllegalStateException("date is after the current date");
		}

		int ago = 0;
		final long second = 1000;
		final long minute = second * 60;
		final long hour = minute * 60;
		final long day = hour * 24;
		final long month = day * 30;
		final long year = day * 365;

		if (diff < second * 10) {
			return new HotDateResult("justnow");
		}

		if (diff < minute) {
			ago = (int) Math.floor(diff / second);
			return new HotDateResult("seconds", ago);
		}

		if (diff < minute * 2) {
			return new HotDateResult("minute");
		}

		if (diff < hour) {
			ago = (int) Math.floor(diff / minute);
			return new HotDateResult("minutes", ago);
		}

		if (diff < hour * 2) {
			return new HotDateResult("hour");
		}

		if (diff < day) {
			ago = (int) Math.floor(diff / hour);
			return new HotDateResult("hours", ago);
		}

		if (diff < day * 2) {
			return new HotDateResult("yesterday");
		}

		if (diff < month) {
			ago = (int) Math.floor(diff / day);
			return new HotDateResult("days", ago);
		}

		if (diff < month * 2) {
			return new HotDateResult("month");
		}

		if (diff < year) {
			ago = (int) Math.floor(diff / month);
			return new HotDateResult("months", ago);
		}

		if (diff < year * 2) {
			return new HotDateResult("year");
		}

		ago = (int) Math.floor(diff / year);
		return new HotDateResult("years", ago);
	}

	public class HotDateResult {
		private String key;
		private Integer[] values;

		public HotDateResult(String key, Integer... values) {
			this.key = key;
			this.values = values;
		}

		public String getKey() {
			return key;
		}

		public Integer[] getValues() {
			return values;
		}

	}

}

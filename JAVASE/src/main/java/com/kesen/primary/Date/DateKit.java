package com.kesen.primary.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: kesen
 * @Date: 2020/4/25 21:06
 * @Description:
 **/
public class DateKit extends DateUtils {
	private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	private DateKit() throws Exception {
		throw new Exception("can't new instance");
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * *
	 *
	 * @Description: 得到当前日期字符串 默认格式格式（yyyy-MM-dd）
	 * @Param: []
	 * @return: java.lang.String
	 * @Author: kesen
	 * @Date: 2020/4/25 21:12
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}


	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate;
		// 可变变量传递的是数组
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * *
	 *
	 * @Description: 通过秒格式化
	 * @Param: [second]
	 * @return: java.lang.String
	 * @Author: kesen
	 * @Date: 2020/4/25 21:15
	 */
	public static String formatWithTime(String second) {
		return formatDate(new Date(Long.valueOf(second) * 1000));
	}

	/**
	 * 功能描述:	返回不大于date2的日期
	 * 如果	date1 >= date2 返回date2
	 * 如果	date1 < date2  返回date1
	 *
	 * @param date1
	 * @param date2
	 * @return Date
	 */
	public static Date ceil(Date date1, Date date2) {
		if (date1 == null && date2 == null) {
			return null;
		}
		if (date1 == null) {
			return date2;
		}
		if (date2 == null) {
			return date1;
		}
		if (date1.after(date2)) {
			return date2;
		} else {
			return date1;
		}
	}

	/**
	 * 获得指定日期的前、后N{calendarType}的时间
	 *
	 * @param date         指定时间
	 * @param number       前、后N{calendarType}
	 * @param calendarType 分类：前后N天（Calendar.DATE）、小时（Calendar.HOUR）。。。
	 * @return 获得指定日期的前、后N{calendarType}的时间
	 */
	public static Date getSpecifiedDayBeforeOrAfter(Date date, int number, int calendarType) {
		Calendar c = Calendar.getInstance();

		c.setTime(date);
		c.add(calendarType, number);

		return c.getTime();
	}


	/**
	 * 获得指定日期的前、后N天的时间
	 *
	 * @param date   指定时间
	 * @param number 前、后N天
	 * @return 获得指定日期的前、后N天的时间
	 */
	public static Date getSpecifiedDayBeforeOrAfter(Date date, int number) {
		return getSpecifiedDayBeforeOrAfter(date, number, Calendar.DATE);
	}

	/**
	 * *
	 *
	 * @Description: 给定时间内的天
	 * @Param: [begin, end, parse]
	 * @return: java.util.List<java.lang.String>
	 * @Author: kesen
	 * @Date: 2020/4/26 7:51
	 */
	public static List<String> getBetweenDays(Date begin, Date end, String parse) {
		List<String> days = new LinkedList<>();

		Calendar timeBegin = Calendar.getInstance();
		timeBegin.setTime(begin);

		Calendar timeEnd = Calendar.getInstance();
		timeEnd.setTime(end);

		while (timeBegin.before(timeEnd)) {
			days.add(formatDate(timeBegin.getTime(), parse));
			timeBegin.add(Calendar.DATE, +1);
		}

		return days;
	}

	/**
	 * *
	 *
	 * @Description: 给定时间范围内的小时
	 * @Param: [begin, end, parse]
	 * @return: java.util.List<java.lang.String>
	 * @Author: kesen
	 * @Date: 2020/4/26 7:52
	 */
	public static List<String> getBetweenHours(Date begin, Date end, String parse) {
		List<String> hours = new LinkedList<>();
		Calendar timeBegin = Calendar.getInstance();
		timeBegin.setTime(begin);

		Calendar timeEnd = Calendar.getInstance();
		timeEnd.setTime(end);

		while (!timeBegin.after(timeEnd)) {
			hours.add(formatDate(timeBegin.getTime(), parse));
			timeBegin.add(Calendar.HOUR, +1);
		}

		return hours;
	}

	
	/**
	** 
	* @Description:  
	* @Param: [str, src_pattern, dst_pattern] 
	* @return: java.lang.String 
	* @Author: kesen
	* @Date: 2020/4/26 8:14
	*/ 
	public static String stringPatternToPattern(String str, String src_pattern, String dst_pattern) {

		if (StringUtils.isNotBlank(dst_pattern)) {

			try {

				Date date = DateKit.parseDate(str, src_pattern);
				return formatDate(date, dst_pattern);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return str;

	}

	/**
	 *
	 * getMinDateOfMonth(取得一月中最早的一天)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午5:23:16
	 * @param date
	 * @return
	 */
	public static Date getMinDateOfMonth(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));

		return calendar.getTime();
	}

	/**
	 *
	 * getMaxDateOfMonth(取得一月中的最后一天)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午4:46:00
	 * @param date
	 * @return
	 */
	public static Date getMaxDateOfMonth(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));

		return calendar.getTime();
	}

	/**
	 *
	 * getMinDateOfDay(取得一个date对象对应的日期的0点0分0秒时刻的Date对象)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午5:20:18
	 * @param date
	 * @return
	 */
	public static Date getMinDateOfDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));

		return calendar.getTime();
	}

	/**
	 * 取得一个date对象对应的小时的59分59秒时刻的Date对象。
	 *
	 * @param date
	 *            一个日期
	 * @return Date对象。
	 */
	public static Date getMaxDateOfHour(Date date) {
		if (date == null) {
			return null;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));

		return calendar.getTime();
	}


	/**
	 * 判断2个日期是否同一天同一小时
	 */
	public static boolean isSameOfHour(Date startDate, Date endDate) {
		String startDateStr = formatDate(startDate, "yyyy-MM-dd HH");
		String endDateStr = formatDate(endDate, "yyyy-MM-dd HH");
		return startDateStr.equals(endDateStr);
	}

	/**
	 * 判断2个日期是否同一天
	 */
	public static boolean isSameOfDay(Date startDate, Date endDate) {
		String startDateStr = formatDate(startDate, "yyyy-MM-dd");
		String endDateStr = formatDate(endDate, "yyyy-MM-dd");
		return startDateStr.equals(endDateStr);
	}

	/**
	 * 判断2个日期是否同一月
	 */
	public static boolean isSameOfMonth(Date startDate, Date endDate) {
		String startDateStr = formatDate(startDate, "yyyy-MM");
		String endDateStr = formatDate(endDate, "yyyy-MM");
		return startDateStr.equals(endDateStr);
	}


	/**
	 * 获取2个时间相隔几月
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getBetweenMonthNumber(Date startDate, Date endDate) {
		int result = 0;
		try {
			if (startDate == null || endDate == null)
				return -1;

			// swap start and end date
			if (startDate.after(endDate)) {
				Date tmp = endDate;
				endDate = startDate;
				startDate = tmp;
			}

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);

			int monthS = calendar.get(Calendar.MONTH);
			int yearS = calendar.get(Calendar.YEAR);

			calendar.setTime(endDate);
			int monthE = calendar.get(Calendar.MONTH);
			int yearE = calendar.get(Calendar.YEAR);

			if (yearE - yearS == 0) {
				result = monthE - monthS;
			} else {
				result = (yearE - yearS - 1) * 12 + (12 - monthS) + monthE;
			}

		} catch (Exception e) {

		}
		return result;
	}


	/**
	 * 获取两个日期之间的小时数
	 *
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getBetweenHourNumber(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60);
	}

	/**
	 *
	 * getMaxDateOfDay(取得一个date对象对应的日期的23点59分59秒时刻的Date对象)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午4:48:09
	 * @param date
	 * @return
	 */
	public static Date getMaxDateOfDay(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));

		return calendar.getTime();
	}

	/**
	 *
	 * getMaxDateOfYesterday(取得昨天23点59分59秒时刻的Date对象)
	 *
	 * @author qiongjie
	 * @date 2020年03月02日下午4:48:00
	 * @return Date
	 */
	public static Date getMaxDateOfYesterday() {

		Calendar calendar = Calendar.getInstance();

		Date date = new Date();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));

		return calendar.getTime();
	}

	/**
	 *
	 * getMinTimeOfHour(取得一个date对象对应的日期的0分0秒时刻的Date对象)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午5:21:48
	 * @param date
	 * @return
	 */
	public static Date getMinTimeOfHour(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));

		return calendar.getTime();
	}

	/**
	 *
	 * getMaxTimeOfHour(取得一小时的最大时间)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午5:06:14
	 * @param date
	 * @return
	 */
	public static Date getMaxTimeOfHour(Date date) {
		return getMaxDateOfHour(date);
	}

	/**
	 * 获取季度的开始时间
	 *
	 * getMinTimeOfQuarter
	 *
	 * @author yangfei
	 * @date 2018年2月7日下午4:06:45
	 * @param date
	 * @return
	 */
	public static Date getMinTimeOfQuarter(Date date) {
		if (date == null)
			return null;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, ((int) calendar.get(Calendar.MONTH) / 3) * 3);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
		return calendar.getTime();
	}

	/**
	 * 获取当前季度的最大时间 getMaxTimeOfQuarter
	 *
	 * @author yangfei
	 * @date 2018年2月7日下午4:07:12
	 * @param date
	 * @return
	 */
	public static Date getMaxTimeOfQuarter(Date date) {
		if (date == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, ((int) calendar.get(Calendar.MONTH) / 3) * 3 + 2);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
		return calendar.getTime();
	}

	/**
	 * 获取给定日期的上一个小时结束时间
	 *
	 * @author mike(黄不羁)
	 * @date 2018年9月19日下午4:42:51
	 * @param date
	 *            当前日期
	 * @return 给定日期的上一个小时结束时间
	 */
	public static Date getLastHourEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, -1);
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
		return calendar.getTime();
	}

	/**
	 *
	 * isMinTimeOfMinute(是否是某个小时的最小值)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午5:29:27
	 * @param date
	 * @return
	 */
	public static boolean isMinTimeOfMinute(Date date) {

		if (date == null) {
			return false;
		}

		Date currentDate = getMinTimeOfHour(date);

		int secondNum = DateKit.getBetweenSecond(date, currentDate);
		return secondNum == 0;

	}

	/**
	 *
	 * isMaxTimeOfHour(是否是某个小时的最大值)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午4:15:52
	 * @param date
	 * @return
	 */
	public static boolean isMaxTimeOfHour(Date date) {

		if (date == null) {
			return false;
		}

		Date currentDate = getMaxTimeOfHour(date);

		int secondNum = DateKit.getBetweenSecond(date, currentDate);
		return secondNum == 0;
	}

	/**
	 *
	 * isMinDayOfDay(判断输入日期是否是一天中的最小时刻)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午5:26:59
	 * @param date
	 * @return
	 */
	public static boolean isMinDayOfDay(Date date) {
		if (date == null)
			return false;
		Date currentDate = getMinDateOfDay(date);
		int secondNum = getBetweenSecond(date, currentDate);
		return secondNum == 0;
	}

	/**
	 *
	 * isMaxDayOfDay(判断输入日期是否是一天中的最大时刻)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午4:32:29
	 * @param date
	 * @return
	 */
	public static boolean isMaxDayOfDay(Date date) {
		if (date == null) {
			return false;
		}

		Date currentDate = getMaxDateOfDay(date);
		int secondNum = getBetweenSecond(date, currentDate);
		return secondNum == 0;
	}

	/**
	 *
	 * isMinDayOfMonth(判断输入日期是否是一月中的最小时刻)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午5:25:21
	 * @param date
	 * @return
	 */
	public static boolean isMinDayOfMonth(Date date) {
		if (date == null)
			return false;
		Date currentDate = getMinDateOfMonth(date);
		int secondNum = getBetweenSecond(date, currentDate);
		return secondNum == 0;
	}

	/**
	 *
	 * isMaxDayOfMonth(判断输入日期是否是一月中的最大时刻)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午5:12:20
	 * @param date
	 * @return
	 */
	public static boolean isMaxDayOfMonth(Date date) {

		if (date == null) {
			return false;
		}

		Date currentDate = getMaxDateOfMonth(date);
		int secondNum = getBetweenSecond(date, currentDate);
		return secondNum == 0;

	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
	 * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm",
	 * "yyyyMMdd","yyyyMMdd HH:mm:ss","yyyyMMdd HH:mm"}
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 *
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (24 * 60 * 60 * 1000);
	}

	/**
	 * 获取过去的小时
	 *
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 60 * 1000);
	}

	/**
	 * 获取过去的分钟
	 *
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime() - date.getTime();
		return t / (60 * 1000);
	}

	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 *
	 * @param timeMillis
	 * @return
	 */
	public static String formatDateTime(long timeMillis) {
		long day = timeMillis / (24 * 60 * 60 * 1000);
		long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
		long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
		long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
		return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	}


	/**
	 * 取得一个date对象对应的日期的0分0秒时刻的Date对象。
	 *
	 * @param date
	 *            一个日期
	 * @return Date对象。
	 */
	public static Date getMinDateOfHour(Date date) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar
				.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar
				.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar
				.getActualMinimum(Calendar.MILLISECOND));

		return calendar.getTime();
	}

	/**
	 *
	 * getBetweenSecond(获取两个时间直接的秒数)
	 *
	 * @author yangxi
	 * @date 2017年12月26日下午4:27:43
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getBetweenSecond(Date startDate, Date endDate) {

		long timeNumber = -1L;
		long beforeTime = startDate.getTime();
		long afterTime = endDate.getTime();

		timeNumber = (afterTime - beforeTime) / 1000L;
		return (int) timeNumber;
	}

	public static String[] dayHourMinSec(long second) {
		long day = second / 86400;
		long hour = second % 86400 / 3600;
		long minute = second % 3600 / 60;
		long snd = second % 60;
		return new String[] { Long.toString(day), Long.toString(hour), Long.toString(minute), Long.toString(snd) };
	}

	/**
	 * 获取日期中的小时信息
	 *
	 * @author mike(黄不羁)
	 * @date 2018年1月8日下午3:56:56
	 * @param date
	 *            日期
	 * @return 日期中的小时信息
	 */
	public static int getHourInDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	public static Date DateLong2Date(long timeLong) {

		return new Date(timeLong * 1000);

	}

	/**
	 * 获取2个时间相隔几分钟
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getBetweenMinuteNumber(Date startDate, Date endDate) {
		if (startDate == null || endDate == null)
			return -1;

		if (startDate.after(endDate)) {
			Date tmp = endDate;
			endDate = startDate;
			startDate = tmp;
		}

		long timeNumber = -1l;
		long TIME = 60L*1000L;
		try {
			timeNumber = (endDate.getTime() - startDate.getTime()) / TIME;

		} catch (Exception e) {
			//TODO
		}
		return (int) timeNumber;
	}

	/**
	 * 将时间范围切割为yyyyMMdd的时间字符串集合
	 *
	 * @author mike(黄不羁)
	 * @date 2016年8月7日下午8:55:42
	 * @param beginTime
	 *            时间范围-开始
	 * @param endTime
	 *            时间范围-结束
	 * @return yyyyMMdd的时间字符串集合
	 */
	public static List<String> splitDay(Date beginTime, Date endTime) {
		List<String> list = new LinkedList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if (beginTime.after(endTime)) {
			return list;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginTime);

		while (!cal.getTime().after(endTime)) {
			list.add(sdf.format(cal.getTime()));
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
		return list;
	}

	/**
	 * 将时间范围切割为yyyyMMddHH的时间字符串集合
	 *
	 * @author mike(黄不羁)
	 * @date 2016年9月7日下午9:58:30
	 * @param beginTime
	 *            时间范围-开始
	 * @param endTime
	 *            时间范围-结束
	 * @return yyyyMMddHH的时间字符串集合
	 */
	public static List<String> splitHour(Date beginTime, Date endTime) {
		List<String> list = new LinkedList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
		if (beginTime.after(endTime)) {
			return list;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(beginTime);

		while (!cal.getTime().after(endTime)) {
			list.add(sdf.format(cal.getTime()));
			cal.add(Calendar.HOUR_OF_DAY, 1);
		}
		return list;
	}

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		System.out.println();
	}
}


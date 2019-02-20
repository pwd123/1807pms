package com.zs.pms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Administrator
 *时间工具类
 */
public class DateUtil {


	/**
	 * 获得当前时间的方法(字符串)
	 * @return 返回当前字符串
	 */
	public static String getStrDate() {
		
		
		//获得日历对象
		Calendar cal = Calendar.getInstance();
		//当前的年
		int year = cal.get(Calendar.YEAR);
		//当前的月(月份从0开始)
		int month = cal.get(Calendar.MONDAY)+1;
		//当前的日
		int date = cal.get(Calendar.DATE);
		//当前的小时
		int hh = cal.get(Calendar.HOUR_OF_DAY);

		//通过获得的当前小时来判断是上午，中午还是下午
		String str = "";
		
		if (hh>=6&&hh<=10) {
			str = "早上好!";
		} else if(hh>10&&hh<=14) {
			str = "中午好!";
		}else if (hh>14&&hh<=18) {
			str = "下午好!";
		}else if (hh>18&&hh<24) {
			str = "晚上好!";
		}else {
			str = "还不睡啊!";
		}
		
		
		return year+"-"+month+"-"+date+"-"+str;
		
	}
	/**
	 * 字符转Date的方法
	 * @param time字符串
	 * @param pattern输入字符串的时间格式
	 * @return dtae的时间
	 * @throws ParseException
	 */
	public static  Date getStrToDate(String time  , String pattern) throws ParseException {
		// TODO Auto-generated constructor stub
		
		//获得格式化对象
		SimpleDateFormat sdf= new SimpleDateFormat(pattern);
	    // 返回格式化好的时间
		return sdf.parse(time);
	
		
	}
	/**
	 * Date转String时间的方法
	 * @param time Date类的时间
	 * @param pattern 把时间格式化成什么样
	 * @return 字符串类的时间
	 */
	public static String getDateToStr(Date time , String pattern) {
		
		//获得格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		//返回格式化好的时间
		return sdf.format(time);
		
	}
	
	
}

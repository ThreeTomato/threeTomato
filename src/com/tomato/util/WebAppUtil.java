package com.tomato.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @ClassName: WebAppUtil
 * @Description: TODO
 * @date 2015-1-26 обнГ11:00:35
 * @author 0000
 *
 */
public class WebAppUtil {

	/**
	 * system current time
	 * @return
	 */
	public static String getCurrentTime(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	
	public static void main(String[] args) {
		System.err.println(getCurrentTime());
	}
}

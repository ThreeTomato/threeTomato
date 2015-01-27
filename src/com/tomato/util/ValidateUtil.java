package com.tomato.util;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

	/**
	 * 数字验证
	 * @param number
	 * @return
	 */
	public static boolean isNumber(String number){
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher matcher = pattern.matcher(number);
		if(matcher.matches())
			return true;
		return false;
	}
	
	/**
	 * 字符串验证
	 * @param str
	 * @return
	 */
	public static boolean stringVal(String str){
		if(null==str||"".equals(str)){
			return true;
		}
		return false;
	}
	
	/**
	 * 集合验证
	 * @param collections
	 * @return
	 */
	public static <T> boolean collectionVal(Collection<T> collections){
		boolean flag = true;
			if(collections==null) return flag;
			if(collections.size()==0) return flag;
		flag = false;
		return flag;
	}
	
}

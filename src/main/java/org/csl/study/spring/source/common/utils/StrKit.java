package org.csl.study.spring.source.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;


public class StrKit {

	public static final String Empty = "";
	
	public static final String Zero = "0";

	public static boolean isEmpty(Object value) {
		return value == null ? true : value.toString().isEmpty();
	}

	public static boolean isNoEmpty(Object value) {
		return !isEmpty(value);
	}

	
	/***
	 * 首字母大小写
	 * @param value
	 * @return
	 */
	public static String uncapitalize(String value) {
		return StringUtils.uncapitalize(value);
	}
    /**
     * 替换所有的匹配字符
     * @param value
     * @param src
     * @param dst
     * @return
     */
	public static String replace(String value, String src, String dst) {
		return StringUtils.replace(value, src, dst);
	}
	
	public static String[] split(String express,String seperator){
		return StringUtils.split(express,seperator);
	}
	
	
	
	
	public static String rightInterct(String value,int size){
		if(value.length()>size){
			return value.substring(value.length()-size,value.length());
		}else{
			return value;
		}
	}
	
	/**
	 * 字节长度
	 * 
	 * @param iString
	 * @return
	 */
	public static int getBytesLength(String iString) {
		if(iString==null){
			return 0;
		}
		return iString.getBytes().length;
	}
	
	/**
	 * 字节长度
	 * @throws Exception 
	 * 
	 */
	public static int getGBKBytesLength(String iString) throws Exception {
		if(iString==null){
			return 0;
		}
		return iString.getBytes("GBK").length;
	}
	

	public static String unicodeToGBK(String iString) throws UnsupportedEncodingException {
		String oString = iString;
		if (iString != null) {
			oString = new String(iString.getBytes("ISO8859_1"), "GBK");
		}
		return oString;
	}

	public static String GBKToUnicode(String iString) throws UnsupportedEncodingException {
		String oString = iString;
		if (iString != null) {
			oString = new String(iString.getBytes("GBK"), "ISO8859_1");
		}
		return oString;
	}
	/**
	 * 转换成HTML格式
	 * 
	 * @param strInValue
	 * @return
	 */
	public static String toHTMLFormat(String strInValue) {
		String strOutValue = "";

		for (int i = 0; i < strInValue.length(); i++) {
			char c = strInValue.charAt(i);
			switch (c) {
			case '<':
				strOutValue = strOutValue + "&lt;";
				break;
			case '>':
				strOutValue = strOutValue + "&gt;";
				break;
			case '\n':
				strOutValue = strOutValue + "<br>";
				break;
			case '\r':
				break;
			case ' ':
				strOutValue = strOutValue + "&nbsp;";
				break;
			default:
				strOutValue = strOutValue + c;
			}
		}

		return strOutValue;
	}

	/**
	 * 转义字符转换
	 * 
	 * @param strInValue
	 * @return
	 */
	public static String encode(String strInValue) {
		String strOutValue = "";
		if(!StrKit.isEmpty(strInValue)){
			for (int i = 0; i < strInValue.length(); i++) {
				char c = strInValue.charAt(i);
				switch (c) {
				case ':':
					strOutValue = strOutValue + "：";
					break;
				case '|':
					strOutValue = strOutValue + "┃";
					break;
				case '\n':
					strOutValue = strOutValue + "\\n";
					break;
				case '\r':
					strOutValue = strOutValue + "\\r";
					break;
				case '"':
					strOutValue = strOutValue + "\\\"";
					break;
				case '\'':
					strOutValue = strOutValue + "\\'";
					break;
				case '\b':
					strOutValue = strOutValue + "\\b";
					break;
				case '\t':
					strOutValue = strOutValue + "\\t";
					break;
				case '\f':
					strOutValue = strOutValue + "\\f";
					break;
				case '\\':
					strOutValue = strOutValue + "\\\\";
					break;
				case '<':
					strOutValue = strOutValue + "\\<";
					break;
				case '>':
					strOutValue = strOutValue + "\\>";
					break;
				default:
					strOutValue = strOutValue + c;
				}

			}
		}
		return strOutValue;
	}


	public static String decode(String strInValue) {
		String strOutValue = strInValue;
		strOutValue = replace(strOutValue, "\\n", "\n");
		strOutValue = replace(strOutValue, "\\r", "\r");
		strOutValue = replace(strOutValue, "\\\\", "\\");
		strOutValue = replace(strOutValue, "\\b", "\b");
		strOutValue = replace(strOutValue, "\\t", "\t");
		strOutValue = replace(strOutValue, "\\\"", "\"");
		strOutValue = replace(strOutValue, "\\'", "'");
		strOutValue = replace(strOutValue, "\\f", "\f");
		strOutValue = replace(strOutValue, "\\<", "<");
		strOutValue = replace(strOutValue, "\\>", ">");
		return strOutValue;
	}

	/**
	 * 空转换成0
	 * 
	 * @param iValue
	 * @return
	 */
	public static String chgStrZero(String iValue) {
		String value = null;

		if (iValue == null)
			value = "0";
		else if (iValue.trim().length() == 0)
			value = "0";
		else {
			value = iValue;
		}
		return value.trim();
	}

	/**
	 * null转换成空，并去掉右边的空格
	 * 
	 * @param strIn
	 * @return
	 */
	public static String rightTrim(String strIn) {
		String strReturn = "";
		int intLength = 0;

		if ((strIn == null) || (strIn.equals("")) || (strIn.equals("null")))
			return "";
		intLength = strIn.length();

		while ((intLength > 0) && (strIn.substring(intLength - 1, intLength).equals(" "))) {
			strIn = strIn.substring(0, intLength - 1);
			intLength = strIn.length();
		}

		strReturn = strIn;
		return strReturn;
	}
	/**
	 * 是否匹配正则表达式
	 * @param value
	 * @param regex
	 * @return
	 */
	public static boolean matches(String value, String regex) {
		
		if(value != null && Pattern.matches(regex, value)){
			 return true;
		}
		return false;
	}
	
	/**
	 * 去掉最后一个分隔符
	 * @param value
	 * @param mark
	 * @return
	 */
	public static String removeLastMark(String value,String mark){
		if(!StrKit.isEmpty(value)){
			return value.substring(0,value.length()-1);
		}
		return value;
	}
	
	
	/**
	 * null转换成空
	 * 
	 * @param strIn
	 * @return
	 */
	public static String nullToEmpty(String strIn) {
		if(strIn == null){
			return "";
		}else{
			return strIn;
		}
	}
	
	public static String newString(String iString, int iTimes){
	    StringBuffer buffer = new StringBuffer();
	    for (int i = 0; i < iTimes; i++) {
	      buffer.append(iString);
	    }
	    return buffer.toString();
	}
	
	public static String space(int iLength){
		return newString(" ", iLength);
	}
	
}

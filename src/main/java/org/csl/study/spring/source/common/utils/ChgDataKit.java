package org.csl.study.spring.source.common.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChgDataKit {
	public static String chgZero(byte byteValue) {
		return String.valueOf(byteValue);
	}

	public static String chgZero(short shortValue) {
		return String.valueOf(shortValue);
	}

	public static String chgZero(int intValue) {
		String strReturn = null;
		if (intValue == 0)
			strReturn = "0";
		else
			strReturn = String.valueOf(intValue);
		return strReturn;
	}

	public static String chgZero(long longValue) {
		String strReturn = null;
		if (longValue == -4154277932753223680L)
			strReturn = "0";
		else
			strReturn = String.valueOf(longValue);
		return strReturn;
	}

	public static String chgZero(float floatValue) {
		String strReturn = null;
		if (floatValue == 0F)
			strReturn = "0";
		else
			strReturn = String.valueOf(floatValue);
		return strReturn;
	}

	public static String chgZero(Double doubleValue) {
		String strReturn = null;
		if (doubleValue == null || doubleValue == 0D) {
			strReturn = "0";
		} else {
			strReturn = String.valueOf(doubleValue);
		}
		return strReturn;
	}
	/**
	 * Double转换成double
	 * 
	 * @param value
	 * @return
	 */
	public static double nullToZero(Double value) {
		double strReturn = 0;
		if (value != null) {
			strReturn = value.doubleValue();
		}
		return strReturn;
	}
  /**
   * BigDecimal转换成Double
   * @param value
   * @return
   */
  public static Double toDouble(BigDecimal value)
  {
	  Double strReturn = null;
    if (value  != null ){
    	strReturn  = value.doubleValue();
    }
    return strReturn;
  }
  /**
   * String转换成Double
   * @param value
   * @return
   */
  public static Double toDouble(String value)
  {
	  Double strReturn = null;
    if (value  != null  && !"".equals(value)){
    	strReturn  = Double.parseDouble(value);
    }
    return strReturn;
  }
  /**
   * BigDecimal转换成Double
   * @param value
   * @return
   */
  public static Double toDouble(Integer value)
  {
	  Double strReturn = null;
    if (value  != null ){
    	strReturn  = value.doubleValue();
    }
    return strReturn;
  }
  public static String chgStrZero(String iValue)
  {
    String value = null;
    if (iValue == null || "".equals(iValue))
      value = "0";
    else if (iValue.trim().length() == 0)
      value = "0";
    else if ("0.0".equals(iValue.trim()))
        value = "0";
    else
      value = iValue;

		return value.trim();
	}

	public static String chgStrZero(String iValue, int fraction) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance();
		numberFormat.setMaximumFractionDigits(fraction);
		numberFormat.setGroupingUsed(false);// 不分组：不用逗号分组12,000,000
		return numberFormat.format(Double.parseDouble(chgStrZero(iValue)));
	}

	public static String nullToString(Object iObject) {
		String value = "";

		if (iObject == null) {
			value = "";
		} else {
			value = iObject.toString();
		}

		return value;
	}
	
	
	public static String getEmptyVal(String val) throws Exception{
		if(val == null || "".equals(val.trim())){
			return "";
		}
		return val.trim();
	}

	/**
	 * 是空字符串或者null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmptyStr(String str) {
		boolean falg = false;

		if (str == null || str.isEmpty()) {
			falg = true;
		}
		return falg;
	}

	public static String getBooleanDescribe(String iValue) {
		String strReturn = iValue;

		if ((iValue.equals("Y")) || (iValue.equals("y")) || (iValue.equals("1")))
			strReturn = "是";
		else if ((iValue.equals("N")) || (iValue.equals("n")) || (iValue.equals("0")))
			strReturn = "否";

		return strReturn;
	}

	public static String strValue(Object value, int fraction) {
		if (value == null) {
			return Integer.toString(0);
		}
		if (Number.class.isInstance(value)) {
			if (fraction >= 0) {
				BigDecimal bigDecimal = new BigDecimal(String.valueOf(value));
				return bigDecimal.setScale(fraction, BigDecimal.ROUND_HALF_UP).toPlainString();
			} else {
				return String.valueOf(value);
			}
		} else if (BigDecimal.class.isInstance(value)) {
			return ((BigDecimal) value).toPlainString();
		} else if (Date.class.isInstance(value)) {
			return new SimpleDateFormat("yyyy-MM-dd").format((Date) value);
		}
		return value.toString();
	}
	public static String strZero(Object value) {
		return strValue(value, -1);
	}

	public static String scaleValue(Number value, long scale, int fraction) {
		if (value == null) {
			return Integer.toString(0);
		}
		return strValue(value.doubleValue() * scale, fraction);
	}

	public static <T> T scale(Number value, long scale, int fraction) {
		if (value == null) {
			return null;
		}
		return (T) castTo(strValue(value.doubleValue() * scale, fraction), value.getClass());
	}

	public static String strValue(Object value, String format) {
		if (value == null) {
			return "";
		}
		if (Date.class.isInstance(value)) {
			return new SimpleDateFormat(format).format((Date) value);
		}
		return strValue(value, 0);
	}

	/**
	 * 将CheckedException转换为RuntimeException.
	 */
	public static RuntimeException unchecked(Exception e) {
		e.printStackTrace();
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}

	/**
	 * 将CheckedException转换为RuntimeException.
	 */
	public static RuntimeException unchecked(String message, Exception e) {
		return new RuntimeException(message, e);
	}

	/**
	 * 判断一个对象是否是空对象
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (obj instanceof CharSequence) {
			return obj.toString().trim().length() == 0;
		}
		if (obj.getClass().equals(Object.class)) {
			return true;
		}
		if (isBaseType(obj.getClass())) {
			return false;
		}
		if (obj instanceof Map) {
			return ((Map) obj).isEmpty();
		}
		if (obj instanceof Collection) {
			return ((Collection) obj).isEmpty();
		}
		if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}
		try {
			return Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors().length == 1;
		} catch (IntrospectionException e) {
			throw unchecked(e);
		}
	}
	
	/**
	 * 判断double类型值是否为空为0
	 * @param value
	 * @return
	 */
	public static boolean isEmptyOrZero(Double value) {
		if(value==null || value==0){
			return true;
		}
		return false;
	}

	/**
	 * 判断一个类型是否是基本类型
	 * 
	 * @param type
	 * @return
	 */
	public static boolean isBaseType(Class<?> type) {
		if (type.isPrimitive()) {
			return true;
		}
		if (CharSequence.class.isAssignableFrom(type)) {
			return true;
		}
		if (Number.class.isAssignableFrom(type)) {
			return true;
		}
		if (Date.class.isAssignableFrom(type)) {
			return true;
		}
		if (Boolean.class.equals(type)) {
			return true;
		}
		if (Character.class.equals(type)) {
			return true;
		}
		if (Class.class.equals(type)) {
			return true;
		}
		if (StringBuilder.class.equals(type)) {
			return true;
		}
		if (StringBuffer.class.equals(type)) {
			return true;
		}
		if (Object.class.equals(type)) {
			return true;
		}
		if (Void.class.equals(type)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否是数字类型
	 * 
	 * @param type
	 * @return
	 */
	public static boolean isNumber(Class<?> type) {
		if (Number.class.isAssignableFrom(type)) {
			return true;
		}
		if (type.equals(int.class)) {
			return true;
		}
		if (type.equals(short.class)) {
			return true;
		}
		if (type.equals(long.class)) {
			return true;
		}
		if (type.equals(float.class)) {
			return true;
		}
		if (type.equals(double.class)) {
			return true;
		}
		if (type.equals(byte.class)) {
			return true;
		}
		return false;
	}

	/**
	 * 获得本源异常信息
	 * 
	 * @param e
	 * @return
	 */
	public static Throwable getCause(Throwable e) {
		return e.getCause() == null ? e : getCause(e.getCause());
	}

	/**
	 * 输出对象字符串格式
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		return toString(obj, null);
	}

	/**
	 * 输出对象字符串格式
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj, String format) {
		if (obj == null) {
			return "";
		}
		if (obj instanceof Throwable) {
			Throwable throwable = (Throwable) obj;
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			throwable.printStackTrace(pw);
			pw.flush();
			pw.close();
			sw.flush();
			return sw.toString();
		}
		if (obj instanceof Date) {
			return new SimpleDateFormat(format == null || format.trim().length() == 0 ? "yyyy-MM-dd HH:mm:ss" : format)
					.format((Date) obj);
		}
		if (isNumber(obj.getClass())) {
			if (format != null && format.trim().length() != 0) {
				return new DecimalFormat(format).format(obj);
			}
		}
		return String.valueOf(obj);
	}

	/**
	 * 将一个对象转换为指定类型
	 * 
	 * @param value
	 * @param type
	 * @return
	 */
	public static <T> T castTo(Object value, Class<T> type) {
		return castTo(value, type, null);
	}

	/**
	 * 将一个对象转换为指定类型
	 * 
	 * @param value
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T castTo(Object value, Class<T> type, String format) {
		if (value == null) {
			return null;
		}
		try {
			if (type.equals(value.getClass()) || type.isAssignableFrom(value.getClass())) {
				return (T) value;
			}
			if (type.equals(value.getClass()) || type.isAssignableFrom(value.getClass())) {
				return (T) value;
			}

			if (CharSequence.class.isAssignableFrom(type)) {
				return (T) toString(value, format);
			}

			if (isNumber(type) && !isNumber(value.getClass())) {
				if (format != null && format.trim().length() != 0) {
					value = new DecimalFormat(format).parse(String.valueOf(value));
				}
			}

			if (Number.class.isAssignableFrom(type)) {
				if (String.valueOf(value).trim().isEmpty() || "NaN".equals(value)) {
					value = String.valueOf(0);
				}
				if (type.equals(Integer.class)) {
					return (T) Integer.valueOf(new BigDecimal(String.valueOf(value)).intValue());
				}
				if (type.equals(Short.class)) {
					return (T) Short.valueOf(new BigDecimal(String.valueOf(value)).shortValue());
				}
				if (type.equals(Long.class)) {
					return (T) Long.valueOf(new BigDecimal(String.valueOf(value)).longValue());
				}
				if (type.equals(Float.class)) {
					return (T) Float.valueOf(new BigDecimal(String.valueOf(value)).floatValue());
				}
				if (type.equals(Double.class)) {
					return (T) Double.valueOf(new BigDecimal(String.valueOf(value)).doubleValue());
				}
				if (type.equals(Byte.class)) {
					return (T) Byte.valueOf(new BigDecimal(String.valueOf(value)).byteValue());
				}
				if (type.equals(BigDecimal.class)) {
					return (T) new BigDecimal(String.valueOf(value));
				}
				if (type.equals(BigInteger.class)) {
					return (T) BigInteger.valueOf(new BigDecimal(String.valueOf(value)).longValue());
				}
			}

			if (type.isPrimitive()) {
				if (type.equals(int.class)) {
					return (T) Integer.valueOf(new BigDecimal(String.valueOf(value)).intValue());
				}
				if (type.equals(short.class)) {
					return (T) Short.valueOf(new BigDecimal(String.valueOf(value)).shortValue());
				}
				if (type.equals(long.class)) {
					return (T) Long.valueOf(new BigDecimal(String.valueOf(value)).longValue());
				}
				if (type.equals(float.class)) {
					return (T) Float.valueOf(new BigDecimal(String.valueOf(value)).floatValue());
				}
				if (type.equals(double.class)) {
					return (T) Double.valueOf(new BigDecimal(String.valueOf(value)).doubleValue());
				}
				if (type.equals(byte.class)) {
					return (T) Byte.valueOf(new BigDecimal(String.valueOf(value)).byteValue());
				}

				if (type.equals(boolean.class)) {
					return (T) Boolean.valueOf(String.valueOf(value));
				}

				if (type.equals(char.class)) {
					String s = String.valueOf(value).trim();
					if (s.length() == 0) {
						return (T) Character.valueOf((char) 0);
					}
					return (T) Character.valueOf(s.charAt(0));
				}
			}

			if (type.equals(Boolean.class)) {
				return (T) Boolean.valueOf(String.valueOf(value));
			}

			if (type.equals(Character.class)) {
				String s = String.valueOf(value);
				if (s.length() == 0) {
					return (T) Character.valueOf((char) 0);
				}
				return (T) Character.valueOf(s.charAt(0));
			}

			if (Date.class.isAssignableFrom(type)) {
				if (value instanceof Date) {
					return type.getConstructor(long.class).newInstance(((Date) value).getTime());
				}

				if (isNumber(value.getClass())) {
					return type.getConstructor(long.class)
							.newInstance(new BigDecimal(String.valueOf(value)).longValue());
				}
				value = String.valueOf(value).replaceAll("[^0-9]+", "");
				return (T) DateKit.parse((String) value);
			}

			Constructor<T> constructor = type.getConstructor(value.getClass());
			return constructor.newInstance(value);
		} catch (Exception e) {
			e.printStackTrace();
			throw unchecked(String.format("将对象:%s转换为类型:%s是发生异常", value, type), e);
		}

	}

	/**
	 * 新建一个Set
	 * 
	 * @param args
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Set<T> newSet(T... args) {
		Set<T> set = new LinkedHashSet<T>();
		for (int i = 0; i < args.length; i++) {
			set.add(args[i]);
		}
		return set;
	}

	/**
	 * 新建一个List
	 * 
	 * @param args
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> newList(T... args) {
		List<T> list = new LinkedList<T>();
		for (int i = 0; i < args.length; i++) {
			list.add(args[i]);
		}
		return list;
	}

	/**
	 * 比较两个对象是否相同，对于数字、日期等按照大小进行比较，自动兼容包装器实例
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean equals(Object a, Object b) {
		if (a == b) {
			return true;
		}
		if (a == null || b == null) {
			return false;
		}
		// 比较数字
		if (isNumber(a.getClass()) && isNumber(b.getClass())) {
			return new BigDecimal(a.toString()).compareTo(new BigDecimal(b.toString())) == 0;
		}
		// 比较字符
		if ((a.getClass().equals(Character.class) || a.getClass().equals(Character.TYPE))
				&& (b.getClass().equals(Character.class) || b.getClass().equals(Character.TYPE))) {
			return ((Character) a).equals((Character) b);
		}
		// 比较真假值
		if ((a.getClass().equals(Boolean.class) || a.getClass().equals(Boolean.TYPE))
				&& (b.getClass().equals(Boolean.class) || b.getClass().equals(Boolean.TYPE))) {
			return ((Boolean) a).equals((Boolean) b);
		}
		// 比较日期
		if (a instanceof Date && b instanceof Date) {
			return ((Date) a).compareTo((Date) b) == 0;
		}
		return a.equals(b);
	}

	/**
	 * 类型转换 空值转为零
	 * 
	 * @param number
	 * @return
	 */
	public static <T> T castWithEmpty(Object number, Class<T> t) {
		if (number == null) {
			if (t.equals(Integer.class)) {
				return (T) Integer.valueOf(0);
			}
			if (t.equals(Short.class)) {
				return (T) Short.valueOf("0");
			}
			if (t.equals(Long.class)) {
				return (T) Long.valueOf("0");
			}
			if (t.equals(Float.class)) {
				return (T) Float.valueOf("0");
			}
			if (t.equals(Double.class)) {
				return (T) Double.valueOf("0");
			}
			if (t.equals(Byte.class)) {
				return (T) Double.valueOf("0");
			}
			if (t.equals(BigDecimal.class)) {
				return (T) new BigDecimal("0");
			}
			if (t.equals(BigInteger.class)) {
				return (T) new BigInteger("0");
			}
		} else if (number.getClass().equals(t)) {
			return (T) number;
		}
		return castTo(number, t);
	}

	public static String prettyNumber(Object t) {
		if (t == null || t.toString().isEmpty()) {
			return Integer.toString(0);
		}
		DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
		if (Number.class.isInstance(t)) {
			return decimalFormat.format(t);
		} else if (BigDecimal.class.isInstance(t)) {
			return ((BigDecimal) t).toPlainString();
		}
		return String.valueOf(t);
	}
	/**
	 * 数字格式化：小数不够位数补充0填充（注意，此方法四舍五入有BUG，HALF_UP不能达到预期效果:如3.15 --> 3.1）
	 * @param value       值
	 * @param pointCount  小数点后的位数
	 * @param isNullToZero  空是否转换成0
	 * @return
	 */
	public static String prettyNumber_Format(Double value,int pointCount,boolean isNullToZero) {
		if (value == null || value.toString().isEmpty()) {
			if(isNullToZero){
				return "0";
			}
			return "";
		}
		if(value.doubleValue() == 0){
			return "0";
		}
		String format = "0";
		if(pointCount > 0){
			format += ".";
			for(int i = 1 ; i <= pointCount; i++){
				format += "0";
			}
		}
		DecimalFormat decimalFormat = new DecimalFormat(format);
		decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
		
		return  decimalFormat.format(value);
	}
	/**
	 * 数字格式化：小数不够位数补充0填充（注意，此方法四舍五入有BUG，HALF_UP不能达到预期效果:如3.15 --> 3.1）
	 * @param value       值
	 * @param pointCount  小数点后的位数
	 * @param isNullToZero 空是否转换成0
	 * @return
	 */
	public static String prettyNumber_Format(String value,int pointCount,boolean isNullToZero) {
		if (value == null || value.toString().isEmpty()) {
			if(isNullToZero){
				return "0";
			}
			return "";
		}
		return prettyNumber_Format(Double.parseDouble(value),pointCount,isNullToZero);
	}
	/**
	 * 四舍五入，保留指定小数位
	 * 
	 * @param value
	 * @param num
	 * @return
	 */
	public static Double roundDouble(Double value, int num) {
		if(value == null){
			return null;
		}
		BigDecimal bigDecimal = new BigDecimal(value);
		Double floatValue = bigDecimal.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
		return floatValue;
	}

	/**
	 * 四舍五入，保留指定小数位
	 * 
	 * @param value
	 * @param num
	 * @return
	 */
	public static void getFloatValues(double[] arrDeductAmount, int num) {
		for (int i = 0; i < arrDeductAmount.length; i++) {
			BigDecimal bigDecimal = new BigDecimal(arrDeductAmount[i]);
			arrDeductAmount[i] = bigDecimal.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
		}
	}

	/**
	 * 计算两值相差的百分比
	 * 
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static Double getFloatValueCommon(Double value1, Double value2) {
		Double floatValue = 0.00;

		// 进行两次四舍五入
		value1 = roundDouble(value1, 3);
		value1 = roundDouble(value1, 2);

		value2 = roundDouble(value2, 3);
		value2 = roundDouble(value2, 2);

		floatValue = (1 - (value2 / value1)) * 100;
		floatValue = roundDouble(floatValue, 2);

		return floatValue;

	}

	public static String setMoney(String value) {
		if(value==null){
			value = "0";
		}
		DecimalFormat format = new DecimalFormat("0.00");
		return format.format(Double.parseDouble(value));
	}

	public static String setMoney(Double value) {
		if(value==null){
			value = 0d;
		}
		DecimalFormat format = new DecimalFormat("0.00");
		return format.format(value);
	}
	
	public static String setInt(Double value) {
		if(value==null){
			value = 0d;
		}
		DecimalFormat format = new DecimalFormat("0");
		return format.format(value);
	}

	public static double getDefault(Double value, int num, double defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		return roundDouble(value, num);
	}

	public static void main(String[] args) {
		Double a = 1.8;
		System.out.println(ChgDataKit.strValue(a,2));
	}
	
	public  static String encodeIdentifyType(String identifyType) throws Exception{
		if(identifyType == null || "".equals(identifyType.trim())){
			return "";
		}
		if("01".equals(identifyType)){
			return "01";
		}else if("07".equals(identifyType) || "51".equals(identifyType)){
			return "02";
		}else if("04".equals(identifyType)){
			return "03";
		}else {
			return "04";
		}
	}
	
	
	public  static String encodeDateFormat(Date date,Double hour) throws Exception{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		StringBuffer	stringBuffer = new StringBuffer(" 00:00:00");
		String hourStr = "0";
		if(hour!=null){
			hourStr = hour.intValue()+"";
		}
	    if(hourStr.length() <= 2){
		  return dateString + stringBuffer.replace(3-hourStr.length(), 3,hourStr).toString();
    	}
		return "";
	}

}
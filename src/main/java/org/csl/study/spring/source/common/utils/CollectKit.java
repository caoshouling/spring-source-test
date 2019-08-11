package org.csl.study.spring.source.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class CollectKit {
	
	/**
	 * 判断是否包含
	 * 
	 * @param eval
	 * @param values
	 * @return
	 */
	public static boolean in(String eval, String... values) {
		for (String value : values) {
			if (value.equalsIgnoreCase(eval)) {
				return true;
			}
			if (value.endsWith("*")) {
				PathMatcher matcher = new AntPathMatcher();
				if (matcher.match(value,eval)) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Map的value 转成List
	 * @param map
	 * @return
	 */
	public static <K,V> List<V>  mapValuesToList(Map<K,V> map){
		List<V> valueList = new ArrayList<V>(map.values());
		return valueList;
	}
	/**
	 * Map的key 转成List
	 * @param map
	 * @return
	 */
	public static <K,V> List<K>  mapKeysToList(Map<K,V> map){
		List<K> valueList = new ArrayList<K>(map.keySet());
		return valueList;
	}
	public static String join(String...values){
		StringBuffer stringBuff=new StringBuffer();
		for(String value:values){
			stringBuff.append(value);
		}
		return stringBuff.toString();
	}
	
	public static boolean containEmpty(Collection collection){
		return collection.contains(null)||collection.contains("");
	}
	
	public static <T> boolean addAll(Collection<T> collection,Collection<T> elementCollection){
		if(collection != null && elementCollection != null && elementCollection.size() > 0){
			return collection.addAll(elementCollection);
		}
		return false;
	}


}

package com.uk.sec.framework.util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.uk.sec.privilege.framework.privilege.model.SecBasDicItem;

/**
 * 工具类
 * @author 景艳磊
 * @date 2015-1-19
 */
public class MyUtils {

	/**
	 * 验证字段是否为空 空true 非空 false
	 * @param str
	 * @return boolean
	 * @author 景艳磊
	 * @date 2015-1-19
	 */
	public static boolean isEmpty(String str) {
		boolean b = false;
		if (str == null || str.equals("")) {
			b = true;
		}
		return b;
	}

	  /**
     * list 转 map
     * @author 景艳磊
     * @date 2015-1-22
     * @param list
     * @return Map<String, SecBasDicItem>
     */
    public static Map<String, SecBasDicItem> listToMap(List<SecBasDicItem> list) {
    	Map<String, SecBasDicItem> map = new LinkedHashMap<String, SecBasDicItem>();
    	if (list.size() > 0) {
    		for (SecBasDicItem items : list) {
//    			System.out.println(items.getItemId()+"="+items.getItemName()+"=================");
    			map.put(items.getItemId()+"", items);
    		}
    	}
    	return map;
    }

    /**
     * 数组转字符串
     * @param array
     * @return
     * @author 景艳磊
     * @date 2015-1-31
     */
    public static String arrayToString(String[] array) {
    	String str = null;
    	if (array.length > 0) {
    		str = Arrays.toString(array);
    		str = str.replace("[", "").replace("]", "");
    	}
    	return str;
    }

    /**
     * 字符串转数组
     * @return
     * @author 景艳磊
     * @date 2015-1-31
     */
    public static String[] stringToArray(String str) {
    	String [] stringArr = str.split(","); 
    	return stringArr;
    }
    
    /**
     * 处理分页参数数组问题
     * @param array
     * @return String[]
     * @author 景艳磊
     * @date 2015-1-31
     */
    public static String[] checkArrays(String[] array) {
//    	System.out.println(array.length);
    	if (array != null && array.length == 1) {
    		return array[0].split(","); 
    	} else {
    		return array;
    	}
    }

    /**
     * 检查数组中是否包含某个值
     * @author 景艳磊
     * @date 2015-2-2
     * @param data
     * @param val
     * @return boolean
     */
    public static boolean checkString(String[] data, String val) {
    	boolean b = false;
    	if (data != null && data.length > 0) {
    		for(String str : data) {
    			if (str.equals(val)) {
    				b = true;
    				break;
    			}
    		}
    	}
    	return b;
    }
    
    public static Integer floatToInt(float money) {
    	return (int)money;
    }

    public static String fen(String str, Integer type) {
    	String string = "";
    	if (type == 1) {
			string = str.substring(33, -1);
		} else {
			string = str.substring(0, 32);
		}
    	return string;
    }
    
    public static String ttt(String str, Integer start, Integer end) {
    	if (end == -1) {
    		return str.substring(start);
    	} else {
    		return str.substring(start, end);
    	}
    	
    }
}

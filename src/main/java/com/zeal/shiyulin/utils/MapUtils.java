package com.zeal.shiyulin.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by  zeal on 2016/1/27.
 */
public class MapUtils {
    public static String FilterMapValue(Map map,String key){
        if(map==null) {
            return "";
        } else{
            if(map.containsKey(key)){
                if(map.get(key)==null){
                    return "";
                }
                else{
                    return String.valueOf(map.get(key));
                }
            }
            return "";
        }
    }

    /**
    * @auther Zeal
    * @description 按键排序(sort by key)
    * @date 2017/9/10 11:32
    */
    public Map<String, String> sortMapByKey(Map<String, String> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, String> sortedMap = new TreeMap<String, String>(new Comparator<String>() {
            @Override
            public int compare(String key1, String key2) {
                int intKey1 = 0, intKey2 = 0;
                try {
                    intKey1 = getInt(key1);
                    intKey2 = getInt(key2);
                } catch (Exception e) {
                    intKey1 = 0;
                    intKey2 = 0;
                }
                return intKey1 - intKey2;
            }});
        sortedMap.putAll(oriMap);
        return sortedMap;
    }

    private int getInt(String str) {
        int i = 0;
        try {
            Pattern p = Pattern.compile("^\\d+");
            Matcher m = p.matcher(str);
            if (m.find()) {
                i = Integer.valueOf(m.group());
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
    * @auther Zeal
    * @description 按值排序(sort by value)
    * @date 2017/9/10 11:39
    */
    public Map<String, String> sortMapByValue(Map<String, String> oriMap) {
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        if (oriMap != null && !oriMap.isEmpty()) {
            List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(oriMap.entrySet());
            Collections.sort(entryList,
                    new Comparator<Map.Entry<String, String>>() {
                        @Override
                        public int compare(Map.Entry<String, String> entry1,
                                           Map.Entry<String, String> entry2) {
                            int value1 = 0, value2 = 0;
                            try {
                                value1 = getInt(entry1.getValue());
                                value2 = getInt(entry2.getValue());
                            } catch (NumberFormatException e) {
                                value1 = 0;
                                value2 = 0;
                            }
                            return value2 - value1;
                        }
                    });
            Iterator<Map.Entry<String, String>> iter = entryList.iterator();
            Map.Entry<String, String> tmpEntry = null;
            while (iter.hasNext()) {
                tmpEntry = iter.next();
                sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
            }
        }
        return sortedMap;
    }
}

package com.lm.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: limeng
 * @Date: 2019/4/23 23:00
 */
public class BaseUtils {

    /**
     * String工具类
     */
    public static class StringUtilsSon extends StringUtils{
        /**
         * 将一个字符串的首字母变成大写
         *
         * @param str
         * @return
         */
        public static String firstLetterUpperCase(String str){
            return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
        }

        /***
         * 根据一个标记转换为驼峰
         * @param str
         * @return
         */
        public static String markToHump(String str, String mark, Integer start){
            String[] strs = str.split(mark);
            String returnStr = "";
            if(start == null){
                start = 0;
            }
            for(int i = 0; i < strs.length; i++){
                returnStr += start == null ? StringUtilsSon.firstLetterUpperCase(strs[i]) : start == i ? strs[i] : StringUtilsSon.firstLetterUpperCase(strs[i]);
            }
            return returnStr;
        }

        /***
         * 将一个标识符在驼峰的字符串中加入进去，并将大写字母转为小写字母
         * @param str 原始数据
         * @param mark 标识
         * @return
         */
        public static String addMarkToString(String str, String mark){
            char[] chs = str.toCharArray();
            int start = 65;
            int end = 90;
            str = "";
            int i = -1;
            for(char ch : chs){
                i++;
                int chInt = (int) ch;
                if(start <= chInt && end >= chInt){
                    if(i != 0){
                        str += (mark + (ch + "").toLowerCase());
                    }else{
                        str += (ch + "").toLowerCase();
                    }
                    continue;
                }
                str += ch;
            }
            return str;
        }


        private static String replaceRange(String source, String oldChar, String newChar, String start, String end, int index){
            int startInt = source.indexOf(start, index);
            int endInt = source.indexOf(end, index);
            if(endInt == -1){
                return source;
            }
            return BaseUtils.StringUtilsSon.replaceRange(
                    source.substring(0, startInt) + source.substring(startInt, endInt).replace(oldChar, newChar) + source.substring(endInt, source.length()),
                    oldChar,
                    newChar,
                    start,
                    end,
                    endInt + 1
            );
        }

        /***
         * 讲一个字符串中两个字符之间的值替换为其他值
         * @param source 数据源
         * @param oldChar 要替换的字符串原来的值
         * @param newChar 要替换的字符串最新的值
         * @param start    范围开始的值
         * @param end 范围结束的值
         * @return
         */
        public static String replaceRange(String source, String oldChar, String newChar, String start, String end){
            return BaseUtils.StringUtilsSon.replaceRange(source, oldChar, newChar, start, end, 0);
        }
    }

    public static class JsonUtils{
        public static Map<String, Object> updateMapKeyToHump(Map<String, Object> map, String mark){
            Map<String, Object> returnMap = new HashMap<String, Object>();
            for(Map.Entry<String, Object> entry : map.entrySet()){
                String keyName = entry.getKey();
                keyName = BaseUtils.StringUtilsSon.markToHump(keyName, mark, 0);
                returnMap.put(keyName, entry.getValue());
            }
            return returnMap;
        }

        /***
         * 将map中的key的名称修改为根据某个标记编辑成驼峰的形式，并通过jsonUtil返回成class对象
         * @param map map集合
         * @param mark 标记
         * @param type 返回值类型
         * @param <T>
         * @return
         */
        public static <T> T jsonToHumpToObject(Map<String, Object> map, String mark, Class<T> type){
            return JsonUtils.jsonObjectToObject(JsonUtils.updateMapKeyToHump(map, mark), type);
        }

        /***
         * 将map中的key的名称修改为根据某个标记编辑成驼峰的形式，并通过jsonUtil返回成class对象
         * @param list list集合
         * @param mark 标记
         * @param type 返回值类型
         * @param <T>
         * @return
         */
        public static <T> List<T> jsonToHumpToList(List<Map<String, Object>> list, String mark, Class<T> type){
            List<T> returnList = new ArrayList<T>();
            for(Map<String, Object> map : list){
                returnList.add(JsonUtils.jsonToHumpToObject(map, mark, type));
            }
            return returnList;
        }


        /***
         * 将一个List转为
         * @param list
         * @param type
         * @param <T>
         * @return
         */
        public static <T> List<T> jsonArrayToList(List<? extends Object> list, Class<T> type){
            return JSONArray.parseArray(JSONArray.toJSONString(list), type);
        }

        public static <T> T jsonObjectToObject(Object object, Class<T> type){
            return JSONObject.parseObject(JSONObject.toJSONString(object), type);
        }


    }
}

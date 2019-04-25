package com.lm.analyze;

import com.lm.util.BaseUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: limeng
 * @Date: 2019/4/23 23:06
 */
public class AnalyzeTest {
    private static final String MARK_SPLIT = "\\|%a%b%c%\\|";
    private static final String UNDERLINE_T = "_";
    /***
     * 将map中的key的名称修改为根据某个标记编辑成驼峰的形式，并通过jsonUtil返回成class对象
     * @param map map
     * @param type type
     * @param <T> 泛型
     * @return return
     */
    private <T> T getResult(Map<String, Object> map, Class<T> type){
        //去除三方插件的字段
        map.remove("logger");
        System.out.println(type.getSimpleName());
        return BaseUtils.JsonUtils.jsonToHumpToObject(map, type.getSimpleName().equals("Map") ? MARK_SPLIT : UNDERLINE_T, type);
    }
    @Test
    public  void init() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id","1111");
        map.put("realname","realname");

        Account result = this.getResult(map, Account.class);
        System.out.println(result);
    }
}

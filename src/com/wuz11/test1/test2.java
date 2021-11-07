package com.wuz11.test1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    private static Pattern linePattern = Pattern.compile("_(\\w)");
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<Map<String,String>> mapList = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("user_name","wuz11");
        map1.put("true_name", "吴正");
        mapList.add(map1);
        Map<String, String> map = new HashMap<>();
        map.put("user_name","lif66");
        map.put("true_name", "李飞");
        mapList.add(map);
        JsonBean jsonBean =JsonBean.success(mapList);
        for(Map mp :mapList){
            Student obj = (Student) maptobean(mp, "com.wuz11.test1.Student");
            System.err.println(obj.getTrueName());
        }
    }

    public static Object maptobean(Map<String,String> map,String className) throws ClassNotFoundException,  IllegalAccessException, InstantiationException, InvocationTargetException {//核心
        Class clazz=Class.forName(className);
        Method[] methods=clazz.getMethods();
        Object obj=clazz.newInstance();
        Set<String> set=map.keySet();
        String keyResult = null;
        for(String var:set){
            keyResult = lineToHump(var);
            for(Method method:methods){
                //判断方法名是否相同
                if(("set"+Character.toUpperCase(keyResult.charAt(0))+keyResult.substring(1)).equals(method.getName())){
                    method.invoke(obj, map.get(var));
                    break;
                }
            }
        }
        return obj;
    }

    /** 下划线转驼峰 */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}

package com.wuz11.test1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将 map 里的 带下划线的key转为 驼峰字段类型的对象
 * @author wuzheng
 */
public class Map2BeanUtil {
    private static Pattern linePattern = Pattern.compile("_(\\w)");
    public static Object maptobean(Map<String,String> map,String className) throws ClassNotFoundException,  IllegalAccessException, InstantiationException, InvocationTargetException {//核心
        Class clazz=Class.forName(className);
        Method[] methods=clazz.getMethods();
        Object obj=clazz.newInstance();
        Set<String> set=map.keySet();
        String keyResult = null;
        for(String var:set){
            // 下划线转驼峰
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

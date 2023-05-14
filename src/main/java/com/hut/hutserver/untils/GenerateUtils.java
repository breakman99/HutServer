package com.hut.hutserver.untils;

import com.hut.hutserver.entity.HutUsersEntity;
import com.hut.hutserver.entity.request.HutUserDTO;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GenerateUtils {
    public static void main(String[] args) {
        classConvertUtils(HutUsersEntity.class, HutUserDTO.class);
    }

    /**
     * 生成两个类Convert方法代码的工具类
     * @param paramType
     * @param targetType
     * @param <T>
     * @param <E>
     */
    public static <T, E> void classConvertUtils(Class<E> paramType, Class<T> targetType) {
        Set<String> paramTypeSet = Arrays.stream(paramType.getDeclaredFields()).map(Field::getName).collect(Collectors.toSet());
        Set<String> targetTypeSet = Arrays.stream(targetType.getDeclaredFields()).map(Field::getName).collect(Collectors.toSet());
        // (DTO && Entity) - Object
        Set<String> intersection = new HashSet<>(paramTypeSet);
        intersection.retainAll(targetTypeSet);
        Set<String> common = new HashSet<>(intersection);
        String res = "";
        res += "public static " + targetType.getSimpleName() + " " + (paramType.getSimpleName().substring(0, 1).toLowerCase() + paramType.getSimpleName().substring(1)) + "2";
        res += targetType.getSimpleName() + "(" + paramType.getSimpleName() + " " + "var1" + ")" + " { \n";
        res += "    " + targetType.getSimpleName() + " var2 = new " + targetType.getSimpleName() + "();\n";
        for (String val : common) {
            String var = val.substring(0, 1).toUpperCase() + val.substring(1);
            res += "    " + "var2.set" + var + "(var1.get" + var + "());\n";
        }
        res += "    return var2;\n}\n";
        System.out.println(res);
    }
}

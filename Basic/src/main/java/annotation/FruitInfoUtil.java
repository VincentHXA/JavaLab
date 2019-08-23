package annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz) {
        String strFruitProvider = "供应商信息";

        Field[] fields = clazz.getDeclaredFields();

        for(Field field: fields) {
            if(field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = (FruitProvider)field.getAnnotation(FruitProvider.class);
                strFruitProvider = "供应商: " + fruitProvider.id() + " 供应商名称: " + fruitProvider.name() + " 地址: " + fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }
    }
}

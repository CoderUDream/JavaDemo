package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by jagger on 2018/8/12.
 */

//@NickNames({@NickName(value = "good", time = 0), @NickName("rich"), @NickName("kind")})

//上面一行等价于下面的三行

@NickName("good")
@NickName("rich")
@NickName("kind")
class PersonA {

    public PersonA(){}
}

@NickName("pool")
class PersonB {

    @NickName("100")
    public int i;

    public PersonB(){}

    @NickName("hello")
    void print(String s) {
        System.out.println("personB say:" + s);
    }
}

public class TestAnnotation {

    public static void testAnnotation() throws Exception {

        Class clazz;
        clazz = Class.forName("annotation.PersonB");

        //获取所有注释
        Annotation[] annotations = clazz.getAnnotations(); //获取所有的注解
        for (Annotation a : annotations) {
            if(a.annotationType() == NickName.class) { //获取到了NickName的注解

                //System.out.println(a.toString());
                NickName o = (NickName)a;
                System.out.println("NickName value:" + o.value() + ", time is:" + o.time());
                System.out.println(a.toString());
            } else if(a.annotationType() == NickNames.class) {  //获取到了NickNames的注解

                NickNames o = (NickNames)a;
                NickName[] nicknames = o.value();

                for(NickName name : nicknames) {
                    System.out.println("NickName value:" + name.value() + ", time is:" + name.time());
                    System.out.println(name.toString());
                }
                System.out.println(a.toString());
            }
        }


        //实例化对象
        Object obj;
        obj = clazz.getConstructor().newInstance();
        PersonB personB = (PersonB)obj;


        //获取属性的注释
        Field field = clazz.getDeclaredField("i");
        field.setAccessible(true);
        if(field.isAnnotationPresent(NickName.class)) {
            NickName a = field.getDeclaredAnnotation(NickName.class);
            personB.i = Integer.valueOf(a.value());
            System.out.println(personB.i);
        }

        //获取函数的注释
        Method method = clazz.getDeclaredMethod("print", String.class);
        method.setAccessible(true);
        if(method.isAnnotationPresent(NickName.class)) {
            NickName a = method.getDeclaredAnnotation(NickName.class);
            method.invoke(personB, a.value());
        }

    }
}

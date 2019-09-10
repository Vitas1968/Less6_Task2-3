package Lesson7_Ref_Ann;

import java.lang.reflect.Method;

public class ClassForTest
{
    public static void main(String[] args)
    {
//        Method[] methods = ClassForTest.class.getDeclaredMethods();
//
//        for (Method met:methods)
//        {
//            System.out.println(met);
//        }
        System.out.println(add(10,5));
        System.out.println(sub(10,5));
        System.out.println(mult(10,5));
        System.out.println(div(10,5));

    }

    static int add(int a,int b)
    {
        return a+b;
    }
    static int sub(int a,int b)
    {
        return a-b;
    }
    static int mult(int a,int b)
    {
        return a*b;
    }

    static int div(int a,int b) throws ArithmeticException
    { if (b!=0) return a/b;
    else throw new ArithmeticException("Деление на ноль");
    }
}

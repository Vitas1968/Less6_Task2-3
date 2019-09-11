package Lesson7_Ref_Ann;

import Lesson7_Ref_Ann.Annotations.AfterSuite;
import Lesson7_Ref_Ann.Annotations.BeforeSuite;
import Lesson7_Ref_Ann.Annotations.Test;
import Lesson7_Ref_Ann.TestClasses.ClassForTest;
import Lesson7_Ref_Ann.TestClasses.TestAnnotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
public class RunTests
{
    public static void main(String[] args)
    {
        try
        {
            start(ClassForTest.class);
            System.out.println("---------------------------------------------------------");
            start(TestAnnotation.class.getCanonicalName());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    static void start(Class clazz) throws Exception
    {
        int countBeforeSuite=0;
        int countAfterSuite=0;
        Object object=clazz.newInstance();

        ArrayList<Method> listMethods =
                new ArrayList <>(Arrays.asList(clazz.getDeclaredMethods()));
        ArrayList<Method> listMethodsTest = new ArrayList <>();
        ArrayList<Method> listMethodsBeforeSuite = new ArrayList <>();
        ArrayList<Method> listMethodsAfterSuite = new ArrayList <>();
        for (Method method:listMethods)
        {
            if (method.isAnnotationPresent(Test.class)) listMethodsTest.add(method);
            if (method.isAnnotationPresent(BeforeSuite.class))
            {
                if (countBeforeSuite<1)
                {listMethodsBeforeSuite.add(method);
                   // System.out.println(listMethodsBeforeSuite.get(0));
                    countBeforeSuite++;
                } else throw new RuntimeException("Второй тест-метод с аннотацией BeforeSuite!");
            }
            if (method.isAnnotationPresent(AfterSuite.class))
            {
                if (countAfterSuite<1)
                {listMethodsAfterSuite.add(method);
                    //System.out.println(listMethodsAfterSuite.get(0));
                    countAfterSuite++;
                } else throw new RuntimeException("Второй тест-метод с аннотацией AfterSuite!");
            }
        }

        listMethodsTest.sort(Collections.reverseOrder((a, b) ->
        {
            Test testA = a.getAnnotation(Test.class);
            Test testB = b.getAnnotation(Test.class);
            return Integer.compare(testA.priority(), testB.priority());
        }));

        listMethods.clear();
        listMethods.addAll(listMethodsBeforeSuite);
        listMethods.addAll(listMethodsTest);
        listMethods.addAll(listMethodsAfterSuite);

        for (Method method:listMethods)
        { method.invoke(object); }
    }



    static void start(String clazzName) throws  Exception
    {
        try
        {
            Class clazz=Class.forName(clazzName);
            start(clazz);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}

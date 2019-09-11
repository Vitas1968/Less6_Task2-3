package Lesson7_Ref_Ann.TestClasses;

import Lesson7_Ref_Ann.Annotations.AfterSuite;
import Lesson7_Ref_Ann.Annotations.BeforeSuite;
import Lesson7_Ref_Ann.Annotations.Test;

import java.lang.reflect.Method;

public class ClassForTest
{
    @BeforeSuite
    public void startTest()
    {
        System.out.println("Выполнится первым");
    }
    @Test
    public void testMethod1()
    {
        System.out.println("Выполняется testMethod1 в ClassForTest. Приоритет по умолчанию 5");
    }
    @Test(priority = 2)
    public void testMethod2()
    {
        System.out.println("Выполняется testMethod2 в ClassForTest. Приоритет 2");
    }

    @Test(priority = 8)
    public void testMethod3()
    {
        System.out.println("Выполняется testMethod3 в ClassForTest. Приоритет 8");
    }
    @AfterSuite
    public void endTest()
    {
        System.out.println("Выполнится последним");
    }

//    @AfterSuite
//    public void endTest1()
//    {
//        System.out.println("Не выполнится совсем");
//    }

}

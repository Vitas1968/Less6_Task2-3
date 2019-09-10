package Lesson7_Ref_Ann.TestClasses;

import Lesson7_Ref_Ann.Annotations.AfterSuite;
import Lesson7_Ref_Ann.Annotations.Test;

import java.lang.reflect.Method;

public class ClassForTest
{
    @AfterSuite
    public void startTest()
    {
        System.out.println("Выполнится первым");
    }
    @Test
    public void testMethod1()
    {
        System.out.println("Выполняется testMethod1 в ClassForTest");
    }
    @Test(priority = 8)
    public void testMethod2()
    {
        System.out.println("Выполняется testMethod2 в ClassForTest");
    }

    @Test(priority = 2)
    public void testMethod3()
    {
        System.out.println("Выполняется testMethod3 в ClassForTest");
    }
    @AfterSuite
    public void endTest()
    {
        System.out.println("Выполнится последним");
    }

    @AfterSuite
    public void endTest1()
    {
        System.out.println("Не выполнится совсем");
    }

}

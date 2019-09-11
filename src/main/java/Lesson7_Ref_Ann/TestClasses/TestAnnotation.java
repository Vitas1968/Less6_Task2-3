package Lesson7_Ref_Ann.TestClasses;

import Lesson7_Ref_Ann.Annotations.AfterSuite;
import Lesson7_Ref_Ann.Annotations.Test;

public class TestAnnotation
{

    @AfterSuite
    public void startTest()
    {
        System.out.println("Выполнится первым в классе TestAnnotation");
    }
    @Test
    public void testMethod1()
    {
        System.out.println("Выполняется testMethod1 в TestAnnotation");
    }
    @Test(priority = 8)
    public void testMethod2()
    {
        System.out.println("Выполняется testMethod2 в TestAnnotation");
    }

    @Test(priority = 2)
    public void testMethod3()
    {
        System.out.println("Выполняется testMethod3 в TestAnnotation");
    }
    @AfterSuite
    public void endTest()
    {
        System.out.println("Выполнится последним в классе TestAnnotation");
    }

    @AfterSuite
    public void endTest1()
    {
        System.out.println("Не выполнится совсем");
    }
}

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

//@RunWith(Parameterized.class)
public class ConversArrayTest
{
    @Parameterized.Parameter
Integer[] arr25 = {  2 ,2, 1,3,7,9,4,57,21,44};

    @org.junit.Before
    public void setUp() throws Exception
    {
    }

    @org.junit.After
    public void tearDown() throws Exception
    {
    }

    @org.junit.Test
    public void conversToArray()
    {
        ConversArray conversArray=new ConversArray();
         int [] arr=conversArray.conversToArray(arr25);
        int [] arrTest={57,21,44};
        assertArrayEquals(arrTest,arr);

    }

//    @org.junit.Test
//    public void conversToArray1()
//    {
//        ConversArray conversArray=new ConversArray();
//        int [] arr=conversArray.conversToArray(conversArray.arr1);
//        int [] arrTest={55,25,45};
//        assertArrayEquals(arrTest,arr);
//
//    }
    @org.junit.Test
    public void conversToArray2()
    {
        ConversArray conversArray=new ConversArray();
        int [] arr=conversArray.conversToArray(conversArray.arr2);
        int [] arrTest={65,35,75};
        assertArrayEquals(arrTest,arr);

    }

    @org.junit.Test
    public void checked()
    {
        ConversArray conversArray=new ConversArray();
        assertTrue(conversArray.checked(conversArray.arr));

    }

    @org.junit.Test
    public void checked1()
    {
        ConversArray conversArray=new ConversArray();
        assertFalse(conversArray.checked(conversArray.arr1));

    }
}
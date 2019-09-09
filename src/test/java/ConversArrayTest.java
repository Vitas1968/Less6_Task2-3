import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ConversArrayTest
{
    private Integer [] inData;
    private int [] outData;

    private static ConversArray conversArray;
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new Integer[]{2 ,2,1,3,7,9,4,56,21,44},new int[]{56,21,44}}, // одна четверка
                {new Integer[]{2 ,2,4, 1,3,4,7,9,4,65,35,75},new int[]{65,35,75}},// две четверки
        });
    }

    public ConversArrayTest(Integer [] input, int [] output)
    {
        inData=input;
        outData=output;
    }

    static Integer[] arrTest1 = {  2 ,2,3,7,9,55,25,45}; // нет ни одной четвеки

    static Integer [] arrCheck = {1,1,4,1,1,4,1};
    static Integer [] arrCheck1 ={1,1,1,1,1,1,1};

    @BeforeClass
    public static void initConversArray() throws Exception
    {
        conversArray=new ConversArray();
    }
//    @Before
//    public void setUp() throws Exception
//    {
//        conversArray=new ConversArray();
//    }

    @After
    public void tearDown() throws Exception
    {
        System.out.println("Тестирование завершено");
    }

    @Test
    public void conversToArrayParam()
    {
        assertArrayEquals(outData,conversArray.conversToArray(inData));

    }

    // ожидаем исключение если во входном массиве нет ни одной четверки
    @Test(expected=RuntimeException.class)
    public void conversToArray1()
    {
        int [] arr=conversArray.conversToArray(arrTest1);
        int [] arrTest={55,25,45};
        assertArrayEquals(arrTest,arr);
    }

    // ожидаем true
    @Test
    public void checked()
    {
        assertTrue(conversArray.checked(arrCheck));
    }

    // ожидаем false
    @Test
    public void checked1()
    {
        assertFalse(conversArray.checked(arrCheck1));
    }
}
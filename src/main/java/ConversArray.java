import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConversArray
{
    Integer [] arr = {2,2,1,3,7,9,4,56,21,44}; // есть один и две четверки
    Integer [] arrCheck = {1,1,4,1,1,4,1};



    public static void main(String[] args)
    {



        ConversArray conversArray=new ConversArray();
        int [] arr1=conversArray.conversToArray(conversArray.arr);

        for (int i = 0; i < arr1.length; i++)
        {
            System.out.print(arr1[i]+" ");
        }
        System.out.println();

        System.out.println(conversArray.checked(conversArray.arrCheck));
    }

    public int[] conversToArray(Integer[] arr)
    {
        ArrayList<Integer> list =new ArrayList( Arrays.asList(arr));
        if (list.contains(4))
        {
            int idx = list.lastIndexOf(4);
            List<Integer> lst=list.subList((idx+1),list.size());
            int tmp = (list.size()-1)-idx;
            int[] array = new int[tmp];
            for(int i = 0; i < lst.size(); i++) array[i] = lst.get(i);
            return array;
        }
        else  throw new RuntimeException("Not four");
    }
   public boolean checked(Integer[] arr)
    {
        ArrayList<Integer> list =new ArrayList( Arrays.asList(arr));
        if (list.contains(4) && list.contains(1) ) return  true;
        return false;
    }
}

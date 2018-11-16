import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args)
    {
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        System.out.println("intArrayList长度： "+intArrayList.size());
        intArrayList.add(5);
        intArrayList.add(9);
        intArrayList.add(2);
        System.out.println("intArrayList: "+intArrayList.toString());
        intArrayList.set(0,9);
        System.out.println("调用set(0,9)后, intArrayList: "+intArrayList.toString());
        System.out.println("调用get(0): "+intArrayList.get(0));
        intArrayList.add(1);
        System.out.println("调用add(1)后, intArrayList: "+intArrayList.toString());
        intArrayList.add(0,5);
        System.out.println("调用add(0,5)后, intArrayList: "+intArrayList.toString());
        System.out.println("调用indexOf(2): "+intArrayList.indexOf(2));
        System.out.println("intArrayList是否包含2: "+ intArrayList.contains(2));
        System.out.println("IntArrayList是否包含3： "+ intArrayList.contains(3));
        intArrayList.remove(3);
        System.out.println("调用remove(3)后, intArrayList: "+intArrayList.toString());
    }
}

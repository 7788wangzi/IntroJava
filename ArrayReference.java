import java.util.Arrays;

public class ArrayReference {

    public static void main(String[] args) {
        System.out.println("验证数组是一个引用类型");

        int intArg = 0;
        int[] intArray = new int[2];

        System.out.println("调用前intArg: "+intArg);
        System.out.println("调用前intArray: "+Arrays.toString(intArray));
        changeInt(intArg);
        changeIntArray(intArray);
        System.out.println("调用后intArg: "+intArg);
        System.out.println("调用后intArray: "+Arrays.toString(intArray));
    }

    public static void changeInt(int arg)
    {
        arg=5;
    }

    public static void changeIntArray(int[] args)
    {
        args[0]=5;
    }
}

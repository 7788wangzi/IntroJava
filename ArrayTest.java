import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        System.out.println("Arrays数组方法");

        int[] nums ={5,3,6,8,11,2};

        // Arrays 方法
        System.out.println("println(nums): "+nums);
        System.out.println("println(Arrays.toString(nums): "+Arrays.toString(nums));
        int[] a = new int[5];
        int[] b = new int[5];

        System.out.println("Arrays.equals(a,b): " +Arrays.equals(a,b));
        System.out.println("a.equals(b): " + a.equals(b));
        Arrays.fill(a,10);
        System.out.println("调用Arrays.fill(a,10),数组a: "+Arrays.toString(a));
    }
}

import java.util.Arrays;
public class Task1 {
    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, 3, 4, 5 };
        Integer[] arr2 = { 1, 2, 3, 4, 5 };
        Integer[] arr3 = { 1, 2, 3, 5, 4 };
        System.out.println("arr1 & arr2 same? " + CompArrays(arr1, arr2));
        System.out.println("arr1 & arr3 same? " + CompArrays(arr1, arr3));
        String[] str1 = { "apple", "banana", "mango" };
        String[] str2 = { "apple", "banana", "mango" };
        String[] str3 = { "apple", "mango", "banana" };
        System.out.println("str1 & str2 same? " + CompArrays(str1, str2));
        System.out.println("str1 & str3 same? " + CompArrays(str1, str3));
    }
    public static <T> boolean CompArrays(T[] arr1, T[] arr2) {
        return Arrays.equals(arr1, arr2);
    }
}

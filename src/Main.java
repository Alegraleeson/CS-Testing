import java.util.Arrays;
import java.util.stream.Collectors;

public class Main{

    public static void main(String[] args){

       int[] intArray = new int[]{2, 1, 4, 3, 6, 5, 7, 10, 9};

       MissingNumber answer = new MissingNumber();

       int answer1 = answer.missingNumber(intArray, 10);

       System.out.println(answer1);

       System.out.println(MissingNumber.missingNumber(intArray, 10));


    }
}




import java.util.*;
import java.util.List;
import java.util.stream.Collectors;  


public class Calculator {

    public int add(String arg) {

        String modifiedArg = arg.replaceAll("\\\\n", ",");
        List<Integer> numbers = Arrays.stream(modifiedArg.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

        int sum = numbers.stream().reduce(0, 
                (element1, element2) -> element1 + element2); 
        
        return sum;
    }
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        int sum = 0;
        System.out.println("Please Enter the required String to evaluate");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        sum = calc.add(a);
        System.out.println(sum);
        
    }
}

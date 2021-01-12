import java.util.*;
import java.util.List;
import java.util.stream.Collectors;  


public class Calculator {

    public int add(String arg) {

        List<Integer> numbers = Arrays.stream(arg.split(","))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

        int sum = numbers.stream().reduce(0, 
                (element1, element2) -> element1 + element2); 
        
        return sum;
    }
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        int sum = 0;
        if(args.length == 0) {
            sum = 0;
        } else {
            sum = calc.add(args[0]);
        }
        System.out.println(sum);
        
    }
}

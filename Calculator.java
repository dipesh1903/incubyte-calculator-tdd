import java.util.*;
import java.util.List;
import java.util.stream.Collectors;  

class NegativeNumberException extends Exception {

	public NegativeNumberException(String string) {
		super(string);
	}

}

public class Calculator {

    public int add(String arg) throws NegativeNumberException {


        Set<String> st = new HashSet<String>();
        char delimiter = ',';
        String modifiedArg = arg;
        String delimiterArr = "";

        if (arg.startsWith("//")) {

            delimiter = arg.charAt(2);
            int endIndex = modifiedArg.indexOf("\\n");
            delimiterArr = modifiedArg.substring(2, endIndex);
            st.addAll(Arrays.asList(delimiterArr.split(",")));
            delimiterArr = String.join("", st);
            modifiedArg = modifiedArg.substring(endIndex+2);
            modifiedArg = modifiedArg.replaceAll("[" + delimiterArr + "]+", ",");

        }

        modifiedArg = modifiedArg.replaceAll("\\\\n", ",");

        List<Integer> numbers = Arrays.stream(modifiedArg.split(","))
        .map(Integer::parseInt)
        .filter(num -> num <= 1000).collect(Collectors.toList());

        List<Integer> filterNumber = numbers.stream().filter(num -> num < 0).collect(Collectors.toList());

        if(filterNumber.size() > 0) {
            throw new NegativeNumberException("negative number not allowed");
        }

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
        try {
            sum = calc.add(a);
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println(e);
        }

        
    }
}

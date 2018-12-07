import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] args)
    {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println("------------------------------------------------------------------------------------");

        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit)");
        Scanner input = new Scanner(System.in);

        String inputVal = input.next();
        while(validOperatorInput(inputVal)==false)
        {
            System.out.print("Please enter an operation (+, -, /, *, = or Q to quit)");
            inputVal = input.next();
        }

        while (!(inputVal.equals("Q") | inputVal.equals("q"))) {
                System.out.print("Please enter first fraction (a/b) or integer (a): ");
                String strA = input.next();
                while(validParameterInput(strA)==null) {
                    System.out.print("Please enter first fraction (a/b) or integer (a): ");
                    strA = input.next();
                }

                System.out.print("Please enter second fraction (a/b) or integer (a): ");
                String strB = input.next();

                while(validParameterInput(strB)==null) {

                    System.out.print("Please enter second fraction (a/b) or integer (a): ");
                    strB = input.next();
                }
                Calculate(inputVal, validParameterInput(strA), validParameterInput(strB));

                System.out.print("Please enter an operation (+, -, /, *, = or Q to quit)");
                inputVal = input.next();
                while(!validOperatorInput(inputVal))
                {
                    System.out.print("Please enter an operation (+, -, /, *, = or Q to quit)");
                    inputVal = input.next();
                }
            }
        }

    public static void Calculate(String operator, Fraction fraA, Fraction fraB)
    {
        Fraction result = null;
        switch (operator)
        {
            case "+":{
                result = fraA.add(fraB);
            }break;
            case "-":{
                result = fraA.subtract(fraB);
            }break;
            case "*":{
                result = fraA.multiply(fraB);
            }break;
            case "/":{
                result = fraA.divide(fraB);
            }break;
            case "=":{
                if(fraA.equals(fraB))
                {
                    System.out.println(fraA.toString()+" = "+fraB.toString()+" is true");
                }
                else{
                    System.out.println(fraA.toString()+" = "+fraB.toString()+" is false");
                }
                return;
            }
        }
        result.toLowestTerms();
        System.out.println(fraA.toString()+" "+operator+" "+fraB.toString()+" = "+ result.toString());
    }

    public static boolean validOperatorInput(String input)
    {
        String[] operators = new String[]{"+","-","*","/","=","q","Q"};
        for(int i=0; i<operators.length;i++)
        {
            if(operators[i].equals(input.trim()))
            {
                return true;
            }
        }
        return false;
    }

    public static Fraction validParameterInput(String input )
    {

        if(input.contains("/"))
        {
            String[] value =input.split("/");
            if(value.length>=2)
            {
                try {
                    int numerator = Integer.parseInt(value[0]);
                    int denominator = Integer.parseInt(value[1]);
                    Fraction result = new Fraction(numerator, denominator);
                    return result;
                }
                catch (Exception ex)
                {
                    return  null;
                }
            }
            return null;
        }
        else{
            try {
                int numerator = Integer.parseInt(input);
                Fraction result = new Fraction(numerator);
                return result;
            }
            catch (Exception ex)
            {
                return  null;
            }
        }
    }
}

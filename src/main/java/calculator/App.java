package calculator;
import java.util.Scanner;

public class App{

    public static double sqRoot(double x){
        if(x < 0){
            throw new IllegalArgumentException("Square root of negative number is not defined");
        }
        return Math.sqrt(x);
    }

    public static long factorial(int x){
        if(x < 0){
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }

        if(x > 20){
            throw new IllegalArgumentException("Factorial only supported for numbers between 0 and 20");
        }

        long prod = 1;

        for(int i=1; i<=x; i++){
            prod *= i;
        }

        return prod;
    }

    public static double naturalLog(double x){
        if(x <= 0){
            throw new IllegalArgumentException("Natural log is defined only for positive numbers");
        }
        return Math.log(x);
    }

    public static double power(double x, double n){
        return Math.pow(x, n);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\nScientific Calculator");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Log (base: e)");
            System.out.println("4. Power");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            try{
                switch(choice){
                    case 1:
                        System.out.print("Enter number: ");
                        double num = sc.nextDouble();
                        System.out.println("Result = " + sqRoot(num));
                        break;

                    case 2:
                        System.out.print("Enter integer: ");
                        int n = sc.nextInt();
                        System.out.println("Result = " + factorial(n));
                        break;

                    case 3:
                        System.out.print("Enter number: ");
                        double ln = sc.nextDouble();
                        System.out.println("Result = " + naturalLog(ln));
                        break;

                    case 4:
                        System.out.print("Enter base: ");
                        double base = sc.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exp = sc.nextDouble();
                        System.out.println("Result = " + power(base, exp));
                        break;

                    case 5:
                        System.exit(0);

                    default:
                        System.out.println("Please choose from the options provided!");
                }

            }
            catch(IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
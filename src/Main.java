import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       //Ievades lasīšana izmantojot Scanner klasi.
       Scanner scan = new Scanner(System.in);
       //Welcome text
        System.out.println("Welcome to Simple Calculator!");
        System.out.println("Would you like to start your calculations?");

        //Main loop
        while (true){

            System.out.println("Enter: y (Start)/n (Quit): ");
            String reply = scan.next();

            switch (reply) {
                case "y":
                    calculation();
                    again();
                    return;
                case "n":
                    end();
                    return;
                default:
                    System.out.println("Invalid input. Try again!");
                    break;
            }

        }
    }

    //End text
    public static void end () {
        System.out.println("Thank you for using Simple Calculator. Good bye!");
    }

    //Again loop (Atgriež pie kalkulatora f-cijas vai uz end f-ciju)
    public static void again(){
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Would you like to do another calculation?");
            System.out.println("Enter: y (Start)/n (Quit): ");
            String again = scan.next();
            switch (again){
                case "y":
                    calculation();
                    break;
                case "n":
                    end();
                    return;
            }
        }
    }

    //Calculator (Izpilda galveno kalkulatora f-cju)
    public static void calculation() {
        Scanner scan = new Scanner(System.in);
        //Paredzēts lai noapaļotu skaitļus līdz diviem cipariem aiz komata
        DecimalFormat df = new DecimalFormat("#.##");

        while (true){
            System.out.println("Enter number x: ");
            double x = scan.nextDouble();

            System.out.println("Enter number y: ");
            double y = scan.nextDouble();

            System.out.println("Choose operation (+, -, *, /): ");
            String operation = scan.next();

            switch (operation) {
                case "+":
                    System.out.println("Result: " + df.format(sum(x, y)));
                    return;

                case "-":
                    System.out.println("Result: " + df.format(sub(x, y)));
                    return;

                case "*":
                    System.out.println("Result: " + df.format(multi(x, y)));
                    return;

                case "/":
                    if(y == 0){
                        System.out.println("Cannot divide by 0. Try again");
                        continue;
                    };
                    System.out.println("Result: " + df.format(div(x, y)));
                    return;

                default:
                    System.out.println("Wrong operation symbol. Try again!");
                    break;
            }
        }
    }

    //Calculator operations (Izpilda kalkulatora operāciju f-cijas)
    public static double sum(double x, double y){
        return x + y;
    }
    public static double sub(double x, double y){
        return x - y;
    }
    public static double multi(double x, double y){
        return x * y;
    }
    public static double div(double x, double y){
        return x / y;
    }
}

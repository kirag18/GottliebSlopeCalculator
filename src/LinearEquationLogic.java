import java.util.Scanner;


public class LinearEquationLogic {
    private String unparsedCoord1;
    private String unparsedCoord2;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Scanner scan;//may need to move location
    private boolean first;

    public LinearEquationLogic(){
        scan = new Scanner(System.in);
        first = true;
    }

    public void start(){
        if (first){
            System.out.println("Welcome to the linear equation calculator");
            first = false;
        }
        getInputs();
        parseInputs();
        printedOutput();
    }

    private void getInputs(){
        System.out.print("Enter coordinate 1: ");
        unparsedCoord1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        unparsedCoord2 = scan.nextLine();
    }

    private void parseInputs(){
        x1 = Integer.parseInt(unparsedCoord1.substring(1,unparsedCoord1.indexOf(",")));
        x2 = Integer.parseInt(unparsedCoord2.substring(1,unparsedCoord2.indexOf(",")));
        y1 = Integer.parseInt(unparsedCoord1.substring(unparsedCoord1.indexOf(",")+2, unparsedCoord1.length()-1));
        y2 = Integer.parseInt(unparsedCoord2.substring(unparsedCoord2.indexOf(",")+2, unparsedCoord2.length()-1));
    }

    private void printedOutput(){
        LinearEquation equation = new LinearEquation(x1,y1,x2,y2);
        System.out.println(equation.lineInfo());
        System.out.println();
        if (x1 != x2) {
            System.out.print("Enter a values for x: ");
            double point = scan.nextDouble();
            System.out.println();
            System.out.println("The point on the line is " + equation.coordinateForX(point));
            System.out.println();
        }
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        scan.nextLine();
        String repeat = scan.nextLine();
        if (repeat.equals("y")){
            start();
        }else{
            System.out.println("Thank You for using the slope calculator, goodbye!");
        }
    }
}

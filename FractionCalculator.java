/**
 * Created by Nicholas Batten for the second coursework assignment.
 */



import java.util.Scanner;
import java.util.Arrays;

public class FractionCalculator
{
    static int storedNum = 0;
    static int storedDenom = 0;
    static int fractionCount = 0;
    static int numberCount = 0;
    static String currentOperator = "";
    static boolean fractionDup = false;
    static boolean numberDup = false;
    static boolean operatorDup = false;
    static int fracCount = 0;
    public static void main(String[]args)
    {
        System.out.print("\f");
        Scanner in = new Scanner(System.in);
        String total;
        String result = "";
        boolean quit = false;
        System.out.println("Hello and welcome to Nick's calculator! Please enter your calculation: "); //Welcome message

        while(!quit)
        {
            System.out.print("input: ");
            total = in.nextLine();
            String divider = "\\s";
            String[] firstParts = total.split(divider);
            int length = firstParts.length;
            int count = 0;
            
            
            if(total.contains("Q") || total.contains("q")) //If the user wants to quit the calculator
            {
                quit = true;
                break;
            }
            
            if(total.contains("s"))//shows the current fraction stored in the Fraction class    
            {
                System.out.println("current stored fraction: " + storedNum + "/" + storedDenom);
            }
            
            if(total.contains("c") || total.contains("C"))
            {
                System.out.println("The calculator has been cleared of all data");
                clear();
            }
            
            if(total.contains("."))
            {
                System.out.println("ERROR. A decimal point has been detected in your input. please ensure that only whole numbersare entered. The calculator has been cleared of all data");
                clear();
                break;
            }
            
            if(total.contains("a"))//if the user request the absolute value of the current fraction
            {
                if((numberDup == false) && (operatorDup == false) && (fractionDup == false))//checks that there is a fraction currently in the calculator
                {
                    System.out.println("ERROR. Please ensure that a fraction is stored in the calculator before requesting the absolute value");
                }
                else
                {
                    Fraction a = new Fraction(storedNum, storedDenom);
                    System.out.println("absolute value of current fraction stored: " + a.absValue(a));
                }
            }
            
            if(total.contains("n"))//if the user wishes to negate the currently stored fraction
            {
                if((numberDup == false) && (operatorDup == false) && (fractionDup == false))//checks that there is a fraction currently in the calculator
                {
                    System.out.println("ERROR. Please ensure that a fraction is stored in the calculator before requesting the negate value");
                }
                else
                {
                    Fraction a = new Fraction(storedNum, storedDenom);
                    System.out.println("negate value of current fraction stored: " + a.negate(a));
                }
            }
            
            //Counts the number of elements that are not empty spaces
            for(int i = 0 ; i<length ;i++)
            {
                if(!firstParts[i].equals("")) //check if the element is a space.
                {
                    count++;
                }
            }
            String[] secondParts =  new String[count];
            int n = 0;
            //Used to fill the 'secondParts' array with elements from 'firstParts'
            for(int y = 0 ; y < length  ; y++)
            {
                if(!firstParts[y].equals(""))
                {
                    secondParts[n] = firstParts[y];
                    n++;
                }
            }
            
            for(int x = 0 ; x < secondParts.length ; x++)
            {
                //fractions
                if(secondParts[x].length() >= 3 && secondParts[x].contains("/"))
                {
                    result = fraction(secondParts[x]);
                }    
                //operators
                else if(secondParts[x].length() == 1 && (secondParts[x].equals("/") || secondParts[x].equals("*") || secondParts[x].equals("-") || secondParts[x].equals("+"))) //Operators
                {
                    result = operator(secondParts[x]);
                }
                
                //numbers
                else if (secondParts[x].matches("[0-9]+") && secondParts[x].length() > 0)//checks that the array element only contains numeric characters 
                {
                    result = number(secondParts[x]);
                }
            }
            System.out.println("Answer: " + result);
        }
        System.out.print("Thank you for using the calculator. goodbye");
        clear();
        in.close();
    }
    
    public static String fraction(String a)
    {
        int denom;
        int num;
        String result = "";
        fracCount = 0;
        for(int i = 0 ; i < a.length() ; i++) //Checks to ensure that there is only a single '/' in each fraction
        {
            if(a.charAt(i) == '/')
            {
                fracCount++;
            }
        }
        
        if(fracCount > 1)
        {
            result = "ERROR. Please ensure that there is only a single '/' in each fraction. The calculator has been cleared of all previous data";
            clear();
        }
        else if(fractionDup)
        {
            result = "ERROR. Please ensure that there is an operator between two fractions. The calculator has been cleared of all previous data";
            clear();
        }
        else if(numberDup)
        {
            result = "ERROR. Please ensure that there is an operator between a fraction and a number. The calculator has been cleared of all previous data";
            clear();
        }
        else
        {       
            //split fraction into numerator and denomintor and then converts to integers
            String[] split = a.split("/");
            
            denom = (Integer.valueOf(split[1]));
            num = (Integer.valueOf(split[0]));
            fractionCount++;   
            if((fractionCount == 1) && (numberCount == 0))//if this is the first fraction and no number has been enterd before
            {
                storedNum = num; //for use when the next fraction is entered
                storedDenom = denom;
                Fraction b = new Fraction(storedNum, storedDenom);
            }
            else if((fractionCount == 1 && numberCount == 1)||(fractionCount == 2))//if this is the second fraction 
            {
                Fraction b = new Fraction(storedNum, storedDenom); //put here instead of putting it in each operator if statement 
                Fraction c = new Fraction(num, denom);  
                if(currentOperator.equals("/"))//if the last operator used was divide
                {
                    Fraction d = (b.divide(c));
                    //System.out.println("new calc: " + d.toString());
                    storedNum = d.getNumerator();
                    storedDenom = d.getDenominator();
                    result = d.toString();
                }
                else if(currentOperator.equals("+"))//if the last operator used was add
                {
                    Fraction d = (b.add(c));
                    //System.out.println("new calc: " + d.toString());
                    storedNum = d.getNumerator();
                    storedDenom = d.getDenominator();
                    result = d.toString();
                }
                else if(currentOperator.equals("-"))//if the last operator used was subtract
                {
                    Fraction d = (b.subtract(c));
                    //System.out.println("new calc: " + d.toString());
                    storedNum = d.getNumerator();
                    storedDenom = d.getDenominator();
                    result = d.toString();
                }
                else if(currentOperator.equals("*"))//if the last operator used was multiply
                {
                    Fraction d = (b.multiply(c));
                    storedNum = d.getNumerator();
                    storedDenom = d.getDenominator();
                    result =  d.toString();
                }
                fractionCount = 1;
            }
        }
        fractionDup = true;
        numberDup = false;
        operatorDup = false;
        fracCount = 0;
        currentOperator = ""; //removes the stored operator once the after each fraction
        return result;
    }
    
    public static String operator(String a)
    {
        String result = "";
        if(fractionDup == false && numberDup == false) //if an operator has been used before a fraction
        {
            result = "ERROR. Please ensure that there is either a fraction or a number at the start of the first calculation. The calculator has been cleared of all previous data";
            clear();
        }
        else if(operatorDup)
        {
            result = "ERROR. Please ensure that there is either a fraction or a number between two operators. The calculator has been cleared of all previous data";
            clear();
        }
        else    
        {
            currentOperator = a;
            operatorDup = true;
            numberDup = false;
            fractionDup = false;
        }
        return result;
    }
    
    public static String number(String a)
    {
        int denom;
        int num;
        String result = "";
        if(numberDup)//if the last entry was a number 
        {
            result = "ERROR. Please ensure that there is an operator between two numbers. The calculator has been cleared of all previous data";
            clear();
        }
        else if(fractionDup)// if the last entry was a fraction 
        {
            result = "ERROR. Please ensure that there is an operator between a number and a fraction. The calculator has been cleared of all previous data";
            clear();
        }
        else
        {
            denom = 1;
            num = (Integer.valueOf(a));
            numberCount++;   
            if((numberCount == 1) && (fractionCount == 0))//if this is the first fraction
            {
                storedNum = num; //for use when the next fraction is entered
                storedDenom = denom;
                Fraction b = new Fraction(storedNum, storedDenom);
            }
            else if(((numberCount == 1) && (fractionCount==1)) || (numberCount == 2)) 
            {
                Fraction b = new Fraction(storedNum, storedDenom); //put here instead of putting it in each operator if statement 
                Fraction c = new Fraction(num, denom);  
                if(currentOperator.equals("/"))//if the last operator used was divide
                {
                    Fraction d = (b.divide(c));
                    storedNum = d.getNumerator();
                    storedDenom = d.getDenominator();
                    result = d.toString();
                }
                else if(currentOperator.equals("+"))//if the last operator used was add
                {
                    Fraction d = (b.add(c));
                    storedNum = d.getNumerator();
                    storedDenom = d.getDenominator();
                    result = d.toString();
                }
                else if(currentOperator.equals("-"))//if the last operator used was subtract
                {
                    Fraction d = (b.subtract(c));
                    storedNum = d.getNumerator();
                    storedDenom = d.getDenominator();
                    result = d.toString();
                }
                else if(currentOperator.equals("*"))//if the last operator used was multiply
                {
                    Fraction d = (b.multiply(c));
                    storedNum = d.getNumerator();
                    storedDenom = d.getDenominator();
                    result = d.toString();
                }
                numberCount = 1;
            }
            fractionDup = false;
            numberDup = true;
            operatorDup = false;
        }
        currentOperator = ""; //removes the stored operator once the after each fraction
        return result;
    }
    
    //clears all variables that 
    public static void clear() //Used to clear the calcultor of all stored values
    {
        storedNum = 0;
        storedDenom = 0;
        fractionCount = 0;
        numberCount = 0;
        currentOperator = "";
        fractionDup = false;
        operatorDup = false;
        numberDup = false;
    }
}
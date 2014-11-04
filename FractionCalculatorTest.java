/**
 * Created by keith for the second coursework assignment.
 *
 * All the tests should be (re-)written using JUnit
 */
public class FractionCalculatorTest {
    public static void main(String[] args) {
        System.out.print("\f"); //Clear terminal window on blueJ software
        
        //test the clear method
        FractionCalculator a = new FractionCalculator();
        
        
        // test the first error check in the operator method
        FractionCalculator b = new FractionCalculator();
        b.clear();
        if((b.operator("*")).contains("ERROR"))
        {
            System.out.println("operator error 1");
        }
        
        // test the second error check in the operator method
        FractionCalculator c = new FractionCalculator();
        c.clear();
        c.fraction("1/2");
        c.operator("*");
        if((c.operator("*")).contains("ERROR"))
        {
            System.out.println("operator error 2");
        }
        
        //test the multiply function in the fraction method
        FractionCalculator d = new FractionCalculator();
        d.clear();
        d.fraction("2/3");
        d.operator("*");
        if(!(d.fraction("3/9")).equals("2/9"))
        {
            System.out.println("ERROR. The multiplication function under the fraction method has failed");
        }
        
        //test the divide function in the fraction method 
        FractionCalculator e = new FractionCalculator();
        e.clear();
        e.fraction("2/3");
        e.operator("/");
        if(!(e.fraction("3/9")).equals("2"))
        {
            System.out.println("ERROR. The division function under the fraction method has failed");
        }
        
        //test the add function in the fraction method 
        FractionCalculator f = new FractionCalculator();
        f.clear();
        f.fraction("22/37");
        f.operator("+");
        if(!(e.fraction("12/76")).equals("529/703"))
        {
            System.out.println("ERROR. The addition function under the fraction method has failed");
        }
        
        //test the subtract function in the fraction method 
        FractionCalculator g = new FractionCalculator();
        g.clear();
        g.fraction("22/37");
        g.operator("-");
        if(!(g.fraction("12/76")).equals("307/703"))
        {
            System.out.println("ERROR. The subtraction function under the fraction method has failed");
        }
        
        // test the first error check in the number method
        FractionCalculator h = new FractionCalculator();
        h.clear();
        h.number("4");
        if((h.number("4")).contains("ERROR"))
        {
            System.out.println("number error 1");
        }
        
        // test the second error check in the number method
        FractionCalculator i = new FractionCalculator();
        i.clear();
        i.fraction("4/4");
        if((h.number("4")).contains("ERROR"))
        {
            System.out.println("number error 2");
        }
        
        // test the first error check in the fraction method
        FractionCalculator j = new FractionCalculator();
        j.clear();
        if((j.fraction("4//4")).contains("ERROR"))
        {
            System.out.println("fraction error 1");
        }
        
        // test the second error check in the fraction method
        FractionCalculator k = new FractionCalculator();
        k.clear();
        k.fraction("1/2");
        if((k.fraction("4/4")).contains("ERROR"))
        {
            System.out.println("fraction error 2");
        }
        
        // test the third error check in the fraction method
        FractionCalculator l = new FractionCalculator();
        l.clear();
        l.number("2");
        if((l.fraction("4/4")).contains("ERROR"))
        {
            System.out.println("fraction error 3");
        }
    }
}
/**
 * Created by keith for the second coursework assignment.
 *
 * All the tests should be (re-)written using JUnit
 */
public class FractionTest {
    public static void main(String[] args) {
        System.out.print("\f"); //Clear terminal window on blueJ software
        
        // test divide by zero - should print an error and exit
        new Fraction(1, 0);
        
        // test multiply
        Fraction a = new Fraction(3,10);
        Fraction b = new Fraction(1,2);
        Fraction c = new Fraction(3,5);
        if (!a.equals(b.multiply(c)))
        {
            System.out.println("Multiply failed");
        }
        
        // test equals
        test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
        test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
        test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
        test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
        test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");

        // tests subtract
        Fraction d = new Fraction(1,5);
        Fraction e = new Fraction(4,10);
        Fraction f = new Fraction(2,10);
        if (!d.equals(e.subtract(f)))
        {
            System.out.println("Subtract failed");
        }
        
        // tests add
        Fraction g = new Fraction(2,4);
        Fraction h = new Fraction(1,4);
        Fraction i = new Fraction(1,4);
        if (!g.equals(h.add(i))) 
        {
            System.out.println("Add failed");
        }
        
        // tests divide
        Fraction j = new Fraction(6,2);
        Fraction k = new Fraction(1,2);
        Fraction l = new Fraction(1,6);
        if (!j.equals(k.divide(l))) 
        {
            System.out.println("Divide failed"); 
        }
        
        // tests absValue
        Fraction m = new Fraction(1,2);
        Fraction n = new Fraction(-1,2);
        if (!m.equals(n.absValue(n))) 
        {
            System.out.println("absValue failed"); 
        }
        
        // tests negate
        Fraction o = new Fraction(-1,2);
        Fraction p = new Fraction(1,2);
        if (!o.equals(p.negate(p))) 
        {
            System.out.println("Negate failed"); 
        }
        
        // tests toString
        Fraction q = new Fraction(1,2);
        String test1 = "1/2";
        if (!test1.equals(q.toString())) 
        {
            System.out.println("toString failed"); 
        }
    }

    static void test(Fraction f1, Fraction f2, String msg){
        if (! f1.equals(f2))
        System.out.println(msg);
    }
}
/**
 * Created by keith for the second coursework assignment.
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0"); 
            // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        if(gcd == -1) //prevents '-' sign appearing before a denominator
        {
            gcd = Math.abs(gcd);
        }
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    @Override
    public String toString() {
        if(getDenominator()== 1)
        {
            return "" + getNumerator();
        }
        else
        {
            return "" + getNumerator() + '/' + getDenominator();
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other) //working
    {

        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }
    
    //this.getDenominator is the first number to be sent to this class
    //other.getDenominator is the second number to be sent to this class
    public Fraction subtract(Fraction other) // working       
    {
        int num = ((this.getNumerator()*other.getDenominator()) - (other.getNumerator()*this.getDenominator()));
        int denom = this.getDenominator()*other.getDenominator();
        return new Fraction(num, denom);
    }
    
    public Fraction add(Fraction other) //working
    {
        int num = ((other.getNumerator()*this.getDenominator()) + (this.getNumerator()*other.getDenominator()));
        int denom = this.getDenominator()*other.getDenominator();
        return new Fraction (num, denom);
    }
    
    public Fraction divide(Fraction other) //working
    {
        int num = this.getNumerator()*other.getDenominator();
        int denom = this.getDenominator()*other.getNumerator();
        return new Fraction (num, denom);
    }

    public Fraction absValue(Fraction other)
    {
        int num = (Math.abs(other.getNumerator()));
        int denom = (Math.abs(other.getDenominator()));
        return new Fraction(num, denom);
    }
    
    public Fraction negate(Fraction other)//changes the fraction to negative
    {
        int num = other.getNumerator();
        num *= -1;
        int denom = other.getDenominator();
        return new Fraction(num, denom);
    }
    
    private int myGcd(int a, int b) 
    {   
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
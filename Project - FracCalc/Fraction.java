public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator){
        if(denominator==0)
            throw new IllegalArgumentException();

        if(denominator<0)
        {
            denominator=0-denominator;
            numerator = 0- numerator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator)
    {
        this(numerator,1);
    }

    public Fraction(){
        this(0);
    }

    public int geNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public String toString(){
        return this.numerator+"/"+this.denominator;
    }

    public double toDouble(){
        return this.numerator/this.denominator;
    }

    public Fraction add(Fraction other)
    {
        int newNumerator = this.numerator*other.denominator+this.denominator*other.numerator;
        int newDenominator = this.denominator*other.denominator;

        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }


    public Fraction subtract(Fraction other)
    {
        int newNumerator = this.numerator*other.denominator-this.denominator*other.numerator;
        int newDenominator = this.denominator*other.denominator;

        Fraction result = new Fraction (newNumerator, newDenominator);
        return result;
    }

    public Fraction multiply(Fraction other)
    {
        int newNumerator = this.numerator*other.numerator;
        int newDenominator = this.denominator * other.denominator;

        Fraction result = new Fraction (newNumerator, newDenominator);
        return result;
    }

    public Fraction divide(Fraction other)
    {
        if(other.numerator==0)
            throw new IllegalArgumentException();
        int newNumerator =  this.numerator*other.denominator;
        int newDenominator = this.denominator*other.numerator;

        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }

    public boolean equals(Object other)
    {
        try {
            Fraction fOther = (Fraction) other;

            if (this.numerator == fOther.numerator & this.denominator == fOther.denominator)
                return true;
            else if(this.denominator*fOther.numerator==this.numerator*fOther.denominator)
                return true;
            else
                return false;
        }
        catch(Exception ex){
            return false;
        }
    }

    public void toLowestTerms(){
        int remainder = gcd(this.numerator, this.denominator);

        this.numerator = this.numerator/remainder;
        this.denominator=this.denominator/remainder;
    }


    public static int gcd(int a, int b)
    {
        if(a==b)
            return a;

        int r = a%b;
        if(r==0)
            return b;
        else
            return gcd(b, r);
    }

}

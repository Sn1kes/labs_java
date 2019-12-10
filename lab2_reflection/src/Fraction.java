public class Fraction {
    int numerator;
    int denominator;

    @MyAnnotation
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b,a % b);
    }

    int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(Fraction a) {
        numerator = a.numerator;
        denominator = a.denominator;
    }

    public Fraction(int _numerator) {
        numerator = _numerator;
        denominator = 1;
    }

    public Fraction(int _numerator, int _denominator) {
        numerator = _numerator;
        denominator = _denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public float get() {
        return (float)numerator / (float)denominator;
    }

    public void setNumerator(Integer numerator) {
        if(numerator == null)
            return;
        this.numerator = numerator;
    }

    public void setDenominator(Integer denominator) {
        if(denominator == null)
            return;
        this.denominator = denominator;
    }

    public Fraction add(Fraction a) {
        Fraction res = new Fraction();
        int div = lcm(denominator, a.denominator);
        res.numerator = div / denominator * numerator + div / a.denominator * a.numerator;
        res.denominator = div;
        return res;
    }

    @MyAnnotation
    public Fraction sub(Fraction a) {
        Fraction res = new Fraction();
        int div = lcm(denominator, a.denominator);
        res.numerator = div / denominator * numerator - div / a.denominator * a.numerator;
        res.denominator = div;
        return res;
    }

    public Fraction mul(Fraction a) {
        Fraction res = new Fraction();
        res.numerator *= a.numerator;
        res.denominator *= a.denominator;
        return res;
    }

    public String toString() {
        return new String(Integer.toString(numerator) + " / " + Integer.toString(denominator));
    }
}

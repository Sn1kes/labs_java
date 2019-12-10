interface FractionComplex_int {
    public int getImaginaryNumerator();
    public int getImaginaryDenominator();
    public float getImaginary();
    public void setImaginaryNumerator(Integer imaginary_numerator);
    @MyAnnotation
    public void setImaginaryDenominator(Integer imaginary_denominator);
}

public final class FractionComplex extends Fraction implements FractionComplex_int {
    private int imaginary_numerator;
    private int imaginary_denominator;

    public FractionComplex() {
        numerator = 0;
        denominator = 1;
        imaginary_numerator = 0;
        imaginary_denominator = 1;
    }

    public FractionComplex(FractionComplex a) {
        numerator = a.numerator;
        denominator = a.denominator;
        imaginary_numerator = a.imaginary_numerator;
        imaginary_denominator = a.imaginary_denominator;
    }

    public FractionComplex(int _numerator) {
        numerator = _numerator;
        denominator = 1;
        imaginary_numerator = 0;
        imaginary_denominator = 1;
    }

    public FractionComplex(int _numerator, int _denominator) {
        numerator = _numerator;
        denominator = _denominator;
        imaginary_numerator = 0;
        imaginary_denominator = 1;
    }

    public FractionComplex(int _numerator, int _denominator, int _imaginary_numerator, int _imaginary_denominator) {
        numerator = _numerator;
        denominator = _denominator;
        imaginary_numerator = _imaginary_numerator;
        imaginary_denominator = _imaginary_denominator;
    }

    public int getImaginaryNumerator() {
        return imaginary_numerator;
    }

    public int getImaginaryDenominator() {
        return imaginary_denominator;
    }

    public float getImaginary() {
        return (float)imaginary_numerator / (float)imaginary_denominator;
    }

    public void setImaginaryNumerator(Integer imaginary_numerator) {
        if(imaginary_numerator == null)
            return;
        this.imaginary_numerator = imaginary_numerator;
    }

    @MyAnnotation
    public void setImaginaryDenominator(Integer imaginary_denominator) {
        if(imaginary_denominator == null)
            return;
        this.imaginary_denominator = imaginary_denominator;
    }

    public FractionComplex add(FractionComplex a) {
        if(a == null)
            a = new FractionComplex();
        FractionComplex res = new FractionComplex();
        int div = lcm(denominator, a.denominator);
        res.numerator = div / denominator * numerator + div / a.denominator * a.numerator;
        res.denominator = div;
        div = lcm(imaginary_denominator, a.imaginary_denominator);
        res.imaginary_numerator = div / imaginary_denominator * imaginary_numerator + div / a.imaginary_denominator * a.imaginary_numerator;
        res.imaginary_denominator = div;
        return res;
    }

    @MyAnnotation
    public FractionComplex sub(FractionComplex a) {
        if(a == null)
            a = new FractionComplex();
        FractionComplex res = new FractionComplex();
        int div = lcm(denominator, a.denominator);
        res.numerator = div / denominator * numerator - div / a.denominator * a.numerator;
        res.denominator = div;
        div = lcm(imaginary_denominator, a.imaginary_denominator);
        res.imaginary_numerator = div / imaginary_denominator * imaginary_numerator + div / a.imaginary_denominator * a.imaginary_numerator;
        res.imaginary_denominator = div;
        return res;
    }

    public FractionComplex mul(FractionComplex a) {
        if(a == null)
            a = new FractionComplex();
        FractionComplex res = new FractionComplex();
        Fraction ar = new Fraction(numerator, denominator);
        Fraction br = new Fraction(a.numerator, a.denominator);
        Fraction ai = new Fraction(imaginary_numerator, imaginary_denominator);
        Fraction bi = new Fraction(a.imaginary_numerator, a.imaginary_denominator);
        ar.mul(br);
        ai.mul(bi);
        ar.sub(ai);
        Fraction real = new Fraction((ar.mul(br)).sub(ai.mul(bi)));
        Fraction imag = new Fraction((ai.mul(br)).add(ar.mul(bi)));
        res.numerator = real.numerator;
        res.denominator = real.denominator;
        res.imaginary_numerator = imag.numerator;
        res.imaginary_denominator = imag.denominator;
        return res;
    }

    public String toString() {
        return new String(Integer.toString(numerator) + " / " + Integer.toString(denominator) + " + ("
                + Integer.toString(imaginary_numerator) + " / " + Integer.toString(imaginary_denominator) + ")i");
    }
}

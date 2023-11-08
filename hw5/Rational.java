package CISC3115_Deborah.hw5;

public class Rational extends Number implements Comparable<Rational> {
    private long numerator;
    private long denominator;

    public Rational() {
        this(0, 1);
    }

    public Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        this.numerator = ((denominator > 0) ? 1 : -1) * numerator / gcd;
        this.denominator = Math.abs(denominator) / gcd;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Rational add(Rational secondRational) {
        return new Rational((numerator * secondRational.getDenominator() + denominator * secondRational.getNumerator()), (denominator * secondRational.getDenominator()));
    }

    public Rational subtract(Rational secondRational) {
        return new Rational((numerator * secondRational.getDenominator() - denominator * secondRational.getNumerator()), (denominator * secondRational.getDenominator()));

    }

    public Rational multiply(Rational secondRational) {
        return new Rational(numerator * secondRational.getNumerator(), denominator * secondRational.getDenominator());

    }

    public Rational divide(Rational secondRational) {
        return new Rational(numerator * secondRational.getDenominator(), denominator * secondRational.getNumerator());
    }

    @Override
    public String toString() {
        if (denominator == 1) return String.valueOf(numerator);
        else return numerator + "/" + denominator;

    }

    private static long gcd(long n, long d) {
        long numeratorAbs = Math.abs(n);
        long denominatorAbs = Math.abs(d);
        long remainder = numeratorAbs % denominatorAbs;
        while (remainder != 0) {
            numeratorAbs = denominatorAbs;
            denominatorAbs = remainder;
            remainder = numeratorAbs % denominatorAbs;
        }
        return denominatorAbs;
    }

    @Override
    public int compareTo(Rational o) {
        Rational difference = this.subtract(o);
        if (difference.getNumerator() > 0)
            return 1;
        else if (difference.getNumerator() < 0)
            return -1;
        else
            return 0;
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }
}

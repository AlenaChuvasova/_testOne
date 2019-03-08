package Main;

import java.util.Objects;

public class Fractions implements Comparable<Fractions> {

    private int num;
    private int den;

    public Fractions(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public Fractions(int num) {
        this(num, 1);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        this.den = den;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fractions fractions = (Fractions) o;
        return num == fractions.num &&
                den == fractions.den;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(num, den);
    }

    @Override
    public String toString() throws ArithmeticException {
        if (den == 1) {
            return String.valueOf(num);
        } else if (den == 0) {
            throw new ArithmeticException("Error!");
        } else {
            return num + "/" + den;
        }
    }

    public Fractions add(Fractions fr1) {
        Fractions sum = new Fractions((fr1.num * den) + (num * fr1.den), (fr1.den * den));
        return sum;
    }

    public Fractions subtraction(Fractions fr1) {
        if (fr1.getNum() == 0) {
            fr1.setDen(1);
        }
        Fractions subtraction = new Fractions((num * fr1.getDen()) - (fr1.getNum() * den), (fr1.den * den));
        return subtraction;
    }

    public Fractions multiply(Fractions fr1) {
        if (fr1.getNum() == 0) {
            fr1.setDen(1);
        }
        Fractions multi = new Fractions((fr1.num * num), (fr1.den * den));
        return multi;
    }

    public Fractions division(Fractions fr1) {
        if (fr1.den == 0) {
            throw new ArithmeticException("Error!");
        }
        Fractions division = new Fractions(num * fr1.den, fr1.num * den);
        division.reduction(fr1);
        return division;
    }

    public Fractions reduction(Fractions fr1) {
        if (fr1.getNum() == 0) {
            fr1.setDen(1);
        }
        int min = Math.min(fr1.num, fr1.den);
        for (int i = 2; i <= Math.abs(min); i++) {
            if (fr1.getNum() % i == 0 && fr1.getDen() % i == 0) {
                fr1.setNum(fr1.getNum()/ i);
                fr1.setDen(fr1.getDen()/ i);
            }
        }
        return this;
    }

    @Override
    public int compareTo(Fractions fr1) {
        int f = this.getNum() * fr1.getDen();
        int g = fr1.getNum() * this.getDen();
        int res = 0;
        if (f > g) {
            res = 1;
        } else if (g > f) {
            res = -1;
        }
        return res;
    }
}

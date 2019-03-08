package Main;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {

    @Test
    public void constructorTest(){
        int num = 5;
        int den = 7;
        Fractions fractions = new Fractions(num,den);
        System.out.println(fractions);
    }

    @Test
    public void equalsTest() {
        Fractions c_test1 = new Fractions(3, 1);
        Fractions c_test2 = new Fractions(0);
        Fractions c_test3 = new Fractions(3, 2);
        Fractions c_test4 = new Fractions(3,-2);

        assertTrue(c_test1.equals(c_test1));
        assertTrue(c_test2.equals(c_test2));
        assertFalse(c_test3.equals(c_test2));
        assertFalse(c_test1.equals(c_test3));
        assertFalse(c_test3.equals(c_test4));
    }

    @Test
    public void hashCodeTest() {
        Fractions f1 = new Fractions(2, 1);
        Fractions f2 = new Fractions(2, 1);
        Fractions f3 = new Fractions(3, 1);

        assertTrue(f1.equals(f2) && f2.equals(f1));
        assertEquals(f1.hashCode() == f2.hashCode(),f1.hashCode() == f2.hashCode());
        assertFalse(f1.equals(f3) && f3.equals(f1));
        assertNotEquals(f1.hashCode(), f3.hashCode());
    }

    @Test
    public void addFunctionTest() {
        Fractions add_test1 = new Fractions(-5, 1);
        Fractions add_test2 = new Fractions(5, 1);
        Fractions res = add_test1.add(add_test2);
        Fractions expected = new Fractions(0);
        assertEquals(expected,res);
        System.out.println("The result of adding " + add_test1 + " and " + add_test2 + " is: " + res + ".");
    }

    @Test
    public void addZeroFunctionTest(){
        Fractions add_test1 = new Fractions(0);
        Fractions add_test2 = new Fractions(-3);
        Fractions res = add_test1.add(add_test2);
        Fractions expected = new Fractions(-3);
        assertEquals(expected,res);
        System.out.println("The result of adding " + add_test1 + " and " + add_test2 + " is: " + res + ".");
    }

    @Test
    public void addChangePlacesTest(){
        Fractions add_test1 = new Fractions(6, 1);
        Fractions add_test2 = new Fractions(10,5);
        Fractions res = add_test1.add(add_test2);
        Fractions expected = add_test2.add(add_test1);
        assertEquals(expected,res);
        System.out.println("The result of adding " + add_test1 + " and " + add_test2 + " is: " + res + ".");
    }

    @Test
    public void subtractionMethodTest(){
        Fractions sub_test1 = new Fractions(6, 1);
        Fractions sub_test2 = new Fractions(-6,1);
        Fractions res = sub_test1.subtraction(sub_test2);
        Fractions expected = new Fractions(12);
        assertEquals(expected,res);
        System.out.println("The result of subtraction " + sub_test1 + " and " + sub_test2 + " is: " + res + ".");
        Fractions sub_test3 = new Fractions(0);
        Fractions sub_test4 = new Fractions(-3,1);
        Fractions res1 = sub_test3.subtraction(sub_test4);
        Fractions expected1 = new Fractions(3);
        assertEquals(expected1,res1);
        System.out.println("The result of subtraction " + sub_test3 + " and " + sub_test4 + " is: " + res1 + ".");
        Fractions sub_test5 = new Fractions(0);
        Fractions res2 = sub_test5.subtraction(sub_test5);
        Fractions expected2 = new Fractions(0);
        assertEquals(expected2,res2);
        System.out.println("The result of subtraction " + sub_test5 + " and " + sub_test5 + " is: " + res2 + ".");
    }

    @Test
    public void multiplyFunctionTest() {
        Fractions multi_test1 = new Fractions(2,5);
        Fractions multi_test2 = new Fractions(8,1);
        Fractions res = multi_test1.multiply(multi_test2);
        assertTrue(res.getNum() == multi_test1.getNum() * multi_test2.getNum());
        assertTrue(res.getDen() == multi_test1.getDen() * multi_test2.getDen());
        System.out.println("The result of multiplying " + multi_test1 + " and " + multi_test2 + " is: " + res + ". Correct.");
    }

    @Test
    public void multiplyZeroFunctionTest() {
        Fractions multi_test1 = new Fractions(5,4);
        Fractions multi_test2 = new Fractions(0);
        Fractions res = multi_test1.multiply(multi_test2);
        assertTrue(res.getNum() == multi_test1.getNum() * multi_test2.getNum());
        assertTrue(res.getDen() == multi_test1.getDen() * multi_test2.getDen());
        System.out.println("The result of multiplying " + multi_test1 + " and " + multi_test2 + " is: " + res + ". Correct.");
    }

    @Test
    public void multiplyChangePlacesTest(){
        Fractions multi_test1 = new Fractions(5,4);
        Fractions multi_test2 = new Fractions(3,11);
        Fractions res = multi_test1.multiply(multi_test2);
        Fractions res1 = multi_test2.multiply(multi_test1);
        assertEquals(res,res1);
        assertEquals(res1,res);
    }

    @Test
    public void divisionMethodTest(){
        Fractions div_test1 = new Fractions(5,1);
        Fractions div_test2 = new Fractions(1,-5);
        Fractions res = div_test1.division(div_test2);
        Fractions expected = new Fractions(-25);
        assertEquals(expected,res);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroTest(){
        Fractions div_test1 = new Fractions(9,1);
        Fractions div_test2 = new Fractions(2,0);
        Fractions div_test3 = new Fractions(1,0);
        Fractions res = div_test1.division(div_test2);
        Fractions expected = new Fractions(25);
        assertEquals(expected,res);
        Fractions res1 = div_test2.division(div_test1);
        Fractions expected1 = new Fractions(25);
        assertEquals(expected1,res1);
        Fractions res2 = div_test1.division(div_test3);
        Fractions expected2 = new Fractions(25);
        assertEquals(expected2,res2);
        Fractions res3 = div_test2.division(div_test3);
        String expected3 = "5";
        assertEquals(expected3,res3);
    }

    @Test
    public void reductionMethodTest() {
        Fractions red_test1 = new Fractions(0);
        Fractions res = red_test1.reduction(red_test1);
        Fractions expected = new Fractions(0);
        assertEquals(expected,res);
        Fractions red_test2 = new Fractions(20,10);
        Fractions res1 = red_test2.reduction(red_test2);
        Fractions expected1 = new Fractions(2);
        assertEquals(expected1,res1);
        Fractions red_test3 = new Fractions(-6);
        Fractions res2 = red_test3.reduction(red_test3);
        Fractions expected2 = new Fractions(-6);
        assertEquals(expected2,res2);
    }

    @Test(expected = ArithmeticException.class)
    public void toStringMethodTest() {

        Fractions tS_test1 = new Fractions(9, 1);
        String expected = "9";
        assertEquals(expected,tS_test1.toString());
        Fractions tS_test2 = new Fractions(-8, 3);
        String expected1 = "-8/3";
        assertEquals(expected1,tS_test2.toString());
        Fractions tS_test3 = new Fractions(0);
        String expected2 = "0";
        assertEquals(expected2,tS_test3.toString());
        Fractions tS_test4 = new Fractions(1,0);
        String expected3 = "1";
        assertEquals(expected3,tS_test4.toString());
    }

    @Test
    public void compareToMethodTest(){
        Fractions comp_test1 = new Fractions(6, 1);
        Fractions comp_test2 = new Fractions(6, 1);
        assertEquals(0,comp_test1.compareTo(comp_test2));
        Fractions comp_test3 = new Fractions(8, 3);
        Fractions comp_test4 = new Fractions(5, 4);
        assertEquals(1,comp_test3.compareTo(comp_test4));
        Fractions comp_test5 = new Fractions(2, 4);
        Fractions comp_test6 = new Fractions(6, 3);
        assertEquals(-1,comp_test5.compareTo(comp_test6));
        Fractions comp_test7 = new Fractions(0);
        Fractions comp_test8 = new Fractions(6, 1);
        assertEquals(-1,comp_test7.compareTo(comp_test8));
        Fractions comp_test9 = new Fractions(-2, 4);
        Fractions comp_test10 = new Fractions(3, 6);
        assertEquals(-1,comp_test9.compareTo(comp_test10));
    }
}






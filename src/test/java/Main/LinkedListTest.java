package Main;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void addTest() {
        LinkedListStructure<String> list = new LinkedListStructure<>();
        list.add("A", 0);
        list.add("B", 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWrongIndexTest() {
        LinkedListStructure<String> list = new LinkedListStructure<>();
        list.add("A", 4);
        list.add("B", 3);
        list.add("C", -1);
    }

    @Test
    public void isEmptyEmptyListTest() {
        Assert.assertTrue(new LinkedListStructure<>().isEmpty());
    }

    @Test
    public void isEmpty() {
        LinkedListStructure<String> list = new LinkedListStructure<>();
        list.add("A", 0);
        list.add("B", 1);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void isEmptyAfterOtherMethods() {
        LinkedListStructure<String> list = new LinkedListStructure<>();
        list.add("A", 0);
        list.remove(0);
        Assert.assertTrue(list.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementFromEmptyList() {
        LinkedListStructure<Integer> list = new LinkedListStructure<>();
        list.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementByWrongIndex() {
        LinkedListStructure<Integer> list = new LinkedListStructure<>();
        list.add(1, 0);
        list.get(4);
    }

    @Test
    public void getTest() {
        LinkedListStructure<Integer> list = new LinkedListStructure<>();
        Integer el = 1;
        list.add(1, 0);
        Assert.assertEquals(el, list.get(0));
    }

    @Test
    public void getAfterOtherMethods() {
        LinkedListStructure<String> list = new LinkedListStructure<>();
        list.add("A", 0);
        list.add("B", 1);
        list.get(0);
        Assert.assertTrue(list.get(0) == "A");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFromEmptyList() {
        LinkedListStructure<Integer> list = new LinkedListStructure<>();
        list.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeElementByWrongIndex() {
        LinkedListStructure<Integer> list = new LinkedListStructure<>();
        list.remove(-1);
        list.get(0);
        list.add(1, 0);
        list.remove(4);
    }

    @Test
    public void remove() {
        LinkedListStructure<String> list = new LinkedListStructure<>();
        list.add("A", 0);
        list.add("B", 1);
        list.remove(0);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void sizeEmptyListTest() {
        Assert.assertTrue(new LinkedListStructure<Integer>().size() == 0);
    }

    @Test
    public void sizeTest() {
        LinkedListStructure<Integer> list = new LinkedListStructure<>();
        list.add(1, 0);
        list.add(2, 1);
        list.add(3, 2);
        Assert.assertEquals(3, list.size());
        list.remove(1);
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void equalsEmptyList() {
        Assert.assertTrue(new LinkedListStructure<String>().equals(new LinkedListStructure<String>()));
    }

    @Test
    public void equalsTest() {
        LinkedListStructure<String> list = new LinkedListStructure<>();
        list.add("A", 0);
        list.add("B", 1);
        LinkedListStructure<String> list1 = new LinkedListStructure<>();
        list.add("A", 0);
        list.add("B", 1);
        Assert.assertEquals(list.equals(list1), list1.equals(list));
        Assert.assertTrue(list.equals(list));
    }

    @Test
    public void equalsForDifTypes() {
        LinkedListStructure<String> list = new LinkedListStructure<>();
        list.add("A", 0);
        LinkedListStructure<Integer> list1 = new LinkedListStructure<>();
        list1.add(1, 0);
        Assert.assertFalse(list.equals(list1));
    }

    @Test
    public void hashCodeTest() {
        LinkedListStructure<Integer> list = new LinkedListStructure<>();
        list.add(1, 0);
        list.add(2, 1);
        LinkedListStructure<Integer> list1 = new LinkedListStructure<>();
        list1.add(1, 0);
        list1.add(2, 1);
        Assert.assertEquals(list.hashCode(), list1.hashCode());
    }

    @Test
    public void toStringTestForEmptyList() {
        LinkedListStructure<String> list = new LinkedListStructure<>();
        Assert.assertTrue(list.toString() == "Empty list");
    }

    @Test
    public void toStringTest() {
        LinkedListStructure<String> list = new LinkedListStructure<>();
        list.add("A", 0);
        list.add("B", 1);
        Assert.assertEquals("LinkedListStructure{size=2, firstNode=A, lastNode=B}", list.toString());
        LinkedListStructure<Integer> list1 = new LinkedListStructure<>();
        list1.add(1, 0);
        list1.add(2, 1);
        Assert.assertEquals("LinkedListStructure{size=2, firstNode=1, lastNode=2}", list1.toString());
    }
}




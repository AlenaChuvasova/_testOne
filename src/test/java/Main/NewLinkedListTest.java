package Main;

import Main.newLinkedList.NewLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class NewLinkedListTest {

    @Test
    public void addTest() {
        NewLinkedList<String> list = new NewLinkedList<>();
        list.add("A", 0);
        list.add("C", 1);
        list.add("B", 1);
        Assert.assertTrue("3", list.size() == 3);
    }

    @Test
    public void simpleAddTest() {
        NewLinkedList<Integer> list = new NewLinkedList<>();
        list.add(0, 0);
        Assert.assertEquals(0, (int) list.get(0));
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void addWrongIndexTest() {
        NewLinkedList<String> list = new NewLinkedList<>();
        list.add("C", -1);
        list.add("D", 17);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addIndexOutOfBoundTest() {
        NewLinkedList<String> list = new NewLinkedList<>(3);
        list.add("A", 5);
    }

    @Test
    public void isEmptyEmptyListTest() {
        Assert.assertTrue(new NewLinkedList<>().isEmpty());
    }

    @Test
    public void isEmpty() {
        NewLinkedList<String> list = new NewLinkedList<>();
        list.add("A", 0);
        list.add("B", 1);
        Assert.assertFalse(list.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementFromEmptyList() {
        NewLinkedList<Integer> list = new NewLinkedList<>();
        list.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementByWrongIndex() {
        NewLinkedList<Integer> list = new NewLinkedList<>();
        list.add(1, 0);
        list.get(4);
        list.get(-1);
        list.add(2,1);
        list.get(2);
    }

    @Test
    public void getTest() {
        NewLinkedList<Integer> list = new NewLinkedList<>();
        Integer el = 1;
        list.add(1, 0);
        Assert.assertEquals(el, list.get(0));
    }

    @Test
    public void getAfterOtherMethods() {
        NewLinkedList<String> list = new NewLinkedList<>();
        list.add("A", 0);
        list.add("B", 1);
        list.get(0);
        Assert.assertTrue(list.get(0) == "A");
    }

    @Test
    public void getWrongIndexTest() {

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFromEmptyList() {
        NewLinkedList<Integer> list = new NewLinkedList<>();
        list.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeElementByWrongIndex() {
        NewLinkedList<Integer> list = new NewLinkedList<>();
        list.remove(-1);
        list.get(0);
        list.add(1, 0);
        list.remove(4);
    }

    @Test
    public void remove() {
        NewLinkedList<String> list = new NewLinkedList<>();
        list.add("A", list.size());
        list.add("B", list.size());
        list.add("C", list.size());
        list.remove(1);
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void sizeEmptyListTest() {
        Assert.assertTrue(new NewLinkedList<Integer>().size() == 0);
    }

    @Test
    public void sizeTest() {
        NewLinkedList<Integer> list = new NewLinkedList<>();
        list.add(1, 0);
        list.add(2, 1);
        list.add(3, 2);
        list.add(4, 3);
        Assert.assertEquals(4, list.size());
        list.remove(1);
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void equalsEmptyList() {
        Assert.assertTrue(new NewLinkedList<String>().equals(new NewLinkedList<String>()));
    }

    @Test
    public void equalsTest() {
        NewLinkedList<String> list = new NewLinkedList<>();
        list.add("A", 0);
        list.add("B", 1);
        NewLinkedList<String> list1 = new NewLinkedList<>();
        list1.add("A", 0);
        list1.add("B", 1);
        Assert.assertEquals(list.equals(list1), list1.equals(list));
        Assert.assertTrue(list.equals(list));
    }

    @Test
    public void equalsTheSameList() {
        NewLinkedList<Integer> list = new NewLinkedList<>();
        list.add(1, 0);
        Assert.assertTrue(list.equals(list));
    }

    @Test
    public void equalsForDifTypes() {
        NewLinkedList<String> list = new NewLinkedList<>();
        list.add("A", 0);
        NewLinkedList<Integer> list1 = new NewLinkedList<>();
        list1.add(1, 0);
        Assert.assertFalse(list.equals(list1));
    }

    @Test
    public void hashCodeTest() {
        NewLinkedList<Integer> list = new NewLinkedList<>();
        list.add(1, 0);
        list.add(2, 1);
        NewLinkedList<Integer> list1 = new NewLinkedList<>();
        list1.add(1, 0);
        list1.add(2, 1);
        Assert.assertEquals(list.hashCode(), list1.hashCode());
        Assert.assertTrue(list.hashCode()==list1.hashCode());
        Assert.assertTrue(list.equals(list1)&&list1.equals(list));
    }

    @Test
    public void hashCodeSizeTest() {
        NewLinkedList<String> list = new NewLinkedList<>();
        list.add("A", 0);
        list.add("B", 1);
        Assert.assertEquals(list.hashCode(),list.hashCode());
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void hashCodeEmptyList(){
        NewLinkedList<Integer> list = new NewLinkedList<>(0);
        list.hashCode();
    }

    @Test
    public void hashCodeAfterChangesTest() {
        NewLinkedList<Integer> list = new NewLinkedList<>();
        list.add(1, 0);
        list.add(2, 1);
        NewLinkedList<Integer> list1 = new NewLinkedList<>();
        list1.add(1, 0);
        list1.add(2, 1);
        list1.add(3, 1);
        list1.remove(0);
        Assert.assertNotEquals(list.hashCode(), list1.hashCode());
    }

    @Test
    public void toStringTestForEmptyList() {
        NewLinkedList<String> list = new NewLinkedList<>();
        Assert.assertTrue(list.toString() == "Empty list");
    }

    @Test
    public void toStringTest() {
        NewLinkedList<String> list = new NewLinkedList<>();
        list.add("A", 0);
        list.add("B", 1);
        Assert.assertEquals("NewLinkedList [A, B]", list.toString());
        NewLinkedList<Integer> list1 = new NewLinkedList<>();
        list1.add(1, 0);
        list1.add(2, 1);
        Assert.assertEquals("NewLinkedList [1, 2]", list1.toString());
    }
}

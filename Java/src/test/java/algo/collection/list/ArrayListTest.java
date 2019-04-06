package algo.collection.list;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ArrayListTest {
    private ArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new ArrayList<>();
    }

    @Test
    public void testAddItemsToList() {
        int n = 50;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        assertEquals(n, list.size());
        for (int i = 0; i < n; i++) {
            assertEquals(Integer.valueOf(i), list.get(i));
        }
    }

    @Test
    public void testRemoveElementInList() {
        list = new ArrayList<>(10);
        Integer[] initialValues = {1, 2, 3, 4, 5};
        Integer[] finalValues = {1, 2, 4, 5};

        for(int v : initialValues) {
            list.add(v);
        }

        for (int i = 0; i < initialValues.length; i++) {
            assertEquals(initialValues[i], list.get(i));
        }

        list.remove(2);
        assertEquals(finalValues.length, list.size());
        for (int i = 0; i < finalValues.length; i++) {
            assertEquals(finalValues[i], list.get(i));
        }
    }

    @Test
    public void testListExpansion() {
        list = new ArrayList<>(10);
        int n = 50;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        assertEquals(n, list.size());
        for (int i = 0; i < n; i++) {
            assertEquals(Integer.valueOf(i), list.get(i));
        }
    }

    @Test
    public void testListShrinking() throws NoSuchFieldException, IllegalAccessException {
        int size = 100;
        int n = 10;
        list = new ArrayList<>(size);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        list.remove(5);
        assertEquals(n-1, list.size());

        Class aClass = ArrayList.class;
        Field dataField = aClass.getDeclaredField("data");
        dataField.setAccessible(true);
        Object[] data = (Object[]) dataField.get(list);
        assertEquals(size/2, data.length);
    }

}
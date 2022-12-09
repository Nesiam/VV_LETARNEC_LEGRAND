package fr.istic.vv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


class BinaryHeapTest {

    ComparatorTest comp = new ComparatorTest();
    List<String> listFilled = new ArrayList<>(Arrays.asList("4","1","2","3","5"));
    List<String> listFull = new ArrayList<>(Arrays.asList("3","2","1","bc","4","5","7","6"));
    List<String> singleton = new ArrayList<>(Arrays.asList("a"));
    BinaryHeap empty = new BinaryHeap(8);

    BinaryHeapTest() throws Exception {
    }

    // Test Constructor

    public BinaryHeap create(List<String> L) throws Exception {
        BinaryHeap heap = new BinaryHeap(8);
        for (String s : L){
            heap.push(s);
        }
        return heap;
    }

    // Constructor related tests
    @Test
    public void capacityNegConstructor1() throws Exception {
        Assertions.assertThrows(Exception.class, () -> new BinaryHeap<>(comp,-5), "Given capacity is negative");
    }

    @Test
    public void capacityNegConstructor2() throws Exception {
        Assertions.assertThrows(Exception.class, () -> new BinaryHeap(-5),"Given capacity is negtive");
    }

    // Pop related tests
    @Test
    public void popHeapEmpty() throws Exception {
        Assertions.assertThrows(IllegalStateException.class, () -> empty.pop(),"Heap is empty");
    }

    @Test
    public void popHeap1() throws Exception {
        BinaryHeap filled = create(listFilled);
        Object popValue = filled.pop();
        assertTrue(popValue == "1","pop failed got " + popValue +" instead of 1");
    }

    @Test
    public void popHeap2() throws Exception {
        BinaryHeap filled = create(listFilled);
        filled.pop();
        List<String> data = Arrays.asList("2","3","5","4");
        assertTrue(filled.getData().equals(data),"data" + data + "pop" + filled.getData());
    }


    // Peek related test
    @Test
    public void peekHeapEmpty() throws Exception {
        Assertions.assertThrows(IllegalStateException.class, () -> empty.peek(),"Heap is empty");
    }

    @Test
    public void peekHeap() throws Exception {
        BinaryHeap filled = create(listFilled);
        assertTrue(filled.peek() == "1");
    }

    // Push Related test
    @Test
    public void pushHeapFull() throws Exception {
        BinaryHeap full = create(listFull);
        Assertions.assertThrows(IllegalStateException.class, () -> full.push("tests"),"Heap is full");
    }

    @Test
    public void pushHeap1() throws Exception {
        BinaryHeap filled = create(listFilled);
        int size = filled.getSize();
        filled.push("tests");
        assertTrue(filled.getSize() == size + 1);
    }

    @Test
    public void pushHeap2() throws Exception {
        BinaryHeap filled = create(listFilled);
        List<String> data = filled.getData();
        data.add("tests");
        filled.push("tests");
        assertTrue(filled.getData().equals(data));
    }

    // Less related test
    @Test
    public void lessIndicesNeg1() throws Exception {
        BinaryHeap filled = create(listFilled);
        Assertions.assertThrows(IllegalStateException.class, () -> filled.less(-5,-1),"Given indices are negative");
    }

    @Test
    public void lessIndicesNeg2() throws Exception {
        BinaryHeap filled = create(listFilled);
        Assertions.assertThrows(IllegalStateException.class, () ->filled.less(-5,1),"Given indices are negative");
    }

    @Test
    public void lessIndicesNeg3() throws Exception {
        BinaryHeap filled = create(listFilled);
        Assertions.assertThrows(IllegalStateException.class, () -> filled.less(5,-1),"Given indices are negative");
    }

    @Test
    public void lessIndicesOufOfBounds1() throws Exception {
        BinaryHeap filled = create(listFilled);
        Assertions.assertThrows(IllegalStateException.class, () -> filled.less(20,30),"Given indices are negative");
    }

    @Test
    public void lessIndicesOufOfBounds2() throws Exception {
        BinaryHeap filled = create(listFilled);
        Assertions.assertThrows(IllegalStateException.class, () -> filled.less(20,3),"Given indices are negative");
    }

    @Test
    public void lessIndicesOufOfBounds3() throws Exception {
        BinaryHeap filled = create(listFilled);
        Assertions.assertThrows(IllegalStateException.class, () -> filled.less(2,30),"Given indices are negative");
    }


    // ParentOf related test
    @Test
    public void parentIndiceNeg() throws Exception {
        BinaryHeap filled = create(listFilled);
        Assertions.assertThrows(IllegalStateException.class, () -> filled.parentOf(-2),"Given indice is negative");
    }

    @Test
    public void parentIndiceOufOfBounds() throws Exception {
        BinaryHeap filled = create(listFilled);
        Assertions.assertThrows(IllegalStateException.class, () -> filled.parentOf(20),"Given indice is out of bounds");
    }

    @Test
    public void parentOf2() throws Exception {
        BinaryHeap filled = create(listFilled);
        assertEquals(1, filled.parentOf(4));
    }

    // LeftChild related test
    @Test
    public void leftIndiceNeg() throws Exception {
        BinaryHeap filled = create(listFilled);
        Assertions.assertThrows(IllegalStateException.class, () ->filled.leftChild(-2),"Given indice is negative");
    }


    @Test
    public void leftIndiceOufOfBounds() throws Exception {
        BinaryHeap filled = create(listFilled);
        Assertions.assertThrows(IllegalStateException.class, () ->filled.leftChild(20),"Given indice is negative");
    }

    @Test
    public void leftChild() throws Exception {
        BinaryHeap filled = create(listFilled);
        assertEquals(3,filled.leftChild(1));
    }

    // RightChild related test
    @Test
    public void rightIndiceNeg() throws Exception {
        BinaryHeap filled = create(listFilled);
        Assertions.assertThrows(IllegalStateException.class, () -> filled.rightChild(-2),"Given indice is negative");
    }

    @Test
    public void rightIndiceOufOfBounds() throws Exception {
        BinaryHeap filled = create(listFilled);
        Assertions.assertThrows(IllegalStateException.class, () -> filled.rightChild(20),"Given indice is negative");
    }

    @Test
    public void rightChild() throws Exception {
        BinaryHeap filled = create(listFilled);
        assertEquals(4,filled.rightChild(1));
    }

}
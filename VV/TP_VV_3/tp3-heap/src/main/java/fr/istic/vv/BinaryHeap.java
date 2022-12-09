package fr.istic.vv;

import com.sun.tools.javac.Main;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.*;


class BinaryHeap<T> {

    private List<T> data;
    private int size;
    private int capacity;
    Comparator<T> comparator = null;


    public int getSize(){return this.size;}

    public List<T> getData(){return this.data;}
    public BinaryHeap(Comparator<T> comp, int cap) throws Exception{
        if (cap <1) {throw new Exception("Given capacity is negtive");}
        data = new ArrayList<>(cap);
        size = 0;
        comparator=comp;
        this.capacity=cap;
    }

    public BinaryHeap(int cap) throws Exception{
        if (cap <1) {throw new Exception("Given capacity is negtive");}
        data = new ArrayList<>(cap);
        size = 0;
        this.capacity=cap;
    }

    public BinaryHeap( List<T> L, int cap){
        size = 0;
        data = L;
        this.capacity=cap;
    }

    public BinaryHeap(BinaryHeap<T> heap){
        this.data = heap.data;
        this.size = heap.size;
        this.comparator=heap.comparator;
        this.capacity=heap.capacity;
    }

    public T pop() throws IllegalStateException{
        // Checking heap capacity
        if (this.size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        // Save the minimum element
        T min = data.get(0);
        // Move the last element to the root of the heap
        data.set(0, data.get(size - 1));
        size--;

        // Sort the new heap
        int current = 0;
        while (true) {
            int left = leftChild(current);
            int right = rightChild(current);

            // Find the minimum of the current element and its children
            int minIndex = current;
            if (left < size && less(left, minIndex)){
                minIndex = left;
            }
            if (right < size && less(right, minIndex)){
                minIndex = right;
            }

            // If the current element is already the minimum, we are done
            if (minIndex == current) {
                break;
            }

            // Otherwise, swap the current element with the minimum element and update the current index
            T temp = data.get(current);
            data.set(current,data.get(minIndex));
            data.set(minIndex,  temp);
            current = minIndex;
        }

        data.remove(size);
        return min;
    }

    public T peek() {
        if (this.size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return data.get(0); }

    public void push(T element) {
        // Checking heap capacity
        if (this.size == capacity) {
            throw new IllegalStateException("Heap is full");
        }
        // Add element
        data.add(element);
        this.size++;

        // Sort the new element
        int newElem = size-1;
        int parent = parentOf(newElem);

        while (newElem > 0 && less(newElem, parent)){
            // Swap the new element with its parent
            T temp = data.get(newElem);
            data.set(newElem,data.get(parent));
            data.set(parent,temp);

            // Update the current and parent indices
            newElem = parent;
            parent = parentOf(newElem);
        }
    }

    public int count() { return data.size(); }

    public boolean less(int i, int j) {
        if (i < 0 || j< 0) {
            throw new IllegalStateException("Given indices are negative");
        }
        if (i > size || j > size) {
            throw new IllegalStateException("Given indices are out of bound");
        }
        if (comparator == null) {
            return ((Comparable<T>) data.get(i)).compareTo(data.get(j)) < 0;
        } else {
            return comparator.compare(data.get(i), data.get(j)) < 0;
        }
    }

    public int parentOf(int i) {
        if (i < 0 ) {
            throw new IllegalStateException("Given indice is negative");
        }
        if (i > size) {
            throw new IllegalStateException("Given indice is out of bounds");
        }
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        if (i < 0 ) {
            throw new IllegalStateException("Given indice is negative");
        }
        if (i > size) {
            throw new IllegalStateException("Given indice is out of bounds");
        }
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        if (i < 0 ) {
            throw new IllegalStateException("Given indice is negative");
        }
        if (i > size) {
            throw new IllegalStateException("Given indice is out of bounds");
        }
        return 2 * i + 2;
    }

}
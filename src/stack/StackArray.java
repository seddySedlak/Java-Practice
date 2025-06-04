package stack;

public class StackArray implements StackInterface {
    private int[] data;
    private int freeIndex;

    public StackArray(int initialCapacity) {
        this.freeIndex = 0;
        data = new int[initialCapacity];
    }

    public void push(int toInsert) {
        if (freeIndex == data.length) {
            expandArray();
        }
        data[freeIndex] = toInsert;
        freeIndex++;
    }

    public int pop() {
        if (freeIndex <= 0) {
            return -1;
        }
        int toReturn = data[freeIndex-1];
        freeIndex--;
        return toReturn;
    }

    public int peek(){
        return data[freeIndex-1];
    }

    private void expandArray(){
        int[] newArray = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }
}

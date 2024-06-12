public class ArrayDeque<T> {

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        nextFirst = items.length - 1;
        nextLast = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return nextLast - nextFirst == 0
                || nextFirst - nextLast == items.length - 1;
    }

    private void resizeLonger(boolean flag) {
        T[] newItems = (T[]) new Object[2 * items.length];
        int start = nextFirst;
        if (flag) {
            start = movePointer(start, true);
        }
        System.arraycopy(items, start, newItems, 0, items.length - start);
        System.arraycopy(items, 0, newItems, items.length - start, start + size - items.length);
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    private int movePointer(int pointer, boolean direction) {
        if (direction) {
            pointer++;
            if (pointer == items.length) {
                pointer = 0;
            }
        } else {
            pointer--;
            if (pointer < 0) {
                pointer = items.length - 1;
            }
        }
        return pointer;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        size++;
        if (nextFirst == nextLast) {
            resizeLonger(false);
        } else {
            nextFirst = movePointer(nextFirst, false);
        }
    }

    public void addLast(T item) {
        items[nextLast] = item;
        size++;
        if (nextFirst == nextLast) {
            resizeLonger(true);
        } else {
            nextLast = movePointer(nextLast, true);
        }
    }

    private void resizeShorter() {
        T[] newItems = (T[]) new Object[items.length / 2];
        int start = movePointer(nextFirst, true);
        System.arraycopy(items, start, newItems, 0, newItems.length - start);
        if (start + size - items.length > 0) {
            System.arraycopy(items, 0, newItems, newItems.length - start, start + size - items.length);
        }
        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public void removeFirst() {
        if (size == 0) {
            return;
        }
        nextFirst = movePointer(nextFirst, true);
        items[nextFirst] = null;
        size--;
        if (items.length * 0.25 >= size) {
            resizeShorter();
        }
    }

    public void removeLast() {
        if (size == 0) {
            return;
        }
        nextLast = movePointer(nextLast, false);
        items[nextLast] = null;
        size--;
        if (items.length * 0.25 >= size) {
            resizeShorter();
        }
    }

    public void printDeque() {
        for (int i = nextFirst + 1; i < nextFirst + size; i++) {
            if (i < items.length) {
                System.out.printf("%s ", items[i]);
            } else {
                System.out.printf("%s ", items[i - items.length]);
            }
        }
        if (nextLast == 0) {
            System.out.println(items[items.length - 1]);
        } else {
            System.out.println(items[nextLast - 1]);
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int i = nextFirst + 1 + index;
        if (i > items.length) {
            i -= items.length;
        }
        return items[i];
    }

    public static void main(String[] args) {
        
    }

}

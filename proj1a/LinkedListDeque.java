public class LinkedListDeque<T> {

    private static class ItemNode<T> {
        T item;
        ItemNode<T> prev;
        ItemNode<T> next;

        ItemNode(T item, ItemNode<T> prev, ItemNode<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        ItemNode() {
            this.item = null;
            this.prev = this;
            this.next = this;
        }
    }

    private int size;
    private final ItemNode<T> sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new ItemNode<>();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    public void addFirst(T item) {
        sentinel.next = new ItemNode<>(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    public void addLast(T item) {
        sentinel.prev = new ItemNode<>(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        ItemNode<T> firstNode = sentinel.next;
        sentinel.next = firstNode.next;
        sentinel.next.prev = sentinel;
        size--;
        return firstNode.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        ItemNode<T> lastNode = sentinel.prev;
        sentinel.prev = lastNode.prev;
        sentinel.prev.next = sentinel;
        size--;
        return lastNode.item;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        ItemNode<T> nodeP = sentinel.next;
        int i = 0;
        while (i < index) {
            nodeP = nodeP.next;
            i++;
        }
        return nodeP.item;
    }

    private T getRecursiveHelper(ItemNode<T> nodeP, int index) {
        if (index < 0) {
            return nodeP.item;
        }
        return getRecursiveHelper(nodeP.next, index - 1);
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getRecursiveHelper(sentinel, index);
    }

    public void printDeque() {
        if (size == 0) {
            System.out.println();
            return;
        }
        ItemNode<T> nodeP = sentinel;
        while (nodeP.next.next != sentinel) {
            nodeP = nodeP.next;
            System.out.printf("%s ", nodeP.item);
        }
        System.out.println(nodeP.next.item);
    }

}

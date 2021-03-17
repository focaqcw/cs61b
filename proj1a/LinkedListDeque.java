public class LinkedListDeque<T> {
    private class StuffNode {
        private T item;
        private StuffNode next;
        private StuffNode prev;

        StuffNode(T i, StuffNode p, StuffNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

//    public LinkedListDeque(T item) {
//        sentinel = new StuffNode(null, null, null);
//        StuffNode firstItem = new StuffNode(item, sentinel, sentinel);
//        sentinel.next = firstItem;
//        sentinel.prev = firstItem;
//        size = 1;
//    }

    public void addFirst(T item) {
        StuffNode newFirst = new StuffNode(item, sentinel, sentinel.next);
        sentinel.next.prev = newFirst;
        sentinel.next = newFirst;

        if (sentinel.prev == sentinel) {
            sentinel.prev = newFirst;
        }

        size += 1;
    }
    public void addLast(T item) {
        StuffNode newLast = new StuffNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = newLast;
        sentinel.prev = newLast;

        if (sentinel.next == sentinel) {
            sentinel.next = newLast;
        }

        size += 1;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
    public void printDeque() {
        if (size > 0) {
            StuffNode currNode = sentinel.next;
            System.out.print(currNode.item + " ");
            while (currNode.next != sentinel) {
                currNode = currNode.next;
                System.out.print(currNode.item + " ");
            }
            System.out.print('\n');
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        StuffNode temp = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = temp.next;

        size -= 1;
        return temp.item;

    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        StuffNode temp = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = temp.prev;

        size -= 1;
        return temp.item;
    }
    public T get(int index) {
        int curr = 0;
        StuffNode currNode = sentinel.next;
        while (curr < index) {
            currNode = currNode.next;
            curr += 1;
        }
        return currNode.item;
    }

    private StuffNode getRecursiveHelper(int index) {
        if (index >= size) {
            return sentinel;
        }
        if (index == 0) {
            return sentinel.next;
        } else {
            return getRecursiveHelper(index - 1).next;
        }

    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index).item;

    }
}

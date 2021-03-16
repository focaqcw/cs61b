public class LinkedListDeque<T> {
    private class StuffNode {
        public T item;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode(T i, StuffNode p, StuffNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null,null);
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel = new StuffNode(null, null,null);
        StuffNode first_item = new StuffNode(item, sentinel,sentinel);
        sentinel.next = first_item;
        sentinel.prev = first_item;
        size = 1;
    }

    public void addFirst(T item){
        StuffNode new_first = new StuffNode(item, sentinel, sentinel.next);
        sentinel.next.prev = new_first;
        sentinel.next= new_first;
        size += 1;
    }
//    public void addLast(T item):
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
//    public void printDeque(): Prints the items in the deque from first to last, separated by a space.
//    public T removeFirst(): Removes and returns the item at the front of the deque. If no such item exists, returns null.
//    public T removeLast(): Removes and returns the item at the back of the deque. If no such item exists, returns null.
//    public T get(int index): Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
}
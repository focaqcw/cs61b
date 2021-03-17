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
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
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

        if (sentinel.prev == sentinel){
            sentinel.prev = new_first;
        }

        size += 1;
    }
    public void addLast(T item){
        StuffNode new_last = new StuffNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = new_last;
        sentinel.prev = new_last;

        if (sentinel.next == sentinel){
            sentinel.next = new_last;
        }

        size += 1;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }
    public void printDeque(){
        if (size > 0){
            StuffNode curr_node = sentinel.next;
            System.out.print(curr_node.item + " ");
            while (curr_node.next != sentinel){
                curr_node = curr_node.next;
                System.out.print(curr_node.item + " ");
            }
            System.out.print('\n');
        }
    }

    public T removeFirst(){
        if (size == 0){
            return null;
        }

        StuffNode temp = sentinel.next;
        sentinel.next.next.prev = sentinel;
        sentinel.next = temp.next;

        size -= 1;
        return temp.item;

    }
    public T removeLast(){
        if (size == 0){
            return null;
        }

        StuffNode temp = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = temp.prev;

        size -= 1;
        return temp.item;
    }
    public T get(int index){
        int curr = 0;
        StuffNode curr_node = sentinel.next;
        while(curr < index){
            curr_node = curr_node.next;
            curr += 1;
        }
        return curr_node.item;
    }

    public StuffNode getRecursiveHelper(int index){
        if(index >= size){
            return sentinel;
        }
        if(index == 0){
            return sentinel.next;
        }else{
            return getRecursiveHelper(index-1).next;
        }

    }

    public T getRecursive(int index){
        return getRecursiveHelper(index).item;

    }
}
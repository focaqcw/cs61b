public class ArrayDeque<T> {
    public T[] items;
    public int size;


    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    public void addFirst(T item) {

        if (size == items.length) {
            resize(size + 1);
        }
        System.arraycopy(items, 0, items, 1, size);

        items[0] = item;
        size = size + 1;
//        System.out.println(items[0]);
//        System.out.println(items[1]);
    }

    public void addLast(T item){
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = item;
        size = size + 1;
//        System.out.println(items[0]);
//        System.out.println(items[1]);

    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        for (int i = 0; i < size; i ++){
            System.out.println(items[i]);
        }
    }
    public T removeFirst(){
        T first = items[0];
        System.arraycopy(items, 1, items, 0, size-1);
        size -=1;

        if (size < items.length / 4){
            resize(items.length * 2);
        }

        return first;
    }
    public T removeLast(){
        size -=1;

        T last = items[size];
        if (size < items.length / 4){
            resize(items.length * 2);
        }

        return last;

    }
    public T get(int index){
        if (index >= size){
            return null;
        }

        return items[index];
    }

}
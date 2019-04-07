public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public void addFirst(E e){
        add(0, e);
    }
    public void addLast(E e){
       add(size, e);
    }

    public void add(int index, E e){
        if(index > size || index < 0){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");
        }
        if(size == data.length){
            resize(2 * data.length);
        }
        for(int i = size - 1; i >= index; i --){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;

    }
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(data.length - 1);
    }

    void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
    }

    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        E result = data[index];
        for(int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null; //loitering objects != memory leak
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return result;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array: size = %d, capacity = %d\n",size,data.length));
        result.append("[");
        for(int i = 0; i < size; i++){
            result.append(data[i]);
            if(i != size - 1){
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < data.length; i++){
            newData[i] = data[i];
        }
        data = newData;
     }
}

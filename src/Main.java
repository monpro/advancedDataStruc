public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array();
        for(int i = 0; i < 10; i++){
            array.addLast(i);
        }
        array.addLast(13);
        System.out.println(array);
    }
}

package Tree;

public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        /**
        if(root == null){
            root = new Node(e);
            size ++;
        }
        else {
            add(root,e);
        }
         **/
        root = addReturn(root, e);
    }

    //insert e into the binary tree with node root
    private void add(Node node, E e){

        if(e.equals(node.e)){
            return;
        }
        else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size ++;
            return;
        }
        else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size ++;
            return;
        }
        if(e.compareTo(node.e) < 0){
            add(node.left,e);
        }else {
            add(node.right, e);
        }
    }

    //insert e into the binary tree with node root
    //return the root with inserting e
    private Node addReturn(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }
        if(e.compareTo(node.e) < 0){
            node.left = addReturn(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            node.right = addReturn(node.right, e);
        }
        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        }
        else if(e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else{
            return contains(node.right, e);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        generateBstString(root, 0, result);
        return result.toString();
    }

    private void generateBstString(Node node, int depth, StringBuilder result){
        if(node == null){
            result.append(generateDepthString(depth) + "null\n");
            return;
        }

        result.append(generateDepthString(depth) + node.e + "\n");
        generateBstString(node.left, depth + 1, result);
        generateBstString(node.right, depth + 1, result);
    }

    private String generateDepthString(int depth){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < depth; i++){
            result.append("--");
        }
        return result.toString();
    }



}

package generic;

/**
 * @author : lvcf on 2016/12/19 11:07
 * @Description : thinking in Java P357
 */
public class LinkedStack<T> {

    private Node top = new Node();//末端哨兵

    private  class Node{
        T item;
        Node next;
        Node(){
            item = null;
            next = null;
        }
        Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
        boolean end() {
            return item == null && next == null;
        }

    }


    public void push(T item){
        top = new Node(item,top);
    }

    public T pop(){
        T result = top.item;
        if(!top.end()){
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        linkedStack.push("123");
        System.out.println(linkedStack.pop());
    }
}

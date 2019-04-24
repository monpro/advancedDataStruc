package RemoveElements203;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("arr cannot be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1; i < arr.length; i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            result.append(cur.val + "->");
            cur = cur.next;
        }
        result.append("NULL");
        return result.toString();
    }
}
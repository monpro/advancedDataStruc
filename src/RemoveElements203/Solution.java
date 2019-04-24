package RemoveElements203;

class Solution {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if(head == null)
            return null;

        ListNode prev = head;
        while (prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            else{
                prev = prev.next;
            }
        }

        return head;
    }

    public ListNode removeElementsWithDummyHead(ListNode head, int val){
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while (prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }
            else{
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode removeElementsWithRecu(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        if(head.val == val){
            return head.next;
        }else{
            return head;
        }
    }


    public static void main(String[] args){
        int[] nums = {1,2,6,7,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode result = (new Solution()).removeElementsWithRecu(head,6);
        System.out.println(result);
    }
}
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

    public ListNode removeElementsWithRecu(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);
        if(head == null){
            System.out.print(depthString);
            System.out.println("Return " + head);
            return null;
        }
        ListNode result = removeElementsWithRecu(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + " : " + result);
        ListNode ret;
        if(head.val == val){
            ret = result;
        }else{
            head.next = result;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < depth; i++){
            result.append("--");
        }
        return result.toString();
    }
    public static void main(String[] args){
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
//        System.out.println(head);
        ListNode result = (new Solution()).removeElementsWithRecu(head,6, 0);
//        System.out.println(result);
    }
}
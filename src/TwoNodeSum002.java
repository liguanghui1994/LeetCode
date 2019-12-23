public class TwoNodeSum002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int curor = 0;
        while(l1 != null || l2 != null || curor != 0){
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            int sum = l1val + l2val + curor;
            current = current.next = new ListNode(sum%10);
            curor = sum / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return result.next;

    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

}

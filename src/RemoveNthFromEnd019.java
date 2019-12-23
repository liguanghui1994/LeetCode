public class RemoveNthFromEnd019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        if(n <= 0){
            return dump.next;
        }
        ListNode first = dump;
        ListNode second = dump;
        while(second != null){
            if(n <= 0) {
                first = first.next;
            }else{
                n--;
            }
            second = second.next;
            if(second.next == null){
                break;
            }
        }
        if(first != null && first.next != null) {
            first.next = first.next.next;
        }
        return dump.next;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        new RemoveNthFromEnd019().removeNthFromEnd(head, 2);
    }
}

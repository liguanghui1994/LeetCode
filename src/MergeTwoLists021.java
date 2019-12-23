public class MergeTwoLists021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);
        ListNode current = dump;
        while(l1 != null || l2 != null){
            if(l1 == null || l2 == null){
                current.next = l1 == null?l2:l1;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }else {
                if (l1.val < l2.val) {
                    //l1小，取l1
                    current.next = l1;
                    l1 = l1.next;
                } else {
                    current.next = l2;
                    l2 = l2.next;
                }
            }
            current = current.next;
        }
        if(current != null){
            current.next = null;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new MergeTwoLists021.ListNode(1);
        l1.next = new MergeTwoLists021.ListNode(2);
        l1.next.next = new MergeTwoLists021.ListNode(4);

        ListNode l2 = new MergeTwoLists021.ListNode(1);
        l2.next = new MergeTwoLists021.ListNode(2);
        l2.next.next = new MergeTwoLists021.ListNode(3);

        new MergeTwoLists021().mergeTwoLists(l1, l2);
    }

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

}

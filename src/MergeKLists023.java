public class MergeKLists023 {

    public static void main(String[] args) {


    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode first = head;
        generate(lists, first);
        return head.next;
    }

    private void generate(ListNode[] lists, ListNode first) {
        Integer temp_val = null;
        boolean not_all_null = false;
        int j = -1;
        for(int i = 0, len = lists.length; i < len; i++){
            ListNode temp_listnode = lists[i];
            if(temp_listnode != null){
                not_all_null = true;
                if(temp_val == null){
                    j = i;
                    temp_val = temp_listnode.val;
                    continue;
                }
                if(temp_listnode.val < temp_val){
                    temp_val = temp_listnode.val;
                    j = i;
                }
            }
        }
        if(j >= 0){
            first.next = lists[j];
            first = first.next;
            lists[j] = lists[j].next;
        }
        if(!not_all_null){
            return;
        }
        generate(lists, first);
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

}

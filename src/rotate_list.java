class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
public class rotate_list {
    public static ListNode rotateRight(ListNode head, int k) {
        if (k==0)
            return head;
        int len=0;
        ListNode index=head;
        ListNode last=head;
        ListNode res=head;
        while (index!=null){
            len++;
            index=index.next;
            if (len>k){
                res=res.next;
            }
            if (len>1){
                last=last.next;
            }
        }
        if (len==k)
            return head;
        if (len>k){
            ListNode res1=res.next;
            res.next=null;
            last.next=head;
            return res1;
        }
        k=k%len;
//        System.out.println(len);
        return rotateRight(head,k);
    }

    public static void main(String[] args) {
        ListNode a1=new ListNode(0);
        ListNode a2=new ListNode(1);
        ListNode a3=new ListNode(2);
        a1.next=a2;a2.next=a3;
        ListNode res=rotateRight(a1,4);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}

//public ListNode rotateRight(ListNode head, int n) {
//    if (head==null||head.next==null) return head;
//    ListNode dummy=new ListNode(0);
//    dummy.next=head;
//    ListNode fast=dummy,slow=dummy;
//
//    int i;
//    for (i=0;fast.next!=null;i++)//Get the total length
//        fast=fast.next;
//
//    for (int j=i-n%i;j>0;j--) //Get the i-n%i th node
//        slow=slow.next;
//
//    fast.next=dummy.next; //Do the rotation
//    dummy.next=slow.next;
//    slow.next=null;
//
//    return dummy.next;
//}

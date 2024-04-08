package Tree.Blind75.LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        one.next.next = three;
        one.next.next.next = four;
        one.next.next.next.next = five;

        ListNode node = reverseList(one);
        while(node != null) {
            if(node.next != null) {
                System.out.print(node.val + "->");
            } else {
                System.out.print(node.val);
            }
            node = node.next;
        }

    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }

        ListNode next = null;
        ListNode curr = head;
        ListNode previous = null;

        while(curr != null) {
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }

        head = previous;
        return head;
    }
}
class ListNode {
 int val;
 ListNode next;

 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

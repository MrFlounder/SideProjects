package Util;

/**
 * Created by guangshuozang on 7/4/17.
 */
public class ListNode {
    public int value;
    public ListNode next;
    public ListNode(int value) {
        this.value = value;
        next = null;
    }
    public static ListNode fromArray(int[] array) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int i = 0;
        while (i < array.length) {
            cur.next = new ListNode(array[i++]);
            cur = cur.next;
        }
        return dummy.next;
    }
    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.value);
            System.out.print(" -> ");
            head = head.next;
        }
        System.out.println("");
    }
}

package class3;

import Util.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by guangshuozang on 7/4/17.
 */
public class ReOrderLinkedList {


        public ListNode reorder(ListNode head) {
            // Write your solution here.
            if (head == null || head.next == null) {
                return head;
            }
            ListNode.print(head);
            ListNode slow = head, fast = head, prev = slow;
            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            prev.next = null;
            ListNode.print(head);
            ListNode head2 = reverse(slow);
            ListNode.print(head2);
            ListNode ret = head;
            merge(head, head2);
            ListNode.print(ret);
            return ret;
        }
        private void merge(ListNode head, ListNode head2) {
            ListNode p = head;
            ListNode prev = head;
            while (head != null && head2 != null) {
                ListNode.print(p);
                prev = head2;
                ListNode temp = head.next;
                head.next = head2;
                ListNode temp2 = head2.next;
                head2.next = temp;
                head = temp;
                head2 = temp2;
                ListNode.print(p);
            }
            while (head2 != null) {
                ListNode.print(p);
                prev.next = head2;
                head2 = head2.next;
            }
        }
        private ListNode reverse(ListNode head) {
            ListNode prev = new ListNode(0);
            ListNode end = head;
            prev.next = head;
            while (head != null) {
                ListNode temp = head.next;
                ListNode temp2 = head;
                head.next = prev;
                head = temp;
                prev = temp2;
            }
            end.next = null;
            return prev;
        }

    public static void main(String[] arg) {
        ReOrderLinkedList ins = new ReOrderLinkedList();
        System.out.println(ins.reorder(ListNode.fromArray(new int[] {1})));
    }
    }



package LinkedListPractice;

public class Length {
    public int length(ListNode head) {
        // corner case
        if (head == null) {
            return 0;
        }

        int len = 0;
        while (head != null) {
            len ++;
            head = head.next;
        }
        return len;
    }
}

package LinkedListPractice;

public class GetIndex {
    public int get(ListNode head, int index) throws Exception{
        if (index < 0 || index > 10) { // length(head)
//            throw IndexOutOfBoundsException;
        }
        if (head == null) {
//            throw TypeNotPresentException;
        }

        ListNode curNode = head;
        while (index > 0 && head != null) {
            head = head.next;
            index--;
        }
        if (head != null) {
            return head.value;
        } else {
//            throw IndexOutOfBoundsException;
        }
        return head.value;
    }
}

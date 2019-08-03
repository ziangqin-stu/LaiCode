package Queue_Stacks;

public class MyQueue_LinkedList {
    private ListNode head;
    private ListNode tail;

    public MyQueue_LinkedList() {
        this.head = this.tail = null;
    }

    public Integer poll() {
        // remove at head
        if (head == null) {
            return null;
        }
        ListNode node = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        node.next = null;
        return node.value;
    }

    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public void offer(int val) {
        // insert at tail
        if (head == null) {
            head = new ListNode(val);
            tail = head;
        }
        tail.next = new ListNode(val);
    }
}

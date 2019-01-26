package algorithm;

public class LinkListApart {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void relocate(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node mid = head;
        Node right = head.next;
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head, right);
    }

    private static void mergeLR(Node head, Node mid) {
        Node next = null;
        while (head.next != null) {
            next = mid.next;
            mid.next = head.next;
            head.next = mid;
            head = mid.next;
            mid = next;
        }
        head.next = mid;
    }

    public static void printLinkedList(Node head) {
        System.out.println("Linked List:");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        relocate(head);
        printLinkedList(head);

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        relocate(head);
        printLinkedList(head);


        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        relocate(head);
        printLinkedList(head);


        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        relocate(head);
        printLinkedList(head);
    }
}

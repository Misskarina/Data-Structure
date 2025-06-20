public class MergesortDll{
    static class Node {
        int data;
        Node next;
        Node prev;

        Node() {
        };

        Node(int num) {
            data = num;
            next = null;
            prev = null;
        }
    };

    public static Node sort(Node head) {
        if (head == null) {
            return head;
        }
       if (head.next == null){
            return head;
        }

        head = mergeSort(head);
        return head;
    }

    public static Node mergeSort(Node dnode) {
        if (dnode == null || dnode.next == null) {
            return dnode;
        }

        Node mid = getMidNode(dnode);
        Node next = mid.next;
        mid.next = null;

        Node l1 = mergeSort(dnode);
        Node l2 = mergeSort(next);

        return merge(l1, l2);
    }

    public static Node merge(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.data <= list2.data) {
            list1.next = merge(list1.next, list2);
            list1.next.prev = list1;
            list1.prev = null;
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            list2.next.prev = list2;
            list2.prev = null;
            return list2;
        }
    }

    public static Node getMidNode(Node node) {
        Node slow = node;
        Node fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(4);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(6);

        head = sort(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
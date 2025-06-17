package dsa;

class Node {
    int data;
    Node next;
    Node(int d) { data = d; }
}

public class EvenOddList {
    Node head;

    void append(int data) {
        Node n = new Node(data);
        if (head == null) { head = n; return; }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = n;
    }

    void segregateEvenOdd() {
        Node evenHead = null, evenTail = null, oddHead = null, oddTail = null, curr = head;

        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (evenHead == null) evenHead = evenTail = curr;
                else { evenTail.next = curr; evenTail = evenTail.next; }
            } else {
                if (oddHead == null) oddHead = oddTail = curr;
                else { oddTail.next = curr; oddTail = oddTail.next; }
            }
            curr = curr.next;
        }

        if (evenHead == null) head = oddHead;
        else {
            evenTail.next = oddHead;
            if (oddTail != null) oddTail.next = null;
            head = evenHead;
        }
    }

    void printList() {
        for (Node temp = head; temp != null; temp = temp.next)
            System.out.print(temp.data + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        EvenOddList list = new EvenOddList();
        int[] arr = {17, 15, 8, 12, 10, 5, 4};
        for (int i : arr) list.append(i);

        System.out.println("Before:");
        list.printList();
        list.segregateEvenOdd();
        System.out.println("After Even-Odd Segregation:");
        list.printList();
    }
    
    
}

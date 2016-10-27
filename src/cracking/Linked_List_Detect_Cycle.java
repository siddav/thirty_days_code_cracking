package cracking;

public class Linked_List_Detect_Cycle {
    class Node {
        int data;
        Node next;
    }

    public static boolean hasCycle(Node node) {
        if (node == null)
            return false;
        Node slow = node;
        Node fast = node.next;
        while (slow != null && fast != null && fast.next != null) {
            if (fast.next == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}

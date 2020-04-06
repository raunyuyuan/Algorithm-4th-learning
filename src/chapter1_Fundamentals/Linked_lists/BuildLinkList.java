package chapter1_Fundamentals.Linked_lists;

public class BuildLinkList<Item> {
    // 增删效率快 但是随机查找慢
    private static class Node<Item> {
        Item item;
        Node next;
    }

    public static void main(String args[]) {
        Node<String> first = new Node<String>();
        Node<String> second = new Node<String>();
        Node<String> third = new Node<String>();

        first.item = "to";
        second.item =  "be";
        third.item = "or";
        first.next = second;
        second.next = third;
    }
}

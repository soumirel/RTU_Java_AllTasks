package rtu.task32_my;

public class ListNode {
    ListNode next;
    MenuItem menuItem;

    public ListNode(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public ListNode(MenuItem menuItem, ListNode next) {
        this.menuItem = menuItem;
        this.next = next;
    }

    public MenuItem getItem() {
        return menuItem;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}



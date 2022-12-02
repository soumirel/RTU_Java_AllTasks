package rtu.task32_my;

public class InternetOrdersManager implements OrdersManager {
    private QueueNode head;
    private QueueNode tail;
    private int size;

    public InternetOrdersManager() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean add(Order order) {
        QueueNode node = new QueueNode();
        node.value = order;
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
        return true;
    }

    public boolean remove(Order order) {
        QueueNode node = head;
        while (node != null) {
            if (node.value.equals(order)) {
                if (node.prev != null) {
                    node.prev.next = node.next;
                } else {
                    head = node.next;
                }
                if (node.next != null) {
                    node.next.prev = node.prev;
                } else {
                    tail = node.prev;
                }
                size--;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public Order order() {
        return head.value;
    }

    public QueueNode head() {
        return head;
    }

    public int itemsQuantity(String itemName) {
        int quantity = 0;
        QueueNode node = head;
        while (node != null) {
            quantity += node.value.itemQuantity(itemName);
            node = node.next;
        }
        return quantity;
    }

    @Override
    public int itemsQuantity(MenuItem menuItem) {
        return itemsQuantity(menuItem.getName());
    }

    @Override
    public Order[] getOrders() {
        Order[] orders = new Order[size];
        QueueNode node = head;
        for (int i = 0; i < size; i++) {
            orders[i] = node.value;
            node = node.next;
        }
        return orders;
    }

    @Override
    public int ordersQuantity() {
        return size;
    }

    @Override
    public int ordersCostSummary() {
        int cost = 0;
        QueueNode node = head;
        while (node != null) {
            cost += node.value.getPrice();
            node = node.next;
        }
        return cost;
    }
}


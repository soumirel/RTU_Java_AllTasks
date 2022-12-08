package rtu.task32;

import java.util.ArrayList;

public class InternetOrder implements Order {
    private ListNode head;
    private ListNode tail;

    private int size;

    private Customer customer;

    public boolean add(MenuItem menuItem) {
        if (menuItem == null) {
            return false;
        }
        if (head == null) {
            head = new ListNode(menuItem);
            tail = head;
        } else {
            tail.next = new ListNode(menuItem);
            tail = tail.next;
        }
        size++;
        return true;
    }

    public boolean remove(MenuItem menuItem) {
        if (menuItem == null) {
            return false;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            if (current.menuItem.getName().equals(menuItem.getName())) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(String itemName) {
        if (itemName == null) {
            return false;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            if (current.menuItem.getName().equals(itemName)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public int removeAll(String name) {
        int removed = 0;
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            if (current.menuItem.getName().equals(name)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                removed++;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return removed;
    }

    public int itemQuantity() {
        return size;
    }

    public int itemQuantity(String name) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            if (current.menuItem.getName().equals(name)) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    public MenuItem[] getItems() {
        MenuItem[] itemsArray = new MenuItem[size];
        ListNode current = head;
        int i = 0;
        while (current != null) {
            itemsArray[i] = current.menuItem;
            current = current.next;
            i++;
        }
        return itemsArray;
    }

    public double getPrice() {
        double price = 0;
        ListNode current = head;
        while (current != null) {
            price += current.menuItem.getPrice();
            current = current.next;
        }
        return price;
    }

    public String[] itemNames() {
        ArrayList<String> names = new ArrayList<String>();
        ListNode current = head;
        while (current != null) {
            if (!names.contains(current.menuItem.getName())) {
                names.add(current.menuItem.getName());
            }
            current = current.next;
        }
        String[] namesArray = new String[names.size()];
        for (int i = 0; i < names.size(); i++) {
            namesArray[i] = names.get(i);
        }
        return namesArray;
    }

    public String[] getSortedItems() {
        ArrayList<String> names = new ArrayList<String>();
        ListNode current = head;
        while (current != null) {
            names.add(current.menuItem.getName());
            current = current.next;
        }
        String[] namesArray = new String[names.size()];
        for (int i = 0; i < names.size(); i++) {
            namesArray[i] = names.get(i);
        }
        return namesArray;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        String result = "";
        ListNode current = head;
        while (current != null) {
            result += current.menuItem.toString() + "\n";
            current = current.next;
        }
        result += "Итоговая стоимость: " + getPrice() + " $\n";
        result += "Клиент: " + customer.getFirstName() + " " + customer.getSecondName() + "\n";
        result += "Адресс: " + customer.getAddress();

        return result;
    }
}


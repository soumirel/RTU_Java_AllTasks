package rtu.task32;

import java.util.ArrayList;

public class TableOrder implements Order {
    private ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

    private int size;

    private Customer customer;

    public boolean add(MenuItem menuItem) {
        if (menuItem == null) {
            return false;
        }
        menuItems.add(menuItem);
        size++;
        return true;
    }

    public boolean remove(MenuItem menuItem) {
        if (menuItem == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (menuItems.get(i).getName().equals(menuItem.getName())) {
                menuItems.remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(String itemName) {
        if (itemName == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (menuItems.get(i).getName().equals(itemName)) {
                menuItems.remove(i);
                size--;
                return true;
            }
        }
        return false;
    }


    public int removeAll(String name) {
        int removed = 0;
        for (int i = 0; i < size; i++) {
            if (menuItems.get(i).getName().equals(name)) {
                menuItems.remove(i);
                size--;
                removed++;
            }
        }
        return removed;
    }

    public int itemQuantity() {
        return size;
    }

    public int itemQuantity(String name) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (menuItems.get(i).getName().equals(name)) {
                count++;
            }
        }
        return count;
    }

    public MenuItem[] getItems() {
        MenuItem[] itemsArray = new MenuItem[size];
        for (int i = 0; i < size; i++) {
            itemsArray[i] = menuItems.get(i);
        }
        return itemsArray;
    }

    public double getPrice() {
        double price = 0;
        for (int i = 0; i < size; i++) {
            price += menuItems.get(i).getPrice();
        }
        return price;
    }

    public String[] itemNames() {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            if (!names.contains(menuItems.get(i).getName())) {
                names.add(menuItems.get(i).getName());
            }
        }
        String[] namesArray = new String[names.size()];
        for (int i = 0; i < names.size(); i++) {
            namesArray[i] = names.get(i);
        }
        return namesArray;
    }

    public String[] getSortedItems() {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            names.add(menuItems.get(i).getName());
        }
        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < names.size() - 1; j++) {
                if (menuItems.get(j).getPrice() < menuItems.get(j + 1).getPrice()) {
                    String temp = names.get(j);
                    names.set(j, names.get(j + 1));
                    names.set(j + 1, temp);
                }
            }
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
        for (int i = 0; i < size; i++) {
            result += menuItems.get(i).toString() + "\n";
        }
        result += "Итоговая стоимость: " + getPrice() + " $\n";
        result += "Клиент: " + customer.getFirstName() + " " + customer.getSecondName() + "\n";
        result += "Адресс: " + customer.getAddress();

        return result;
    }
}



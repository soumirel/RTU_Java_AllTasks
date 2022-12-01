package rtu.task17;

public class Main {
    public static void main(String[] args) {
        Order order = new Order() {
            @Override
            public boolean add(Item item) {
                return false;
            }

            @Override
            public String[] itemsNames() {
                return new String[0];
            }

            @Override
            public int itemsQuantity() {
                return 0;
            }

            @Override
            public int itemQuantity(String itemName) {
                return 0;
            }

            @Override
            public int itemQuantity(Item itemName) {
                return 0;
            }

            @Override
            public Item[] getItems() {
                return new Item[0];
            }

            @Override
            public boolean remove(String ItemName) {
                return false;
            }

            @Override
            public boolean remove(Item ItemName) {
                return false;
            }

            @Override
            public int removeAll(String ItemName) {
                return 0;
            }

            @Override
            public int removeAll(Item ItemName) {
                return 0;
            }

            @Override
            public Item[] sortedItemsByCostDesc() {
                return new Item[0];
            }

            @Override
            public int costTotal() {
                return 0;
            }

            @Override
            public Customer getCustomer() {
                return null;
            }

            @Override
            public void setCustomer(Customer customer) {
            }
        };
        System.out.println("Adding item: " + order.add(null));
        System.out.println("Removing item: " + order.remove(""));
        System.out.println("Removing all: " + order.removeAll(""));
        System.out.println("Cost total: " + order.costTotal());
        System.out.println("Customer: " + order.getCustomer());
    }
}

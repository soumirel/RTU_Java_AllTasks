package rtu.task31;

enum OrderType {
    INTERNET,
    TABLE
}

public class Main {
    static final String[][] dishes = {
            {"Scrambled eggs", "5.5", "Beaten egg fried in a pan"},
            {"Shawarma", "3.9", "A Middle Eastern dish of spit-roasted meat wrapped in pita bread"},
            {"Avocado toast", "3.5", "Toast with avocado paste", "5.5"},
            {"Pancakes", "6.5", "A dish baked from batter in a frying pan."},
            {"Porridge", "3.0", "Oatmeal"},
            {"Sandwich", "2.9", "Two slices of bread with filling"},
            {"Eclair", "2.0", "Cake in the form of a tube of choux pastry covered with fudge"},
            {"Vegetable salad", "2.9", "A fresh vegetable salad"},
            {"Ice cream", "1.9", "2 chocolate scoops"},
            {"Syrniki", "6.0", "Slavic cottage cheese dish baked in a pan"},
    };

    private static Order GenerateRandomOrder(OrderType type) {
        Order order = null;
        if (type == OrderType.INTERNET) {
            order = new InternetOrder();
        } else {
            order = new TableOrder();
        }

        order.setCustomer(Customer.RandomCustomer());

        // Add 1-2 random dishes
        for (int i = 0; i < 1 + (int) (Math.random() * 2); i++) {
            String[] dish = dishes[(int) (Math.random() * dishes.length)];
            order.add(new Dish(dish[0], Double.parseDouble(dish[1]), dish[2]));
        }

        for (int i = 0; i < 1 + (int) (Math.random() * 3); i++) {
            DrinkTypeEnum drink = DrinkTypeEnum.values()[(int) (Math.random() * DrinkTypeEnum.values().length)];
            order.add(Drink.GetDrink(drink));
        }

        return order;
    }

    public static void main(String[] args) {
        TableOrdersManager tableOrdersManager = new TableOrdersManager();
        for (int i = 0; i < 2; i++) {
            tableOrdersManager.add((TableOrder) GenerateRandomOrder(OrderType.TABLE), i);
        }

        System.out.println("Оффлайн заказы:");
        System.out.println("--------------------");
        for (int i = 0; i < tableOrdersManager.ordersQuantity(); i++) {
            System.out.println("Столик " + i + ":\n" + tableOrdersManager.getOrder(i));
            System.out.println("--------------------");
        }

        System.out.println("Суммарная стоимость: " + tableOrdersManager.ordersCostSummary() + " $");

        System.out.println();

        InternetOrdersManager internetOrdersManager = new InternetOrdersManager();
        for (int i = 0; i < 2; i++) {
            internetOrdersManager.add(GenerateRandomOrder(OrderType.INTERNET));
        }

        System.out.println("Онлайн заказы:");
        QueueNode order = internetOrdersManager.head();
        System.out.println("--------------------");
        while (order != null) {
            System.out.println(order.value);
            order = order.next;
            System.out.println("--------------------");
        }

        System.out.println("Суммарная стоимость: " + internetOrdersManager.ordersCostSummary() + " $");

    }
}


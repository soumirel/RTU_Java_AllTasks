package rtu.task17;

public class Main
{
    /** Generates a random order.
     */
    private static RestaurantOrder generateOrder() {
        String[][] dishes = {
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

        String[][] drinks = {
                {"Coffee", "3.9", "A drink made from roasted and ground coffee beans"},
                {"Tea", "3.2", "Beverage obtained by boiling, brewing and/or infusing the leaf of the tea bush"},
                {"Soda", "2.0", "Soft drink made from mineral or ordinary water saturated with carbon dioxide"},
                {"Water", "1.5", "Pure water"},
                {"Juice", "3.9", "Apple juice"},
                {"Almond milk", "3.0", "A drink made from a mixture of ground, unroasted almonds and water. Lactose-free"},
                {"Nonalcoholic beer", "4.9", "Beer without alcohol"},
                {"Wine", "7.9", "Alcoholic beverage obtained by fermenting fresh grapes"},
        };

        RestaurantOrder order = new RestaurantOrder();
        for (int i = 0; i < 1 + (int)(Math.random() * 3); i++) {
            String[] newDish = dishes[(int)(Math.random() * dishes.length)];
            order.add(new Dish(newDish[0], Double.parseDouble(newDish[1]), newDish[2]));
        }

        for (int i = 0; i < 1 + (int)(Math.random() * 3); i++) {
            String[] newDrink = drinks[(int)(Math.random() * drinks.length)];
            order.add(new Drink(newDrink[0], Double.parseDouble(newDrink[1]), newDrink[2]));
        }

        return order;
    }

    public static void main(String[] args)
    {
        TablesOrdersManager orderManager = new TablesOrdersManager(10);

        // Add 4 random orders
        for (int i = 0; i < 3; i++) {
            RestaurantOrder newOrder = generateOrder();
            orderManager.add(newOrder, i);
        }

        System.out.println();
        System.out.println("Добавлено 3 случайно сгенерированных заказа");

        System.out.println("Добавление заказа на первый свободный стол");
        int firstFreeTable = orderManager.getFreeTableNumber();
        orderManager.add(generateOrder(), firstFreeTable);

        printAllOrders(orderManager);

        System.out.println();
        System.out.println("Удаление заказа с первого столика");
        orderManager.removeOrder(0);

        printAllOrders(orderManager);

        System.out.println();

        System.out.println("Свободные столики: " + orderManager.getFreeTableNumbers());
        System.out.println("Суммарная стоимость заказов всех столиков " + orderManager.getTotalOrdersCost() + " $");
        System.out.println("Всего заказов кофе: " + orderManager.getItemsAmount("Coffee"));

    }

    private static void printAllOrders(TablesOrdersManager orderManager)
    {
        System.out.println("Информация по всем столикам:");
        Order[] orders = orderManager.getOrders();
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null) {
                Order order = orders[i];
                System.out.println("-----------------------");
                System.out.println("Заказ столика " + i + ":");
                System.out.println(order);
                System.out.println("Стоимость заказа: " + order.getPrice() + '$');
            }
        }
        System.out.println("-----------------------");
    }
}


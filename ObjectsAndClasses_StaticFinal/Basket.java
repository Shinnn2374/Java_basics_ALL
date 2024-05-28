public class Basket {

    private String items = "";
    private static int price = 0;
    private int limit;
    private static int count = 0;
    private static int basketCount = 0;
    private static int totalCost = 0;
    private static int getBasketCount = 0;
    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
        getBasketCount();
    }
    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.price = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        this.count = count;
        this.price = price;
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (this.price + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        getTotalCount();
        getTotalCost();
    }
    public static int getTotalCost(){
        totalCost = totalCost + price * count;
        return totalCost;
    }
    public static int getTotalCount(){
        basketCount = basketCount + count;
        return basketCount;
    }
    public static int getMidlleCost(){
        int middleCost = totalCost / basketCount;
        System.out.println(middleCost);
        return middleCost;
    }
    public static int getMidlleCostBasket(){
        int middleCostBasket = totalCost / (Basket.getBasketCount() - 1);
        System.out.println(middleCostBasket);
        return middleCostBasket;
    }
    public static int getBasketCount(){
        getBasketCount = getBasketCount + 1;
        return getBasketCount;
    }


    public void clear() {
        items = "";
        price = 0;
    }

    public int getPrice() {
        return price;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}

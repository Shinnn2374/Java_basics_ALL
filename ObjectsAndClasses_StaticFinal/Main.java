public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("meat",100,5);
        basket.add("milk",80,5);
        basket.add("egg",30,20);
        System.out.println("\n");
        Basket basket1 = new Basket();
        basket1.add("kolbasa",500,1);
        basket1.add("chease",250,2);
        System.out.println("\n");
        Basket basket2 = new Basket();
        basket2.add("juce",500,1);
        basket2.add("icecream",250,2);
        System.out.println("\n");
        Basket basket3 = new Basket();
        basket3.add("sigi",250,2);
        basket3.add("hqd",1000,1);
        System.out.println("\n");
        System.out.println("\n");
        Basket.getMidlleCost();
        Basket.getMidlleCostBasket();
    }
}


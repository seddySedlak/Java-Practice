import java.util.ArrayList;

public class StoreManegement {
    ArrayList<String> storage;
    int storeBudget;
    String[] supplyKind;
    int[] prices;

    public StoreManegement(String[] supplyKind, int[] prices) {
        storage = new ArrayList<>();
        storeBudget = 10000;
        this.supplyKind = supplyKind;
        this.prices = prices;
    }

    void resupply(String item) {
        storage.add(item);
        storeBudget -= 500;
        System.out.println("Bylo pridano: " + storage.get(storage.size()-1));
    }

    void resupply(String[] items) {
        for (String item : items) {
            storage.add(item);
        }
    }

    void sell(String item) {
        if (storage.contains(item)) {
            storeBudget += 1000;
            System.out.println("Prodalo se:" + item);
        }
        else {
            System.out.println(item + "Neni na sklade");
        }
    }

    void shipOrder(String[] items) {
        for (String item : items) {
            sell(item);
        }
    }

    void run() {
        int operation;
        for (int i = 0; i < 100; i++) {
            operation = generateRandomNumber(0, 3);
            switch (operation) {
                case 0:
                    resupply(getRandomItem());
                    break;
                case 1:
                    String[] items = new String[5];
                    for (int j = 0; j < items.length; j++) {
                        items[j] = getRandomItem();
                    }
                    resupply(items);
                    break;
                case 2:
                    sell(getRandomItem());
                    break;
                case 3:
                    String[] itemsToSell = new String[5];
                    for (int j = 0; j < itemsToSell.length; j++) {
                        itemsToSell[j] = getRandomItem();
                    }
                    shipOrder(itemsToSell);
                    break;
            }
        }
    }

    int generateRandomNumber(int min, int max) {
        return (int)(Math.random() * (max - min + 1) + min);
    }

    String getRandomItem() {
        return supplyKind[generateRandomNumber(0, supplyKind.length-1)];
    }

    int assignPrice(String item) {
        int itemPriceIndex = -1;
        for (int i = 0; i < supplyKind.length - 1; i++) {
            if (item.equals(supplyKind[i])) {
                itemPriceIndex = i;
                return prices[itemPriceIndex];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] supplyKind = {"Guns", "Computers", "Tin Cans", "Chairs", "Toilet paper"};
        int[] prices = {1400, 450, 520, 21, 150, 2};
        StoreManegement store = new StoreManegement(supplyKind, prices);
        store.run();
        System.out.println("Simulated ended and the budget is:" + store.storeBudget + " $");
    }
}

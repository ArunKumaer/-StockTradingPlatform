import java.util.*;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class Portfolio {
    Map<String, Integer> holdings = new HashMap<>();
    double balance = 10000; // initial balance

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.price * quantity;
        if (balance >= cost) {
            balance -= cost;
            holdings.put(stock.symbol, holdings.getOrDefault(stock.symbol, 0) + quantity);
            System.out.println("Bought " + quantity + " of " + stock.symbol);
        } else {
            System.out.println("Not enough balance!");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        if (holdings.getOrDefault(stock.symbol, 0) >= quantity) {
            balance += stock.price * quantity;
            holdings.put(stock.symbol, holdings.get(stock.symbol) - quantity);
            System.out.println("Sold " + quantity + " of " + stock.symbol);
        } else {
            System.out.println("Not enough shares to sell!");
        }
    }

    public void displayPortfolio() {
        System.out.println("Balance: $" + balance);
        System.out.println("Holdings: " + holdings);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Portfolio portfolio = new Portfolio();
        Stock apple = new Stock("AAPL", 150);
        Stock google = new Stock("GOOG", 2800);

        while (true) {
            System.out.println("1. Buy Stock\n2. Sell Stock\n3. View Portfolio\n4. Exit");
            int choice = sc.nextInt();
            if (choice == 4) break;

            if (choice == 1) {
                System.out.println("Enter stock (AAPL/GOOG) and quantity:");
                String sym = sc.next();
                int qty = sc.nextInt();
                if (sym.equals("AAPL")) portfolio.buyStock(apple, qty);
                else if (sym.equals("GOOG")) portfolio.buyStock(google, qty);
            } else if (choice == 2) {
                System.out.println("Enter stock (AAPL/GOOG) and quantity:");
                String sym = sc.next();
                int qty = sc.nextInt();
                if (sym.equals("AAPL")) portfolio.sellStock(apple, qty);
                else if (sym.equals("GOOG")) portfolio.sellStock(google, qty);
            } else if (choice == 3) {
                portfolio.displayPortfolio();
            }
        }
    }
}

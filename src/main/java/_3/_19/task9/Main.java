package _3._19.task9;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Obtain a list of products belongs to category “Books” with price > 100
        List<Product> productList = new ArrayList<>();
        List<Product> books = Util.getProductByCategoryAndMoreThenPrice(productList, "Book", 100);

        // Obtain a list of order with products belong to category “Baby”
        List<Order> orderList = new ArrayList<>();
        List<Order> baby = Util.getOrderByCategory(orderList, "Baby");

        // Obtain a list of product with category = “Toys” and then apply 10% discount
        List<Product> toys = Util.getProductByCategoryAndApplyDiscount(productList, "Toys", 10);

        // Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
        List<Product> orderForTyreBetweenDate = Util.getOrderForTyreBetweenDate(orderList, 2,
                LocalDate.of(2021, 2, 1), LocalDate.of(2021, 4, 1));

        // Get the cheapest products of “Books” category
        Optional<Product> book = Util.getCheapestProductByCategory(productList, "Book");

        // Get the 3 most recent placed order
        List<Order> orders = Util.getMostRecentPlacedOrder(orderList, 3);

        // Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its distinct product list
        List<Product> list = Util.getProductListFromOrderBy(orderList, LocalDate.of(2021, 3, 15));

        // Calculate total lump sum of all orders placed in Feb 2021
        double allOrders = Util.calculateTotalSumOfAllOrders(orderList);

        // Calculate order average payment placed on 14-Mar-2021
        OptionalDouble aDouble = Util.calculateAverageOfAllOrdersBy(orderList, LocalDate.of(2021, 3, 14));

        // Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category “Books”
        Util.printPriceStatisticsByCategory(productList, "Book");

        // Obtain a data map with order id and order’s product count
        Map<String, Integer> map = Util.obtainDataWithOrderIdAndProductCount(orderList);

        // Produce a data map with order records grouped by customer
        Map<Customer, List<Order>> map1 = Util.getMapWithOrderGroupedByCustomer(orderList);

        // Produce a data map with order record and product total sum
        Map<Order, Double> map2 = Util.getMapWithOrderAndProductTotalSum(orderList);

        // Obtain a data map with list of product name by category
        Map<String, List<String>> map3 = Util.getMapWithListProductNameByCategory(productList);

        // Get the most expensive product by category
        Map<String, Optional<Product>> map4 = Util.getMostExpensiveProductByCategory(productList);
    }
}

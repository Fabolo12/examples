package lesson19.task9;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Util {
    public static List<Product> getProductByCategoryAndMoreThenPrice(List<Product> productList, String category, int price) {
        return productList.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .filter(p -> p.getPrice() > price)
                .collect(Collectors.toList());
    }

    public static List<Order> getOrderByCategory(List<Order> orderList, String category) {
        return orderList.stream()
                .filter(o ->
                        o.getProducts().stream().anyMatch(p -> p.getCategory().equalsIgnoreCase(category))
                )
                .collect(Collectors.toList());
    }

    public static List<Product> getProductByCategoryAndApplyDiscount(List<Product> productList, String category, int discount) {
        return productList.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .map(p -> p.withPrice(p.getPrice() * (1 - discount / 100.0)))
                .collect(Collectors.toList());
    }

    public static List<Product> getOrderForTyreBetweenDate(List<Order> orderList, int tier, LocalDate from, LocalDate to) {
        return orderList.stream()
                .filter(o -> o.getCustomer().getTier() == tier)
                .filter(o -> o.getOrderDate().compareTo(from) >= 0)
                .filter(o -> o.getOrderDate().compareTo(to) <= 0)
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public static Optional<Product> getCheapestProductByCategory(List<Product> productList, String category) {
        return productList.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .min(Comparator.comparing(Product::getPrice));
    }

    public static List<Order> getMostRecentPlacedOrder(List<Order> orderList, int limit) {
        return orderList.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static List<Product> getProductListFromOrderBy(List<Order> orderList, LocalDate date) {
        return orderList.stream()
                .filter(o -> o.getOrderDate().isEqual(date))
                .peek(System.out::println)
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public static double calculateTotalSumOfAllOrders(List<Order> orderList) {
        return orderList.stream()
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static OptionalDouble calculateAverageOfAllOrdersBy(List<Order> orderList, LocalDate date) {
        return orderList.stream()
                .filter(o -> o.getOrderDate().isEqual(date))
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .average();
    }

    public static void printPriceStatisticsByCategory(List<Product> productList, String category) {
        DoubleSummaryStatistics statistics = productList.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();

        System.out.printf("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f%n",
                statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum());
    }

    public static Map<String, Integer> obtainDataWithOrderIdAndProductCount(List<Order> orderList) {
        return orderList.stream()
                .collect(Collectors.toMap(Order::getId, order -> order.getProducts().size()));
    }

    public static Map<Customer, List<Order>> getMapWithOrderGroupedByCustomer(List<Order> orderList) {
        return orderList.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
    }

    public static Map<Order, Double> getMapWithOrderAndProductTotalSum(List<Order> orderList) {
        return orderList.stream()
                .collect(Collectors.toMap(
                                Function.identity(), order -> order.getProducts().stream()
                                        .mapToDouble(Product::getPrice)
                                        .sum()
                        )
                );
    }

    public static Map<String, List<String>> getMapWithListProductNameByCategory(List<Product> productList) {
        return productList.stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.mapping(Product::getName, Collectors.toList())
                        )
                );
    }

    public static Map<String, Optional<Product>> getMostExpensiveProductByCategory(List<Product> productList) {
        return productList.stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.maxBy(Comparator.comparing(Product::getPrice))
                        )
                );
    }
}

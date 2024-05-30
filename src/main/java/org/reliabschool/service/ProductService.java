package org.reliabschool.service;

import org.reliabschool.entity.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.System.out;

public class ProductService {

    public final Product[] products = {
            new Product("1", "1", 1, 1),
            new Product("2", "2", 2, 2),
            new Product("3", "3", 3, 3),
            new Product("4", "4", 4, 4),
            new Product("5", "5", 5, 5)
    };

    public final Scanner scanner = new Scanner(System.in);

    public void sortByPriceDesc(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getPrice).reversed());
    }

    public void findAndEdit() {
        out.println("Введите название для поиска объекта:");
        String nameToFind = scanner.nextLine();
        Product product = findByName(products, nameToFind);

        out.println("Введите номер поля, требующего замены:");
        out.println("1 Название");
        out.println("2 Производитель");
        out.println("3 Количество");
        out.println("4 Цена");
        int num = Integer.parseInt(scanner.nextLine());

        out.println("Введите новое значение поля:");
        String newValue = scanner.nextLine();
        switch (num) {
            case 1 -> product.setName(newValue);
            case 2 -> product.setManufacturer(newValue);
            case 3 -> product.setQuantity(Integer.parseInt(newValue));
            case 4 -> product.setPrice(Integer.parseInt(newValue));
            default -> throw new IllegalArgumentException("Неправильно введено значение номера поля");
        }
        out.println(product);
    }

    public Product findByName(Product[] products, String name) {
        return Arrays.stream(products)
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Не найден подходящий объект"));
    }

    public long getProductsWithPriceLessThanAvg(Product[] products) {
        double averagePrice = getAveragePrice(products);
        return Arrays.stream(products)
                .filter(p -> p.getPrice() < averagePrice)
                .count();
    }

    public Product[] getMaxQuantityProducts(Product[] products) {
        int maxQuantity = Arrays.stream(products)
                .mapToInt(Product::getQuantity)
                .max()
                .orElse(0);
        return Arrays.stream(products)
                .filter(p -> p.getQuantity() == maxQuantity)
                .toArray(Product[]::new);
    }

    public double getAveragePrice(Product[] products) {
        return Arrays.stream(products)
                .mapToInt(Product::getPrice)
                .average()
                .orElse(0);
    }
}

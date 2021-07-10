package com.company;

import java.util.Scanner;

public class Menu {
    Scanner in = new Scanner(System.in);
    public void menu1(){
        System.out.println("Введите число от 1 до 4:\n1. Добавление продукта\n" +
                "2. Получение продукта по id\n" +
                "3. Получение списка всех продуктов\n" +
                "4. Удаление продукта по id\n");
        int num=in.nextInt();
        switch (num) {
            case 1: //добавить продукт
                addProduct();
                break;
            case 2: //найти продукт по ID
                searchById();
                break;

            case 3: //Вывод всего списка продуктов

                displayList();

                break;
            case 4: //Удаление продукта по ID
                deleteProduct();
                break;

            default:
                System.out.println("Повторите ввод");
                System.out.println();
                /* Menu.menu1();*/
        }}

    public int readInt(){
        return in.nextInt();
    }
    public double readDouble(){
        return Double.parseDouble(in.nextLine());
    }

    public String readString(){
        return in.nextLine();
    }

    public void addProduct() {
        System.out.println("Введите ID продукта:");
        int ID = readInt();
        System.out.println("Введите название продукта:");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Введите категорию продукта:");
        Scanner in2 = new Scanner(System.in);
        String category = in.nextLine();
        System.out.println("Введите цену продукта:");
        Scanner in1 = new Scanner(System.in);
        double price = in.nextDouble();
        Product product = createProduct(ID, name, price, category);
        ProductRepository.dataBase().add(product);
        System.out.println(product);
        menu1();
    }
    public static Product createProduct(int ID, String name, double price, String category) {
        return new Product(ID, name, price, category);
    }
    public void displayList(){
        for(Product product: ProductRepository.dataBase()){
            System.out.println(product);
        }
        menu1();
    }
    public void searchById(){
        System.out.println("Введите ID продукта: ");
        int id = readInt();
        for(Product product : ProductRepository.dataBase()){
            if(id == product.getId()){
                System.out.println(product);
                menu1();
                return;
            }
        }
        System.out.println("Продукт не найден");
        menu1();
    }

    public void deleteProduct() {
        System.out.println("Введите ID: ");
        int id = in.nextInt();
        for(Product product : ProductRepository.dataBase()){
            if(id == product.getId()){
                ProductRepository.dataBase().remove(product);
                break;
            }
        }
        System.out.println("Продукт не найден");
        menu1();
    }
}

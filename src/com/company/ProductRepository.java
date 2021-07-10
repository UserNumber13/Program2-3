package com.company;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    static List<Product> list=new ArrayList<>();
    public static List<Product> dataBase (){
        return list;
    }

    static
    {
        list.add(Menu.createProduct(1234, "Гречка", 2.0, "крупы"));
        list.add(Menu.createProduct(1345, "Рис", 3.7, "крупы"));
        list.add(Menu.createProduct(4569, "Пшено", 1.4, "крупы"));
    }
}

package test;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class testJdk8 {



    public static void main(String[] args){
        // 接口作为参数传入
        List<Product> products = generateList();
//        List<Product> result = filterProductByPredicate(products,new idPredicate());
//        result.forEach(product -> System.out.println(product.getName()));
        //流式处理
        // products.stream().filter((product -> product.getId() <5)).map(Product::getName).forEach(System.out :: println);

//        Consumer<Integer> con = (x) -> System.out.println(x);
//        con.accept(100);
//        Function<Integer,Integer> function1 = (value)-> value * 2;
//        Function<Integer,Integer> function2 = value -> value + 3;
//        Function<Integer,Integer> function3 = function1.andThen(function2);
//        System.out.println(function3.apply(2));
//        Function<Product,String> function4 = value -> value.getName().toUpperCase();
//        products.stream().map(function4).forEach(System.out :: println);
        Function<Product,String> function5 = product -> product.getName();
        BiFunction<List<Product>,String, Optional<Product>> biFunction = (productList, name) -> productList.stream().filter(product -> product.getName().equalsIgnoreCase(name)).findFirst();
        Optional<Integer> id = biFunction.apply(products,"jack").map(Product::getId);
        System.out.println(biFunction.apply(products,"jack").map(Product::getId).get());
        //        products.stream().map(Product::getName).forEach(System.out::println);
    }

    private static List<Product> generateList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("jack",20));
        productList.add(new Product("lucy",6));
        productList.add(new Product("tank",7));


        return productList;
    }

    public static List<Product> filterProductByPredicate(List<Product> list, MyPredicate<Product> mp){
        List<Product> prods = new ArrayList<>();
        for (Product prod : list){
            if (mp.test(prod)){
                prods.add(prod);
            }
        }
        return prods;
    }




    interface MyPredicate<T>{
        boolean test(T t);
    }

    static class namePredicate implements MyPredicate<Product>{

        private static final String JName = "jack";

        @Override
        public boolean test(Product product) {
            return JName.equalsIgnoreCase(product.getName());
        }
    }

    static class idPredicate implements MyPredicate<Product>{

        @Override
        public boolean test(Product product) {
            return 5<product.getId();
        }
    }




    @Getter
    @Setter
    static
    class Product{

        public Product(String name,int id){
            this.name = name;
            this.id = id;
        }

        String name;

        int id;
    }
}

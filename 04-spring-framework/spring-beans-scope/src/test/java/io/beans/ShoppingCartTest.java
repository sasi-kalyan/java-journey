package io.beans;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ShoppingCart.class)
public class ShoppingCartTest {

    @Autowired
    ShoppingCart cart1;

    @Autowired
    ShoppingCart cart2;

//    @Test
//    public void testSingletonScope(){
//        cart1.addItems("Lapton");
//        cart2.addItems("Mouse");
//
//        System.out.println("Cart1 Items: "+ cart1.getItems());
//        System.out.println("Cart2 Items: "+ cart2.getItems());
//        System.out.println("Same Objects? : "+ (cart1 == cart2));
//    }

    @Test void testPrototypeScope(){
        cart1.addItems("Lapton");
        cart2.addItems("Mouse");

        System.out.println("Cart1 Items: "+ cart1.getItems());
        System.out.println("Cart2 Items: "+ cart2.getItems());
        System.out.println("Same Objects? : "+ (cart1 == cart2));
    }
}

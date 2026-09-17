package io.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component  //No Scope Specified -- Default Scope i.e SINGLETON
//@Scope("prototype")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShoppingCart {
    List<String> items = new ArrayList<>();

    public void addItems(String item){
        items.add(item);
    }

    public List<String> getItems(){
        return items;
    }
}

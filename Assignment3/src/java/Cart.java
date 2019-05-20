/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cestdrama
 */
import java.util.*;
public class Cart {
    private List<Item> cart;

    public Cart() {
        cart=new ArrayList<>();
    }

    public List<Item> getCart() {
        return cart;
    }

    public void setCart(List<Item> cart) {
        this.cart = cart;
    }
    
    public Item SearchItem(String name) {
        for (Item item : cart) {
            if (name.equals(item.getName())) {
                return item;
            }
        }
        return null;
     }
     
    public void addItem(Item item){
         cart.add(item);
     }
     
//    public void removeItem(Item item) {
//        cart.remove(item);
//    }
    
    public void deleteItem(String name) {
        Item item = SearchItem(name);
        if (item != null)
            cart.remove(item);
    }
    
    public void modifyItemCount(String name, int count) {
        for (Item i : cart) {
            if (name.equals(i.getName())) {
                i.setCount(count);
            }
        }
    }
    
    
}

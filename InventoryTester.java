package pjava.ch04.inventory.iterable2;

import java.util.Iterator;
import pjava.ch04.inventory.InventoryItem;

public class InventoryTester {

    public static void main(String[] args) {
        
        Inventory inventory = new Inventory();
        
        InventoryItem x;
        
        x = new InventoryItem(101, "USB Mouse", 5, 10, 450 ); 
        inventory.addNewInventoryItem(x);

        x = new InventoryItem(102, "DVD Drive", 5, 5, 2100 ); 
        inventory.addNewInventoryItem(x);
        
        x = new InventoryItem(103, "Hard Disk", 10, 2, 3500 ); 
        inventory.addNewInventoryItem(x);
        
        try {
        
            inventory.addStock(103, 1);
            inventory.withdrawStock(102, 3);
        
        }
        catch(Exception e) {
            
        }
        
        
        
        System.out.println("All items in Stock");
        System.out.println("-----------------------------------");
        Iterator<InventoryItem> iterator = inventory.getItems();
        InventoryItem item;
        while (iterator.hasNext()) {
            item = iterator.next();
            System.out.println(item.getItemCode()+","+item.getItemDescription());     
        }
        System.out.println("-----------------------------------");

        System.out.println("Items under Stock");
        InventoryItem[] ius = inventory.itemsUnderStock();
        for ( InventoryItem i : ius )
            System.out.println(i.getItemCode()+","+i.getItemDescription());     
        System.out.println("-----------------------------------");
        
    }
    
}

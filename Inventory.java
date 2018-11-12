package pjava.ch04.inventory.iterable2;

import java.util.ArrayList;
import java.util.Iterator;
import pjava.ch04.inventory.InSufficientStock;
import pjava.ch04.inventory.InventoryItem;
import pjava.ch04.inventory.ItemNotFound;

public class Inventory{ 
    public Inventory(){ 
        
        items = new ArrayList<>();

    } 
    public void addNewInventoryItem(InventoryItem new_item){ 

        items.add( new_item );

    } 
    public void addStock(int item_code, int qty) throws ItemNotFound { 

        //adds specified qty of specified item to the inventory
        //you may have locate the specified item in the collection before increasing its stock

        InventoryItem itm = search( item_code );
        itm.addStock(qty);

    } 
    public void withdrawStock(int item_code, int qty) 
                             throws ItemNotFound, InSufficientStock { 

        InventoryItem itm = search( item_code );
        itm.withdrawStock(qty);

    } 
    public InventoryItem[] itemsUnderStock() {

        ArrayList<InventoryItem> items_us = new ArrayList<InventoryItem>();

        for( InventoryItem itm : items) {

            if ( itm.isUnderStock() ) {
                //you can not directly add this item to items_us
                //rather return clone of.
                InventoryItem x = new InventoryItem( 
                        itm.getItemCode(),
                        itm.getItemDescription(), 
                        itm.getStock(),
                        itm.getMinRequiredStock(),
                        itm.getCost() );
                //if clone method had been defined with InventoryItem,
                //you could have used that instead of explicitly copied,
                //as x = itm.clone();
                items_us.add( x );
            }
        }
        //below is typical way of converting arraylist object to array object.
        InventoryItem[] t = new InventoryItem[0];
        t= items_us.toArray(t);
        return t;
    }
    private InventoryItem search(int item_code) throws ItemNotFound {
            //returns item object with given item code, if found

        for( InventoryItem itm : items) {
            if ( itm.getItemCode() == item_code )
                return itm;
        }

        throw new ItemNotFound();

    }

    public double totalInventoryCost() {

        double cost = 0;

        for( InventoryItem itm : items) {

            cost += itm.getCost() * itm.getStock();
            
        }
        
        return cost;

    }
    
    public Iterator<InventoryItem> getItems() {
        
        return new ItemIterator();
        
    }
    
    //Field Declarations

    private ArrayList<InventoryItem> items;

    private class ItemIterator implements Iterator<InventoryItem> {
        
            public boolean hasNext()
            {
               return current < items.size();
            }

            public InventoryItem next()
            {
               return items.get(current++);
            }

            public void remove()
            {
               throw new UnsupportedOperationException();
            }
            private int current = 0;
    }

}




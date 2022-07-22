package com.company;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;


class Item6k
{
    private String name;
    private double price;
    private int quantity;


    public Item6k( String itemName, double itemPrice, int numPurchased )
    {
        name = itemName;
        price = itemPrice;
        quantity = numPurchased;
    }


    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }


    @Override
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String strTab = name.length() > 8 ? "\t" : "\t\t";
        return name + strTab + fmt.format( price ) + "\t\t" + quantity + "\t\t"
                + fmt.format( price * quantity );
    }
}


public class SHOPPINGCART
{
    public static void main( String[] args )
    {
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner( System.in );
        String keepShopping = "y";


        ArrayList<Item6k> cart = new ArrayList<Item6k>();


        do
        {
            System.out.print( "Enter the name of the item: " );
            itemName = scan.nextLine();
            System.out.print( "Enter the unit price: " );
            itemPrice = scan.nextDouble();
            System.out.print( "Enter the quantity: " );
            quantity = scan.nextInt();
            scan.nextLine();

          Item6k s1 = new Item6k(itemName, itemPrice, quantity);
            cart.add(s1);
            System.out.print( "Continue shopping (y/n)? " );
            keepShopping = scan.nextLine();
        }
        while ( keepShopping.equalsIgnoreCase( "y" ) );

        System.out.println();
        System.out.println( "Final Shopping Cart totals" );

        double sumtotal = 0;

        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        for(int i=0;i<cart.size();i++){

            System.out.println(cart.get(i));

            sumtotal+=(cart.get(i).getPrice()*cart.get(i).getQuantity());
        }
        System.out.println("Total £ Amount in Cart: " + sumtotal );
    }
}

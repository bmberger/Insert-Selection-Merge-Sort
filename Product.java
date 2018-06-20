
/**
 * Purpose: To set a class for a Product
 *
 * @author Briana Berger
 * @version 04/09/2018
 *
 */
public class Product
{
    // instance variables
    private int productNum, quantity;
    private double price; 
    private String name;

    // Constructor for objects of class Movie
    public Product(String name, int productNum, double p, int q)
    {
        // initialize instance variables
        this.name = name;
        this.productNum = productNum;
        this.price = p;
        this.quantity = q;
    }

    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getProductNumber()
    {
        return productNum;
    }
    
    public void setProductNumber(int productNum)
    {
        this.productNum = productNum;
    }
    
    public double getPrice()
    {
        return price;
    }
   
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
   
    public String toString()
    {
        String str = String.format("%10s %10s %14s %10s", name, productNum, price, quantity);
        return str;
    }
}

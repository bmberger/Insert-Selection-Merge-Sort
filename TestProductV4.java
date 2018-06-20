
 /**
 * This class demonstrates the merge sort algorithm.
 *
 * @author Briana Berger
 * @version 04/10/2018
 */

public class TestProductV4
{
    public static void main(String[] args)
    {
        Product[] products = new Product[10];
        Product[] sorted = new Product[10];
        
        products[0] = new Product("Hat", 345, 15.99, 1);
        products[1] = new Product("Cup", 234, 5.50, 4);
        products[2] = new Product("Planner", 789, 20.10, 1);
        products[3] = new Product("Paper", 977, 10.99, 4);
        products[4] = new Product("Tape", 887, 11.45, 1);
        products[5] = new Product("Pencil", 246, .50, 10);
        products[6] = new Product("Vase", 297, 30.99, 1);
        products[7] = new Product("Mug", 978, 10.50, 1);
        products[8] = new Product("Stapler", 141, 13.50, 1);
        products[9] = new Product("Binder", 745, 5.99, 5);
        
        System.out.println("    <<<< Before Sorting >>>> \n");
        printArray(products);
        
        System.out.println("\n     <<<< After Merge Sorting >>>>");
        System.out.println("<<<< by product number ascending - passing an array and order >>>>\n");
        mergeSort(products, 0, products.length-1);
        printArray(products);
        
        System.out.println("\n     <<<< After Insertion Sorting >>>>");
        System.out.println("<<<< by name ascending - passing an array and order >>>>\n");
        sorted = insertionName(products, 1);
        printArray(sorted);
        
        System.out.println("\n     <<<< After Insertion Sorting >>>>");
        System.out.println("<<<< by name descending - passing an array and order >>>>\n");
        sorted = insertionName(products, 2);
        printArray(sorted);
        
        System.out.println("\n     <<<< After Selection Sorting >>>>");
        System.out.println("<<<< by price ascending - passing an array and order >>>>\n");
        sorted = selectionPrice(products, 1);
        printArray(sorted);
        
        System.out.println("\n     <<<< After Selection Sorting >>>>");
        System.out.println("<<<< by price descending - passing an array and order >>>>\n");
        sorted = selectionPrice(products, 2);
        printArray(sorted);
        
        System.out.println("\n     <<<< After Selection Sorting >>>>");
        System.out.println("<<<< by quantity ascending - passing an array and order >>>>\n");
        sorted = selectionQuantity(products, 1);
        printArray(sorted);
        
        System.out.println("\n     <<<< After Selection Sorting >>>>");
        System.out.println("<<<< by quantity descending - passing an array and order >>>>\n");
        sorted = selectionQuantity(products, 2);
        printArray(sorted);
    }
    
    public static void printArray(Product[] source)
    {
        System.out.printf("%10s %14s %10s %14s %n", "Name", "Product #", "Price", "Quantity");
        for(int i = 0; i < source.length; i++)
            System.out.println(source[i]);
            
        System.out.println();
    }
    
    public static void mergeSort(Product[] source, int low, int high)
    {
        if( low == high )
            return;

        int mid = ( low + high ) / 2;
        
        mergeSort( source, low, mid);
        mergeSort( source, mid + 1, high); 
        mergeProductNumber( source, low, mid, high);
    }
    
    public static void mergeProductNumber(Product[] source, int low, int mid, int high)
    {
        Product[] dest = new Product[ high - low + 1 ];

        int i = low, j = mid + 1, n = 0;

        while( i <= mid || j <= high )
        {
            if( i > mid )
            {
                dest[ n ] = source[ j ];
                j++;
            }
            else if( j > high )
            {
                dest[ n ] = source[ i ];
                i++;
            }
            else if( source[ i ].getProductNumber() < source[ j ].getProductNumber())
            {
                dest[ n ] = source[ i ];
                i++;
            }
            else
            {
                dest[ n ] = source[ j ];
                j++;
            }
            n++;
        }

        for( int k = low ; k <= high ; k++ )
            source[ k ] = dest[ k - low ];
    }
    
    public static Product[] insertionName(Product[] source, int order)
    {
        Product[] dest = new Product[source.length];

        for( int i = 0 ; i < source.length ; i++ )
        {
            Product next = source[ i ];
            int insertIndex = 0;
            int k = i;
            while( k > 0 && insertIndex == 0 )
            {
                if(order == 1)
                {
                    if(next.getName().compareTo(dest[k-1].getName()) > 0)
                    {
                        insertIndex = k;
                    }
                    else
                    {
                        dest[ k ] = dest[ k - 1 ];
                    }
                    k--;
                }
                else if (order == 2)
                {
                    if(next.getName().compareTo(dest[k-1].getName()) < 0)
                    {
                        insertIndex = k;
                    }
                    else
                    {
                        dest[ k ] = dest[ k - 1 ];
                    }
                    k--;
                }
            }
            dest[insertIndex] = next;
        }
        return dest;
    }
    
    public static Product[] selectionPrice(Product[] source, int order)
    {
        for (int i = source.length - 1 ; i >= 0 ; i-- )
        {
            int posmax = 0;

            for (int k = 0 ; k <= i ; k++ )
            {
                if(order == 1)
                {
                    if (source[k].getPrice() > source[posmax].getPrice())
                    {
                        posmax = k;
                    }
                }
                else if(order == 2)
                {
                    if (source[k].getPrice() < source[posmax].getPrice())
                    {
                        posmax = k;
                    }
                }
            }
            double price = source[i].getPrice();
            source[i].setPrice(source[posmax].getPrice());;
            source[posmax].setPrice(price);
        }
        return source;
    }
    
    public static Product[] selectionQuantity(Product[] source, int order)
    {
        for (int i = source.length - 1 ; i >= 0 ; i-- )
        {
            int posmax = 0;

            for (int k = 0 ; k <= i ; k++ )
            {
                if(order == 1)
                {
                    if (source[k].getQuantity() > source[posmax].getQuantity())
                    {
                        posmax = k;
                    }
                }
                else if(order == 2)
                {
                    if (source[k].getQuantity() < source[posmax].getQuantity())
                    {
                        posmax = k;
                    }
                }
            }
            int quantity = source[i].getQuantity();
            source[i].setQuantity(source[posmax].getQuantity());;
            source[posmax].setQuantity(quantity);
        }
        return source;
    }
} // end of class

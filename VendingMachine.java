import java.util.ArrayList;

/**
   A vending machine.
*/
public class VendingMachine
{  
   public ArrayList<Product> products;
   public CoinSet coins;
   public CoinSet currentCoins;

   /**
      Constructs a VendingMachine object.
   */
   public VendingMachine()
   { 
      products = new ArrayList<Product>();
      coins = new CoinSet();
      currentCoins = new CoinSet();
   }
  
    public Product[] getProductTypes ()
    {
        Product[] p = {};
        ArrayList <Product> product = new ArrayList <Product> ();
        /*for (Product p : products)
        {
            if (temp.contains(p.getName()))
            {
                temp.add(p);
            }
        }
        return temp;*/

        for (int i = 0; i < this.products.size(); i++)
        {
            if (! (product.contains(this.products.get(i))))
            {
                product.add(this.products.get(i));
            }
        }

        return product.toArray(p);
    }

   public void addCoin (Coin coin)
   {
        currentCoins.addingCoin(coin);
   }

   public double removeMoney ()
   {
        double removalOfCoins = currentCoins.valueOfSet();
        currentCoins.clearCoin();
        return removalOfCoins;
   }

   public void buyProduct (Product boughtProduct) throws VendingException
   {
        boolean bought = false;
        String name;

        if (boughtProduct.getPrice() <= currentCoins.valueOfSet())
        {
            while (bought == false)
            {
                for (int i = 0; i < products.size(); i++)
                {
                    if (products.get(i).getName().equals(boughtProduct.getName()))
                    {
                        coins.setCoinsIncome(boughtProduct.getPrice(), coins.valueOfSet());
                        double newValue = 0;
                        currentCoins.setCoinsChange(boughtProduct.getPrice(), currentCoins.valueOfSet());
                        products.remove(i);
                        bought = true;
                        System.out.println ("Enjoy your product");
                    }
                }
            }
        }
        else 
        {
        throw new VendingException("Insuficient funds");
        }
   }

   public void addProduct (Product p, int quantity)
   {
        for (int i = 0; i < quantity; i++)
        {
            products.add(p);
        }
   }
}
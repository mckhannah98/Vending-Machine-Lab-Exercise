import java.util.ArrayList;

/**
   A set of coins.
*/
public class CoinSet
{  
   private ArrayList<Coin> set;

   /**
      Constructs a CoinSet object.
   */
   public CoinSet()
   {  
      set = new ArrayList<Coin>();
   }

   public void addingCoin (Coin coins)
   {
       set.add(coins);
   }

   public void clearCoin ()
   {
       set.clear();
   }

   public double valueOfSet ()
   {
        double value = 0;
        for (int i = 0; i < set.size(); i++)
        {
            value = value + set.get(i).getValue();
        }
        return value;
   }

   public void setCoinsChange (double value, double currentValue)
   {
       double newValue = currentValue - value;
       set.clear();
       set.add(new Coin(newValue, "Change"));
   }

   public void setCoinsIncome (double value, double currentValue)
   {
       double newValue = currentValue + value;
       set.add(new Coin(newValue, "Income"));
   }
}

/**
 * Company 2 = Apple
 */
final class Apple extends Company 
{
    private double AppleDemand; //Measuring demand for Apple
    private int globalWageIncrease; //Variable to create an increasing trend for company (small bias upwards mimicking stock market)
    
    public Apple()
    {
      super(7.0, "APPL (Apple)");  //initial price and name
      this.AppleDemand = 1;
      this.globalWageIncrease = globalWageIncrease;
    }

    @Override 
    public void fluctuation() // Fluctuating price of Stocks
    {
        int change = (int)(Math.random()*(3-1))+1; //random int from 2 numbers, 2= stockPrice falls, 1= stockPrice rises
        int range = (int)(Math.random()*(7-1))+1; // random number our of 5 for the range of stockPrice change
        double value =0;
        if (range == 1) {
            value = 0.083; //% change
            if (change == 1) {
                setStockPrice(getStockPrice() * (1 + value));
            } else {
                setStockPrice(getStockPrice() * (1 - value));
            }
        }
        else if (range == 2) {
            value = 0.061; //% change
            if (change == 1) {
                setStockPrice(getStockPrice() * (1 + value));
            } else {
                setStockPrice(getStockPrice() * (1 - value));
            }
        }
        else if (range == 3 || range == 4) {
            value = 0.023; //% change
            if (change == 1) {
                setStockPrice(getStockPrice() * (1 + value));
            } else {
                setStockPrice(getStockPrice() * (1 - value));
            }
        }
        else if (range == 5 || range == 6) {
            value = 0.009; //% change
            if (change == 1) {
                setStockPrice(getStockPrice() * (1 + value));
            } else {
                setStockPrice(getStockPrice() * (1 - value));
            }
        }
    }
    
    public void setAppleDemand(double newDemand) 
    {
        this.AppleDemand = newDemand;
    }
    
    public double getAppleDemand() 
    {
        return this.AppleDemand;
    }
    
    public double changeAppleDemand() 
    {
        this.globalWageIncrease = (int)(Math.random()*(20-1))+1; //Measure for health concern
        setAppleDemand(1); //Start from multiple of 1 each time to prevent exponential change in price
        if (this.globalWageIncrease > 16) // Global Wage increase is high therefore demand for apple increases
        {
            setAppleDemand(getAppleDemand() + 0.05);
        }
        else if  (this.globalWageIncrease < 5) // Global Wage increase is low therefore demand for apple decreases
        {
            setAppleDemand(getAppleDemand() - 0.04);
        }
        return this.AppleDemand;
    }
    
    @Override 
    public double getStockPrice() 
    {
        return super.getStockPrice() * changeAppleDemand();  //to fluctuate price each time
    }
}


/**
 * Company 1 = Coca Cola
 */
final class CocaCola extends Company
{
    private double ColaDemand; //Measuring demand for cola
    private int globalHealthConcern; //Variable to create an increasing trend for company (small bias upwards mimicking stock market).
    
    public CocaCola()
    {
        super(5.0, "KO (Coca Cola)"); //initial price and name 
        this.ColaDemand = 1;
        this.globalHealthConcern = globalHealthConcern;
    }
    
    @Override
    public void fluctuation() // Fluctuating price of Stocks
    {
        int change = (int)(Math.random()*(3-1))+1; //random int from 2 numbers, 2= stockPrice falls, 1= stockPrice rises
        int range = (int)(Math.random()*(5-1))+1; // random number our of 5 for the range of stockPrice change
        double value =0;
        if (range == 1) {
            value = 0.056; //% change
            if (change == 1) {
                setStockPrice(getStockPrice() * (1 + value));
            } else {
                setStockPrice(getStockPrice() * (1 - value));
            }
        }
        else if (range == 2) {
            value = 0.031; //% change
            if (change == 1) {
                setStockPrice(getStockPrice() * (1 + value));
            } else {
                setStockPrice(getStockPrice() * (1 - value));
            }
        }
        else if (range == 3 || range == 4) {
            value = 0.012; //% change
            if (change == 1) {
                setStockPrice(getStockPrice() * (1 + value));
            } else {
                setStockPrice(getStockPrice() * (1 - value));
            }
        } 
    }
    
    public void setColaDemand(double newDemand) 
    {
        this.ColaDemand = newDemand;
    }
    
    public double getColaDemand() 
    {
        return this.ColaDemand;
    }
    
    public double changeColaDemand()
    {
        this.globalHealthConcern = (int)(Math.random()*(20-1))+1; //Measure for health concern
        setColaDemand(1); //Start from multiple of 1 each time to prevent exponential change in price
        if (this.globalHealthConcern > 16) // Health concern is high therefore demand for cola decreases
        {
            setColaDemand(getColaDemand() - 0.05);
        }
        else if  (this.globalHealthConcern < 5) // Health concern is low therefore demand for cola increases
        {
            setColaDemand(getColaDemand() + 0.06);
        }
        return this.ColaDemand;
    }
    
    @Override 
    public double getStockPrice() 
    {
        return super.getStockPrice() * changeColaDemand(); //to fluctuate price each time
    }
    
}

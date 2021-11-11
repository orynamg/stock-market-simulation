
/**
 * Company 3 = Tesla
 */
final class Tesla extends Company
{
    private double TeslaDemand; //Measuring demand for Tesla
    private int globalTrafficCongestion; //Variable to create an increasing trend for company (small bias upwards mimicking stock market)
    
    public Tesla()
    {
       super(6.0, "TSLA (Tesla)");  //initial price and name 
       this.TeslaDemand = 1;
       this.globalTrafficCongestion = globalTrafficCongestion;
    }
    
    @Override 
    public void fluctuation() // Fluctuating price of Stocks
    {
        int change = (int)(Math.random()*(3-1))+1; //random int from 2 numbers, 2= stockPrice falls, 1= stockPrice rises
        int range = (int)(Math.random()*(6-1))+1; // random number our of 5 for the range of stockPrice change
        double value =0;
        if (range == 1) {
            value = 0.034; //% change
            if (change == 1) {
                setStockPrice(getStockPrice() * (1 + value));
            } else {
                setStockPrice(getStockPrice() * (1 - value));
            }
        }
        else if (range == 2) {
            value = 0.020; //% change
            if (change == 1) {
                setStockPrice(getStockPrice() * (1 + value));
            } else {
                setStockPrice(getStockPrice() * (1 - value));
            }
        }
    }
    
    public void setTeslaDemand(double newDemand) 
    {
        this.TeslaDemand = newDemand;
    }
    
    public double getTeslaDemand() 
    {
        return this.TeslaDemand;
    }
    
    public double changeTeslaDemand() 
    {
        this.globalTrafficCongestion = (int)(Math.random()*(20-1))+1; //Measure for health concern
        setTeslaDemand(1); //Start from multiple of 1 each time to prevent exponential change in price
        if (this.globalTrafficCongestion > 16) // Global Traffic congestion is high therefore demand for tesla decreases
        {
            setTeslaDemand(getTeslaDemand() - 0.07);
        }
        else if  (this.globalTrafficCongestion < 5) //  Global Traffic congestion is low therefore demand for tesla increases
        {
            setTeslaDemand(getTeslaDemand() + 0.08);
        }
        return this.TeslaDemand;
    }
    
    @Override 
    public double getStockPrice() 
    {
        return super.getStockPrice() * changeTeslaDemand(); //to fluctuate price each time
    }
}

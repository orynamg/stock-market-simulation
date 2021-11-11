
/**
 * Personal Portfolio Class
 */
public class Portfolio
{
    // instance variables - replace the example below with your own
    private double credit;
    private int[] stocks = {0,0,0}; // Array of Number of each Stock

    public Portfolio(double credit)
    {
        this.credit = credit; // Balance in your account
        this.stocks = stocks;
    }

    public double getCredit()
    {
        return this.credit;
    }
    
    public void addCredit(double extraCredit)
    {
        this.credit += extraCredit;
    }
    
    public void reduceCredit(double extraCredit)
    {
        this.credit -= extraCredit;
    }
    
    public int getStockInfo(int index) 
    {
       return stocks[index]; 
    }
    
    public void setStock(int index, int numStocks) 
    {
        this.stocks[index] += numStocks; 
    }
}

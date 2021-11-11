
/**
 * Abstract class Company - Template for Comapany structure
 */
public abstract class Company
{
    private double stockPrice;
    private String companyName;
    
    public Company(double stockPrice, String companyName)
    {
        this.stockPrice = stockPrice;
        this.companyName = companyName;
    }
    
    public double getStockPrice() 
    {
        return this.stockPrice;
    }
    
    public void setStockPrice(double price) 
    {
        this.stockPrice =price;
    }
    
    public void fluctuation() //Will be overriden in each subclass 
    {
        this.stockPrice +=1;
    }
    
    public double calcStock(int numStocks) //For calculating total price for buying and selling stocks
    {
        return numStocks * stockPrice; 
    }
    
      public String getCompanyName() 
    {
        return this.companyName;
    }
}

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.Timer;
import java.util.*;
import javafx.util.Pair;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class StocksInterface extends Frame implements ActionListener, KeyListener
{
    //Arrays || Arraylists for GUI
    private ArrayList<Company> stocks = new ArrayList<Company>();
    private Map<String, ArrayList<Pair<Date, Double>>> prices = new HashMap<>();
    //text Areas
    private TextArea t = new TextArea("");
    private TextArea myPortfolio = new TextArea("");
    // textboxes
    private TextField TextboxTrade = new TextField(21);
    private TextField TextboxNumStocks = new TextField(21);
    private TextField TextboxCredit = new TextField(21);
    //Portfolio instance variable
    private Portfolio myport = new Portfolio(100);
    //Charts
    private LineChart chartCola = new LineChart(); // A chart variable for each company.
    private LineChart chartApple = new LineChart();
    private LineChart chartTesla = new LineChart();
    
    private void initUI() 
    {
        setLayout(null);
        setSize(1000,600);
        
        
        //Textboxes Section
        Label numStockLabel = new Label("Enter Number of Stocks: ");
        numStockLabel.setBounds(20, 50, 200, 30);
        add(numStockLabel);
        TextboxNumStocks.setBounds(230, 50, 100, 30);
        TextboxNumStocks.addKeyListener(this);
        add(TextboxNumStocks);
        
        Label companyNameLabel = new Label("Enter Company Name: ");
        companyNameLabel.setBounds(20, 100, 200, 30);
        add(companyNameLabel);
        TextboxTrade.addKeyListener(this);
        TextboxTrade.setBounds(230, 100, 100, 30);
        add(TextboxTrade);
        
        Label creditLabel = new Label("Enter Credit: ");
        creditLabel.setBounds(20, 200, 200, 30);
        add(creditLabel);
        TextboxCredit.addKeyListener(this);
        TextboxCredit.setBounds(230, 200, 100, 30);
        add(TextboxCredit);
    
        
        //Buy & Sell & Add Credit Buttons
        Button buttonBuy = new Button("Buy Stocks");
        buttonBuy.addActionListener(event -> buyStocks(event));
        buttonBuy.setBounds(20,150,150,30);
        add(buttonBuy);
        
        Button buttonSell = new Button("Sell Stocks");
        buttonSell.addActionListener(event -> sellStocks(event));
        buttonSell.setBounds(170,150,150,30);
        add(buttonSell);
        
        Button buttonAdd = new Button("Add Credit");
        buttonAdd.addActionListener(event -> addCredit(event));
        buttonAdd.setBounds(20,250,150,30);
        add(buttonAdd);
        
        Button buttonFileOutput = new Button("Save to File");
        buttonFileOutput.addActionListener(event -> saveFile(event));
        buttonFileOutput.setBounds(170,250,150,30);
        add(buttonFileOutput);
        
        //myPortfolio
        myPortfolio.setBounds(20, 300, 310, 250);
        add(myPortfolio);
        
        
        //Stock Prices
        t.setBounds(400, 50, 520, 100);
        add(t);
        
        //Stock Plots
        chartCola.setBounds(400, 170, 520, 120);
        add(chartCola);
        chartApple.setBounds(400, 300, 520, 120);
        add(chartApple);
        chartTesla.setBounds(400, 430, 520, 120);
        add(chartTesla);
        
        pack();
        show();
    }
    
    private void updateStockPrices() 
    {
        Date time = Calendar.getInstance().getTime();
                
        for (int i=0; i<stocks.size(); i++) 
        {
            var companyPrices = prices.get(stocks.get(i).getCompanyName());
            if (companyPrices.size() == 100) //On screen plot graph should only have 10 instances. 
            {
                companyPrices.remove(0); //Earliest instance is removed 
            }
            stocks.get(i).fluctuation();
            companyPrices.add(new Pair(time, stocks.get(i).getStockPrice()));
        }
            
    }
    
    private void displayStockPrices() 
    {
        t.setText("");
        for (Company stock: stocks) // For each stock in stocks
        {
            String display =String.format("%-12s:", stock.getCompanyName()); 
            var companyPrices = prices.get(stock.getCompanyName());
            for (int i=Math.max(companyPrices.size()-10, 0); i<companyPrices.size(); i++) 
            {
                display += String.format("  %.2f", companyPrices.get(i).getValue()); // Formatting to 2 decimal places
            }
            display += "\n";
            t.append(display);
        }
        
        //Company company1 = stocks.get(0);
        //ArrayList<Double> series = new ArrayList<>();
        ArrayList<ArrayList<Double>> series =  new ArrayList<ArrayList<Double>>(3);
        ArrayList<Double> series1 = new ArrayList<>();
        ArrayList<Double> series2 = new ArrayList<>();
        ArrayList<Double> series3 = new ArrayList<>();
        series.add(series1);
        series.add(series2);
        series.add(series3);
        
        for (int i=0; i<3; i++) 
        {
            for (var pair: prices.get(stocks.get(i).getCompanyName())) 
            {
                series.get(i).add(pair.getValue());
            }
        }
        
        
        chartCola.plot(series.get(0), Color.RED, stocks.get(0).getCompanyName());
        chartApple.plot(series.get(1), Color.BLUE, stocks.get(1).getCompanyName());
        chartTesla.plot(series.get(2), Color.ORANGE, stocks.get(2).getCompanyName());
    }
    
    
    public StocksInterface()
    {
        super();
        initUI();
        
        
        //Instantilising stock Companies
        Company cocaCola = new CocaCola();
        Company apple = new Apple();
        Company tesla = new Tesla();
        stocks.add(cocaCola);
        stocks.add(apple);
        stocks.add(tesla);
        
        for (Company stock: stocks) 
        {
            prices.put(stock.getCompanyName(), new ArrayList<>());
        }
        
        
        // Set Timer for Price Fluctuation
        ActionListener actListener = new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent event) 
            {
                try {
                    updateStockPrices();
                    displayStockPrices();
                } catch(Exception e) {
                    System.out.println("Error in timer function");
                    e.printStackTrace();   
                }
                
                
            } 
        };
        
        Timer timer = new Timer(500, actListener);
        timer.start();
        
        
        // My Portfolio TextArea
        
        myPortfolio.append("My Portfolio: \n");
        
        for (int i=0; i<stocks.size(); i++) // To display your stocks
        {
            myPortfolio.append(stocks.get(i).getCompanyName() + ": " + myport.getStockInfo(i) + "\n") ;
        }
        
        String s = Double. toString(myport.getCredit());
        myPortfolio.append("My Credit: \n" + s + "\n"); // Displaying credit
        
        
    }
    
    public void addCredit(ActionEvent evt) 
    {
        try 
        {
            int Credit = Integer.parseInt(TextboxCredit.getText()); // Credit that is requested to be added
            myport.addCredit(Credit);
            Refresh();
    
        } catch(Exception e) {
            System.out.println("Error while adding credit.");
            e.printStackTrace();
            
        }
    }
    
    public void saveFile(ActionEvent evt) 
    {
        try {
            File filePrices = new File("stock-prices.txt");
            filePrices.createNewFile();
            FileWriter writer = new FileWriter(filePrices);
            for (var company: stocks) 
            {
                var companyPrices = prices.get(company.getCompanyName());
                var lastPrice = companyPrices.get(companyPrices.size()-1);
                String line = String.format("%s %s %.2f\n", company.getCompanyName(), lastPrice.getKey().toString(), lastPrice.getValue());
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) { 
            System.out.println("IO Error while saving file.");
            e.printStackTrace();
        } catch(Exception e ) {
            System.out.println("Error while saving file.");
            e.printStackTrace();
        }
    }
    
    public void sellStocks(ActionEvent evt) 
    {
        
        try 
        {
            int NumStocks = Integer.parseInt(TextboxNumStocks.getText()); // Number of stocks chosen to sell
            String TextTrade = TextboxTrade.getText(); //Name of Company goes here
            if (TextTrade.equals("KO")) 
            {
                if (NumStocks <= myport.getStockInfo(0)) //Checking is you have the stocks available to sell
                {
                    myport.addCredit(stocks.get(0).calcStock(NumStocks));
                    myport.setStock(0, (-NumStocks));            
                }
            }
             else if (TextTrade.equals("AAPL")) 
            {
                if (NumStocks <= myport.getStockInfo(1)) //Checking is you have the stocks available to sell
                {
                    myport.addCredit(stocks.get(1).calcStock(NumStocks));
                    myport.setStock(1, (-NumStocks));
                }
            }
             else if (TextTrade.equals("TSLA")) //Checking is you have the stocks available to sell
            {
                if (NumStocks <= myport.getStockInfo(2)) 
                {
                    myport.addCredit(stocks.get(2).calcStock(NumStocks));
                    myport.setStock(2, (-NumStocks));
                }
            }
            Refresh();
        } catch(Exception e) {
            System.out.println("Error while selling stocks.");
            e.printStackTrace();
        }
        
        
    }
    
    public void buyStocks(ActionEvent evt) 
    {
        
        
        try 
        {
            int NumStocks = Integer.parseInt(TextboxNumStocks.getText()); // Number of stocks chosen to buy
            String TextTrade = TextboxTrade.getText(); //Name of Company goes here
            
                if (TextTrade.equals("KO")) 
            {
                if (myport.getCredit() >= stocks.get(0).calcStock(NumStocks)) //Checking is you have enough Credit to buy
                {
                    myport.reduceCredit(stocks.get(0).calcStock(NumStocks));
                    myport.setStock(0, NumStocks);
                }
            }
             else if (TextTrade.equals("AAPL")) 
            {
                if (myport.getCredit() >= stocks.get(1).calcStock(NumStocks)) //Checking is you have enough Credit to buy
                {
                    myport.reduceCredit(stocks.get(1).calcStock(NumStocks));
                    myport.setStock(1, NumStocks);
                }
            }
             else if (TextTrade.equals("TSLA")) 
            {
                if (myport.getCredit() >= stocks.get(1).calcStock(NumStocks)) //Checking is you have enough Credit to buy
                {
                    myport.reduceCredit(stocks.get(2).calcStock(NumStocks));
                    myport.setStock(2, NumStocks);
                }
            }
            
            Refresh();
        } catch(Exception e) {
            System.out.println("Error while buying stocks.");
            e.printStackTrace(); 
        }
        
    }
    
    public void Refresh() // To Refresh and re-build current portfolio every time after user buys/sells stocks
    {
        myPortfolio.setText("");
        myPortfolio.append("My Portfolio: \n");
    
        for (int i=0; i<stocks.size(); i++) 
        {
            myPortfolio.append(stocks.get(i).getCompanyName() + ": " + myport.getStockInfo(i) + "\n");
        }
        String s = Double. toString( Math.round(myport.getCredit() * 100.0) / 100.0 ); 
        myPortfolio.append("My Credit: \n" + s + "\n");
    }
    
    public void actionPerformed(ActionEvent evt) {};
    
    public void keyReleased(KeyEvent e) {} ; 
    
    public void keyPressed(KeyEvent e) {} ;
    
    public void keyTyped(KeyEvent e) {} ;
    
    public static void main(String[] args) 
    {
        new StocksInterface();
    
    }
}
      


import java.awt.*;
import java.util.List;
import java.util.*;

class LineChart extends Canvas  
{  
    private List<Double> series;
    private Color color;
    private String CompanyName;
    
    public LineChart() 
    {  
        setBackground (Color.WHITE);  
        
    }
    
    public void paint(Graphics g)  
    {  
        g.setColor(Color.black);
        // draw axis
        int pad = 10;
        g.drawLine(pad, pad, pad, getHeight()-pad); //defining x and y coor
        g.drawLine(pad, getHeight()-pad, getWidth()-pad, getHeight()-pad); //defining x and y coor
        
        // starting coordinates
        int x0 = pad;
        int y0 = getHeight()-pad;
    
        
        if (series == null) 
        {
            return;
        }
        
        double seriesMin = series.get(0);
        double seriesMax = series.get(0);
        for (int i=0; i<series.size(); i++) //finding min and max values
        {
            if (series.get(i) > seriesMax) 
            {
                seriesMax = series.get(i);
            }
            
            if (series.get(i) < seriesMin) 
            {
                seriesMin = series.get(i);
            }
        }
        int seriesHeight = getHeight() - 2*pad;
        int seriesWidth = getWidth() - 3*pad;
        int step = seriesWidth/series.size();
        double scale = (double)(seriesHeight/(seriesMax- seriesMin)/1.3);
        
        
        int[] X = new int[series.size()];
        int[] Y = new int[series.size()];
        
        int x = x0;
        for (int i=0; i< series.size(); i++) 
        {
            X[i] = x;
            x += step;
            
            Y[i] = (int)(y0- seriesHeight*0.1 - (series.get(i) - seriesMin)*scale);
            
        }
        
        g.setColor(color);
        g.drawPolyline(X, Y, series.size());
        g.drawString(String.format("%.2f", series.get(series.size()-1)), X[series.size()-1]+3, Y[series.size()-1]);
        g.drawString(CompanyName, x0+200, y0-98);
    }
    
    public void plot(List<Double> series, Color color, String CompanyName) 
    {
        this.series = series;
        this.color = color;
        this.CompanyName = CompanyName;
        repaint();
    }
}  

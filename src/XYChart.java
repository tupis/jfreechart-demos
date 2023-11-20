import DTO.CSVDTO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

public class XYChart extends ApplicationFrame {

	private static final long serialVersionUID = 3114198779331053753L;

    public XYChart(final String title, CSVDTO nordeste, CSVDTO maranhao, CSVDTO saoLuis) {

        super(title);
        final JFreeChart chart = createChart(createDataset(nordeste, maranhao, saoLuis));

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    private XYSeriesCollection createDataset(CSVDTO nordeste, CSVDTO maranhao, CSVDTO saoLuis) {
    	XYSeriesCollection collection = new XYSeriesCollection();
        
    	XYSeries s1 = new XYSeries("S1");
    	s1.add(1, 5);
    	s1.add(2, 9);
    	s1.add(3, 3);
    	s1.add(4, 8);
    	collection.addSeries(s1);
    	
    	
    	XYSeries s2 = new XYSeries("S2");
    	s2.add(1, 9);
    	s2.add(2, 3);
    	s2.add(3, 8);
    	s2.add(4, 5);
    	collection.addSeries(s2);
    	
    	
    	XYSeries s3 = new XYSeries("S3");
    	for (double i =0; i<4; i += 0.1) {
    		s3.add(i, Math.sin(i));
    	}
    	collection.addSeries(s3);
    	
    	return collection;
    	
    }
    

    private JFreeChart createChart(XYSeriesCollection dataset) {
    	JFreeChart chart = ChartFactory.createXYLineChart("title", "xAxisLabel", "yAxisLabel", dataset, PlotOrientation.VERTICAL, true, true, true);

        return chart;
    }
    
    public static void main(final String[] args) {

    }

}
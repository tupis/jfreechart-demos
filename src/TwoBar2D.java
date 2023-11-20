import DTO.CSVDTO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;


public class TwoBar2D extends ApplicationFrame {

	private static final long serialVersionUID = -1314877738034042129L;

    public TwoBar2D(final String title, CSVDTO data1, CSVDTO data2) {
        super(title);

        String titleChart = "Comparação entre " + data1.getLocal() + " e " + data2.getLocal();

        final JFreeChart chart = createChart(createDataset(data1, data2), titleChart);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset(CSVDTO data1, CSVDTO data2) {
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.setValue(data1.getJaneiro(), data1.getLocal(), "Jan");
        dataset.setValue(data1.getFevereiro(), data1.getLocal(), "Fev");
        dataset.setValue(data1.getMarco(), data1.getLocal(), "Mar");
        dataset.setValue(data1.getAbril(), data1.getLocal(), "Abr");
        dataset.setValue(data1.getMaio(), data1.getLocal(), "Mai");
        dataset.setValue(data1.getJunho(), data1.getLocal(), "Jun");
        dataset.setValue(data1.getJulho(), data1.getLocal(), "Jul");
        dataset.setValue(data1.getAgosto(), data1.getLocal(), "Ago");
        dataset.setValue(data1.getSetembro(), data1.getLocal(), "Set");
        dataset.setValue(data1.getOutubro(), data1.getLocal(), "Out");
        dataset.setValue(data1.getNovembro(), data1.getLocal(), "Nov");
        dataset.setValue(data1.getDezembro(), data1.getLocal(), "Dez");


        dataset.setValue(data2.getJaneiro(), data2.getLocal(), "Jan");
        dataset.setValue(data2.getFevereiro(), data2.getLocal(), "Fev");
        dataset.setValue(data2.getMarco(), data2.getLocal(), "Mar");
        dataset.setValue(data2.getAbril(), data2.getLocal(), "Abr");
        dataset.setValue(data2.getMaio(), data2.getLocal(), "Mai");
        dataset.setValue(data2.getJunho(), data2.getLocal(), "Jun");
        dataset.setValue(data2.getJulho(), data2.getLocal(), "Jul");
        dataset.setValue(data2.getAgosto(), data2.getLocal(), "Ago");
        dataset.setValue(data2.getSetembro(), data2.getLocal(), "Set");
        dataset.setValue(data2.getOutubro(), data2.getLocal(), "Out");
        dataset.setValue(data2.getNovembro(), data2.getLocal(), "Nov");
        dataset.setValue(data2.getDezembro(), data2.getLocal(), "Dez");

    	return dataset;
    }
    

    private JFreeChart createChart(CategoryDataset dataset, String title) {

    	JFreeChart chart = ChartFactory.createBarChart(title, "Meses", "Número de óbitos", dataset, PlotOrientation.VERTICAL, true, true, true);

    	CategoryPlot plot = chart.getCategoryPlot();
    	
    	plot.setRangeGridlinePaint(Color.BLACK);
    
    	plot.setBackgroundPaint(Color.WHITE);
    	
    	plot.setOutlineVisible(false);
    	
    	BarRenderer renderer = (BarRenderer) plot.getRenderer();
    	
    	renderer.setGradientPaintTransformer(null);
    	
    	GradientPaint gp1 = new GradientPaint(
			7, 7, Color.BLUE,
			2, 2, Color.BLACK,
			true
		);
		renderer.setSeriesPaint(0, gp1);
    	
    	renderer.setBarPainter(new StandardBarPainter());
    	
        return chart;
        
    }
}



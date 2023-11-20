


import java.awt.Color;
import java.awt.GradientPaint;
import java.lang.reflect.Field;

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
import org.jfree.ui.RefineryUtilities;


public class Bar2D extends ApplicationFrame {
	private static final long serialVersionUID = -1314877738034042129L;

    public Bar2D(final String title, CSVDTO fields) {
        super(title);
        final JFreeChart chart = createChart(createDataset(fields), fields.getLocal());
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset(CSVDTO fields) {
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.setValue(fields.getJaneiro(), fields.getLocal(), "Jan");
        dataset.setValue(fields.getFevereiro(), fields.getLocal(), "Fev");
        dataset.setValue(fields.getMarco(), fields.getLocal(), "Mar");
        dataset.setValue(fields.getAbril(), fields.getLocal(), "Abr");
        dataset.setValue(fields.getMaio(), fields.getLocal(), "Mai");
        dataset.setValue(fields.getJunho(), fields.getLocal(), "Jun");
        dataset.setValue(fields.getJulho(), fields.getLocal(), "Jul");
        dataset.setValue(fields.getAgosto(), fields.getLocal(), "Ago");
        dataset.setValue(fields.getSetembro(), fields.getLocal(), "Set");
        dataset.setValue(fields.getOutubro(), fields.getLocal(), "Out");
        dataset.setValue(fields.getNovembro(), fields.getLocal(), "Nov");
        dataset.setValue(fields.getDezembro(), fields.getLocal(), "Dez");

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



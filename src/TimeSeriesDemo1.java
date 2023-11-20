import java.awt.Color;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;

import DTO.CSVDTO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo1 extends ApplicationFrame {


    public TimeSeriesDemo1(String title, CSVDTO DTOMaranhao, CSVDTO DTOSaoLuis) {
        super(title);
        XYDataset dataset = createDataset(DTOMaranhao, DTOSaoLuis);
        JFreeChart chart = createChart(dataset, DTOMaranhao, DTOSaoLuis);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setMouseZoomable(true, false);
        setContentPane(chartPanel);
    }


    private static JFreeChart createChart(XYDataset dataset, CSVDTO DTOMaranhao, CSVDTO DTOSaoLuis) {

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            DTOMaranhao.getLocal() + " x " + DTOSaoLuis.getLocal(),
            "Meses",
            "Número de óbitos",
            dataset,          
            true,             
            true,             
            false             
        );

        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
        
        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
        }
        
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        
        return chart;
    }
    
   
    private static XYDataset createDataset(CSVDTO DTOMaranhao, CSVDTO DTOSaoLuis) {

        TimeSeries infosSaoLuis = new TimeSeries(DTOSaoLuis.getLocal(), Month.class);

        infosSaoLuis.add(new Month(1, 2022), DTOSaoLuis.getJaneiro());
        infosSaoLuis.add(new Month(2, 2022), DTOSaoLuis.getFevereiro());
        infosSaoLuis.add(new Month(3, 2022), DTOSaoLuis.getMarco());
        infosSaoLuis.add(new Month(4, 2022), DTOSaoLuis.getAbril());
        infosSaoLuis.add(new Month(5, 2022), DTOSaoLuis.getMaio());
        infosSaoLuis.add(new Month(6, 2022), DTOSaoLuis.getJunho());
        infosSaoLuis.add(new Month(7, 2022), DTOSaoLuis.getJulho());
        infosSaoLuis.add(new Month(8, 2022), DTOSaoLuis.getAgosto());
        infosSaoLuis.add(new Month(9, 2022), DTOSaoLuis.getSetembro());
        infosSaoLuis.add(new Month(10, 2022), DTOSaoLuis.getOutubro());
        infosSaoLuis.add(new Month(11, 2022), DTOSaoLuis.getNovembro());
        infosSaoLuis.add(new Month(12, 2022), DTOSaoLuis.getDezembro());

        TimeSeries infosMaranhao = new TimeSeries(DTOMaranhao.getLocal(), Month.class);

        infosMaranhao.add(new Month(1, 2022), DTOMaranhao.getJaneiro());
        infosMaranhao.add(new Month(2, 2022), DTOMaranhao.getFevereiro());
        infosMaranhao.add(new Month(3, 2022), DTOMaranhao.getMarco());
        infosMaranhao.add(new Month(4, 2022), DTOMaranhao.getAbril());
        infosMaranhao.add(new Month(5, 2022), DTOMaranhao.getMaio());
        infosMaranhao.add(new Month(6, 2022), DTOMaranhao.getJunho());
        infosMaranhao.add(new Month(7, 2022), DTOMaranhao.getJulho());
        infosMaranhao.add(new Month(8, 2022), DTOMaranhao.getAgosto());
        infosMaranhao.add(new Month(9, 2022), DTOMaranhao.getSetembro());
        infosMaranhao.add(new Month(10, 2022), DTOMaranhao.getOutubro());
        infosMaranhao.add(new Month(11, 2022), DTOMaranhao.getNovembro());
        infosMaranhao.add(new Month(12, 2022), DTOMaranhao.getDezembro());

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(infosMaranhao);
        dataset.addSeries(infosSaoLuis);

        return dataset;
    }

   
    public static JPanel createDemoPanel(CSVDTO DTOMaranhao, CSVDTO DTOSaoLuis) {
        JFreeChart chart = createChart(createDataset(DTOMaranhao, DTOSaoLuis), DTOMaranhao, DTOSaoLuis);
        return new ChartPanel(chart);
    }

}
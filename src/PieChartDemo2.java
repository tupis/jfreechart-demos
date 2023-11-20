import DTO.CSVDTO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import java.awt.*;

public class PieChartDemo2 extends ApplicationFrame {


    public PieChartDemo2(final String title, CSVDTO brasil, CSVDTO nordeste, CSVDTO maranhao, CSVDTO saoLuis) {

        super(title);
        final PieDataset dataset = createDataset(brasil, nordeste, maranhao, saoLuis);
        final JFreeChart chart = createChart(dataset);

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }
    
    private PieDataset createDataset(CSVDTO brasil, CSVDTO nordeste, CSVDTO maranhao, CSVDTO saoLuis) {
        final DefaultPieDataset dataset = new DefaultPieDataset();

        dataset.setValue(brasil.getLocal(), brasil.getTotalAno());
        dataset.setValue(nordeste.getLocal(), nordeste.getTotalAno());
        dataset.setValue(maranhao.getLocal(), maranhao.getTotalAno());
        dataset.setValue(saoLuis.getLocal(), saoLuis.getTotalAno());

        return dataset;
    }

    private JFreeChart createChart(final PieDataset dataset) {
        final JFreeChart chart = ChartFactory.createPieChart(
            "Pie Chart Demo 2",  // chart title
            dataset,             // dataset
            true,                // include legend
            true,
            false
        );
        final PiePlot plot = (PiePlot) chart.getPlot();
        plot.setNoDataMessage("No data available");
        plot.setExplodePercent(0, 0.30);
        
        plot.setSectionPaint("One", Color.BLACK);
        plot.setSectionPaint("Two", Color.WHITE);
        

        plot.setOutlinePaint(Color.RED);
        
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}--{1}--{2}"));
        
        plot.setLabelLinkStyle(PieLabelLinkStyle.STANDARD);
        
        chart.setBorderVisible(false);
        
        chart.setBorderPaint(Color.RED);

        return chart;
    }
    
    public static void main(final String[] args) {


    }

}
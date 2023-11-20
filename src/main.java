import DTO.CSVDTO;
import org.jfree.ui.RefineryUtilities;

import java.util.List;

public class main {
    public static void main(final String[] args) {
        CSVReader csvReader = new CSVReader();
        List<CSVDTO> csv = csvReader.readCSV();

        CSVDTO dataBrasil = csv.get(0);
        CSVDTO dataNordeste = csv.get(1);
        CSVDTO dataMaranhao = csv.get(2);
        CSVDTO dataSaoLuis = csv.get(3);

        executeOneBar(dataBrasil);
        executeOneBar(dataNordeste);
        executeTwoBar(dataBrasil, dataNordeste);
        executeMaranhoSaoLuis(dataMaranhao, dataSaoLuis);
    }

    private static void executeGraphicPizza(CSVDTO brasil, CSVDTO nordeste, CSVDTO maranhao, CSVDTO saoLuis) {
        final PieChartDemo2 demo = new PieChartDemo2("Pie Chart Demo 2", brasil, nordeste, maranhao, saoLuis);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

    private static void executeOneBar(CSVDTO data) {
        final Bar2D demo = new Bar2D(data.getLocal(), data);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

    private static void executeTwoBar(CSVDTO data, CSVDTO data2) {
        String title = "Comparação entre " + data.getLocal() + " e " + data2.getLocal();
        final TwoBar2D demo = new TwoBar2D(title, data, data2);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

    private static void executeNordesMaranhaoSaoLuis(CSVDTO nordeste, CSVDTO maranhao, CSVDTO saoLuis) {
        final XYChart demo = new XYChart("Title", nordeste, maranhao, saoLuis);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

    private static void executeMaranhoSaoLuis(CSVDTO dataMaranhao, CSVDTO dataSaoLuis) {
        TimeSeriesDemo1 demo = new TimeSeriesDemo1("Número de Obitos", dataMaranhao, dataSaoLuis);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}

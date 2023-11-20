import DTO.CSVDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {


    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + File.separator + "src" + File.separator + "locais.csv";

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int[] desiredLines = {1, 10, 11, 20};
            
            int lineCount = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                lineCount++;

                String[] fields = line.split(",");

                if(lineCount == desiredLines[0] || lineCount == desiredLines[1] || lineCount == desiredLines[2] || lineCount == desiredLines[3]) {
                    for(int i = 0; i < fields.length; i++) {
                        if(i > 20) {
                            System.out.println("Campo " + i + ": " + fields[i]);
                        }
                    }   
                    System.out.println();                 
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + filePath);
            e.printStackTrace();
        }
    }

    public List<CSVDTO> readCSV(String path) {
        String filePath;

        if(path != null) {
            filePath = path;
        } else {
            String currentDirectory = System.getProperty("user.dir");
            filePath = currentDirectory + File.separator + "src" + File.separator + "localidade.csv";
        }

        List<CSVDTO> dto = new ArrayList<CSVDTO>();

        try {

            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int[] desiredLines = {1, 10, 11, 20};

            int lineCount = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                lineCount++;

                String[] fields = line.split(";");

                if(lineCount == desiredLines[0] || lineCount == desiredLines[1] || lineCount == desiredLines[2] || lineCount == desiredLines[3]) {
                    CSVDTO csv = new CSVDTO();
                    for(int i = 0; i < fields.length; i++) {
                        if(i > 20) {
                            switch (i) {
                                case 21:
                                    csv.setLocal(fields[i]);
                                    break;
                                case 22:
                                    csv.setJaneiro(formatNumber(fields[i]));
                                    break;
                                case 23:
                                    csv.setFevereiro(formatNumber(fields[i]));
                                    break;
                                case 24:
                                    csv.setMarco(formatNumber(fields[i]));
                                    break;
                                case 25:
                                    csv.setAbril(formatNumber(fields[i]));
                                    break;
                                case 26:
                                    csv.setMaio(formatNumber(fields[i]));
                                    break;
                                case 27:
                                    csv.setJunho(formatNumber(fields[i]));
                                    break;
                                case 28:
                                    csv.setJulho(formatNumber(fields[i]));
                                    break;
                                case 29:
                                    csv.setAgosto(formatNumber(fields[i]));
                                    break;
                                case 30:
                                    csv.setSetembro(formatNumber(fields[i]));
                                    break;
                                case 31:
                                    csv.setOutubro(formatNumber(fields[i]));
                                    break;
                                case 32:
                                    csv.setNovembro(formatNumber(fields[i]));
                                    break;
                                case 33:
                                    csv.setDezembro(formatNumber(fields[i]));
                                    break;
                                case 34:
                                    csv.setTotalAno(formatNumber(fields[i]));
                                    break;
                                default:
                                    break;
                            }

                        }
                    }
                    dto.add(csv);
                    System.out.println();
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + filePath);
            e.printStackTrace();
        }

        return dto;
    }

    public List<CSVDTO> readCSV() {
        return readCSV(null);
    }

    private Double formatNumber(String number) {
        return Double.parseDouble(number.replace(".", "").replace(",", "."));
    }
}

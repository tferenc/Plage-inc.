package utility; /**
 * Created by tamasferenc on 2017.02.28..
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

    private String filepath = "Plage-inc./diseases.csv";

    public DiseaseCard[] readlnCards(filepath) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(filepath));
            while ((line = br.readLine()) != null) {

                String[] virus = line.split(cvsSplitBy);

                System.out.println("Vírus neve : " + virus[0] + "," + " halálozási ráta: " + virus[1] + "," + " Halálozás/100 000 fő "
                        + virus[2] + "," + " Lappangási idő (nap): " + virus[3]);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
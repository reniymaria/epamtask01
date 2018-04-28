package by.tc.task01.dao.impl.fileparsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
    private static final String FILENAME = "C:\\Users\\maria.yurchak\\Documents\\Java\\JavaEpam\\TemplateMariaYurchak\\Template\\src\\main\\resources\\appliances_db.txt"; //folder should be changed
    private ParsingLine parseLine = new ParsingLine();

    public void readFile() {
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.trim().isEmpty()) {
                    continue;
                } else {
                    parseLine.parseAll(sCurrentLine);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

    public ParsingLine getParsingLine() {
        return parseLine;
    }

}
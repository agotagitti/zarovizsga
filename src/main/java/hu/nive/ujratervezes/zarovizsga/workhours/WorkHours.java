package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {


    public String minWork(String file) {
        Path path = Path.of(file);
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            StringBuilder sb = new StringBuilder();
            int minWorkHour = 0;
            while((line = br.readLine()) != null) {
                minWorkHour = getMinWorkHour(line, sb, minWorkHour);
            }
            return sb.toString();
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot access file", ioe);
        }
    }

    private int getMinWorkHour(String line, StringBuilder sb, int minWorkHour) {
        String[] lineData = line.split(",");
        if (minWorkHour == 0 || Integer.parseInt(lineData[1]) < minWorkHour) {
            minWorkHour = Integer.parseInt(lineData[1]);
            sb.setLength(0);
            sb.append(lineData[0]);
            sb.append(": ");
            sb.append(lineData[2]);
        }
        return minWorkHour;
    }
}

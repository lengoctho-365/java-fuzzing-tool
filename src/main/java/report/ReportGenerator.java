package report;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import crash.CrashScanner;

public class ReportGenerator {

    public static void export(File out) throws Exception {
        List<File> crashes = CrashScanner.scan();
        try (FileWriter w = new FileWriter(out)) {
            w.write("Fuzz report\n");
            w.write("=================\n");
            for (File c : crashes) {
                w.write(c.getAbsolutePath() + "\n");
            }
        }
    }
}

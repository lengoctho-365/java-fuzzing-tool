package crash;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CrashScanner {

    public static List<File> scan() {
        List<File> out = new ArrayList<>();
        File root = new File(".");
        scanRecursive(root, out);
        return out;
    }

    private static void scanRecursive(File f, List<File> out) {
        if (f.isDirectory()) {
            File[] children = f.listFiles();
            if (children == null) return;
            for (File c : children) scanRecursive(c, out);
        } else {
            String name = f.getName().toLowerCase();
            if (name.contains("crash") || name.contains("repro") || name.contains("crash_") || name.startsWith("crash")) {
                out.add(f);
            }
        }
    }
}

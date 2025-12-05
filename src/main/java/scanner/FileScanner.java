package scanner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileScanner {
    public static List<File> scanJavaFiles(File root) {
        List<File> result = new ArrayList<>();
        scanRecursively(root, result);
        return result;
    }

    private static void scanRecursively(File file, List<File> list) {
        if (!file.exists()) return;

        if (file.isFile() && file.getName().endsWith(".java")) {
            list.add(file);
            return;
        }

        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                scanRecursively(f, list);
            }
        }
    }
}

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
            // Bỏ qua các thư mục không liên quan
            String name = f.getName();
            if (name.equals("src") || name.equals("target") || 
                name.equals(".git") || name.equals(".idea")) {
                return;
            }
            
            File[] children = f.listFiles();
            if (children == null) return;
            for (File c : children) scanRecursive(c, out);
        } else {
            String name = f.getName();
            
            // CHỈ CHẤP NHẬN CRASH FILES TỪ JAZZER
            // Jazzer tạo crash files với pattern: crash-<hash>
            // KHÔNG bao gồm .java, .class, hoặc các file khác
            if (name.startsWith("crash-") && !name.contains(".")) {
                // Kiểm tra file có nội dung (không phải file rỗng)
                if (f.length() > 0) {
                    out.add(f);
                    System.out.println("Real crash found: " + f.getAbsolutePath());
                }
            }
        }
    }
}
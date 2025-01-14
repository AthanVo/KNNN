package movieticketbooking;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageFinder {

    public static void main(String[] args) {
        String startDirectory = "D:/"; // Thư mục bắt đầu, có thể thay đổi
        List<String> imageFiles = new ArrayList<>();
        findImages(new File(startDirectory), imageFiles);

        // In ra danh sách các tệp ảnh
        for (String filePath : imageFiles) {
            System.out.println(filePath);
        }
    }

    // Phương thức duyệt và tìm ảnh
    public static void findImages(File dir, List<String> imageFiles) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles(); // Lấy danh sách tệp/thư mục con
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        // Đệ quy duyệt qua các thư mục con
                        findImages(file, imageFiles);
                    } else if (isImageFile(file)) {
                        // Thêm tệp ảnh vào danh sách
                        imageFiles.add(file.getAbsolutePath());
                    }
                }
            }
        }
    }

    // Kiểm tra xem tệp có phải ảnh không
    public static boolean isImageFile(File file) {
        String[] imageExtensions = {".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        String fileName = file.getName().toLowerCase();
        for (String ext : imageExtensions) {
            if (fileName.endsWith(ext)) {
                return true;
            }
        }
        return false;
    }
}

//Предварительно вручную создать папку Games на диске D
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String t = "Успешно создан";
        String f = "НЕ создан";

        File srcDir = new File("D://Games//src");
        File resDir = new File("D://Games//res");
        File saveGamesDir = new File("D://Games//savegames");
        File tempDir = new File("D://Games//temp");
        File mainDir = new File(srcDir, "main");
        File testDir = new File(srcDir, "test");
        File drawablesDir = new File(resDir, "drawables");
        File vectorsDir = new File(resDir, "vectors");
        File iconsDir = new File(resDir, "icons");
        List<File> dirs = Arrays.asList(srcDir, resDir, saveGamesDir, tempDir, mainDir, testDir,drawablesDir, vectorsDir, iconsDir);
        for (File dir : dirs) {
            if (dir.mkdir())
                sb.append("Каталог " + dir +" " + t + "\n");
            else
                sb.append("Каталог " + dir + " " + f + "\n");
        }

        File mainFile = new File(mainDir, "Main.java");
        File utilsFile = new File(mainDir, "Utils.java");
        File tempFile = new File(tempDir, "temp.txt");
        List<File> files = Arrays.asList(mainFile, utilsFile, tempFile);
        for (File file : files) {
            try {
                if (file.createNewFile())
                    sb.append("Файл " + file + " " + t + "\n");
                else
                    sb.append("Файл " + file + " " + f + "\n");
            } catch(IOException ex) {
                sb.append(ex.getMessage());
            }
        }

        try(FileWriter writer = new FileWriter(tempFile)) {
            writer.write(sb.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

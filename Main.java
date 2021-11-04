import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        //создание каталогов
        katalog(text,
                "D://netologi//Games//src//main",
                "D://netologi//Games//src//test",
                "D://netologi//Games//res//drawables",
                "D://netologi//Games//res//vectors",
                "D://netologi//Games//icons",
                "D://netologi//Games//savegames",
                "D://netologi//Games//temp");
        //создание файлов
        createFile(text,
                "D://netologi//Games//src//main//Main.java",
                "D://netologi//Games//src//main//Utils.java",
                "D://netologi//Games//temp//temp.txt"
        );
        //создание лога
        try (FileWriter writer = new FileWriter("D://netologi//Games//temp//temp.txt", false)) {
            writer.write(text.toString());
            writer.flush();
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    public static void katalog(StringBuilder text, String... links) {
        for (String path : links) {
            File src = new File(path);
            if (src.mkdirs()) {
                text.append("каталог " + path.substring(21) + " создан\n");
            }
        }
    }

    public static void createFile(StringBuilder text, String... links) {
        for (String path : links) {
            File utils = new File(path);
            try {
                if (utils.createNewFile()) {
                    text.append("Файл " + path.substring(21) + " создан\n");
                }
            } catch (IOException err) {
                text.append(err.getMessage()).append("\n");
            }
        }
    }
}

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UniqueWordsCounter {
    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\Lenovo\\OneDrive\\Dokumenty\\solvd\\input.txt");
        File outputFile = new File("C:\\Users\\Lenovo\\OneDrive\\Dokumenty\\solvd\\output.txt");

        try {
            List<String> lines = FileUtils.readLines(inputFile, "UTF-8");

            Set<String> uniqueWords = new HashSet<>();
            Set<String> duplicateWords = new HashSet<>();

            lines.stream()
                    .map(StringUtils::split)
                    .flatMap(Arrays::stream)
                    .map(StringUtils::strip)
                    .filter(word -> !word.isEmpty())
                    .map(String::toLowerCase)
                    .forEach(word -> {
                        if (!uniqueWords.contains(word)) {
                            uniqueWords.add(word);
                        } else {
                            duplicateWords.add(word);
                        }
                    });
            uniqueWords.removeAll(duplicateWords);

            FileUtils.writeStringToFile(outputFile, "Number of unique words: " + uniqueWords.size(), "UTF-8");
        } catch (IOException e) {
            System.err.println("Error: The specified file does not exist.");
        }
    }
}


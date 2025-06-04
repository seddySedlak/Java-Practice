package OOP.HUB;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

//Important
//filePractice contains counting of characters, words, paragrahps, sentences, lines and appending

public class filePractice1 {
    void run() {
        String inPath = "files/Movies.txt";
        String outPath = "files/filePracticeAppend.txt";
        int charCount = 0;
        int wordCount = 0;
        int paragraphs = 0;
        int sentences = 0;
        try {
            List<String> lines = Files.readAllLines(Paths.get(inPath));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(outPath), true)));
            //count of characters
            for (String line : lines) {
                charCount += line.length();
                //count of paragraphs
                if (line.equals("")) {
                    paragraphs++;
                }
                //count of sentences
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '?' || line.charAt(i) == '.' || line.charAt(i) == '!') {
                        sentences++;
                    }
                }
                //count of words
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == ' ') {
                        wordCount++;
                    }
                }
                wordCount++;
            }
            pw.println("---" + inPath + "---");
            pw.println("Line: " + lines.size());
            pw.println("Words: " + wordCount);
            pw.println("Char: " + charCount);
            pw.println("Paragraphs: " + (paragraphs + 1));
            pw.println("Sentences: " + sentences);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

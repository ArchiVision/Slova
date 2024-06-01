package org.archivision.slova.theaetetus.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TextLoader {
    public static String loadText(String fileName) throws IOException {
        // Get the InputStream for the file from the resources folder
        ClassLoader classLoader = TextLoader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IOException("File " + fileName + " not found in resources folder.");
        }

        // Read the contents of the file
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Ignore lines starting with '#'
                if (!line.trim().startsWith("#")) {
                    contentBuilder.append(line).append("\n");
                }
            }
        }

        return contentBuilder.toString();
    }
}
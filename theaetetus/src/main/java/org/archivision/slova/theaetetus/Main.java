package org.archivision.slova.theaetetus;

import org.archivision.slova.theaetetus.util.TextLoader;
import org.languagetool.JLanguageTool;
import org.languagetool.language.Ukrainian;
import org.languagetool.rules.RuleMatch;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        final JLanguageTool langTool = new JLanguageTool(new Ukrainian());
        final String text = TextLoader.loadText("Theaetetus");
        final List<RuleMatch> matches = langTool.check(text);

        for (RuleMatch match : matches) {
            System.out.println("Potential error at characters " +
                    match.getFromPos() + "-" + match.getToPos() + ": " +
                    match.getMessage());
            System.out.println("Suggested correction(s): " +
                    match.getSuggestedReplacements());
        }
    }
}
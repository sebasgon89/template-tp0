package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.List;

public class RegExGenerator {
    private int maxLength = 5;

    public RegExGenerator(int maxLength) {
        this.maxLength = maxLength;
    }

    public List<String> generate(String regEx, int numberOfResults) {
        final RegExParser regExParser = new RegExParser(regEx, this.maxLength);

        return new ArrayList<String>() {
            {

                String aux = new String(regExParser.parseRegExpression());
                //add(regExParser.parseRegExpression());
                //add("b");
                //add("c");
            }
        };
    }
}
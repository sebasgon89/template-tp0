package ar.fiuba.tdd.template.tp0;


import java.util.List;
import java.util.Random;

public class RegExParser {

    private String regExExpression;
    private String result;
    private int maxChars;

    public RegExParser (String expression, int maxChars){
        this.regExExpression = expression;
        this.maxChars = maxChars;
        this.result = new String("");
    }

    private char currentChar(int index){
        return this.regExExpression.charAt(index);
    }

    private char nextChar(int index){
        if (index < this.regExExpression.length()-1){
            return this.regExExpression.charAt(index + 1);
        } else {
            return 'a';
        }

    }

    private int randomNumber (int min, int max){
        Random rand = new Random();
        int randNum = rand.nextInt((max - min) + 1) + min;
        return randNum;
    }

    private char randomCharacter (){
        Random rand = new Random();
        char randChar = (char) (rand.nextInt(26) + 'a');
        return randChar;
    }

    private String randomString(char ammount, boolean randomChars, char toRepeat){

        int randomMin;
        int randomMax;
        String randomString = new String("");

        if (ammount == '*'){
            randomMin = 0;
            randomMax = this.maxChars;
        } else if (ammount == '?') {
            randomMin = 0;
            randomMax = 1;
        } else if (ammount == '+'){
            randomMin = 1;
            randomMax = this.maxChars;
        } else {//if (ammount == '1'){
            randomMin = 1;
            randomMax = 1;
        }

        int ammountOfChars = randomNumber(randomMin, randomMax);
        for (int i=0; i<ammountOfChars; i++){
            if (randomChars) {
                randomString += randomCharacter();
            } else {
                randomString += toRepeat;
            }
        }

        return randomString;



    }



    public String parseRegExpression(){
        String intermediateResult = new String();
        String setExpr = new String();
        String repeatCharacters = new String("+*?");

        int charCount = 0;
        while (charCount < this.regExExpression.length()){
            if (currentChar(charCount) == '.'){
                if (repeatCharacters.indexOf(nextChar(charCount)) != 0){
                    intermediateResult += randomString(nextChar(charCount), true, 'x');
                    charCount++;
                } else {
                    intermediateResult += randomCharacter();
                }
            } else {
                if (repeatCharacters.indexOf(nextChar(charCount)) != 0){
                    intermediateResult += randomString(nextChar(charCount), false, currentChar(charCount));
                    charCount++;
                } else {
                    intermediateResult += currentChar(charCount);
                }
            }

            charCount++;

            this.result += intermediateResult;
            intermediateResult = "";
        }

        return this.result;

    }

}

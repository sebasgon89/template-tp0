package ar.fiuba.tdd.template.tp0;


public class Application {
    public static void main(String args[]){
        RegExGenerator rEG = new RegExGenerator(5);

        rEG.generate(args[0], 1);
    }
}

package part8;

/**
 * Created by niceyuanze on 17-4-19.
 */
public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy v){
        this.strategy = v;
    }

    public boolean validate(String s){
        return strategy.execute(s);
    }

    public static void main(String[] args) {
        Validator numericValidator = new Validator( s -> s.matches("[a-z]+"));
        boolean b1 = numericValidator.validate("aaa");
        System.out.println(b1);
        Validator lowerCaseValidator = new Validator( s -> s.matches("\\d+"));
        System.out.println(lowerCaseValidator.validate("111"));

    }
}

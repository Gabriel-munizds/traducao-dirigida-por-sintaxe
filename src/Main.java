//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String input = "8+5-7+9";
        Parser p = new Parser(input.getBytes());
        p.parse();

    }
}
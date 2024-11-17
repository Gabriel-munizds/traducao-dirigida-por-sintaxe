public class Parser {
    private byte[] input;
    private int current;


    public Parser(byte[] bytes) {
        this.input = bytes;
    }

    public void parse() {
        expr();
    }


    private char peek(){
        if(current < input.length){
            return (char) input[current];
        }
        return '\0';
    }

    private void match(char c){
        if(c == peek()){
            current++;
        } else {
            throw new Error("erro de sintaxe");
        }
    }
    void expr(){
        digit();
        oper();
    }

    private void digit() {
        if(Character.isDigit(peek())){
            System.out.println("push " + peek());
            match(peek());
        } else {
            throw new Error("Erro de sintaxe");
        }

    }

    private void oper() {
        if(peek() == '+'){
            match('+');
            digit();
            System.out.println("add");
            oper();
        } else if (peek() == '-') {
            match('-');
            digit();
            System.out.println("sub");
            oper();
        }
    }
}

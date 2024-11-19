public class Parser {
    private Scanner scanner;
    private Token currentToken;


    public Parser(byte[] input) {
        scanner = new Scanner(input);
        currentToken = scanner.nextToken();
    }

    public void parse() {
        letStatement();
    }

    private void match(TokenType t) {
        if (currentToken.type == t) {
            nextToken();
        }else {
            throw new Error("syntax error");
        }
    }
    void expr() {
        term();
        oper();
    }

    void number () {
        System.out.println("push " + currentToken.lexeme);
        match(TokenType.NUMBER);
    }

    void oper () {
        if (currentToken.type == TokenType.PLUS) {
            match(TokenType.PLUS);
            term();
            System.out.println("add");
            oper();
        } else if (currentToken.type == TokenType.MINUS) {
            match(TokenType.MINUS);
            term();
            System.out.println("sub");
            oper();
        }
    }

    private void nextToken(){
        currentToken = scanner.nextToken();
    }
    void term () {
        if (currentToken.type == TokenType.NUMBER)
            number();
        else if (currentToken.type == TokenType.IDENT) {
            System.out.println("push "+currentToken.lexeme);
            match(TokenType.IDENT);
        }
        else
            throw new Error("syntax error");
    }
    void letStatement () {
        match(TokenType.LET);
        var id = currentToken.lexeme;
        match(TokenType.IDENT);
        match(TokenType.EQ);
        expr();
        System.out.println("pop "+id);
        match(TokenType.SEMICOLON);
    }
}

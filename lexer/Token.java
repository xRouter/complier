package lexer;

public class Token {

    public static final char NullChar = (char)-1;

    private TokenTypeEnum tokenType;

    private final StringBuilder tokenText = new StringBuilder();

    public TokenTypeEnum getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenTypeEnum tokenType) {
        this.tokenType = tokenType;
    }

    public String getTokenTextStr() {
        return tokenText.toString();
    }

    public Token append(char ch){
        tokenText.append(ch);
        return this;
    }

    public char charAt(int index){
        if (this.tokenText.length() < 1 || index < 0 || index > this.tokenText.length() - 1) {
            return NullChar;
        }
        return this.tokenText.charAt(index);
    }

    //是否是字母
    public static boolean isAlpha(int ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
    }

    //是否是数字
    public static boolean isDigit(int ch) {
        return ch >= '0' && ch <= '9';
    }

    //是否是空白字符
    public static boolean isBlank(int ch) {
        return ch == ' ' || ch == '\t' || ch == '\n';
    }
}

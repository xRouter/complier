package lexer.states;

import lexer.DfaStateEnum;
import lexer.LexerContext;
import lexer.Token;

public class DfaStateInitial extends DfaState {

    public DfaStateInitial(LexerContext context) {
        super(context);
    }

    public void accept(char ch){
        if (Token.isAlpha(ch)) { //第一个字符是字母
            if (ch == 'i') {
                context.toState(DfaStateEnum.KeywordInt).newToken().accept(ch);
            } else {
                context.toState(DfaStateEnum.Identifier).newToken().accept(ch); //进入Id状态
            }
        } else if (Token.isDigit(ch)) {//第一个字符是数字
            context.toState(DfaStateEnum.IntLiteral).accept(ch);
        } else if (ch == '>') { //第一个字符是>
            context.toState(DfaStateEnum.GT).newToken().accept(ch);
        } else if (ch == '+') {
            context.toState(DfaStateEnum.Plus).newToken().accept(ch);
        } else if (ch == '-') {
            context.toState(DfaStateEnum.Minus).newToken().accept(ch);
        }
//        else if (ch == '*') {
//            result = DfaStateEnum.Star;
//            token.setTokenType(TokenTypeEnum.Star);
//            token.append(ch);
//        } else if (ch == '/') {
//            result = DfaStateEnum.Slash;
//            token.setTokenType(TokenTypeEnum.Slash);
//            token.append(ch);
//        } else if (ch == ';') {
//            result = DfaStateEnum.SemiColon;
//            token.setTokenType(TokenTypeEnum.SemiColon);
//            token.append(ch);
//        } else if (ch == '(') {
//            result = DfaStateEnum.LeftParen;
//            token.setTokenType(TokenTypeEnum.LeftParen);
//            token.append(ch);
//        } else if (ch == ')') {
//            result = DfaStateEnum.RightParen;
//            token.setTokenType(TokenTypeEnum.RightParen);
//            token.append(ch);
//        } else if (ch == '=') {
//            result = DfaStateEnum.Assignment;
//            token.setTokenType(TokenTypeEnum.Assignment);
//            token.append(ch);
//        }
        else {
            context.toState(DfaStateEnum.Initial);
        }
    }
}

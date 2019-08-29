package lexer.states;

import lexer.DfaStateEnum;
import lexer.LexerContext;
import lexer.Token;
import lexer.TokenTypeEnum;

public class DfaStateIdKeywordInt extends DfaState {

    public DfaStateIdKeywordInt(LexerContext context) {
        super(context);
    }

    public void accept(char ch) {
        //进入int 分析状态
        if (  ch == 'i' && context.tokenCharAt(0) == Token.NullChar
           || ch == 'n' && context.tokenCharAt(0) == 'i'
           || ch == 't' && context.tokenCharAt(1) == 'n') {
            context.getCurToken().setTokenType(TokenTypeEnum.KeywordInt);
            context.getCurToken().append(ch);
            return;
        }
        if(Token.isBlank(ch)){
            if(context.tokenCharAt(2) == 't') {
                context.toState(DfaStateEnum.Initial).newToken().accept(ch);
                return;
            }
            context.getCurToken().setTokenType(TokenTypeEnum.Identifier);
            context.toState(DfaStateEnum.Initial).newToken().accept(ch);
            return;
        }
        //继续分析id模式
        if (Token.isDigit(ch) || Token.isAlpha(ch)) {
            context.toState(DfaStateEnum.Identifier).accept(ch);
            return;
        }
        //回初始状态
        throw new RuntimeException("Not support!");
    }
}

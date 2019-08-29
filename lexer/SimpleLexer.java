package lexer;

import java.util.List;

public class SimpleLexer {

    //什么时候改变状态，什么时候切换上下文；
    public static List<Token> parse(String script) {
        LexerContext context = new LexerContext(script);
        context.toState(DfaStateEnum.Initial);
        while (context.hasNext()) {
            char ch = context.next();
            context.getCurState().accept(ch);
            System.out.println(String.format("%s : %s  token=%s", ch, context.getCurState().getClass()
                    , JsonUtil.toJsonString(context.getCurToken())));
        }
        //放入最后一个
        if (!StringUtil.isBlank(context.getCurToken().getTokenTextStr())) {
            context.getTokenList().add(context.getCurToken());
        }
        return context.getTokenList();
    }

    public static void main(String[] args) {
        List<Token> tokens = parse("age >= 45+3");
        System.out.println(JsonUtil.toJsonString(tokens));
    }
}

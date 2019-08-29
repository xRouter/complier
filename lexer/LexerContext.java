package lexer;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexerContext {

    private String script;

    private int scriptIndex = 0;

    private DfaState curState;

    private Token curToken;

    private final List<Token> tokenList = new ArrayList<>();

    private final Map<DfaStateEnum, DfaState> stateMap;

    {
        stateMap = new HashMap<>();
        stateMap.put(DfaStateEnum.Initial, new DfaStateInitial(this));
        stateMap.put(DfaStateEnum.Identifier, new DfaStateIdentifier(this));
        stateMap.put(DfaStateEnum.Id_int1, new DfaStateIdKeywordInt(this));
        stateMap.put(DfaStateEnum.IntLiteral, new DfaStateIntLiteral(this));
        stateMap.put(DfaStateEnum.GT, new DfaStateGT(this));
        stateMap.put(DfaStateEnum.GE, new DfaStateGE(this));
        stateMap.put(DfaStateEnum.Plus, new DfaStatePlus(this));
        stateMap.put(DfaStateEnum.Minus, new DfaStateMinus(this));
    }

    public DfaState getCurState() {
        return curState;
    }

    public LexerContext toState(DfaStateEnum stateEnum) {
        DfaState state = stateMap.get(stateEnum);
        if (state == null) {
            throw new RuntimeException("未定义的类型:" + stateEnum);
        }
        this.curState = state;
        return this;
    }

    public Token getCurToken() {
        return curToken;
    }

    public LexerContext newToken() {
        return newToken(null);
    }

    public LexerContext newToken(TokenTypeEnum tokenType) {
        if (this.curToken != null && !StringUtil.isBlank(this.curToken.getTokenTextStr())) {
            tokenList.add(this.curToken);
        }

        if (tokenType != null) {
            Token tmp = new Token();
            tmp.setTokenType(tokenType);
            this.curToken = tmp;
        }

        return this;
    }

    public LexerContext accept(char ch) {
        if (this.curState == null) {
            throw new RuntimeException("state is null!");
        }
        this.curState.accept(ch);
        return this;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public LexerContext(String script) {
        Assert.hasText(script, "无效的文本：" + script);
        this.script = script;
    }

    public boolean hasNext() {
        return scriptIndex < script.length();
    }

    public char next() {
        return script.charAt(scriptIndex++);
    }

    public char tokenCharAt(int index) {
        return curToken == null ? Token.NullChar : curToken.charAt(index);
    }
}

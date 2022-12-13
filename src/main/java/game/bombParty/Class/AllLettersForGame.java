package game.bombParty.Class;

public enum AllLettersForGame {
    A('A'),
    B('B'),
    C('C'),
    D('D'),
    E('E'),
    F('F'),
    G('G'),
    H('H'),
    I('I'),
    J('J'),
    L('L'),
    M('M'),
    N('N'),
    O('O'),
    P('P'),
    Q('Q'),
    R('R'),
    S('S'),
    T('T'),
    U('U'),
    V('V');

    private final char value;
    AllLettersForGame(char value) {
        this.value = value;
    }

    public String getValue() {
        return String.valueOf(this.value);
    }
}
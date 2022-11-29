package game.bombParty.Class;

public enum Alphabet {
    A('A'),
    B('B'),
    C('C'),
    D('D'),
    E('E'),
    F('F'),
    G('G'),
    H('H'),
    I('I'),
    J('I'),
    K('K'),
    L('L'),
    M('M'),
    N('N'),
    O('O'),
    P('P'),
    Q('Q'),
    R('R'),
    S('S'),
    U('U'),
    V('V'),
    W('W'),
    X('X'),
    Y('Y'),
    Z('Z');

    private final char value;
    Alphabet(char value) {
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }
}
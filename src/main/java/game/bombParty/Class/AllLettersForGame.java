package game.bombParty.Class;

/**
 * Cette Enum permet d'avoir une liste de lettre pour le gain de vie quand on les a toutes trouvées. Il y a les lettres K, W, X, Y, Z qui ne sont pas comprises car elles sont trop compliqués à placer.
 */
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

    /**
     * Valeur de la lettre.
     */
    private final char value;

    /**
     * Le constructeur de la class AllLettersForGame.
     *
     * @param value : Valeur de la lettre.
     */
    AllLettersForGame(char value) {
        this.value = value;
    }

    /**
     * Avoir la valeur de la lettre.
     *
     * @return La valeur de la lettre.
     */
    public String getValue() {
        return String.valueOf(this.value);
    }
}
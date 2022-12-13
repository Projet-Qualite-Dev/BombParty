package game.bombParty.Class;

/**
 * Cette Enum permet d'avoir une liste de lettre pour le gain de vie quand on les a toutes trouvées. Il y a les lettres K, W, X, Y, Z qui ne sont pas (comprises) car elles sont trop compliquées à placer.
 */
public enum AllLettersForGame {

    /**
     * La lettre A.
     */
    A('A'),
    /**
     * La lettre B.
     */
    B('B'),
    /**
     * La lettre C.
     */
    C('C'),
    /**
     * La lettre D.
     */
    D('D'),
    /**
     * La lettre E.
     */
    E('E'),
    /**
     * La lettre F.
     */
    F('F'),
    /**
     * La lettre G.
     */
    G('G'),
    /**
     * La lettre H.
     */
    H('H'),
    /**
     * La lettre I.
     */
    I('I'),
    /**
     * La lettre J.
     */
    J('J'),
    /**
     * La lettre L.
     */
    L('L'),
    /**
     * La lettre M.
     */
    M('M'),
    /**
     * La lettre N.
     */
    N('N'),
    /**
     * La lettre O.
     */
    O('O'),
    /**
     * La lettre P.
     */
    P('P'),
    /**
     * La lettre Q.
     */
    Q('Q'),
    /**
     * La lettre R.
     */
    R('R'),
    /**
     * La lettre S.
     */
    S('S'),
    /**
     * La lettre T.
     */
    T('T'),
    /**
     * La lettre U.
     */
    U('U'),
    /**
     * La lettre V.
     */
    V('V');

    /**
     * Valeur de la lettre.
     */
    private final char value;

    /**
     * Le constructeur de l'enum AllLettersForGame.
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
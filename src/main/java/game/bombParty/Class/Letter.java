package game.bombParty.Class;

/**
 * Cette class permet de gérer les lettres que le joueur rentre.
 */
public final class Letter {

    /**
     * La valeur de la lettre.
     */
    private final AllLettersForGame value;
    /**
     * Si la lettre a déjà été utilisée ou non.
     */
    private boolean use;

    /**
     * Le constructeur de la class Letter.
     *
     * @param value : La lettre.
     */
    public Letter(AllLettersForGame value) {
        this.value = value;
        this.use = false;
    }

    /**
     * Savoir si la lettre a déjà été utilisée.
     *
     * @return boolean : Si la lettre a été utilisée.
     */
    public boolean getUse() {
        return this.use;
    }

    /**
     * Avoir la valeur de la lettre.
     *
     * @return La valeur de la lettre.
     */
    public String getValue() {
        return value.getValue();
    }

    /**
     * Mettre la lettre utilisée.
     */
    void use(){
        this.use = true;
    }

    /**
     * Mettre la lettre non utilisée.
     */
    public void unUse() {
        this.use = false;
    }

    /**
     * Avoir une couleur par rapport à l'utilisation de la lettre.
     *
     * @return La couleur.
     */
    public String getColor() {
        if (this.use) return "green";
        else return "white";
    }
}
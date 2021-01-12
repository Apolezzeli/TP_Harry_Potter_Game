package ar.com.ada.online.harrypotterpractice;

public abstract class Spell {

    protected String spellName;
    protected Integer energyCost;

    public Spell() {
    }

    public Spell(String spellName, Integer energyCost) {
        this.spellName = spellName;
        this.energyCost = energyCost;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public Integer getEnergyCost() {
        return energyCost;
    }

    public void setEnergyCost(Integer energyCost) {
        this.energyCost = energyCost;
    }

    public abstract void addSpell();
}

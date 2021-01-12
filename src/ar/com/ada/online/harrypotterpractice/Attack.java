package ar.com.ada.online.harrypotterpractice;

public class Attack extends Spell {

    protected Integer damageLevel;

    public Attack() {

    }

    public Attack(Integer damageLevel) {
        this.damageLevel = damageLevel;
    }

    public Attack(String spellName, Integer energyCost, Integer damageLevel) {
        super(spellName, energyCost);
        this.damageLevel = damageLevel;
    }

    public Integer getDamageLevel() {
        return damageLevel;
    }

    public void setDamageLevel(Integer damageLevel) {
        this.damageLevel = damageLevel;
    }

    @Override
    public void addSpell() {

    }
}



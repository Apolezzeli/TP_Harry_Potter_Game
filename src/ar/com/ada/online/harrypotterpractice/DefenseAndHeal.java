package ar.com.ada.online.harrypotterpractice;

public class DefenseAndHeal extends Spell {

    protected Integer lifeReceived;

    public DefenseAndHeal() {
    }

    public DefenseAndHeal(String spellName, Integer energyCost, Integer lifeReceived) {
        super(spellName, energyCost);
        this.lifeReceived = lifeReceived;
    }

    public Integer getLifeReceived() {
        return lifeReceived;
    }

    public void setLifeReceived(Integer lifeReceived) {
        this.lifeReceived = lifeReceived;
    }

    @Override
    public void addSpell() {

    }
}

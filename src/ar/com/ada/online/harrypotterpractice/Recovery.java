package ar.com.ada.online.harrypotterpractice;

public class Recovery extends Spell {

    protected Integer energyReceived;

    public Recovery() {
    }

    public Recovery(String spellName, Integer energyCost, Integer energyReceived) {
        super(spellName, energyCost);
        this.energyReceived = energyReceived;
    }

    public Integer getEnergyReceived() {
        return energyReceived;
    }

    public void setEnergyReceived(Integer energyReceived) {
        this.energyReceived = energyReceived;
    }

    @Override
    public void addSpell() {

    }
}

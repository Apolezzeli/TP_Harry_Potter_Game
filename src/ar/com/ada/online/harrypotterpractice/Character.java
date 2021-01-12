package ar.com.ada.online.harrypotterpractice;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    protected String name;
    protected String location;
    protected Integer lifeLevel = 100;
    protected Integer magicEnergy = 100;
    protected List<Spell> spellList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getLifeLevel() {
        return lifeLevel;
    }

    public void setLifeLevel(Integer lifeLevel) {
        this.lifeLevel = lifeLevel;
    }

    public Integer getMagicEnergy() {
        return magicEnergy;
    }

    public void setMagicEnergy(Integer magicEnergy) {
        this.magicEnergy = magicEnergy;
    }

    public List<Spell> getSpellList() {
        return spellList;
    }

    public void setSpellList(List<Spell> spellList) {
        this.spellList = spellList;
    }

    public List<Attack> getAttackSpellList() {
        ArrayList<Attack> attacks = new ArrayList<>();
        for (Spell spell : spellList) {
            if (spell instanceof Attack)
                attacks.add((Attack) spell);
        }

        return attacks;
    }

    public List<Recovery> getRecoverySpellList() {
        ArrayList<Recovery> recoveries = new ArrayList<>();
        for (Spell spell : spellList) {
            if (spell instanceof Recovery)
                recoveries.add((Recovery) spell);
        }

        return recoveries;
    }

    public List<DefenseAndHeal> getDefenseAndHealSpellList() {
        ArrayList<DefenseAndHeal> defenseAndHeals = new ArrayList<>();
        for (Spell spell : spellList) {
            if (spell instanceof DefenseAndHeal)
                defenseAndHeals.add((DefenseAndHeal) spell);
        }

        return defenseAndHeals;
    }

    public void receiveAttack(Integer damageLevel, String location) {
        if (this.location.equals(location))
            this.lifeLevel = this.lifeLevel - damageLevel;
    }

    public void addSpell(Spell spell) {
        this.spellList.add(spell);
    }

    public Boolean isItDead() {
        return lifeLevel <= 0;
    }

    public Boolean isItDarkOrFree() {
        int contador = 0;

        for (int i = 0; i < spellList.size(); i++) {
            if (spellList.get(i) instanceof Attack) {
                contador++;
            }
        }

        return contador > 3;
    }

    public void printCharacterStatus() {
        System.out.println("\n***************************************");
        System.out.println("Name: " + getName());
        System.out.println("Life Level: " + getLifeLevel());
        System.out.println("Magic Energy Level: " + getMagicEnergy());
        System.out.println("***************************************");
    }


}

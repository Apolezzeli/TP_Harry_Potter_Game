package ar.com.ada.online.harrypotterpractice;

public class Wand {

    private String wandName;
    private Integer extraDamage;

    public Wand(String wandName, Integer extraDamage) {
        this.wandName = wandName;
        this.extraDamage = extraDamage;
    }

    public String getType() {
        return wandName;
    }

    public void setType(String wandName) {
        this.wandName = wandName;
    }

    public int getExtraDamage() {
        return extraDamage;
    }

    public void setExtraDamage(Integer extraDamage) {
        this.extraDamage = extraDamage;
    }


}

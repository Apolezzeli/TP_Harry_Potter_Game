package ar.com.ada.online.harrypotterpractice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Character player1;
    private Character player2;
    private Scanner keyboard = new Scanner(System.in);

    public void settingGame() {
        System.out.println("Welcome to the magic adventure of Harry Potter Game\n");

        System.out.println("********************");
        System.out.println(" SELECT PLAYER ONE:");
        System.out.println("******************** \n");
        player1 = selectCharacter();

        System.out.println("********************");
        System.out.println(" SELECT PLAYER TWO:");
        System.out.println("******************** \n");
        player2 = selectCharacter();

        loadSpellToPlayer();
    }

    private Character selectCharacter() {
        int option;
        Character character = null;

        do {
            System.out.println("What do you want to be?:\n\t1) Wizard/Witch\n\t2) Elf");
            option = keyboard.nextInt();
            switch (option) {
                case 1:
                    character = selectWizard();
                    break;
                case 2:
                    character = selectElf();
                    break;

                default:
                    System.out.println("Incorrect option\n");
                    break;
            }

        }
        while (option > 2 || option < 1);
        return character;
    }

    private String selectLocation() {

        String location = null;
        int option;

        do {
            System.out.println("Select location:");
            System.out.println("\t1) A");
            System.out.println("\t2) B");
            System.out.println("\t3) C");
            option = keyboard.nextInt();

            switch (option) {
                case 1:
                    location = "A";
                    break;
                case 2:
                    location = "B";
                    break;
                case 3:
                    location = "C";
                    break;

                default:
                    System.out.println("Incorrect option\n");
                    break;
            }
        }
        while (option > 3 || option < 1);

        return location;

    }

    private Elf selectElf() {
        Elf elf = new Elf();
        int option;

        do {
            System.out.println("Choose your Elf for the match:");
            System.out.println("\t1) Kreacher");
            System.out.println("\t2) Hokey");
            System.out.println("\t3) Dobby");
            System.out.println("\t4) Winky");
            option = keyboard.nextInt();

            switch (option) {
                case 1:
                    elf.setName("Kreacher");
                    break;
                case 2:
                    elf.setName("Hokey");
                    break;
                case 3:
                    elf.setName("Dobby");
                    break;
                case 4:
                    elf.setName("Winky");
                    break;
                default:
                    System.out.println("Incorrect option\n");
                    break;
            }

        }
        while (option > 4 || option < 1);

        System.out.println("Select your initial location\n");

        elf.setLocation(selectLocation());

        return elf;


    }

    private Wand randomWand() {
        List<Wand> wandArrayList = Arrays.asList(
                new Wand("Blackthorn", 3),
                new Wand("Elder", 5),
                new Wand("Oak", 2)
        );

        Random rand = new Random();
        Wand wand = wandArrayList.get(rand.nextInt(wandArrayList.size()));

        return wand;
    }

    private Wizard selectWizard() {
        Wizard wizard = new Wizard();
        int option;

        do {
            System.out.println("Choose your Wizard or Witch for the match:");
            System.out.println("\t1) Harry Potter");
            System.out.println("\t2) Hermione Granger");
            System.out.println("\t3) Draco Malfoy");
            System.out.println("\t4) Bellatrix Lestrange");
            System.out.println("\t5) Minerva McGonagall");
            System.out.println("\t6) Tom Ryddle/Lord Voldemort");
            option = keyboard.nextInt();

            switch (option) {
                case 1:
                    wizard.setName("Harry Potter");
                    break;
                case 2:
                    wizard.setName("Hermione Granger");
                    break;
                case 3:
                    wizard.setName("Draco Malfoy");
                    break;
                case 4:
                    wizard.setName("Bellatrix Lestrange");
                    break;
                case 5:
                    wizard.setName("Minerva McGonagall");
                    break;
                case 6:
                    wizard.setName("Tom Ryddle/Lord Voldemort");
                    break;
                default:
                    System.out.println("Incorrect option\n");
                    break;
            }
        }
        while (option > 6 || option < 1);

        Wand wand = randomWand();
        System.out.println("When you choose a wizard or a witch, a WAND chooses you to join in your adventure!");
        System.out.println("***************************************");
        System.out.println("The Wand who choose you is: " + wand.getType());
        System.out.println("***************************************\n");

        wizard.setWand(wand);

        System.out.println("Select your initial location\n");

        wizard.setLocation(selectLocation());

        return wizard;

    }

    private void loadSpellToPlayer() {
        System.out.println("********************");
        System.out.println(" SELECT PLAYER ONE:");
        System.out.println("******************** \n");
        for (int i = 0; i < 6; i++) {
            spellMenu(player1, keyboard);

            if (player1.getSpellList().size() < 6) {
                System.out.println("Wish to add another spell?:\n\t1) YES\n\t2) NO\n");

                int continueMenu = keyboard.nextInt();
                if (continueMenu == 2) break;
            }
        }

        System.out.println("********************");
        System.out.println(" SELECT PLAYER TWO:");
        System.out.println("******************** \n");
        for (int i = 0; i < 6; i++) {
            spellMenu(player2, keyboard);

            if (player2.getSpellList().size() < 6) {
                System.out.println("Wish to add another spell?:\n\t1) YES\n\t2) NO\n");

                int continueMenu = keyboard.nextInt();
                if (continueMenu == 2) break;
            }
        }

    }

    private void spellMenu(Character character, Scanner keyboard) {

        System.out.println("Choose the best spells for the match (You can choose up to six spells).\n\nCategories:\n\t1) Attack\n\t2) Recovery\n\t3) Defense and Heal");
        int option = keyboard.nextInt();
        do {
            switch (option) {
                case 1:
                    Attack attack = getAttackSpell(keyboard);
                    if (attack != null)
                        character.addSpell(attack);
                    break;

                case 2:
                    Recovery recovery = getRecoverySpell(keyboard);
                    if (recovery != null)
                        character.addSpell(recovery);
                    break;

                case 3:
                    DefenseAndHeal defenseAndHeal = getDefenseAndHealSpell(keyboard);
                    if (defenseAndHeal != null)
                        character.addSpell(defenseAndHeal);
                    break;
                default:
                    System.out.println("Incorrect option\n");
                    break;
            }
        }
        while (option > 3 || option < 1);
    }

    static Attack getAttackSpell(Scanner keyboard) {
        System.out.println("Choose the Attack spell");
        System.out.println("\t1) Oppugno\t\t\tEnergy Cost: 15 pts\t\tOpponent Life damage:  20 pts");
        System.out.println("\t2) Bombarda\t\t\tEnergy Cost: 20 pts\t\tOpponent Life damage:  25 pts");
        System.out.println("\t3) Depulso\t\t\tEnergy Cost: 10 pts\t\tOpponent Life damage:  15 pts");
        System.out.println("\t4) Glacius\t\t\tEnergy Cost:  5 pts\t\tOpponent Life damage:  10 pts");
        System.out.println("\t5) Avada Kedavra\tEnergy Cost: 90 pts\t\tOpponent Life damage: 100 pts");
        System.out.println("\t6) Imperius\t\t\tEnergy Cost: 80 pts\t\tOpponent Life damage:  90 pts");
        System.out.println("\t7) Cruciatus\t\tEnergy Cost: 70 pts\t\tOpponent Life damage:  80 pts");


        int option = keyboard.nextInt();

        Attack attack = new Attack();
        switch (option) {
            case 1:
                attack.setSpellName("Oppugno");
                attack.setEnergyCost(15);
                attack.setDamageLevel(20);
                break;

            case 2:
                attack.setSpellName("Bombarda");
                attack.setEnergyCost(20);
                attack.setDamageLevel(25);
                break;

            case 3:
                attack.setSpellName("Depulso");
                attack.setEnergyCost(10);
                attack.setDamageLevel(15);
                break;

            case 4:
                attack.setSpellName("Glacius");
                attack.setEnergyCost(5);
                attack.setDamageLevel(10);
                break;
            case 5:
                attack.setSpellName("Avada Kedavra");
                attack.setEnergyCost(90);
                attack.setDamageLevel(100);
                break;
            case 6:
                attack.setSpellName("Imperius");
                attack.setEnergyCost(80);
                attack.setDamageLevel(90);
                break;
            case 7:
                attack.setSpellName("Cruciatus");
                attack.setEnergyCost(70);
                attack.setDamageLevel(80);
                break;
            default:
                System.out.println("Incorrect option\n");
                attack = null;
        }

        return attack;
    }

    static Recovery getRecoverySpell(Scanner keyboard) {
        System.out.println("Choose the Recovery spell");
        System.out.println("\t1) Maxi recovery\t\tEnergy Cost:  7 pts\t\tGives you: 15 Energy pts");
        System.out.println("\t2) Super recovery\t\tEnergy Cost:  4 pts\t\tGives you: 10 Energy pts");
        System.out.println("\t3) Simple recovery\t\tEnergy Cost:  1 pts\t\tGives you:  6 Energy pts");

        int option = keyboard.nextInt();

        Recovery recovery = new Recovery();

        switch (option) {
            case 1:
                recovery.setSpellName("Maxi recovery");
                recovery.setEnergyCost(7);
                recovery.setEnergyReceived(15);
                break;

            case 2:
                recovery.setSpellName("Super recovery");
                recovery.setEnergyCost(4);
                recovery.setEnergyReceived(10);
                break;

            case 3:
                recovery.setSpellName("Simple recovery");
                recovery.setEnergyCost(1);
                recovery.setEnergyReceived(6);
                break;

            default:
                System.out.println("Incorrect option\n");
                recovery = null;
        }

        return recovery;
    }

    static DefenseAndHeal getDefenseAndHealSpell(Scanner keyboard) {
        System.out.println("Choose the defense and heal spell");
        System.out.println("\t1) Protego Horriblis\t\tEnergy Cost: 15 pts\t\tGives you: 20 Life pts");
        System.out.println("\t2) Caeca Temporalis\t\t\tEnergy Cost: 15 pts\t\tGives you: 25 Life pts");
        System.out.println("\t3) Impedimenta\t\t\t\tEnergy Cost:  5 pts\t\tGives you: 10 Life pts");
        System.out.println("\t4) Protego\t\t\t\t\tEnergy Cost:  5 pts\t\tGives you: 10 Life pts");
        System.out.println("\t5) Protego Totalum\t\t\tEnergy Cost: 10 pts\t\tGives you: 15 Life pts");
        System.out.println("\t6) Tutelae et defensionis\tEnergy Cost: 20 pts\t\tGives you: 25 Life pts");
        System.out.println("\t7) Vulnera Sanentur\t\t\tEnergy Cost: 10 pts\t\tGives you: 15 Life pts");

        int option = keyboard.nextInt();

        DefenseAndHeal defenseAndHeal = new DefenseAndHeal();
        switch (option) {
            case 1:
                defenseAndHeal.setSpellName("Protego Horriblis");
                defenseAndHeal.setEnergyCost(15);
                defenseAndHeal.setLifeReceived(20);
                break;

            case 2:
                defenseAndHeal.setSpellName("Caeca Temporalis");
                defenseAndHeal.setEnergyCost(15);
                defenseAndHeal.setLifeReceived(20);
                break;

            case 3:
                defenseAndHeal.setSpellName("Impedimenta");
                defenseAndHeal.setEnergyCost(5);
                defenseAndHeal.setLifeReceived(10);
                break;

            case 4:
                defenseAndHeal.setSpellName("Protego");
                defenseAndHeal.setEnergyCost(5);
                defenseAndHeal.setLifeReceived(10);
                break;
            case 5:
                defenseAndHeal.setSpellName("Protego Totalum");
                defenseAndHeal.setEnergyCost(10);
                defenseAndHeal.setLifeReceived(15);
                break;
            case 6:
                defenseAndHeal.setSpellName("Tutelae et defensionis");
                defenseAndHeal.setEnergyCost(20);
                defenseAndHeal.setLifeReceived(25);
                break;

            case 7:
                defenseAndHeal.setSpellName("Vulnera Sanentur");
                defenseAndHeal.setEnergyCost(10);
                defenseAndHeal.setLifeReceived(15);
                break;

            default:
                System.out.println("Incorrect option\n");
                defenseAndHeal = null;
        }

        return defenseAndHeal;
    }

    public void play() {

        do {
            System.out.println("********************");
            System.out.println(" PLAYER ONE´S TURN:");
            System.out.println("******************** \n");
            turn(player1, player2);
            if (player2.isItDead()) {
                break;
            }
            System.out.println("********************");
            System.out.println(" PLAYER TWO´S TURN:");
            System.out.println("******************** \n");
            turn(player2, player1);
        }
        while (!player1.isItDead());

    }

    private void turn(Character playerInTurn, Character opponent) {


        System.out.println("Now it´s time for the match!\n");

        // pregunta y seleccion del usario
        // swicth 1) attackOponente(playerInTurn, opponent) => es donde la ista de hechizos del juagador
        // 1 se extrae el hechizo de ataque quw desea usar

        System.out.println("What are you going to do?\n");
        System.out.println("\t1) Attack");
        System.out.println("\t2) Recovery");
        System.out.println("\t3) Defense and Heal");

        Integer option = keyboard.nextInt();
        switch (option) {
            case 1:
                attackOpponent(playerInTurn, opponent);
                break;

            case 2:
                recoveryYourself(playerInTurn);
                break;

            case 3:
                defenseAndHealYourself(playerInTurn);
                break;

            default:
                System.out.println("Incorrect option\n");

        }
        if (!opponent.isItDead()) {
            option = null;
            System.out.println("Do you want to change your location?\n\t1) YES\n\t2) NO\n");
            option = keyboard.nextInt();
            if (option == 1) {
                playerInTurn.setLocation(selectLocation());
            }
        }


    }

    private void recoveryYourself(Character playerInTurn) {
        List<Recovery> recoverySpellList = playerInTurn.getRecoverySpellList();
        for (int i = 1; i <= recoverySpellList.size(); i++) {
            System.out.println(i + ")" + recoverySpellList.get(i - 1).getSpellName());
        }
        int i = keyboard.nextInt();
        Recovery recovery = recoverySpellList.get(i - 1);

        Integer recoveryLevel = recovery.getEnergyReceived();

        if (playerInTurn.getMagicEnergy() >= recovery.getEnergyCost()) {

            if (playerInTurn instanceof Wizard) {

                if (!playerInTurn.isItDarkOrFree() && playerInTurn.getLifeLevel() <= 35) {
                    recoveryLevel = recoveryLevel + 10;
                }

            } else {
                if (playerInTurn.isItDarkOrFree()) {
                    recoveryLevel = recoveryLevel + 5;
                }
            }

            Integer finalEnergyLevel = recoveryLevel + playerInTurn.getMagicEnergy();

            if (finalEnergyLevel > 100) {
                finalEnergyLevel = 100;
            }
            int diffMagicEnergy = playerInTurn.getMagicEnergy() - recovery.getEnergyCost();
            playerInTurn.setMagicEnergy(diffMagicEnergy);

            playerInTurn.setMagicEnergy(finalEnergyLevel);
        } else {
            System.out.println("OH NO! Your magic energy is not enough to cast this spell.");
            System.out.println("Therefore you lose your turn.");
            System.out.println("But don't worry, you will have 10 extra magic energy points for the next turn.");
            int newMagicEnergy = playerInTurn.getMagicEnergy() + 10;
            playerInTurn.setMagicEnergy(newMagicEnergy);

        }
        playerInTurn.printCharacterStatus();


    }

    private void defenseAndHealYourself(Character playerInTurn) {
        List<DefenseAndHeal> defenseAndHealSpellList = playerInTurn.getDefenseAndHealSpellList();
        for (int i = 1; i <= defenseAndHealSpellList.size(); i++) {
            System.out.println(i + ")" + defenseAndHealSpellList.get(i - 1).getSpellName());
        }
        int i = keyboard.nextInt();
        DefenseAndHeal defenseAndHeal = defenseAndHealSpellList.get(i - 1);


        Integer defenseAndHealLevel = defenseAndHeal.getLifeReceived();

        if (playerInTurn.getMagicEnergy() >= defenseAndHeal.getEnergyCost()) {

            if (playerInTurn instanceof Wizard) {

                if (playerInTurn.isItDarkOrFree()) {
                    defenseAndHealLevel = defenseAndHealLevel - 10;
                }

            } else {
                if (playerInTurn.isItDarkOrFree()) {
                    defenseAndHealLevel = defenseAndHealLevel + 5;
                } else {
                    defenseAndHealLevel = defenseAndHealLevel + 10;
                }
            }

            Integer finalLiveLevel = defenseAndHealLevel + playerInTurn.getLifeLevel();

            if (finalLiveLevel > 100) {
                finalLiveLevel = 100;
            }
            int diffMagicEnergy = playerInTurn.getMagicEnergy() - defenseAndHeal.getEnergyCost();
            playerInTurn.setMagicEnergy(diffMagicEnergy);

            playerInTurn.setLifeLevel(finalLiveLevel);
        } else {
            System.out.println("OH NO! Your magic energy is not enough to cast this spell.");
            System.out.println("Therefore you lose your turn.");
            System.out.println("But don't worry, you will have 10 extra magic energy points for the next turn.");
            int newMagicEnergy = playerInTurn.getMagicEnergy() + 10;
            playerInTurn.setMagicEnergy(newMagicEnergy);

        }
        playerInTurn.printCharacterStatus();

    }

    private void attackOpponent(Character playerInTurn, Character opponent) {

        List<Attack> attackSpellList = playerInTurn.getAttackSpellList();
        for (int i = 1; i <= attackSpellList.size(); i++) {
            System.out.println(i + ")" + attackSpellList.get(i - 1).getSpellName());
        }
        int i = keyboard.nextInt();

        Attack attack = attackSpellList.get(i - 1);

        System.out.println("Where are you going to attack?\n");
        String attackLocation = selectLocation();

        Integer damageLevel = attack.getDamageLevel();

        if (playerInTurn.getMagicEnergy() >= attack.getEnergyCost()) {

            if (playerInTurn instanceof Wizard) {
                // aqui se extae la instancia de la varita que tiene el mago y se guarde en la variable wand
                Wand wand = ((Wizard) playerInTurn).getWand();

                if (playerInTurn.isItDarkOrFree()) {
                    damageLevel = damageLevel + wand.getExtraDamage() + 10;

                } else {
                    damageLevel = damageLevel + wand.getExtraDamage();
                }

            } else {
                if (playerInTurn.isItDarkOrFree()) {
                    damageLevel = damageLevel + 5;
                }
            }
            int diffMagicEnergy = playerInTurn.getMagicEnergy() - attack.getEnergyCost();
            playerInTurn.setMagicEnergy(diffMagicEnergy);

            opponent.receiveAttack(damageLevel, attackLocation);


        } else {
            System.out.println("OH NO! Your magic energy is not enough to cast this spell.");
            System.out.println("Therefore you lose your turn.");
            System.out.println("But don't worry, you will have 10 extra magic energy points for the next turn.");
            int newMagicEnergy = playerInTurn.getMagicEnergy() + 10;
            playerInTurn.setMagicEnergy(newMagicEnergy);
        }
        playerInTurn.printCharacterStatus();

        printShowWinner(playerInTurn, opponent);
    }

    public void printShowWinner(Character playerInTurn, Character opponent) {
        if (opponent.isItDead()) {
            System.out.println("\n***************************************************************");
            System.out.println(playerInTurn.getName() + " CONGRATS!!! YOU ARE THE WINNER OF THE GAME");
            System.out.println("**************************************************************");
        }
    }


}








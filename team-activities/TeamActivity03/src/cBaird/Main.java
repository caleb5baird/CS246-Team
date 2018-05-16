package cBaird;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Caleb",10, 20, 30);
        player1.addEquipment("staff", 100);
        player1.addEquipment("magicRing", 50);
        player1.addEquipment("amulet", 70);
        player1.addEquipment("dagger", 30);
        player1.addEquipment("aintientRune", 80);
        player1.addEquipment("enchantedTunic", 90);
        Game game = new Game(player1);
        game.saveGame();
        Game newGame = game.loadGame("caleb");
    }
}

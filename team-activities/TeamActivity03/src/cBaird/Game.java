package cBaird;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class Game {
    private Player player1;

    public Game(Player player1) {
        this.player1 = player1;
    }

    public void saveGame() {
        //convert the player to a string
        Gson gson = new Gson();
        String savedGame = gson.toJson(player1);

        //Prompt the user for a name to save the game as.
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name of this game?");
        String gameName = scanner.next();

        //Save the json string to a file of the name gameName
        try {
            PrintWriter out = new PrintWriter(gameName);
            out.println(savedGame);
            out.close();
        }
        catch(IOException ex) {
            System.out.println(ex);
        }
    }

    public static Game loadGame(String gameName) {
        //read the file
        String savedPlayer = new String();
        try {
            BufferedReader br = new BufferedReader(new FileReader(gameName));
            savedPlayer = br.readLine();
            br.close();
        } catch (IOException ex) {

        }

        //create the game
        Gson gson = new Gson();
        Player player = gson.fromJson(savedPlayer, Player.class);
        Game SavedGame = new Game(player);

        //return the saved game
        return SavedGame;
    }
}

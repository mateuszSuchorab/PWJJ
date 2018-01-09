
package zadaniaskryptjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Player implements Runnable{

    private int board[][];
    // liczba >= 100 to mina, 0, 1, ..., 8 -- ile wokól min
    private boolean click[][];
    private PrintWriter out;
    private BufferedReader in;
    private Socket connection;

    private void initializeBoard() {
        board = new int[11][11];
        click = new boolean[11][11];
        int w, k, counter;
        counter = 0;
        while (counter < 10) {
            w = (int) (Math.random() * 9) + 1;
            k = (int) (Math.random() * 9) + 1;
            if (board[w][k] < 100) {
                ++counter;
                board[w][k] = 100;
                ++board[w - 1][k - 1];
                ++board[w - 1][k];
                ++board[w - 1][k + 1];
                ++board[w][k - 1];
                ++board[w][k + 1];
                ++board[w + 1][k - 1];
                ++board[w + 1][k];
                ++board[w + 1][k + 1];
            }
        }
    }

    public Player(Socket connection) {
        initializeBoard();
        this.connection = connection;
        try {
            out = new PrintWriter(connection.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public void run() {
        int w, k, discovered, number;
        String wsp;
        boolean end = false;
        discovered = 0;
        try {
            out.println("OK.");
            while ((!end) && (discovered < 71)) {
                wsp = in.readLine();
                if (wsp == null) {
                    end = true;
                } else {
                    try {
                        number = Integer.parseInt(wsp);
                        w = (int) ((number) / 10);
                        System.out.println(w);
                        k = (int)(number%10);
                        System.out.println(k);
                    } catch (NumberFormatException e) {
                        w = 200;
                        k = 200;
                    }
                    if ((w >= 0) && (w <= 10) && (k >= 0) && (k <= 10)) {
                        if (board[w][k] >= 100) {
                            out.println("bum");
                            end = true;
                        } else {
                            out.println(Integer.toString(board[w][k]));
                            if (!click[w][k]) {
                                ++discovered;
                            }
                        }
                        click[w][k] = true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        } finally {
            try {
                connection.close();
            } 
            catch (IOException e) {}
        }
    }
}


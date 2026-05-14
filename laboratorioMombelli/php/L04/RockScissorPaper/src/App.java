public class App {

    static String[] symbols = {"rock", "scissor", "paper"}; //array di stringhe
    //String[] symbols = new String[3];
    //symbols[0] = "rock";
    //symbols[1] = "scissor";
    //symbols[2] = "paper";
    
    // metodi ausiliari ==> i metodi marcati private e static
    private static String choice(){
        int randomIndex = (int) (Math.random() * symbols.length); // genera un numero casuale tra 0 e la lunghezza dell'array
        return symbols[randomIndex]; // restituisce il simbolo corrispondente al numero casuale generato
    }

    private static String determineWinner(String choice1, String choice2){
        if (choice1.equals(choice2)) {
            return "It's a tie!";
        } else if ((choice1.equals("rock") && choice2.equals("scissor")) ||
                   (choice1.equals("scissor") && choice2.equals("paper")) ||
                   (choice1.equals("paper") && choice2.equals("rock"))) {
            return "Player 1 wins!";
        } else {
            return "Player 2 wins!";
        }
    }

    public static void main(String[] args) throws Exception { // static ==> spazio di suddivisione della memoria ram
        // è statico perché sennò non partirebbe mai il programma
        // può lavorare solo con altri elementi statici
        String player1Choice = choice(); // chiamata al metodo choice per ottenere la scelta del giocatore 1
        String player2Choice = choice(); // chiamata al metodo choice per ottenere la scelta del

        System.out.println("<html><body>");
        System.out.println("<h1>Rock, Scissor, Paper Game</h1>");

        System.out.println("<div>Player 1 chooses: " + player1Choice + "</div>"); // stampa la scelta del giocatore 1
        System.out.println("<div>Player 2 chooses: " + player2Choice + "</div>"); // stampa la scelta del giocatore 2

        String result = determineWinner(player1Choice, player2Choice); // chiamata al metodo determineWinner per determinare il vincitore
        System.out.println("<div>" + result + "</div>"); // stampa il risultato del gioco
        System.out.println("</body></html>");
        
    }
}

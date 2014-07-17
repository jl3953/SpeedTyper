package SpeedTyper;

import java.util.Scanner;

/**
 * Determines how much of the original passage the player matched while typing
 *
 * @author Jennifer Lam
 *
 */
public class Matcher {

    private String playerResponse;
    private int matchedWords;
    private int errors;

    public Matcher(){
        this.playerResponse = "";
        this.matchedWords = 0;
        this.errors = 0;
    }

    public void readIn(Scanner sc) {
        this.playerResponse = sc.nextLine();
    }

    public int calculateMatch(String passage) {
        String[] passageArray = passage.split(" ");
        String[] responseArray = this.playerResponse.split(" ");

        int loopNum = (passageArray.length < responseArray.length) ?
            passageArray.length : responseArray.length;
        
        this.errors = passageArray.length;
        int r = 0;
        for (int i = 0; i < loopNum; i++){
            if (passageArray[i].equals(responseArray[r])){
                this.matchedWords++;
                this.errors--;
            }
            else {
                System.out.println(passageArray[i] + " " + responseArray[r]);
                //words stuck together
                if (responseArray[r].contains(passageArray[i] + "&" +
                            passageArray[i+1]))
                    i++;
                else{
                    if (i + 1 <  passageArray.length && i-1 > 0) {
                        //skip ahead
                        if (responseArray[r].equals(passageArray[i+1])){
                            i++;
                        }
                        //left back
                        else if (responseArray[r].equals(passageArray[i-1])) {
                            i--;
                        }
                    }
                }
            }
            r++;
        }
        return this.matchedWords - this.errors;
    }

    public String getPlayerResponse() {
        return this.playerResponse;
    }

    public int getMatchedWords() {
        return this.matchedWords;
    }

    public int getErrors() {
        return this.errors;
    }
}

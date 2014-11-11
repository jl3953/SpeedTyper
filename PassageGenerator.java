import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Generates a passage
 *
 * @author Jennifer Lam
 *
 */
public class PassageGenerator {

    private final static int PASSAGE_QTY = 3;
    private final static String PASSAGE_SRC = "passages.txt";

    private String header;
    private String passage;

    public PassageGenerator() {
        this.header = "";
        this.passage = "";
        this.generatePassage();
    }

    public void generatePassage() {
        Random rand = new Random();
        int passageNum = rand.nextInt(PASSAGE_QTY);

        try {
            BufferedReader br = new BufferedReader(new FileReader(PASSAGE_SRC));
            for (int i = 0; i < passageNum; i++) {
                this.header = br.readLine();
                this.passage = br.readLine();
                br.readLine(); //line b/w passages
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String showPassage() {
        return this.header + "\n" + this.passage;
    }

    public String getPassage() {
        return this.passage;
    }

    public String getHeader() {
        return this.header;
    }
}

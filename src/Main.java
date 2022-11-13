import initialiser.Initialise;
import ui.*;

/**
 * Main class that starts MOBLIMA
 */
public class Main {
    /**
     * Method to start the MOBLIMA
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Initialise.initialiseMOBLIMA();
    
        AccountUI.WelcomePage();
        
    }

}
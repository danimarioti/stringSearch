package stringsearch;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.*;

class Log {  
    //
    private static Logger LOGGER;     
    //
    
    public Log() throws IOException{
        LOGGER = Logger.getLogger("stringsearch");
        setupLogger();
    }
    
    public Logger getLog() {
        return LOGGER;
    }
    
    private void setupLogger(){
        LOGGER.setLevel(Level.ALL);// gravando tudo
        
        try{
            String filePath = Paths.get(".").toAbsolutePath().normalize().toString(); //pegar o diretório atual
            filePath+=("/src/stringsearch/LogFile.txt");
            FileHandler fHand= new FileHandler(filePath);
            SimpleFormatter sformatter = new SimpleFormatter();//deixando tudo em formatação simples. Para ficar em txt
            fHand.setFormatter(sformatter);
            LOGGER.addHandler(fHand);
        } catch (IOException | SecurityException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}


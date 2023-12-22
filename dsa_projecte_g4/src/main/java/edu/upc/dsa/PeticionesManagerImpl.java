package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.Peticiones;
import edu.upc.dsa.models.VOCredenciales;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PeticionesManagerImpl implements PeticionesManager {
    private static PeticionesManager instance;
    protected List<Peticiones> LPeticiones = new ArrayList<>();
    final static Logger logger = Logger.getLogger(PeticionesManagerImpl.class);

    public static PeticionesManager getInstance() {
        if (instance == null) instance = new PeticionesManagerImpl();
        return instance;
    }

    public int addPeticiones(String date, String title, String message, String sender) {
        edu.upc.dsa.models.Peticiones p = new Peticiones(date, title, message, sender);
        logger.info("new petición ");
        this.LPeticiones.add(p);
        logger.info("new petición added");
        return 0;
    }
    public int addPeticiones(Peticiones p) {
        logger.info("new petición ");
        this.LPeticiones.add(p);
        logger.info("new petición added");
        return 0;
    }
    public List<Peticiones> getallpeticiones() {
        return new ArrayList<>(this.LPeticiones);
    }

    public int sizeP() {
        int ret = this.LPeticiones.size();
        logger.info("size " + ret);

        return ret;
    }
}

package jdbc.cosole_daskboard_tomten;

import java.util.List;

public interface RepositoryInterface {
    List<Nisse> getAllNisse();
    int countRows(String tabellnamn);
    int getAntalBarn();
    double getGodhetAvg();
}

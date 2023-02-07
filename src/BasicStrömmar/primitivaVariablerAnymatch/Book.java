package BasicStrömmar.primitivaVariablerAnymatch;

public class Book {
    String titel;
    String författare;
    String genre;
    String färg;
    int betyg;
    String ägare;
    boolean ärfakta;

    public Book(){};

    public Book(String titel, String författare, String genre, String färg, int betyg, String ägare, boolean ärfakta) {
        this.titel = titel;
        this.författare = författare;
        this.genre = genre;
        this.färg = färg;
        this.betyg = betyg;
        this.ägare = ägare;
        this.ärfakta = ärfakta;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getFörfattare() {
        return författare;
    }

    public void setFörfattare(String författare) {
        this.författare = författare;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFärg() {
        return färg;
    }

    public void setFärg(String färg) {
        this.färg = färg;
    }

    public int getBetyg() {
        return betyg;
    }

    public void setBetyg(int betyg) {
        this.betyg = betyg;
    }

    public String getÄgare() {
        return ägare;
    }

    public void setÄgare(String ägare) {
        this.ägare = ägare;
    }

    public boolean isFakta() {
        return ärfakta;
    }

    public void setFakta(boolean fakta) {
        this.ärfakta = fakta;
    }


}

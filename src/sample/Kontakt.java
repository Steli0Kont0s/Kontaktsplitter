package sample;

import java.io.Serializable;

public class Kontakt implements Serializable {
    private String input = "";
    private String name = "";
    private String vorname = "";
    private String titel = "";
    private String anrede = "";
    private String briefanrede = "";
    private String geschlecht = "x"; // x, m, w
    private String sprache = "DE"; // EN, DE

    public boolean korrekt = false;

    public String getInput() {return input;}

    public void setInput(String input) {this.input = input;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAnrede() {
        return anrede;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    public String getBriefanrede() {
        return briefanrede;
    }

    public void setBriefanrede(String briefanrede) {
        this.briefanrede = briefanrede;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    /**
     * Anrede und Briefanrede anhand gegebener Kontaktdaten erstellen
     */
    public void generateAnrede(){
        String anfang = "Sehr geehrte/r";

        if(this.vorname.isEmpty() && this.anrede.isEmpty() && !this.geschlecht.contentEquals("m") && !this.geschlecht.contentEquals("w")){
            this.briefanrede = "Fehler, nicht genügend Informationen";
            this.korrekt = false;
            return;
        }


        if(this.anrede.isEmpty()) {
            if (this.geschlecht.contentEquals("m")) {
                anfang = "Sehr geehrter";
                this.anrede = "Herr";
            } else if (this.geschlecht.contentEquals("w")) {
                anfang = "Sehr geehrte";
                this.anrede = "Frau";
            } else {
                anfang = "Sehr geehrte/r";
            }
        }
        else{
            switch (this.anrede.toLowerCase()) {
                case "herr": anfang = "Sehr geehrter";
                    break;
                case "frau": anfang = "Sehr geehrte";
                    break;
                case "mr": anfang = "Dear";
                    break;
                case "mr.": anfang = "Dear";
                    break;
                case "mrs": anfang = "Dear";
                    break;
                case "mrs.": anfang = "Dear";
                    break;
                case "ms": anfang = "Dear";
                    break;
                case "ms.": anfang = "Dear";
                    break;
                default: anfang = "Sehr geehrte/r";

            }


        }




        this.briefanrede = anfang + " " + this.anrede + " " + this.titel + " " + this.vorname + " " + this.name;


        this.briefanrede = this.briefanrede.replaceAll("\\s+", " "); // Doppelte Leerzeichen entfernen

        this.korrekt = true;

    }
}

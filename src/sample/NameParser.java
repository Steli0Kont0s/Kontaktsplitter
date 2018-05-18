package sample;

import java.util.*;

public class NameParser {
    private static Kontakt kontakt;
    private static ArrayList<String> list;

    /**
     * Kontakt aus String parsen
     * @param input
     * @return
     */
    public static Kontakt parse(String input){
        kontakt = new Kontakt();
        list = new ArrayList<>(Arrays.asList(input.split(" ")));

        kontakt.setInput(input);

        if(list.size() == 0){
            System.out.println("Fehler, Keine Eingabe");
        }
        else if(list.size() == 1){

            kontakt.setName(toUpperCase(list.get(0)));
        }
        else if(list.size() > 1){
            kontakt.setName(toUpperCase(list.get(list.size() - 1))); // Name = letztes Element
            list.remove(list.size()-1);
            setAnrede();
            setTitle();
            setSurname();
        }

        return kontakt;
    }

    /**
     * Vorname aus Strings extrahieren
     */
    private static void setSurname(){
        String names = "";
        for(String item:list){
           names = names + toUpperCase(item) + " ";
        }
        kontakt.setVorname(names);
    }

    /**
     * Titel aus Strings extrahieren
     */
    private static void setTitle(){
        String titels = "";
        for(Iterator<String> iterator = list.iterator(); ((Iterator) iterator).hasNext();){
            String titel = stringContainsItemFromList(iterator.next(), TitelList.titelList);
            if(titel.length() > 0){
                titels = titels + titel + " ";
                iterator.remove();
            }
        }
        kontakt.setTitel(titels);
    }

    /**
     * Anrede ermitteln
     */
    private static void setAnrede(){
        switch (list.get(0).toLowerCase()) { // Anrede Überprüfen
            case "herr":
                kontakt.setAnrede("Herr");
                kontakt.setGeschlecht("m");
                kontakt.setSprache("de");
                list.remove(0);
                break;
            case "frau":
                kontakt.setAnrede("Frau");
                kontakt.setGeschlecht("w");
                kontakt.setSprache("de");
                list.remove(0);
                break;
            case "mr":
                kontakt.setAnrede("Mr.");
                kontakt.setGeschlecht("m");
                kontakt.setSprache("en");
                list.remove(0);
                break;
            case "mrs":
                kontakt.setAnrede("Mrs.");
                kontakt.setGeschlecht("w");
                kontakt.setSprache("en");
                list.remove(0);
                break;
            case "ms":
                kontakt.setAnrede("Ms.");
                kontakt.setGeschlecht("w");
                kontakt.setSprache("en");
                list.remove(0);
                break;
            case "mr.":
                kontakt.setAnrede("Mr.");
                kontakt.setGeschlecht("m");
                kontakt.setSprache("en");
                list.remove(0);
                break;
            case "mrs.":
                kontakt.setAnrede("Mrs.");
                kontakt.setGeschlecht("w");
                kontakt.setSprache("en");
                list.remove(0);
                break;
            case "ms.":
                kontakt.setAnrede("Ms");
                kontakt.setGeschlecht("w");
                kontakt.setSprache("en");
                list.remove(0);
                break;

            default:    // Keine Anrede eingegeben
                kontakt.setGeschlecht("x");
                break;
        }
    }

    /**
     * Überprüfen ob String in einer Liste vorkommt
     * @param inputStr
     * @param items
     * @return
     */
    private static String stringContainsItemFromList(String inputStr, List<String> items) {
        Optional<String> result = items.stream().filter(inputStr::matches).findAny();
        if(result.isPresent())
            return result.get();
        else
            return "";
    }

    /**
     * Ersten Buchstabe eines Strings groß, rest klein Schreiben
     * @param str
     * @return
     */
    private static String toUpperCase(String str){
        String cap = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
        int i = cap.indexOf('-');   // Nachnamen nach Bindestrich groß schreiben
        if(i > 0){
            System.out.println(i);
            cap = cap.substring(0,i+1) + cap.substring(i+1,i+2).toUpperCase() + cap.substring(i+2);
        }
        return cap;
    }
}

package xyz.devgrill.mond;

public class Berechnen {

    public static String Berechne(int kmh, String active) {
        String resultat = "";
        switch (active){
            case "Day":
                int totalDay = 384400 * 24 / kmh;
                resultat = Integer.toString(totalDay);
                break;

            case "Hour":
                int totalHour = 384400 / kmh;
                resultat = Integer.toString(totalHour);
                break;
        }
        return resultat;
    }

}

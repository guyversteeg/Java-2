/*
 * Genereert een pseudorandom woord uit een tekstfile
 */

package opgave2;

import java.util.Scanner;
import java.util.Random;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Leest woorden uit file en kan een random woord hiervan leveren
 * OO 2013 opgave 2
 * @author Pieter Koopman
 */
public class WoordLezer
{
    private List<String> woorden = new ArrayList<String> ();
    Random rand = new Random ();
    private int aantalWoorden = 0;     // aantal gelzen woorden
    /**
     * Constructor, bepaalt het aantal gelezen woorden in de file.
     * Gelezen woorden worden opgeslagen in een arrayList.
     * IOexceptions bij het lezen worden gevangen en afgedrukt.
     * @param fileNaam: fileNaam van de file met woorden
     */
    public WoordLezer( String fileNaam )
    {
        fileNaam = "woorden.txt";
        try
        {
            FileReader file = new FileReader( fileNaam );
            Scanner scan = new Scanner( file );
            for ( ; scan.hasNext("\\S+"); aantalWoorden += 1)
                woorden.add( scan.next("\\S+").toLowerCase() );
            file.close();
        }
        catch ( IOException ioe )
        {
            System.out.println("Oeps, er ging iets mis bij lezen van de file " + fileNaam + ioe.getMessage() );
        }
    }

    /**
     * @return het aantal gelezen woorden.
     */
    public int getAantalWoorden()
    {
        return aantalWoorden;
    }

    /**
     * Geeft een pseudo random woord uit de lijst met opgeslagen woorden
     * @return random woord uit file
     */
    public String geefWoord()
    {
        if ( aantalWoorden > 0 )
            return woorden.get( rand.nextInt( aantalWoorden ));
        else
            return "";
    }
}

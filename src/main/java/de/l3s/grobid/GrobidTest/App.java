package de.l3s.grobid.GrobidTest;

import java.util.Arrays;

import org.grobid.core.data.BiblioItem;
import org.grobid.core.engines.Engine;
import org.grobid.core.factory.GrobidFactory;
import org.grobid.core.main.GrobidHomeFinder;
import org.grobid.core.utilities.GrobidProperties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        try {
            String pGrobidHome = "/home/rja/GROBID/grobid-home";

            // The GrobidHomeFinder can be instantiate without parameters to verify the grobid home in the standard
            // location (classpath, ../grobid-home, ../../grobid-home)

            // If the location is customised: 
            GrobidHomeFinder grobidHomeFinder = new GrobidHomeFinder(Arrays.asList(pGrobidHome));       

            //The GrobidProperties needs to be instantiate using the correct grobidHomeFinder or it will use the default 
            //locations
            GrobidProperties.getInstance(grobidHomeFinder);

            System.out.println(">>>>>>>> GROBID_HOME="+GrobidProperties.get_GROBID_HOME_PATH());

            Engine engine = GrobidFactory.getInstance().createEngine();

            // Biblio object for the result
            BiblioItem resHeader = new BiblioItem();
            
            
            final String ref = "Linek, S., Teka Hadgu, A., Hoffmann, C.P., Jäschke, R., Puschmann, C.: It’s all about information? The Following Behaviour of Professors and PhD Students on Twitter. The Journal of Web Science. 3, 1–15 2017. ";
            
            final BiblioItem result = engine.processRawReference(ref, true);
            
            System.out.println("#######################################################################");
            System.out.println("input string:  " + ref);
            System.out.println("output BibTeX: " + result.toBibTeX());
            System.out.println("#######################################################################");
            
        } 
        catch (Exception e) {
            // If an exception is generated, print a stack trace
            e.printStackTrace();
        } 
    }
}

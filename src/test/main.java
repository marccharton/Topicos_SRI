package test;

import indexador.Indexador;
import collector.Collector;
import collector.DbManager;
import collector.IDbManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Marc
 */
public class main {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Connection to the database
        IDbManager d = DbManager.getInstance();
	d.setUrl("jdbc:mysql://localhost:3306/topicos_sri");
	d.connect();

        // Creation of the scanner to get the input
        Scanner s = new Scanner(System.in);
        System.out.println("1. Collector");
        System.out.println("2. Indexador");
        System.out.println("What do yo want to lauch ?");
        String choose = s.next();
        
        
        if (choose.compareTo("1") == 0)
        {
            System.out.println("---------------------------------");
            System.out.println("            Collector");
            
            // We fill the queue with the default value of the class
            Queue urls = new LinkedList();
            urls.add("http://www.kram47.fr");
            //urls.add("http://www.stf.jus.br/portal/principal/principal.asp");
            //urls.add("http://www.camara.gov.br");
            //urls.add("http://www.senado.gov.br/");

            // We Launch the collector
            Collector myColector  = new Collector();
            myColector.setUrls(urls);
            myColector.run();
        }
        else if (choose.compareTo("2") == 0)
        {
          System.out.println("---------------------------------");
          System.out.println("            Indexador");
          System.out.println("---------------------------------");
          Indexador indexador = new Indexador();
          indexador.run();
        }
              
    }
}


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.util.*;

public class prueba2delectura {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        System.out.println("Cantidad de registro: ");
        System.out.println("Inicio: " + startTime);
        try {
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Obtengo el documento, a partir del XML
            Document documento = builder.parse(new File("personas4.xml"));

            // Cojo todas las etiquetas coche del documento
            NodeList listpersonas = documento.getElementsByTagName("persona");
            FileWriter archivotxt = new FileWriter("personas.txt");
            System.out.println("Iniciando......");

            // eliminar variables que ya no se usan
            factory = null;
            builder = null;
            documento = null;
            recolectorBasura();

            // Recorro las etiquetas
            // for (int temp = 0; temp < listpersonas.getLength(); temp++) {

            for (int i = 0; i < listpersonas.getLength(); i++) {
                // Cojo el nodo actual
                Node nodo = listpersonas.item(i);
                // Compruebo si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    // Lo transformo a Element
                    Element e = (Element) nodo;
                    // Obtengo sus hijos
                    NodeList hijos = e.getChildNodes();
                    // Recorro sus hijos

                    for (int j = 0; j < hijos.getLength(); j++) {
                        // Obtengo al hijo actual
                        Node hijo = hijos.item(j);
                        // Compruebo si es un nodo
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            // Muestro el contenido
                            archivotxt.write(" |" + hijo.getNodeName() + ": " + hijo.getTextContent() + "|");

                        }

                        hijo = null;
                    }
                    e = null;
                    hijos = null;
                    archivotxt.write("\n");

                }

                nodo = null;

                if (i % 100000 == 0) {
                    System.out.println(i);
                    recolectorBasura();

                }

            }

            // }
            archivotxt.close();
            System.out.println("Fin termino....");

            long endTime = System.currentTimeMillis();

            System.out.println("fin: " + endTime);

            System.out.println("Duración: " + (endTime - startTime) / 1000 + " segundos");
            System.out.println("Duración: " + (endTime - startTime) + " ms");

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void recolectorBasura() {
        Runtime garbage = Runtime.getRuntime();
        garbage.gc();

    }
}

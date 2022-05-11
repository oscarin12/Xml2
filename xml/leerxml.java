import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.lang.model.element.ElementKind;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.util.Calendar;
import java.util.Date;

public class leerxml {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {

        long startTime = System.currentTimeMillis();

        System.out.println("Inicio: " + startTime);

        File file;

        try {
            file = new File("personas.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("persona");
            // Node nList = nList2.getElementsByTagName("persona");
            // System.out.println(nList.getElementsByTagName("persona"));

            System.out.println("----------------------------");

            FileWriter archivotxt = new FileWriter("personas.txt");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    // Element sElement = (Element)
                    // eElement.getElementsByTagName("telefonos").item(0);

                    archivotxt.write("id: " + eElement.getElementsByTagName("id").item(0).getTextContent()
                            + " | " + "Nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent()
                            + " | " + "Apellido: " + eElement.getElementsByTagName("apellido").item(0).getTextContent()
                            + " | " + "Pais: " + eElement.getElementsByTagName("Pais").item(0).getTextContent()
                            + " | " + "Direccion: "
                            + eElement.getElementsByTagName("Direccion").item(0).getTextContent()
                            + " | " + "Contrato: " + eElement.getElementsByTagName("contrato").item(0).getTextContent()
                            + " | " + "Fecha de nacimiento: "
                            + eElement.getElementsByTagName("fecha_nacimiento").item(0).getTextContent()
                            + " | " + "Pasaporte: "
                            + eElement.getElementsByTagName("pasaporte").item(0).getTextContent()
                            + " | " + "Correo: " + eElement.getElementsByTagName("correo").item(0).getTextContent()
                            + " | " + "Celular: " + eElement.getElementsByTagName("celular").item(0).getTextContent()
                            + " | " + "Telefono: " + eElement.getElementsByTagName("telefono").item(0).getTextContent()
                            + " | " + "Antiguedad: "
                            + eElement.getElementsByTagName("antiguedad").item(0).getTextContent()
                            + " | " + "Dedua total: "
                            + eElement.getElementsByTagName("deduatotal").item(0).getTextContent()
                            + " | " + "Interes: " + eElement.getElementsByTagName("interes").item(0).getTextContent()
                            + " | " + "Cuotas impagas: "
                            + eElement.getElementsByTagName("cuotasimpagas").item(0).getTextContent()
                            + " | " + "Pago adelantado: "
                            + eElement.getElementsByTagName("pagoadelantado").item(0).getTextContent()
                            + " | " + "\n");

                }
            }
            System.out.println("listo¡");
            archivotxt.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        long endTime = System.currentTimeMillis();

        System.out.println("fin: " + endTime);

        System.out.println("Duración: " + (endTime - startTime) / 1000 + " segundos");
        System.out.println("Duración: " + (endTime - startTime) + " ms");

    }
}
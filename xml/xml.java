import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xml {

    public static void main(String argv[]) throws ParserConfigurationException, SAXException {

        int TOTAL_REGISTRO = 0;

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Elemento raíz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("personas");
            doc.appendChild(rootElement);

            for (int i = 0; i <= TOTAL_REGISTRO; i++) {
                // Primer elemento
                Element elemento1 = doc.createElement("persona");
                rootElement.appendChild(elemento1);
                Element elemento2 = doc.createElement("hola");
                rootElement.appendChild(elemento2);

                // Se agrega un atributo al nodo elemento y su valor
                Element attr = doc.createAttribute("id");
                attr.setValue(i + "");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("nombres");
                attr.setValue("Oscar");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("apellidos");
                attr.setValue("Medina");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("pais");
                attr.setValue("chile");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("direccion");
                attr.setValue("coliseo");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("contrato");
                attr.setValue("DD-VV");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("fcnacimiento");
                attr.setValue("10/02/2000");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("sexo");
                attr.setValue("Masculino");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("pasaporte");
                attr.setValue("VI-200140");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("mail");
                attr.setValue("maximo.10.meridio@gmail.com");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("celular");
                attr.setValue("+569854521");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("antiguedad");
                attr.setValue("5");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("deudatotal");
                attr.setValue("2500500");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("interes");
                attr.setValue("500500");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("cuotassimpagas");
                attr.setValue("12");
                elemento1.setAttributeNode(attr);

                attr = doc.createAttribute("pagoadelantado");
                attr.setValue("75");
                elemento1.setAttributeNode(attr);
            }

            // Se escribe el contenido del XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("personas.xml"));

            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();

        } catch (TransformerException tfe) {
            tfe.printStackTrace();

        }

    }

}
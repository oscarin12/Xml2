import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import java.util.Date;
import java.util.Calendar;

public class prueba {

    public static void main(String[] args) {

        int TOTAL_REGISTRO = 4000000;
        long startTime = System.currentTimeMillis();

        System.out.println("Cantidad de registro: " + TOTAL_REGISTRO);
        System.out.println("Inicio: " + startTime);

        try {
            // Creo una instancia de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Creo un documentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Creo un DOMImplementation
            DOMImplementation implementation = builder.getDOMImplementation();

            // Creo un documento con un elemento raiz
            Document documento = implementation.createDocument(null, "informacion", null);
            documento.setXmlVersion("1.0");

            // Creo los elementos
            Element personas = documento.createElement("personas");

            for (int i = 0; i <= TOTAL_REGISTRO; i++) {
                Element persona = documento.createElement("persona");
                Element celular = documento.createElement("celulu");

                // creacion de atributos
                // id
                Element id = documento.createElement("id");
                Text textId = documento.createTextNode(i + "");
                id.appendChild(textId);
                persona.appendChild(id);

                // nombre y apellidos
                Element nombre = documento.createElement("nombre");
                Text textNombre = documento.createTextNode("jose");
                nombre.appendChild(textNombre);
                persona.appendChild(nombre);

                Element apellido = documento.createElement("apellido");
                Text textApellido = documento.createTextNode("manuel");
                apellido.appendChild(textApellido);
                persona.appendChild(apellido);

                // pais
                Element pais = documento.createElement("Pais");
                Text textPais = documento.createTextNode("chile");
                pais.appendChild(textPais);
                persona.appendChild(pais);

                // Direccion
                Element direccion = documento.createElement("Direccion");
                Text textDireccion = documento.createTextNode("coliseo");
                direccion.appendChild(textDireccion);
                persona.appendChild(direccion);

                // contrato
                Element contrato = documento.createElement("contrato");
                Text textContrato = documento.createTextNode("1");
                contrato.appendChild(textContrato);
                persona.appendChild(contrato);

                // fecha de nacimmiento
                Element fcnacimiento = documento.createElement("fecha_nacimiento");
                Text textFcnacimiento = documento.createTextNode("02/06/2000");
                fcnacimiento.appendChild(textFcnacimiento);
                persona.appendChild(fcnacimiento);

                // pasaporte
                Element pasaporte = documento.createElement("pasaporte");
                Text textPasaporte = documento.createTextNode("VI-200140");
                pasaporte.appendChild(textPasaporte);
                persona.appendChild(pasaporte);

                // correo
                Element correo = documento.createElement("correo");
                Text textCorreo = documento.createTextNode("hola@gmail.com");
                correo.appendChild(textCorreo);
                persona.appendChild(correo);

                // telefonos
                Element telefonos = documento.createElement("telefonos");
                Element celu = documento.createElement("celular");
                Element telefono = documento.createElement("telefono");
                Text textCelu = documento.createTextNode("1234");
                Text texttelefono = documento.createTextNode("123");
                telefono.appendChild(texttelefono);
                celu.appendChild(textCelu);
                persona.appendChild(telefonos);
                telefonos.appendChild(celular.appendChild(celu));
                telefonos.appendChild(celular.appendChild(telefono));
                // antiguedad
                Element antiguedad = documento.createElement("antiguedad");
                Text textAntiguedad = documento.createTextNode("5");
                antiguedad.appendChild(textAntiguedad);
                persona.appendChild(antiguedad);

                // deduatotal
                Element deduatotal = documento.createElement("deduatotal");
                Text textDeduatotal = documento.createTextNode("2500500");
                deduatotal.appendChild(textDeduatotal);
                persona.appendChild(deduatotal);

                // interes
                Element interes = documento.createElement("interes");
                Text textInteres = documento.createTextNode("500500");
                interes.appendChild(textInteres);
                persona.appendChild(interes);

                // cuotasimpagas
                Element cuotasimpagas = documento.createElement("cuotasimpagas");
                Text textCuotasimpagas = documento.createTextNode("12");
                cuotasimpagas.appendChild(textCuotasimpagas);
                persona.appendChild(cuotasimpagas);

                // pagoadelantado
                Element pagoadelantado = documento.createElement("pagoadelantado");
                Text textPagoadelantado = documento.createTextNode("75");
                pagoadelantado.appendChild(textPagoadelantado);
                persona.appendChild(pagoadelantado);

                // Añado al elemento persona el elemento persona
                personas.appendChild(persona);

                // Añado al root el elemento persona
                documento.getDocumentElement().appendChild(personas);

            }

            // Asocio el source con el Document
            Source source = new DOMSource(documento);
            // Creo el Result, indicado que fichero se va a crear
            Result result = new StreamResult(new File("personas4.xml"));

            // Creo un transformer, se crea el fichero XML
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }

        long endTime = System.currentTimeMillis();

        System.out.println("fin: " + endTime);

        System.out.println("Duración: " + (endTime - startTime) / 1000 + " segundos");
        System.out.println("Duración: " + (endTime - startTime) + " ms");

    }

}

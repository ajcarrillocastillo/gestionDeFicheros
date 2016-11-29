/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import gestionDeMovimientos.modelo.Empleado;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


/**
 *
 * @author Rafa
 */
public class FicheroXML {
    
        private static FicheroXML escrituraYLecturaXML = null;

    public static FicheroXML devolverFicherosEscrituraXML() {

        if (escrituraYLecturaXML != null) {
            return escrituraYLecturaXML;
        } else {
            escrituraYLecturaXML = new FicheroXML();
            return escrituraYLecturaXML;
        }
    }

    public boolean escribirFicheroXML(String numeroDeEmpleado, String nombre,
        String apellido, String numeroDeMovimiento,double Importe,String tipo,String fecha, String descripcion) throws TransformerConfigurationException, TransformerException {
        
        File archivo = new File("FicheroXml.xml");
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            //crea la factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //crea el documento
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Implementamos el DOM
            DOMImplementation implementation = builder.getDOMImplementation();
            //Creamos el Documento con los parametros (buscar para que sirve cada uno)
            Document document = implementation.createDocument(null, "Empleados", null);
            //le decimos que versión de xml es.
            document.setXmlVersion("1.0");

            //Definimos el elemento Raíz.
            Element elementoRaiz = document.getDocumentElement();
            //Definimos La primera etiqueta, que es Hoteles.
          
           
                Element EmpleadoNode = document.createElement("Empleado");
                
                Element numeroEmpleadoNode = document.createElement("NumeroDeEmpleado");
                Text numeroEmpleado = document.createTextNode(numeroDeEmpleado);
                numeroEmpleadoNode.appendChild(numeroEmpleado);
                
                Element nombreEmpleadoNode = document.createElement("NombreDeEmpleado");
                Text nombreEmpleado = document.createTextNode(nombre);
                nombreEmpleadoNode.appendChild(nombreEmpleado);
                
                Element apellidoEmpleadoNode = document.createElement("ApellidoDeEmpleadoEmpleado");
                Text apellidoEmpleado = document.createTextNode(apellido);
                apellidoEmpleadoNode.appendChild(apellidoEmpleado);
                
                Element MovimientosNode = document.createElement("Movimientos");
                    Element MovimientoNode  = document.createElement("Movimiento");
                 
                Element importeMovimientoNode = document.createElement("importeMovimiento");
                Text importeMovimiento = document.createTextNode(Importe+"");
                importeMovimientoNode.appendChild(importeMovimiento);
                
                 Element tipoMovimientoNode = document.createElement("tipoMovimientoNode");
                Text tipoMovimiento = document.createTextNode(tipo);
                tipoMovimientoNode.appendChild(tipoMovimiento);
                
                 Element fechaMovimientoNode = document.createElement("fechaMovimiento");
                Text fechaMovimiento = document.createTextNode(fecha);
                fechaMovimientoNode.appendChild(fechaMovimiento);
                
                 Element descripcionMovimientoNode = document.createElement("descripcionMovimiento");
                Text descripcionMovimiento = document.createTextNode(descripcion);
                descripcionMovimientoNode.appendChild(descripcionMovimiento);
                
                MovimientoNode.appendChild(importeMovimientoNode);
                MovimientoNode.appendChild(tipoMovimientoNode);
                MovimientoNode.appendChild(fechaMovimientoNode);
                MovimientoNode.appendChild(descripcionMovimientoNode);
                
                MovimientosNode.appendChild(MovimientoNode);
                
                EmpleadoNode.appendChild(numeroEmpleadoNode);
                EmpleadoNode.appendChild(nombreEmpleadoNode);
                EmpleadoNode.appendChild(apellidoEmpleadoNode);
                EmpleadoNode.appendChild(MovimientosNode);
                //lo añadimos a Hoteles
                elementoRaiz.appendChild(EmpleadoNode);
                //con el source generamos el xml
                Source source = new DOMSource(document);
                //le indicamos en que fichero se va a guardar pasandole la ruta por parámetro.
                Result rutaAlmacenFichero = new StreamResult(archivo);
                // lo transformamos y creamos la instancia
                Transformer transfomer = TransformerFactory.newInstance().newTransformer();
                //le pasamos por parametro el xml que generamos y la ruta de almacenaje.
                transfomer.transform(source, rutaAlmacenFichero);
            

        } catch (IOException ioe) {
            return false;
        } catch (ParserConfigurationException pce) {
            return false;
        }

        return true;
    }
    //arreglar luego
     public ArrayList leerFicheroXML(int eleccion) throws ParserConfigurationException, SAXException, IOException {
        File archivo = new File("FicheroXml.xml");
        if (!archivo.exists()) {
            System.out.println("Fichero No existente");
            return null;
        }
        //inicializamos el arraylist.
        ArrayList<Empleado> listaDeEmpleadoXML = new ArrayList<Empleado>();

        //Cargamos el archivo xml-
        DocumentBuilderFactory cargarArchivoFactory = DocumentBuilderFactory.newInstance();
        //instanciamos
        DocumentBuilder db = cargarArchivoFactory.newDocumentBuilder();
        //parseamos el documento
        Document document = db.parse(archivo);
        //Lo normalizamos
        document.getDocumentElement().normalize();
        //Ahora vamos a crear una lista de los nodos donde almacenaremos todos los clientes.
        NodeList listaDeEmpleados = document.getDocumentElement().getElementsByTagName("Empleados");
        //Inicializamos el nodo donde almacenaremos los items de cada cliente.
        Node nodoEmpleados;
        for (int i = 0; i < listaDeEmpleados.getLength(); i++) {
            nodoEmpleados = listaDeEmpleados.item(i);
            NodeList NodeListClientes = nodoEmpleados.getChildNodes();
            Node atributosEmpleados;
            //Atributos del cliente
            // Se tienen que inicializar.
            String dni = null;
            String nombre = null;
            int nHabitacion = 0;
            int nNoches = 0;

            for (int j = 0; j < NodeListClientes.getLength(); j++) {
                atributosEmpleados = NodeListClientes.item(j);
                if (atributosEmpleados.getNodeName().equals("NOMBRECLIENTE")) {
                    nombre = atributosEmpleados.getTextContent();
                }
                if (atributosEmpleados.getNodeName().equals("DNICLIENTE")) {
                    dni = atributosEmpleados.getTextContent();
                }
                if (atributosEmpleados.getNodeName().equals("NHABITACIONCLIENTE")) {
                    nHabitacion = Integer.parseInt(atributosEmpleados.getTextContent());
                }
                if (atributosEmpleados.getNodeName().equals("NNOCHES")) {
                    nNoches = Integer.parseInt(atributosEmpleados.getTextContent());
                }

            }
            listaDeEmpleadoXML.add(new Empleado(nombre, nombre, dni, null));

        }

        return listaDeEmpleadoXML;
    }
    
    
}
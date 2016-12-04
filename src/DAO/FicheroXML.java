/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import gestionDeMovimientos.modelo.Empleado;
import gestionDeMovimientos.modelo.Movimiento;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static FicheroXML devolver() {

        if (escrituraYLecturaXML != null) {
            return escrituraYLecturaXML;
        } else {
            escrituraYLecturaXML = new FicheroXML();
            return escrituraYLecturaXML;
        }
    }

    public boolean escribirFicheroXMLEmpleados(String numeroDeEmpleado, String nombre,
            String apellido) throws TransformerConfigurationException, TransformerException {
        boolean existe = false;
        ArrayList<Empleado> listaEmpleados = new ArrayList();
        try {
         listaEmpleados = leerFicheroXMLEmpleadosReescribir();
        File f = new File("FicheroXmlEmpleados.xml");
        
            if (!f.exists()) {
                f.createNewFile();
            }
           
            //crea la factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //crea el documento
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Implementamos el DOM
            DOMImplementation implementation = builder.getDOMImplementation();
            //Creamos el Documento con los parametros (buscar para que sirve cada uno)
            Document d = implementation.createDocument(null, "listaEmpleados", null);
            //le decimos que versión de xml es.
            d.setXmlVersion("1.0");

            //Definimos el elemento Raíz.
            Element elementoRaiz = d.getDocumentElement();
            Element EmpleadosNode = d.createElement("Empleados");
            //Definimos La primera etiqueta, que es Hoteles.

            for (Empleado e : listaEmpleados) {
                if (e.getNumeroDeEmpleado().equals(numeroDeEmpleado)) {
                    existe = true;
                }
                Element EmpleadoNode = d.createElement("Empleado");

                Element numeroEmpleadoNode = d.createElement("NumeroDeEmpleado");
                Text numeroEmpleado = d.createTextNode(e.getNumeroDeEmpleado());
                numeroEmpleadoNode.appendChild(numeroEmpleado);

                Element nombreEmpleadoNode = d.createElement("NombreDeEmpleado");
                Text nombreEmpleado = d.createTextNode(e.getNombre());
                nombreEmpleadoNode.appendChild(nombreEmpleado);

                Element apellidoEmpleadoNode = d.createElement("ApellidoDeEmpleado");
                Text apellidoEmpleado = d.createTextNode(e.getApellido());
                apellidoEmpleadoNode.appendChild(apellidoEmpleado);

                EmpleadoNode.appendChild(numeroEmpleadoNode);
                EmpleadoNode.appendChild(nombreEmpleadoNode);
                EmpleadoNode.appendChild(apellidoEmpleadoNode);
                //lo añadimos a Hoteles
                EmpleadosNode.appendChild(EmpleadoNode);

            }

            if (!existe) {
                Element EmpleadoNode = d.createElement("Empleado");

                Element numeroEmpleadoNode = d.createElement("NumeroDeEmpleado");
                Text numeroEmpleado = d.createTextNode(numeroDeEmpleado);
                numeroEmpleadoNode.appendChild(numeroEmpleado);

                Element nombreEmpleadoNode = d.createElement("NombreDeEmpleado");
                Text nombreEmpleado = d.createTextNode(nombre);
                nombreEmpleadoNode.appendChild(nombreEmpleado);

                Element apellidoEmpleadoNode = d.createElement("ApellidoDeEmpleado");
                Text apellidoEmpleado = d.createTextNode(apellido);
                apellidoEmpleadoNode.appendChild(apellidoEmpleado);

                EmpleadoNode.appendChild(numeroEmpleadoNode);
                EmpleadoNode.appendChild(nombreEmpleadoNode);
                EmpleadoNode.appendChild(apellidoEmpleadoNode);
                //lo añadimos a Hoteles
                EmpleadosNode.appendChild(EmpleadoNode);
            }
            elementoRaiz.appendChild(EmpleadosNode);
            //con el source generamos el xml
            Source s = new DOMSource(d);
            //le indicamos en que fichero se va a guardar pasandole la ruta por parámetro.
            Result rutaAlmacenFichero = new StreamResult(f);
            // lo transformamos y creamos la instancia
            Transformer transfomer = TransformerFactory.newInstance().newTransformer();
            //le pasamos por parametro el xml que generamos y la ruta de almacenaje.
            transfomer.transform(s, rutaAlmacenFichero);
        } catch (IOException ex) {
            Logger.getLogger(FicheroXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FicheroXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(FicheroXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

    public ArrayList leerFicheroXMLEmpleadosReescribir() throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Empleado> listaDeEmpleadoXML = new ArrayList<Empleado>();
        Empleado empleadoAnnadir;
        String numeroEmpleado;
        String nombreEmpleado;
        String apellidoEmpleado;
        File f = new File("FicheroXmlEmpleados.xml");
        if (f.exists()) {

            try {

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc;
                doc = dBuilder.parse(f);

                //optional, but recommended
                //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                doc.getDocumentElement().normalize();

                NodeList nList = doc.getElementsByTagName("Empleado");

                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        numeroEmpleado = eElement.getElementsByTagName("NumeroDeEmpleado").item(0).getTextContent();
                        nombreEmpleado = eElement.getElementsByTagName("NombreDeEmpleado").item(0).getTextContent();
                        apellidoEmpleado = eElement.getElementsByTagName("ApellidoDeEmpleado").item(0).getTextContent();
                        empleadoAnnadir = new Empleado(numeroEmpleado, nombreEmpleado, apellidoEmpleado);
                        listaDeEmpleadoXML.add(empleadoAnnadir);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return listaDeEmpleadoXML;

    }

    public ArrayList leerFicheroXMLEmpleados() throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Empleado> listaDeEmpleadoXML = new ArrayList<Empleado>();
        Empleado empleadoAnnadir;
        String numeroEmpleado;
        String nombreEmpleado;
        String apellidoEmpleado;
        File f = new File("FicheroXmlEmpleados.xml");
        if (f.exists()) {
            try {

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(f);

                //optional, but recommended
                //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                doc.getDocumentElement().normalize();

                NodeList nList = doc.getElementsByTagName("Empleado");
                ArrayList<Movimiento> listaDeMovimientos = leerFicheroXMLMovimientos();

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    ArrayList<Movimiento> listaDeMovimientosComprobar = new ArrayList();
                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        numeroEmpleado = eElement.getElementsByTagName("NumeroDeEmpleado").item(0).getTextContent();
                        nombreEmpleado = eElement.getElementsByTagName("NombreDeEmpleado").item(0).getTextContent();
                        apellidoEmpleado = eElement.getElementsByTagName("ApellidoDeEmpleado").item(0).getTextContent();

                        for (Movimiento m : listaDeMovimientos) {
                            if (m.getNumeroDeEmpleado().equals(numeroEmpleado)) {
                                listaDeMovimientosComprobar.add(m);
                            }
                        }
                        empleadoAnnadir = new Empleado(numeroEmpleado, nombreEmpleado, apellidoEmpleado, listaDeMovimientosComprobar);
                        listaDeEmpleadoXML.add(empleadoAnnadir);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listaDeEmpleadoXML;

    }

    public boolean escribirFicheroXMLMovimientos(String numeroDeMovimiento, double Importe, String tipo, String fecha, String descripcion, String numeroDeEmpleado) throws TransformerConfigurationException, TransformerException {
        boolean existe = false;
        ArrayList<Movimiento> listaMovimientos = new ArrayList();
        try {
        listaMovimientos = leerFicheroXMLMovimientos();
        File f = new File("FicheroXmlMovimientos.xml");
        
            if (!f.exists()) {
                f.createNewFile();
            }
            
            //crea la factory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            //crea el documento
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Implementamos el DOM
            DOMImplementation implementation = builder.getDOMImplementation();
            //Creamos el Documento con los parametros (buscar para que sirve cada uno)
            Document d = implementation.createDocument(null, "listaMovimiento", null);
            //le decimos que versión de xml es.
            d.setXmlVersion("1.0");

            //Definimos el elemento Raíz.
            Element elementoRaiz = d.getDocumentElement();
            Element MovimientosNode = d.createElement("Movimientos");
            //Definimos La primera etiqueta, que es Hoteles.

            for (Movimiento m : listaMovimientos) {
                if (m.getNumeroDeEmpleado().equals(numeroDeEmpleado)) {
                    if (m.getNumeroDeMovimiento().equals(numeroDeMovimiento)) {
                        existe = true;
                    }
                }
                Element MovimientoNode = d.createElement("Movimiento");

                Element numeroMovimientoNode = d.createElement("NumeroDeMovimiento");
                Text numeroMovimiento = d.createTextNode(m.getNumeroDeMovimiento());
                numeroMovimientoNode.appendChild(numeroMovimiento);

                Element ImporteNode = d.createElement("Importe");
                Text ImporteTexto = d.createTextNode("" + m.getImporte());
                ImporteNode.appendChild(ImporteTexto);

                Element tipoNode = d.createElement("Tipo");
                Text tipoTexto = d.createTextNode(m.getTipo());
                tipoNode.appendChild(tipoTexto);

                Element fechaNode = d.createElement("Fecha");
                Text fechaTexto = d.createTextNode(m.getFecha());
                fechaNode.appendChild(fechaTexto);

                Element descripcionNode = d.createElement("Descripcion");
                Text descripcionTexto = d.createTextNode(m.getDescripcion());
                descripcionNode.appendChild(descripcionTexto);

                Element numeroDeEmpleadoNode = d.createElement("NumeroDeEmpleado");
                Text numeroDeEmpleadoTexto = d.createTextNode(m.getNumeroDeEmpleado());
                numeroDeEmpleadoNode.appendChild(numeroDeEmpleadoTexto);

                MovimientoNode.appendChild(numeroMovimientoNode);
                MovimientoNode.appendChild(ImporteNode);
                MovimientoNode.appendChild(tipoNode);
                MovimientoNode.appendChild(fechaNode);
                MovimientoNode.appendChild(descripcionNode);
                MovimientoNode.appendChild(numeroDeEmpleadoNode);

                //lo añadimos a Hoteles
                MovimientosNode.appendChild(MovimientoNode);

            }

            if (!existe) {

                Element MovimientoNode = d.createElement("Movimiento");

                Element numeroMovimientoNode = d.createElement("NumeroDeMovimiento");
                Text numeroMovimiento = d.createTextNode(numeroDeMovimiento);
                numeroMovimientoNode.appendChild(numeroMovimiento);

                Element ImporteNode = d.createElement("Importe");
                Text ImporteTexto = d.createTextNode("" + Importe);
                ImporteNode.appendChild(ImporteTexto);

                Element tipoNode = d.createElement("Tipo");
                Text tipoTexto = d.createTextNode(tipo);
                tipoNode.appendChild(tipoTexto);

                Element fechaNode = d.createElement("Fecha");
                Text fechaTexto = d.createTextNode(fecha);
                fechaNode.appendChild(fechaTexto);

                Element descripcionNode = d.createElement("Descripcion");
                Text descripcionTexto = d.createTextNode(descripcion);
                descripcionNode.appendChild(descripcionTexto);

                Element numeroDeEmpleadoNode = d.createElement("NumeroDeEmpleado");
                Text numeroDeEmpleadoTexto = d.createTextNode(numeroDeEmpleado);
                numeroDeEmpleadoNode.appendChild(numeroDeEmpleadoTexto);

                MovimientoNode.appendChild(numeroMovimientoNode);
                MovimientoNode.appendChild(ImporteNode);
                MovimientoNode.appendChild(tipoNode);
                MovimientoNode.appendChild(fechaNode);
                MovimientoNode.appendChild(descripcionNode);
                MovimientoNode.appendChild(numeroDeEmpleadoNode);

                //lo añadimos a Hoteles
                MovimientosNode.appendChild(MovimientoNode);

            }
            elementoRaiz.appendChild(MovimientosNode);
            //con el source generamos el xml
            Source s = new DOMSource(d);
            //le indicamos en que fichero se va a guardar pasandole la ruta por parámetro.
            Result rutaAlmacenFichero = new StreamResult(f);
            // lo transformamos y creamos la instancia
            Transformer transfomer = TransformerFactory.newInstance().newTransformer();
            //le pasamos por parametro el xml que generamos y la ruta de almacenaje.
            transfomer.transform(s, rutaAlmacenFichero);
        } catch (IOException ex) {
            Logger.getLogger(FicheroXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FicheroXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(FicheroXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

    public ArrayList leerFicheroXMLMovimientos() throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Movimiento> listaDeMovimientoXML = new ArrayList<Movimiento>();
        Movimiento MovimientoAnnadir;
        String numeroDeMovimiento;
        String importe;
        String tipo;
        String fecha;
        String descripcion;
        String numeroDeEmpleado;
        File f = new File("FicheroXmlMovimientos.xml");
        if (f.exists()) {

            try {

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(f);

            //optional, but recommended
                //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                doc.getDocumentElement().normalize();

                NodeList nList = doc.getElementsByTagName("Movimiento");

                for (int temp = 0; temp < nList.getLength(); temp++) {

                    Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        numeroDeMovimiento = eElement.getElementsByTagName("NumeroDeMovimiento").item(0).getTextContent();
                        importe = eElement.getElementsByTagName("Importe").item(0).getTextContent();
                        tipo = eElement.getElementsByTagName("Tipo").item(0).getTextContent();
                        fecha = eElement.getElementsByTagName("Fecha").item(0).getTextContent();
                        descripcion = eElement.getElementsByTagName("Descripcion").item(0).getTextContent();
                        numeroDeEmpleado = eElement.getElementsByTagName("NumeroDeEmpleado").item(0).getTextContent();
                        MovimientoAnnadir = new Movimiento(numeroDeMovimiento, Double.parseDouble(importe), tipo, fecha, descripcion, numeroDeEmpleado);
                        listaDeMovimientoXML.add(MovimientoAnnadir);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return listaDeMovimientoXML;

    }

    /*
     public boolean escribirFicheroXMLEmpleados(String numeroDeEmpleado, String nombre,
     String apellido, String numeroDeMovimiento,double Importe,String tipo,String fecha, String descripcion) throws TransformerConfigurationException, TransformerException {
     ////////////////////////////        
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
     */
}

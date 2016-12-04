/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionDeMovimientos.controlador;

import DAO.*;

import gestionDeMovimientos.modelo.Empleado;
import gestionDeMovimientos.modelo.Movimiento;
import gestionDeMovimientos.vista.JFrameVisionadoDeEmpleados;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author jesus
 */
public class ControladorVisionadoDeEmpleados {

    private JFrameVisionadoDeEmpleados vistaVisionadoDeDatos;
    private ArrayList<Empleado> listaDeEmpleado;
    private int tipoDato = 0;

    public ControladorVisionadoDeEmpleados(JFrameVisionadoDeEmpleados visionadoDeDatos) {
        this.vistaVisionadoDeDatos = visionadoDeDatos;
        FicheroObjetosEmpleado.devolver();
        RellenarTabla(tipoDato);
    }

    public void creaColumnas(TableModelNoEditable modelo) {
        modelo.addColumn("Numero de Empleado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cantidad de Movimientos");
    }

    public void RellenarTabla(int tipoFichero) {
        JTable tablaEmpleados = vistaVisionadoDeDatos.getjTableEmpleados();
        TableModelNoEditable modelo = new TableModelNoEditable();
        tablaEmpleados.setModel(modelo);
        creaColumnas(modelo);

        try {
            switch (tipoFichero) {
                case 0:
                    listaDeEmpleado = FicheroTexto.devolver().leerFicheroTxtEmpleados();
                    this.tipoDato = tipoFichero;
                    break;

                case 1:
                    listaDeEmpleado = FicheroBinario.devolver().leerFicherosEmpleadosDat();
                    this.tipoDato = tipoFichero;
                    break;

                case 2:
                    listaDeEmpleado = FicheroObjetosEmpleado.devolver().leerFicherosObjEmpleado();
                    this.tipoDato = tipoFichero;
                    break;

                case 3:
                    listaDeEmpleado = FicheroXML.devolver().leerFicheroXMLEmpleados();
                    this.tipoDato = tipoFichero;
                    break;

                default:
                    break;
            }
            Object[] columna = new Object[4];
            if (listaDeEmpleado.isEmpty()) {
                JOptionPane.showMessageDialog(vistaVisionadoDeDatos, "No hay empleados seleccione otro tipo de fichero o añadelos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                for (Empleado e : listaDeEmpleado) {
                    columna[0] = e.getNumeroDeEmpleado();
                    columna[1] = e.getNombre();
                    columna[2] = e.getApellido();
                    columna[3] = "" + e.getListaDeMovimientos().size();
                    modelo.addRow(columna);
                }

                tablaEmpleados.setModel(modelo);
                tablaEmpleados.repaint();
            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AbrirInsertadoDeEmpleados() {
        ControladorInsertardoDeEmpleados.AbrirInsertadoDeDatos(vistaVisionadoDeDatos);
    }

    public void AbrirInsertadoDeMovimientos(int tipoDeFichero) {
        ArrayList<Empleado> listaDeEmpleados = new ArrayList();
        try {
            switch (tipoDeFichero) {
                case 0:
                    listaDeEmpleados = FicheroTexto.devolver().leerFicheroTxtEmpleados();
                    break;
                case 1:
                    listaDeEmpleados = FicheroBinario.devolver().leerFicherosEmpleadosDat();
                    break;
                case 2:
                    listaDeEmpleados = FicheroObjetosEmpleado.devolver().leerFicherosObjEmpleado();
                    break;
                case 3:listaDeEmpleados = FicheroXML.devolver().leerFicheroXMLEmpleados();
                    break;
                default:
                    break;

            }

        } catch (IOException ex) {
            Logger.getLogger(ControladorInsertardoDeMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (listaDeEmpleados.size() == 0) {
            JOptionPane.showMessageDialog(vistaVisionadoDeDatos, "No hay empleados seleccione otro tipo de fichero o añadelos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new ControladorInsertardoDeMovimientos(listaDeEmpleados, tipoDeFichero);
        }
    }

    public void AbrirVerMovimiento(java.awt.event.MouseEvent evt, JTable jTableMiListaPeliculas) {
        int fila = jTableMiListaPeliculas.rowAtPoint(evt.getPoint());
        ArrayList<Movimiento> listaDeMovimientos = new ArrayList();
        String numeroDeEmpleado = jTableMiListaPeliculas.getValueAt(fila, 0).toString();
        try {
            switch (tipoDato) {
                case 0:
                    listaDeMovimientos = FicheroTexto.devolver().leerFicheroTxtMovimientos();
                    break;
                case 1:
                    listaDeMovimientos = FicheroBinario.devolver().leerFicherosMovimientoDat();
                    break;
                case 2:
                    listaDeMovimientos = FicheroObjetosMovimiento.devolver().leerFicherosObjMovimiento();
                    break;
                case 3:
                    listaDeMovimientos = FicheroXML.devolver().leerFicheroXMLMovimientos();
                    break;
                default:
                    break;
            }

            if (listaDeMovimientos.isEmpty()) {
                JOptionPane.showMessageDialog(vistaVisionadoDeDatos, "No hay Movimientos seleccione otro tipo de fichero o añadelos", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                ArrayList<Movimiento> listaDeMovimientosEmpleado = new ArrayList();

                for (Movimiento m : listaDeMovimientos) {
                    if (m.getNumeroDeEmpleado().equals(numeroDeEmpleado)) {
                        listaDeMovimientosEmpleado.add(m);
                    }
                }
                if (listaDeMovimientosEmpleado.isEmpty()) {
                    JOptionPane.showMessageDialog(vistaVisionadoDeDatos, "No hay Movimientos en este empleado seleccione otro tipo de fichero o añadelos", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    new ControladorVisionadoDeMovimientos(listaDeMovimientosEmpleado);
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(vistaVisionadoDeDatos, "No se han podido recoger los datos", "Error", JOptionPane.ERROR_MESSAGE);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(vistaVisionadoDeDatos, "No se han podido recoger los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(vistaVisionadoDeDatos, "No se han podido recoger los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SAXException ex) {
            Logger.getLogger(ControladorVisionadoDeEmpleados.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(vistaVisionadoDeDatos, "No se han podido recoger los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}

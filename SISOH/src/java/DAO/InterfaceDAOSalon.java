/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Salon;
import java.util.List;

/**
 *
 * @author Angel
 */
public interface InterfaceDAOSalon {
    public List<Salon> mostrarSalon();
    public Salon buscarSalon(int id);
    public void modificarSalon(Salon UAC);
    public void insertarSalon(Salon UAC);
    public void eliminarSalon(Salon UAC);
    
}

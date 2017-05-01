/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.Salon;
import Servicios.ServiceFacadeLocator;
import Servicios.ServiceLocator;
import java.util.List;

/**
 *
 * @author Angel
 */
public class SalonesDelegate {

    private List<Salon> salones;

    public SalonesDelegate() {

    }

    public List<Salon> getSalones() {
        return ServiceFacadeLocator.getFacadeSalones().consultaSalon();
    }
    
    public void agregarSalon(Salon sala){
        ServiceFacadeLocator.getFacadeSalones().agregarSalon(sala);
    }
    
    public void eliminarSalon(Salon sala){
        ServiceFacadeLocator.getFacadeSalones().eliminarSalon(sala);
    }
    
    public void modificarSalon(Salon sala){
        ServiceFacadeLocator.getFacadeSalones().modificarSalon(sala);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidad.Salon;
import Servicios.ServiceLocator;
import java.util.List;

/**
 *
 * @author Angel
 */
public class FacadeSalones {

    public List<Salon> consultaSalon() {

        List<Salon> resultado = null;
        ServiceLocator.getInstanceSalonesDAO().setObjeto(Salon.class);
        resultado = ServiceLocator.getInstanceSalonesDAO().mostrarSalon();
        return resultado;

    }
    
    public void agregarSalon(Salon sala){
        ServiceLocator.getInstanceSalonesDAO().setObjeto(Salon.class);
        ServiceLocator.getInstanceSalonesDAO().insertarSalon(sala);
    }
    
    public void modificarSalon(Salon sala){
        ServiceLocator.getInstanceSalonesDAO().setObjeto(Salon.class);
        ServiceLocator.getInstanceSalonesDAO().modificarSalon(sala);
    }
    
    public void eliminarSalon(Salon sala){
        ServiceLocator.getInstanceSalonesDAO().setObjeto(Salon.class);
        ServiceLocator.getInstanceSalonesDAO().eliminarSalon(sala);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.Edificio;
import Servicios.ServiceFacadeLocator;
import java.util.List;

/**
 *
 * @author Miltokk
 */
public class EdificiosDelegate {
 private List<Edificio> edificios;
    
    public EdificiosDelegate(){
        
    }
    
    public List<Edificio> getEdificios(){
        return ServiceFacadeLocator.getFacadeEdificio().consultaEdificio();
    }
    
   public void agregarEdificio(Edificio edificio){
       ServiceFacadeLocator.getFacadeEdificio().agregarEdificio(edificio);
   }
   
   public void eliminarEdificio(Edificio edificio){
       ServiceFacadeLocator.getFacadeEdificio().eliminarEdificio(edificio);
   }
   
   public void modificarEdificio(Edificio edificio){
       ServiceFacadeLocator.getFacadeEdificio().modificarEdificio(edificio);
   }
   
  
}

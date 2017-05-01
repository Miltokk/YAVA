/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Logica.FacadeEdificio;
import Logica.FacadeSalones;

/**
 *
 * @author Miltokk
 */
public class ServiceFacadeLocator {
    
    private static FacadeEdificio facadeEdificio;
    private static FacadeSalones facadeSalon;
    
    public static FacadeEdificio getFacadeEdificio(){
    
        if( facadeEdificio == null )
            facadeEdificio = new FacadeEdificio();
        
        return facadeEdificio;
    
    }
    
    public static FacadeSalones getFacadeSalones(){
        if(facadeSalon==null)
            facadeSalon=new FacadeSalones();
        return facadeSalon;
    }
}

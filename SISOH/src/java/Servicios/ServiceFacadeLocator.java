/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Logica.FacadeEdificio;

/**
 *
 * @author Miltokk
 */
public class ServiceFacadeLocator {
    
    private static FacadeEdificio facadeEdificio;
    
    public static FacadeEdificio getFacadeEdificio(){
    
        if( facadeEdificio == null )
            facadeEdificio = new FacadeEdificio();
        
        return facadeEdificio;
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.EdificiosDAO;

/**
 *
 * @author Miltokk
 */
public class ServiceLocator {
    
    private static EdificiosDAO ConexionDAO;
     
      public static EdificiosDAO getInstanceEdificioDAO(){
        
        if ( ConexionDAO == null )
            ConexionDAO = new EdificiosDAO();
        
        return ConexionDAO;
    }
     
}

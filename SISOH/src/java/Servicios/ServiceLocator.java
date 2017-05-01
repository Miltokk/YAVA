/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.EdificiosDAO;
import DAO.SalonesDAO;

/**
 *
 * @author Miltokk
 */
public class ServiceLocator {

    private static EdificiosDAO ConexionDAO;
    private static SalonesDAO salonDAO;

    public static EdificiosDAO getInstanceEdificioDAO() {

        if (ConexionDAO == null) {
            ConexionDAO = new EdificiosDAO();
        }

        return ConexionDAO;
    }

    public static SalonesDAO getInstanceSalonesDAO() {
        if (salonDAO == null) {
            salonDAO = new SalonesDAO();
        }
        return salonDAO;
    }

}

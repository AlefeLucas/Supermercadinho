/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.supermercado.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Alefe Lucas
 */
public class DAO {

    protected File dir;
    protected RandomAccessFile raf;

    protected DAO() {
        dir = Paths.get(System.getProperty("user.dir"), "db").toFile();
        
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

}

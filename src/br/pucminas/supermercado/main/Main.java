/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.supermercado.main;

import br.pucminas.supermercado.dao.UsuarioDAO;
import br.pucminas.supermercado.model.Usuario;
import java.io.IOException;

/**
 *
 * @author Alefe Lucas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        //inserirEx(usuarioDAO);
        
        lerTudo(usuarioDAO);
        
        atualizarId(usuarioDAO, 2);
        System.out.println("\n\n");
        lerTudo(usuarioDAO);
    }

    private static void atualizarId(UsuarioDAO usuarioDAO, int id) {
        Usuario usuario = usuarioDAO.read(id);
        usuario.setNome("Homão");
        usuarioDAO.update(usuario);
    }

    private static void lerTudo(UsuarioDAO usuarioDAO) {
        int length = usuarioDAO.getLastID();
        for (int i = 1; i <= length; i++) {
            System.out.println(usuarioDAO.read(i));
        }
    }

    private static void inserirEx(UsuarioDAO usuarioDAO) {
        Usuario[] usuarios = new Usuario[]{
            new Usuario(null, "675.456.987-04", "Gabs", "+55 31 4353453", "gabs@gmail.com", "1234"),
            new Usuario(null, "123.456.987-04", "Lulu", "+55 31 455464564", "lulu@gmail.com", "1234"),
            new Usuario(null, "999.456.987-04", "Afele", "+55 31 999994564", "afele@gmail.com", "1234")
        };
        
        for (Usuario usuario : usuarios) {
            usuarioDAO.insert(usuario);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucminas.supermercado.dao;

import br.pucminas.supermercado.model.Usuario;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FAZER UM INDICADOR SHORT DE TAMANHO DO REGISTRO PARA PODER PULA-LO ARMAZENAR
 * ULTIMO ID
 *
 * ESTRUTURA REGISTRO ID, NOME, CPF,
 *
 * @author Alefe Lucas
 */
public class UsuarioDAO extends DAO {

    private int lastID;

    /**
     *
     */
    public UsuarioDAO() {
        File db = Paths.get(dir.getPath(), "usuario.db").toFile();
        try {
            if (!db.exists()) {
                this.raf = create(db); //cria o bd se não existir e retorna o raf
            } else {
                this.raf = new RandomAccessFile(db, "rws"); //se existir, simplesmente inicia o raf
                lastID = raf.readInt(); //inicia o ultimo id usado
            }
        } catch (IOException ex) {
            System.err.println("Erro ao conectar-se a usuario.db");
            ex.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Cria o arquivo usuario.db e inicializa ID
     *
     * @param db
     * @return
     */
    private RandomAccessFile create(File db) throws IOException {
        RandomAccessFile raf = null;

        db.createNewFile();
        raf = new RandomAccessFile(db, "rws");
        raf.writeInt(0);

        return raf;
    }

    public int getLastID() {
        return lastID;
    }

    public void insert(Usuario usuario) {
        insert(usuario, true);
    }

    private void insert(Usuario usuario, boolean autoIncrement) {

        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                DataOutputStream data = new DataOutputStream(buffer)) {
            if (autoIncrement) {                
                usuario.setId(++lastID); //Coloca o id certo
                raf.seek(0);
                raf.writeInt(lastID);
                
            }

            //Escreve os dados do registro no buffer
            data.writeBoolean(false);//Lápide
            data.writeInt(usuario.getId());
            data.writeUTF(usuario.getNome());
            data.writeUTF(usuario.getCpf());
            data.writeUTF(usuario.getEmail());
            data.writeUTF(usuario.getSenha());
            data.writeUTF(usuario.getTelefone());
            raf.seek(raf.length()); //Pula pro final do arquivo
            raf.writeShort(data.size()); //Indicador de tamanho do registro
            raf.write(buffer.toByteArray()); //O registro

            System.out.println("Usuario " + usuario.getNome() + " inserido com sucesso.");
        } catch (IOException ex) {
            System.err.println("Erro ao inserir");
            ex.printStackTrace();
        }

    }

    /**
     * Lê por ID
     *
     * @param id
     * @return
     * @throws IOException
     */
    public Usuario read(int id) {
        Usuario usuario = null;

        try {
            raf.seek(4); //Pula o "ultimo ID"
            boolean repete = true;

            do {
                short regSize = raf.readShort();
                byte[] data = new byte[regSize];

                if (raf.read(data) != regSize) {
                    throw new IOException("Inconsistência nos dados");
                }

                DataInputStream source = new DataInputStream(new ByteArrayInputStream(data));

                if (!source.readBoolean() && id == source.readInt()) {
                    usuario = new Usuario();
                    usuario.setId(id);
                    usuario.setNome(source.readUTF());
                    usuario.setCpf(source.readUTF());
                    usuario.setEmail(source.readUTF());
                    usuario.setSenha(source.readUTF());
                    usuario.setTelefone(source.readUTF());
                    repete = false;
                }

            } while (repete);
        } catch (EOFException ex) {
            System.out.println("ID não encontrado");
        } catch (IOException ex) {
            System.err.println("Erro ao fazer leitura");
            ex.printStackTrace();
        }
        return usuario;
    }

    public void update(Usuario usuario) {
        delete(usuario);
        insert(usuario, false);
        
    }

    public void delete(Usuario usuario) {
        try {
            raf.seek(4); //Pula o "ultimo ID"
            boolean repete = true;

            do {

                short regSize = raf.readShort();
                long pos = raf.getFilePointer();
                byte[] data = new byte[regSize];

                if (raf.read(data) != regSize) {
                    throw new IOException("Inconsistência nos dados");
                }

                DataInputStream source = new DataInputStream(new ByteArrayInputStream(data));

                if (!source.readBoolean() && source.readInt() == usuario.getId()) {
                    raf.seek(pos);
                    raf.writeBoolean(true);
                }

            } while (repete);
        } catch (EOFException ex) {
            System.out.println("ID não encontrado");
        } catch (IOException ex) {
            System.err.println("Erro ao fazer leitura");
            ex.printStackTrace();
        }
    }
}

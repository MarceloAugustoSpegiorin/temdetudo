package DTO;

import java.util.ArrayList;
import utils.campo;

public class usuariosDTO extends ClassePaiDTO {
    private campo<Integer> id_usuario;
    private campo<String> nome_usuario;
    private campo<String> senha;
    private campo<Integer> nivel_acesso;

    public usuariosDTO(){
        this.NomedaTabela = "usuarios";
         id_usuario = new campo<>();
         nome_usuario = new campo<>();
         senha = new campo<>();
         nivel_acesso = new campo<>();
         
         id_usuario.ChavePrimaria = true;
         
         id_usuario.nomedoCampo = "id_usuario";
         nome_usuario.nomedoCampo = "nome_usuario";
         senha.nomedoCampo = "senha";
         nivel_acesso.nomedoCampo = "nivel_acesso";
         
    }
    @Override
    public ArrayList<campo> retornaCampos(){
        ArrayList<campo> listadeCampos = new ArrayList<>();
        listadeCampos.add(id_usuario);
        listadeCampos.add(nome_usuario);
        listadeCampos.add(senha);
        listadeCampos.add(nivel_acesso);

        
        return listadeCampos;
    }    
    
    public campo<Integer> getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario.valorCampo = id_usuario;
    }

    public campo<String> getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario.valorCampo = nome_usuario;
    }

    public campo<String> getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha.valorCampo = senha;
    }

    public campo<Integer> getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso( int nivel_acesso) {
        this.nivel_acesso.valorCampo  = nivel_acesso;
    }

}

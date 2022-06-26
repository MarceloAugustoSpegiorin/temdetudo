package DTO;

import java.util.ArrayList;
import utils.campo;

public class produtosDTO extends ClassePaiDTO{
    
    private campo<Integer> id_produto;
    private campo<String> descricao_produto;
    private campo<Integer> quantidade_estoque;
    private campo<Double> valor;

    
    @Override
    public ArrayList<campo> retornaCampos(){
        ArrayList<campo> listadeCampos = new ArrayList<>();
        listadeCampos.add(id_produto);
        listadeCampos.add(descricao_produto);
        listadeCampos.add(quantidade_estoque);
        listadeCampos.add(valor);
        
        return listadeCampos;
    }
    
    public produtosDTO(){
         this.NomedaTabela = "produtos";
         id_produto = new campo<>();
         descricao_produto = new campo<>();
         quantidade_estoque = new campo<>();
         valor = new campo<>();
         
         id_produto.ChavePrimaria = true;
         id_produto.nomedoCampo = "id_produto ";
         
         descricao_produto.nomedoCampo = "descricao_produto";
         quantidade_estoque.nomedoCampo = "quantidade_estoque";
         valor.nomedoCampo = "valor";
         
    }
    
    public campo<Integer> getId_produto() {
        return id_produto;
    }

    public void setId_produto(campo<Integer> id_produto) {
        this.id_produto = id_produto;
    }

    public campo<String> getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(campo<String> descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public campo<Integer> getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(campo<Integer> quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public campo<Double> getValor() {
        return valor;
    }

    public void setValor(campo<Double> valor) {
        this.valor = valor;
    }
    
}

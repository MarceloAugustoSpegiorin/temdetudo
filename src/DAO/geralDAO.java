package DAO;

import DTO.ClassePaiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import utils.CRUDUtil;
import utils.StringUtil;
import utils.campo;

public class geralDAO {

    private bancoDAO banco;

    public geralDAO() {

        banco = new bancoDAO();
    }

    public String atualizaRegistro(ClassePaiDTO objDTO) {
        ArrayList<campo> listadeCampos = objDTO.retornaCampos();
        StringUtil trataSTR = new StringUtil();
        String comando = " UPDATE " + objDTO.NomedaTabela + " SET ";
        //String campos = "";
        String valores = "";
        for (int i = 0; i < listadeCampos.size(); i++) {

            if (!listadeCampos.get(i).ChavePrimaria) {

                valores += listadeCampos.get(i).nomedoCampo;
                if (listadeCampos.get(i).valorCampo.getClass() == String.class) {
                    valores += " = " + trataSTR.colocaAspasSimples(listadeCampos.get(i).valorCampo.toString());
                } else {
                    valores += " = " + listadeCampos.get(i).valorCampo.toString();
                }
                if (i < listadeCampos.size() - 1) {
                    valores += ",";
                }
            }

        }
        String comandoWhere = " WHERE ";
        for (int i = 0; i < listadeCampos.size(); i++) {
            if (listadeCampos.get(i).ChavePrimaria) {
                comandoWhere += listadeCampos.get(i).nomedoCampo + " = " + listadeCampos.get(i).valorCampo.toString();
            }
        }

        String comandoFinal = comando + valores + comandoWhere;
        banco.executaComando(comandoFinal);

        return comandoFinal;
    }

    public TableModel retornaConsulta(ClassePaiDTO objDTO, String filtro) {
        String comando ="";
        StringUtil trataString = new StringUtil();
        if (filtro == ""){
            comando = "select * from "+objDTO.NomedaTabela;
        }else{
              comando = "select * from "+objDTO.NomedaTabela + " where "+filtro;
        }
        return CRUDUtil.resultSetToTableModel(banco.retornaDados(comando));
    }

    public String apagaRegistro(ClassePaiDTO objDTO) {
        ArrayList<campo> listadeCampos = objDTO.retornaCampos();
        String comando = "delete from " + objDTO.NomedaTabela + " where ";
        String comandoWhere = "";
        for (int i = 0; i < listadeCampos.size(); i++) {
            if (listadeCampos.get(i).ChavePrimaria) {
                comandoWhere = listadeCampos.get(i).nomedoCampo + " = " + listadeCampos.get(i).valorCampo.toString();
            }
        }
        banco.executaComando(comando + comandoWhere);
        return comando + comandoWhere;
    }

    public String insereRegistro(ClassePaiDTO objDTO) {
        ArrayList<campo> listadeCampos = objDTO.retornaCampos();
        StringUtil trataSTR = new StringUtil();
        String comando = "Insert into " + objDTO.NomedaTabela;
        String campos = "";
        String valores = "";
        for (int i = 0; i < listadeCampos.size(); i++) {

            if (!listadeCampos.get(i).ChavePrimaria) {
                campos += listadeCampos.get(i).nomedoCampo;
                if (listadeCampos.get(i).valorCampo.getClass() == String.class) {
                    valores += trataSTR.colocaAspasSimples(listadeCampos.get(i).valorCampo.toString());
                } else {
                    valores += listadeCampos.get(i).valorCampo.toString();
                }
                if (i < listadeCampos.size() - 1) {
                    campos += ",";
                    valores += ",";
                }
            }
        }

        comando += " (" + campos + ")" + " values (" + valores + ")";
        banco.executaComando(comando);
        return comando;
    }

}

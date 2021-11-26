package Ordenacao;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Arquivo;

/**
 *
 * @author olive
 */
public class InsertionSort {
    private List<Arquivo> dados;
    
    public InsertionSort(List<Arquivo> local_dados){
        dados = local_dados;
    }
    
    public void Ordenar(){
        int i, j;
        Arquivo chave;
        
        for (j = 1; j < dados.size(); j++){
            chave = dados.get(j);
            
            try {
                for (i = j - 1; (i >= 0) && (dados.get(i).toBlob().length() > chave.toBlob().length()); i--){
                    dados.set(i+1, dados.get(i));
                }
                dados.set(i+1, chave);
            } catch (SQLException ex) {
                Logger.getLogger(InsertionSort.class.getName()).log(Level.SEVERE, null, ex);
            }        
            
        }
    }

    public List<Arquivo> getDados() {
        return dados;
    }
}

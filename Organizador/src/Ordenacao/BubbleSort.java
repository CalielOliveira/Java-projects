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
public class BubbleSort {
    private List<Arquivo> dados;
    
    public BubbleSort(List<Arquivo> local_dados){
        dados = local_dados;
    }
    
    public void Ordenar(){
        int length = dados.size();
        Arquivo aux;
        
        int trocados = 0;
        int count = 0;
        while(true){
            try {
                if (dados.get(count).toBlob().length() > dados.get(count+1).toBlob().length()){
                    aux = dados.get(count+1);
                    dados.set(count+1, dados.get(count));
                    dados.set(count, aux);
                    trocados++;                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (count == length-2){
                count = 0;
                if(trocados == 0){
                    break;                   
                }
                trocados = 0;            
            }else{
                count++;
            }
        }
    }

    public List<Arquivo> getDados() {
        return dados;
    }
}

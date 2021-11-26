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
public class VetorOrdenado {
    private List<Arquivo> dados;
    
    public VetorOrdenado(List<Arquivo> local_dados){
        dados = local_dados;
    }
    
    public void Ordenar(){
        int lenght = dados.size();
        Arquivo aux;
        
        for (int i=0; i<lenght-1; i++){
            for (int j=0; j<lenght-1-i; j++){
                try {
                    if (dados.get(j).toBlob().length() > dados.get(j+1).toBlob().length()){
                        
                        aux = dados.get(j+1);
                        dados.add(j+1, dados.get(j)); 
                        dados.add(j, aux);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(VetorOrdenado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public List<Arquivo> getDados() {
        return dados;
    }
}

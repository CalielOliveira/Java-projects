package model.bean;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

/**
 *
 * @author olive
 */
public class Arquivo {
    private String name;
    private byte[] byteArq;
    
    public Arquivo(File f) throws IOException{
        name = f.getName();
        byteArq = Files.readAllBytes(f.toPath());
    }   
    
    public Arquivo(byte[] b, String local_name) throws IOException{
        name = local_name;
        byteArq = b;
    }   
    
    public Blob toBlob() throws SQLException{
        return new SerialBlob(byteArq);
    }

    public byte[] getByteArq() {
        return byteArq;
    }

    public void setByteArq(byte[] byteArq) {
        this.byteArq = byteArq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

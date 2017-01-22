/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leadmyteam;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Projekt {
    public int dlugosc = 4;
    
    private int idProjektu;
    private String nazwaProjektu;
    private Date dataOddania;
    private Date dataRozpoczecia;
    
    public List<Pracownik> uczestnicyProjektu = new ArrayList<>();
    
    public Projekt(
        int IDProjektu,
        String NazwaProjektu,
        Date DataOddania,
        Date DataRozpoczecia
    ){
        this.idProjektu = IDProjektu;
        this.nazwaProjektu = NazwaProjektu;
        this.dataOddania = DataOddania;
        this.dataRozpoczecia = DataRozpoczecia;
    }   
    
    public Object[] PobierzObiekt(){
        Object[] dane = {idProjektu, nazwaProjektu, dataOddania, dataRozpoczecia};
        return dane;
    }
    
    public int PobierzIdProjektu(){
        return idProjektu;
    }
    
    public String PobierzNazweProjektu(){
        return nazwaProjektu;
    }
}

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
    public int dlugoscDoUczestnikow = 3;

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
    ) {
        this.idProjektu = IDProjektu;
        this.nazwaProjektu = NazwaProjektu;
        this.dataOddania = DataOddania;
        this.dataRozpoczecia = DataRozpoczecia;
    }

    Projekt(String nazwaProjektu, Date dataZakonczenia, Date dataRozpoczecia) {
        this.nazwaProjektu = nazwaProjektu;
        this.dataOddania = dataOddania;
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public Object[] PobierzObiekt() {
        Object[] dane = {idProjektu, nazwaProjektu, dataOddania, dataRozpoczecia};
        return dane;
    }

    public Object[][] PobierzDaneDoSzczegolow() {
        if (uczestnicyProjektu.size() > 0) {
            Object[][] dane = new Object[uczestnicyProjektu.size()][uczestnicyProjektu.get(0).dlugoscDoProjektow];
            for(int i=0; i<uczestnicyProjektu.size(); i++){
                dane[i] = uczestnicyProjektu.get(i).PobierzObiektDoProjektow();
            }
            return dane;
        } else {
            return null;
        }
    }

    public int PobierzIdProjektu() {
        return idProjektu;
    }

    public Pracownik ZnajdzUczestnikaProjektu(String pesel){
        for(int i=0; i<uczestnicyProjektu.size(); i++){
            if(uczestnicyProjektu.get(i).PobierzPesel().equals(pesel)){
                return uczestnicyProjektu.get(i);
            }
        }
        return null;
    }
    
    public String PobierzNazweProjektu() {
        return nazwaProjektu;
    }
    
    public void SortujPoNazwisku(){
        for(int i=0; i <uczestnicyProjektu.size();i++){
            for(int j=1; j< uczestnicyProjektu.size(); j++){
                if(uczestnicyProjektu.get(j - 1).PobierzNazwisko().charAt(0) > uczestnicyProjektu.get(j).PobierzNazwisko().charAt(0)){
                    Pracownik temp = uczestnicyProjektu.get(j);
                    uczestnicyProjektu.set(j, uczestnicyProjektu.get(j - 1));
                    uczestnicyProjektu.set(j-1, temp);
                }
            }
        }
    }
    
    public void SortowaniePoPeselu(){
        for(int i=0; i <uczestnicyProjektu.size();i++){
            for(int j=1; j< uczestnicyProjektu.size(); j++){
                if(Long.parseLong(uczestnicyProjektu.get(j-1).PobierzPesel()) > Long.parseLong(uczestnicyProjektu.get(j).PobierzPesel())){
                    Pracownik temp = uczestnicyProjektu.get(j);
                    uczestnicyProjektu.set(j, uczestnicyProjektu.get(j - 1));
                    uczestnicyProjektu.set(j-1, temp);
                }
            }
        }    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leadmyteam;

import java.sql.Date;

public class Urlop {
    public int dlugosc = 5;
    
    private String pesel;
    private String imie;
    private String nazwisko;
    private Date dataRozpoczecia;
    private Date dataZakonczenia;
    
    public Urlop(
        String Pesel,
        String imie,
        String nazwisko,
        Date DataRozpoczecia,
        Date DataZakonczenia){
        
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataRozpoczecia = DataRozpoczecia;
        this.dataZakonczenia = DataZakonczenia;
        this.pesel = Pesel; 
    }
    
    public Object[] PobierzObiekt(){
        Object[] dane = {pesel, imie, nazwisko, dataRozpoczecia, dataZakonczenia};
        return dane;    
    }
    
    public String PobierzNazwisko(){
        return nazwisko;
    }
    
    public String PobierzImie(){
        return imie;
    }
    
    public String PobierzPesel(){
        return pesel;
    }
    
    public void ZmienDaty(Date dataRozpoczecia, Date dataZakonczenia){
        this.dataRozpoczecia = dataRozpoczecia;
        this.dataZakonczenia = dataZakonczenia;
    }
}

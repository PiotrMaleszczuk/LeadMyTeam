
package leadmyteam;

public class ZmienDanePracownikaSQL_Query {
    
    public int IDStanowiska;
    
    public String PobierzZapytanieSQL(
        int KtoraKolumna,
        String pesel,
        String imie,
        String nazwisko,
        String adres,
        String miasto,
        String kodpocztowy,
        String kraj,
        String nazwaStanowiska,
        int liczbaGodzin,
        float stawkaGodzinowa
    ){
        String zapytanie = "";
        if(KtoraKolumna < 7){
            zapytanie += "UPDATE Pracownicy\n SET ";
            switch(KtoraKolumna){
                case 0:
                    zapytanie += "Pesel='" + pesel +"'\n";
                    break;
                case 1:
                    zapytanie += "Imie='" + imie + "'\n";
                    break;
                case 2:
                    zapytanie += "Nazwisko='" + nazwisko + "'\n";
                    break;
                case 3:
                    zapytanie += "Adres='" + adres + "'\n";
                    break;
                case 4:
                    zapytanie += "Miasto='" + miasto + "'\n";
                    break;
                case 5:
                    zapytanie += "[Kod Pocztowy]='" + kodpocztowy + "'\n";
                    break;
                case 6:
                    zapytanie += "Kraj='" + kraj + "'\n";
                    break;
            }
            zapytanie += "WHERE Pesel='" + pesel + "';";
        }
        
        else if(KtoraKolumna == 7){
            zapytanie += "UPDATE Stanowiska\n SET Nazwa='" + nazwaStanowiska + "'\n";
            zapytanie += "WHERE Pesel='" + pesel + "';";
        }
        
        else if(KtoraKolumna == 8){
            zapytanie += "UPDATE Etat\n SET Liczba_Godzin='" + liczbaGodzin + "'\n"; 
            zapytanie += "WHERE Pesel='" + pesel + "';";           
        }
        
        else if(KtoraKolumna == 9){
            zapytanie += "UPDATE Stawka\n SET Kwota='" + stawkaGodzinowa + "'\n"; 
            zapytanie += "WHERE IDStanowiska='" + IDStanowiska + "';";
        }
        
        return zapytanie;
    }
    
    
}

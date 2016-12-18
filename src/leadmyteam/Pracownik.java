package leadmyteam;

public class Pracownik implements Comparable<Pracownik>{
    
    private final String pesel;
    private final String imie;
    private final String nazwisko;
    private final String adres;
    private final String miasto;
    private final String kodPocztowy;
    private final String kraj;
    private final String nazwaStanowiska;
    private final int liczbaGodzin;
    private final float StawkaGodzinowa;
    
    private final float wyplata;
    
    public Pracownik(
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
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.miasto = miasto;
        this.kodPocztowy = kodpocztowy;
        this.kraj = kraj;
        this.nazwaStanowiska = nazwaStanowiska;
        this.liczbaGodzin = liczbaGodzin;
        this.StawkaGodzinowa = stawkaGodzinowa;
        this.wyplata = (float)this.liczbaGodzin * this.StawkaGodzinowa;
    }
    
    public Object[] PobierzObiekt(){
        Object[] dane = {pesel, imie, nazwisko, adres, miasto, kodPocztowy, kraj, nazwaStanowiska, liczbaGodzin, GetWyplata()};
        return dane;
    }
    
    public String PobierzDane(){
        String dane = pesel + "\t" + imie + "\t" + nazwisko + "\t" + adres + "\t" + miasto + "\t" + kodPocztowy + "\t" + kraj + "\t" + nazwaStanowiska + "\t" + liczbaGodzin + "\t" + StawkaGodzinowa;
        return dane;
    }
    
    public String PobierzNazwisko(){
        return nazwisko;
    }
    
    public String PobierzPesel(){
        return pesel;
    }
    
    public float GetWyplata(){
        return wyplata;
    }

    @Override
    public int compareTo(Pracownik o) {
        return pesel.compareTo(o.pesel);
    } 
}

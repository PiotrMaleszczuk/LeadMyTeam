package leadmyteam;

import java.io.Console;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class SqlConnection {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    private ZmienDanePracownikaSQL_Query zmienDanePracownikaSQL_Query = new ZmienDanePracownikaSQL_Query();
    public List<Pracownik> Pracownicy;
    public List<Urlop> Urlopy;

    String connectionUrl = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=LeadMyTeam;user=LeadMyTeam;password=leadmyteam;integratedSecurity=true";

    public SqlConnection() {
        Pracownicy = new ArrayList<>();
        Urlopy = new ArrayList<>();
        Connect();
    }

    public Object[][] PobierzPracownikow() {
        Object[][] dane = new Object[Pracownicy.size()][Pracownicy.get(0).dlugosc];

        for (int i = 0; i < Pracownicy.size(); i++) {
            dane[i] = Pracownicy.get(i).PobierzObiekt();
        }
        return dane;
    }

    public Object[][] PobierzUrlopy() {
        Object[][] dane = new Object[Urlopy.size()][Urlopy.get(0).dlugosc];

        for (int i = 0; i < Urlopy.size(); i++) {
            dane[i] = Urlopy.get(i).PobierzObiekt();
        }
        return dane;
    }

    private void Connect() {
        try {
            // Establish the connection.  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
        } // Handle any errors that may have occurred.  
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //FUNKCJE ODPOWIEDZIALNE ZA PRACOWNIKOW
    // <editor-fold defaultstate="collapsed" desc="Funkcje Pracownika">
    public void Sort1() {
        for (int i = 0; i < Pracownicy.size(); i++) {
            for (int j = 1; j < Pracownicy.size() - i; j++) {
                if (Pracownicy.get(j - 1).PobierzNazwisko().charAt(0) > Pracownicy.get(j).PobierzNazwisko().charAt(0)) {
                    Pracownik temp = Pracownicy.get(j);
                    Pracownicy.set(j, Pracownicy.get(j - 1));
                    Pracownicy.set(j - 1, temp);
                }
            }
        }
    }

    public void SortPesel() {
        Collections.sort(Pracownicy);
    }

    public void DodajPracownika(
            String pesel,
            String imie,
            String nazwisko,
            String adres,
            String miasto,
            String kodpocztowy,
            String kraj,
            String nazwaStanowiska,
            int liczbaGodzin,
            float stawkaGodzinowa) {

        addEmployer(pesel, imie, nazwisko, adres, miasto, kodpocztowy, kraj);
        addTime(pesel, liczbaGodzin);
        addWorkPlace(pesel, nazwaStanowiska);
        addEarnings(pesel, stawkaGodzinowa);
        Pracownicy.add(new Pracownik(pesel, imie, nazwisko, adres, miasto, kodpocztowy, kraj, nazwaStanowiska, liczbaGodzin, stawkaGodzinowa));
    }

    private void addEmployer(String pesel, String imie, String nazwisko, String adres, String miasto, String kodpocztowy, String kraj) {
        String SQL = "INSERT INTO Pracownicy VALUES('" + pesel + "','" + imie + "','" + nazwisko + "','" + adres + "','" + miasto + "','" + kodpocztowy + "','" + kraj + "')";

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addTime(String pesel, int liczbaGodzin) {
        String SQL = "INSERT INTO Etat VALUES('" + pesel + "','" + liczbaGodzin + "')";

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addWorkPlace(String pesel, String nazwaStanowiska) {
        String SQL = "INSERT INTO Stanowiska(Nazwa,Pesel) VALUES('" + nazwaStanowiska + "','" + pesel + "')";

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addEarnings(String pesel, float stawkaGodzinowa) {
        int idStanowisko = 0;
        int idEtatu = 0;
        String SQL = "Select IDStanowiska, e.IDEtatu FROM Stanowiska s\n"
                + "LEFT JOIN Etat e\n"
                + "ON e.Pesel = s.Pesel\n"
                + "WHERE s.Pesel = '" + pesel + "'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                idStanowisko = rs.getInt(1);
                idEtatu = rs.getInt(2);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        addEarningsIntoDatabase(stawkaGodzinowa, idStanowisko, idEtatu);
    }

    private void addEarningsIntoDatabase(float stawkaGodzinowa, int idStanowisko, int idEtatu) {
        String SQL = "INSERT INTO Stawka(Kwota,IDStanowiska,IDEtatu) VALUES('" + stawkaGodzinowa + "','" + idStanowisko + "','" + idEtatu + "')";

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(SQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void ZmienDanePracownika(
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
    ) {

        Pracownicy.set(Pracownicy.indexOf(znajdzPracownika(pesel)), new Pracownik(
                pesel,
                imie,
                nazwisko,
                adres,
                miasto,
                kodpocztowy,
                kraj,
                nazwaStanowiska,
                liczbaGodzin,
                stawkaGodzinowa));

        zmienDanePracownikaSQL_Query.IDStanowiska = GetIDStanowiska(pesel);
        String SQL = zmienDanePracownikaSQL_Query.PobierzZapytanieSQL(
                KtoraKolumna,
                pesel,
                imie,
                nazwisko,
                adres,
                miasto,
                kodpocztowy,
                kraj,
                nazwaStanowiska,
                liczbaGodzin,
                stawkaGodzinowa);

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(SQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void UsunPracownika(String pesel) {
        deleteEarnings(GetIDStanowiska(pesel));
        deleteWorkPlace(pesel);
        deleteTime(pesel);
        deleteEmployer(pesel);
        Pracownicy.remove(znajdzPracownika(pesel));
    }

    public void PobierzPracownikowZBazyDanych() {
        try {
            String SQL = "Select distinct p.Pesel, p.Imie, p.Nazwisko, p.Adres, p.Miasto, p.[Kod Pocztowy], p.Kraj,  s.Nazwa, e.Liczba_Godzin, st.Kwota from Pracownicy p\n"
                    + "LEFT JOIN Stanowiska s\n"
                    + "ON p.Pesel = s.Pesel\n"
                    + "LEFT JOIN Etat e\n"
                    + "ON p.Pesel = e.Pesel\n"
                    + "LEFT JOIN Stawka st\n"
                    + "ON st.IDEtatu = e.IDEtatu";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            Pracownicy = new ArrayList<>();
            while (rs.next()) {
                Pracownicy.add(new Pracownik(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getFloat(10)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteWorkPlace(String pesel) {
        String SQL = "DELETE FROM Stanowiska WHERE Pesel='" + pesel + "'";

        try {
            stmt = conn.createStatement();
            stmt.execute(SQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteTime(String pesel) {
        String SQL = "DELETE FROM Etat WHERE Pesel='" + pesel + "'";

        try {
            stmt = conn.createStatement();
            stmt.execute(SQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteEarnings(int idStanowiska) {
        String SQL = "DELETE FROM Stawka WHERE IDStanowiska='" + idStanowiska + "'";

        try {
            stmt = conn.createStatement();
            stmt.execute(SQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private int GetIDStanowiska(String pesel) {
        int idStanowiska = 0;
        String SQL = "Select IDStanowiska FROM Stanowiska s\n"
                + "WHERE s.Pesel = '" + pesel + "'";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                idStanowiska = rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return idStanowiska;
    }

    private void deleteEmployer(String pesel) {
        String SQL = "DELETE FROM Pracownicy WHERE Pesel='" + pesel + "'";

        try {
            stmt = conn.createStatement();
            stmt.execute(SQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

// </editor-fold>
    // ************************************
    //FUNKCJE ODPOWIEDZIALNE ZA URLOPY
    // <editor-fold defaultstate="collapsed" desc="Funkcje Urlopy">
    public void PobierzUrlopyZBazyDanych() {
        try {
            String SQL = "Select distinct p.Pesel, p.Imie, p.Nazwisko, u.DataRozpoczecia, u.DataZakonczenia from Pracownicy p\n"
                    + "RIGHT JOIN Urlopy u\n"
                    + "ON p.Pesel = u.Pesel";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL);

            Urlopy = new ArrayList<>();
            while (rs.next()) {
                Urlopy.add(new Urlop(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getDate(5)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DodajUrlop(
            String pesel,
            Date dataRozpoczecia,
            Date dataZakonczenia) {

        String SQL = "INSERT INTO Urlopy VALUES('" + pesel + "','" + dataRozpoczecia + "','" + dataZakonczenia + "')";

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        Pracownik temp = znajdzPracownika(pesel);
        Urlopy.add(new Urlop(pesel, temp.PobierzImie(), temp.PobierzNazwisko(), dataRozpoczecia, dataZakonczenia));
        //znajdzUrlop(pesel).ZmienDaty(dataRozpoczecia, dataZakonczenia);
    }

    public void usunUrlop(String pesel) {
        String SQL = "DELETE FROM Urlopy WHERE Pesel='" + pesel + "'";

        try {
            stmt = conn.createStatement();
            stmt.execute(SQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        Urlopy.remove(znajdzUrlop(pesel));
    }

    public void sortujUrlopyPoPeselu() {
        for (int i = 0; i < Urlopy.size(); i++) {
            for (int j = 1; j < Urlopy.size() - i; j++) {
                if (Long.parseLong(Urlopy.get(j - 1).PobierzPesel()) > Long.parseLong(Urlopy.get(j).PobierzPesel())) {
                    Urlop temp = Urlopy.get(j);
                    Urlopy.set(j, Urlopy.get(j - 1));
                    Urlopy.set(j - 1, temp);
                }
            }
        }
    }

    public void sortujUrlopyPoNazwisku() {
        for (int i = 0; i < Urlopy.size(); i++) {
            for (int j = 1; j < Urlopy.size() - i; j++) {
                if (Urlopy.get(j - 1).PobierzNazwisko().charAt(0) > Urlopy.get(j).PobierzNazwisko().charAt(0)) {
                    Urlop temp = Urlopy.get(j);
                    Urlopy.set(j, Urlopy.get(j - 1));
                    Urlopy.set(j - 1, temp);
                }
            }
        }
    }
// </editor-fold>
    // ************************************

    public Pracownik znajdzPracownika(String pesel) {
        for (int i = 0; i < Pracownicy.size(); i++) {
            if (pesel.equals(Pracownicy.get(i).PobierzPesel())) {
                return Pracownicy.get(i);
            }
        }

        return null;
    }

    public Urlop znajdzUrlop(String pesel) {
        for (int i = 0; i < Urlopy.size(); i++) {
            if (pesel.equals(Urlopy.get(i).PobierzPesel())) {
                return Urlopy.get(i);
            }
        }

        return null;
    }

}

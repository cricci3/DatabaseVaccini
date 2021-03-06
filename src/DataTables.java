import java.sql.*;
import java.util.*;

public class DataTables {
    //permette di accedere al meccanismo dei cursori
    //permette di navigare tra le tuple come se fosse un DBMS
    private ArrayList<CentroVaccinale> centriVaccinaliTable;
    private ArrayList<CittadinoRegistrato> cittadiniRegistratiTable;
    private ArrayList<CittadinoVaccinato> cittadiniVaccinatiTable; //da implementare
    private ArrayList<EventiAvversi> eventiAvversiTable; //da implementare

    public DataTables() {
        this.centriVaccinaliTable = new ArrayList<CentroVaccinale>();
        this.cittadiniRegistratiTable = new ArrayList<CittadinoRegistrato>();
        this.cittadiniVaccinatiTable = new ArrayList<CittadinoVaccinato>();
        this.eventiAvversiTable = new ArrayList<EventiAvversi>();
    }

    public ArrayList<CentroVaccinale> handleCentriVaccinaliSet(ResultSet rs) throws SQLException {
        rs.first(); //così handle iniziano da prima riga
        while(rs.next()) {
            CentroVaccinale cv = new CentroVaccinale(rs.getString("nome"),
                    rs.getString("indirizzo"),
                    rs.getString("comune"),
                    rs.getString("provincia"),
                    rs.getInt("cap"),
                    rs.getString("tipologia"));
            centriVaccinaliTable.add(cv);
        }
        return centriVaccinaliTable;
    }

    public ArrayList<CentroVaccinale> getCentriVaccinaliTable(){
        return this.centriVaccinaliTable;
    }

    public void handleCittadiniRegistratiSet(ResultSet rs) throws SQLException {
        rs.first(); //così handle iniziano da prima riga
        while(rs.next()) {
            CittadinoRegistrato cittr = new CittadinoRegistrato(
                    rs.getString("nomeCV"),
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getString("cf"),
                    rs.getString("data"),
                    rs.getString("nomeVacc"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("password")
            );
            cittadiniRegistratiTable.add(cittr);
        }
    }

    public ArrayList<CittadinoRegistrato> getCittadiniRegistratiTable(){
       return this.cittadiniRegistratiTable;
    }


    public void handleCittadiniVaccinatiSet(ResultSet rs) throws SQLException {
        rs.first(); //così handle iniziano da prima riga
        while(rs.next()) {
            CittadinoVaccinato cittv = new CittadinoVaccinato(
                    rs.getString("nomeCV"),
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getString("cf"),
                    rs.getString("data"),
                    rs.getString("nomeV"));
            cittadiniVaccinatiTable.add(cittv);
        }
    }

    public ArrayList<CittadinoVaccinato> getCittadiniVaccinatiTable(){
        return this.cittadiniVaccinatiTable;
    }


    public String handleEventiAvversiSet(ResultSet rs) throws SQLException{
        String risultato = null;
        while (rs.next()){
            risultato.concat(rs.getString("febbre"));
            risultato.concat(String.valueOf(rs.getInt("media")));
        }
        return risultato;
    }

    /*
    public void handleEventiAvversiSet(ResultSet rs) throws SQLException {
        //rs.first(); //così handle iniziano da prima riga
        while(rs.next()) {
            EventiAvversi eventi = new EventiAvversi((rs.getString("cittadino"),
                    rs.getString("testa"),
                    rs.getString("noteTesta"),
                    rs.getString("febbre"),
                    rs.getString("noteFebbre"),
                    rs.getString("dolori"),
                    rs.getString("noteDolori"),
                    rs.getString("linfoadenopatia"),
                    rs.getString("noteLinfo"),
                    rs.getString("tachicardia"),
                    rs.getString("noteTach"),
                    rs.getString("crisiI"),
                    rs.getString("noteCrisiI"));
            cittadiniVaccinatiTable.add(eventi);
        }
    }

    public ArrayList<EventiAvversi> getEventiAvversiTables(){
        return this.eventiAvversiTable;
    }
     */
}

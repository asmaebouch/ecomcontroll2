package com.example.patientmvc.BD;

import com.example.patientmvc.entities.Act;
import com.example.patientmvc.entities.Patient;
import com.example.patientmvc.entities.Sexe;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBC_Test {

    public static void main(String[] args) {
        Connection connection1 = Singleton.getSession();
        //  PreparedStatement besoin = null;
        //ResultSet resultSet = null;
        var credits = new ArrayList<Patient>();
        try {

            var ps = connection1.prepareStatement( " select * FROM patient p,act a where p.idAct=a.id"
            );
           // ps.setDouble(1,3000.0);
            var rs = ps.executeQuery();
            //  "select * from credits"

            while(rs.next()){
                var id = rs.getLong("id");
                var nomdemandeur = rs.getString("nom");
                var prenomdemandeur= rs.getString("prenom");
                var sexe= rs.getString("sexe");
                var tel= rs.getString("tel");
                var mail= rs.getString("mail");
                var cin =rs.getString("cin");
                var type= rs.getString("type");
                var prix = rs.getDouble("prix");
                var description = rs.getString("descirption");
                var client= new Act();
                client.SetComplet(id,type,prix,description);
                credits.add(new Patient(id,nomdemandeur,prenomdemandeur,mail,tel, sexe,client,cin));

            }
            if(credits.isEmpty()) throw new SQLException("Aucun crédit trouvé");
            else credits.forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Singleton.closeSession();
    }
}


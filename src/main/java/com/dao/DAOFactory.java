package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {

		public static final String CHEMIN = "src/main/resources/application.properties";
				
		
		public static Connection getConnection() throws Exception {
			String[] properties = chargerProprietes();
			Connection connect = null;
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				connect = DriverManager.getConnection(properties[0]+"?user="+properties[1]+"&password="+properties[2]);
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			return connect;
		}

		
		public static String[] chargerProprietes() throws Exception {
			Properties properties = new Properties();
			String url;
			String nomUtilisateur;
			String motDePasse;

		    FileInputStream fichierProperties = new FileInputStream(CHEMIN); 


			try {
				properties.load(fichierProperties);
				url = properties.getProperty("URL");
				nomUtilisateur = properties.getProperty("UTILISATEUR");
				motDePasse = properties.getProperty("MOT_DE_PASSE");
			} catch (FileNotFoundException e) {
				throw new Exception("Fichier introuvale" + e);
			} catch (IOException e) {
				throw new Exception("Impossible de charger le fichier properties " + CHEMIN, e);
			}
			
			return new String[] { url, nomUtilisateur, motDePasse};
		}
		
		
	
}

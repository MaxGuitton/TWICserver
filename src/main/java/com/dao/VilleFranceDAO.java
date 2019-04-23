package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.VilleFrance;

public class VilleFranceDAO {	
	
	public ArrayList<VilleFrance> trouver(VilleFrance ville) throws Exception, SQLException {
		
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		ArrayList<VilleFrance> villes = new ArrayList<>();
		
		String codeINSEE = ville.getCodeINSEE();
		String nom = ville.getNom();
		String codePostal = ville.getCodePostal();
		String libelleAcheminement = ville.getLibelleAcheminement();
		String ligne_5 = ville.getLigne_5();
		String latitude = ville.getLatitude();
		String longitude = ville.getLongitude();
		
		String query = "SELECT * FROM ville_france WHERE "+
				(codeINSEE == null ? "Code_commune_INSEE IS NOT NULL ":"Code_commune_INSEE = ? ")+
				(nom == null ? "AND Nom_commune IS NOT NULL ":"AND Nom_commune = ? ")+
				(codePostal == null ? "AND Code_postal IS NOT NULL ":"AND Code_postal = ? ")+
				(libelleAcheminement == null ? "AND Libelle_acheminement IS NOT NULL ":"AND Libelle_acheminement = ? ")+
				(ligne_5 == null ? "AND Ligne_5 IS NOT NULL ":"AND Ligne_5 = ? ")+
				(latitude == null ? "AND Latitude IS NOT NULL ":"AND Latitude = ? ")+
				(longitude == null ? "AND Longitude IS NOT NULL":"AND Longitude = ? ")
				+";";
		
		connect = DAOFactory.getConnection();
		preparedStatement = connect.prepareStatement(query);
		
		int index = 0;
		if(codeINSEE != null) {
			index++;
			preparedStatement.setString(index, codeINSEE);
		}
		if(nom != null) {
			index++;
			preparedStatement.setString(index, nom);
		}
		if(codePostal != null) {
			index++;
			preparedStatement.setString(index, codePostal);
		}
		if(libelleAcheminement != null) {
			index++;
			preparedStatement.setString(index, libelleAcheminement);
		}
		if(ligne_5 != null) {
			index++;
			preparedStatement.setString(index, ligne_5);
		}
		if(latitude != null) {
			index++;
			preparedStatement.setString(index, latitude);
		}
		if(longitude != null) {
			index++;
			preparedStatement.setString(index, longitude);
		}
		resultSet = preparedStatement.executeQuery();
		

		
		while(resultSet.next()) {
			VilleFrance villeAjoute = new VilleFrance();
			villeAjoute.setCodeINSEE(resultSet.getString("Code_commune_INSEE"));
			villeAjoute.setNom(resultSet.getString("Nom_commune"));
			villeAjoute.setCodePostal(resultSet.getString("Code_postal"));
			villeAjoute.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
			villeAjoute.setLigne_5(resultSet.getString("Ligne_5"));
			villeAjoute.setLatitude(resultSet.getString("Latitude"));
			villeAjoute.setLongitude(resultSet.getString("Longitude"));
			
			villes.add(villeAjoute);
		}
		
		resultSet.close();
		preparedStatement.close();
		connect.close();
		
		return villes;
	}
	
	
	public void supprimer(VilleFrance ville) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		
		String codeINSEE = ville.getCodeINSEE();
		String nom = ville.getNom();
		String codePostal = ville.getCodePostal();
		String libelleAcheminement = ville.getLibelleAcheminement();
		String ligne_5 = ville.getLigne_5();
		String latitude = ville.getLatitude();
		String longitude = ville.getLongitude();
		
		String query = "DELETE FROM ville_france WHERE "+
				(codeINSEE == null ? "Code_commune_INSEE IS NOT NULL ":"Code_commune_INSEE = ? ")+
				(nom == null ? "AND Nom_commune IS NOT NULL ":"AND Nom_commune = ? ")+
				(codePostal == null ? "AND Code_postal IS NOT NULL ":"AND Code_postal = ? ")+
				(libelleAcheminement == null ? "AND Libelle_acheminement IS NOT NULL ":"AND Libelle_acheminement = ? ")+
				(ligne_5 == null ? "AND Ligne_5 IS NOT NULL ":"AND Ligne_5 = ? ")+
				(latitude == null ? "AND Latitude IS NOT NULL ":"AND Latitude = ? ")+
				(longitude == null ? "AND Longitude IS NOT NULL":"AND Longitude = ? ")
				+";";
		
		connect = DAOFactory.getConnection();
		preparedStatement = connect.prepareStatement(query);
		
		int index = 0;
		if(codeINSEE != null) {
			index++;
			preparedStatement.setString(index, codeINSEE);
		}
		if(nom != null) {
			index++;
			preparedStatement.setString(index, nom);
		}
		if(codePostal != null) {
			index++;
			preparedStatement.setString(index, codePostal);
		}
		if(libelleAcheminement != null) {
			index++;
			preparedStatement.setString(index, libelleAcheminement);
		}
		if(ligne_5 != null) {
			index++;
			preparedStatement.setString(index, ligne_5);
		}
		if(latitude != null) {
			index++;
			preparedStatement.setString(index, latitude);
		}
		if(longitude != null) {
			index++;
			preparedStatement.setString(index, longitude);
		}
		System.out.println(preparedStatement);
		preparedStatement.executeUpdate();
	}
	
	public void creer(VilleFrance ville) throws Exception {
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		
		String query = "INSERT INTO ville_france (Code_commune_INSEE,Nom_commune,Code_Postal,Libelle_acheminement,Ligne_5,Latitude,Longitude) "
				+ "VALUES ('"+ville.getCodeINSEE()+"','"+
				ville.getNom()+"','"+
				ville.getCodePostal()+"','"+
				ville.getLibelleAcheminement()+"','"+
				ville.getLigne_5()+"','"+
				ville.getLatitude()+"','"+
				ville.getLongitude()+"');";
		
		connect = DAOFactory.getConnection();
		preparedStatement = connect.prepareStatement(query);
		System.out.println(preparedStatement);
		
		preparedStatement.executeUpdate();
	}
	
	public void modifier(VilleFrance ville) throws Exception{
		Connection connect = null;
		PreparedStatement preparedStatement = null;
		
		String query = "UPDATE ville_france SET Nom_commune = ?, Code_Postal = ?,"
				+ "Libelle_acheminement = ?, Ligne_5 = ?, Latitude = ?, Longitude = ? WHERE Code_commune_INSEE = ?";
		
		connect = DAOFactory.getConnection();
		preparedStatement = connect.prepareStatement(query);
		
		preparedStatement.setString(1, ville.getNom());
		preparedStatement.setString(2, ville.getCodePostal());
		preparedStatement.setString(3, ville.getLibelleAcheminement());
		preparedStatement.setString(4, ville.getLigne_5());
		preparedStatement.setString(5,  ville.getLatitude());
		preparedStatement.setString(6, ville.getLongitude());
		preparedStatement.setString(7, ville.getCodeINSEE());
		
		preparedStatement.executeUpdate();
	}
	
}

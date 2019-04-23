package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.VilleFrance;
import com.dao.VilleFranceDAO;

@RestController
public class TestController {

	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<VilleFrance> get(@RequestParam(required = false,value="Code_commune_INSEE")String codeINSEE,
									@RequestParam(required = false,value="Nom_commune")String nom,
									@RequestParam(required = false,value="Code_postal")String codePostal,
									@RequestParam(required = false,value="Libelle_acheminement")String libelleAcheminement,
									@RequestParam(required = false,value="Ligne_5")String ligne_5,
									@RequestParam(required = false,value="Latitude")String latitude,
									@RequestParam(required = false,value="Longitude")String longitude) throws SQLException, Exception
	{
		System.out.println("Appel GET");
		
		VilleFranceDAO villeFranceDAO = new VilleFranceDAO();
		
		VilleFrance ville = new VilleFrance(codeINSEE,nom,codePostal,libelleAcheminement,ligne_5,latitude,longitude);
		ArrayList<VilleFrance> villes = new ArrayList<VilleFrance>();
				
		villes = villeFranceDAO.trouver(ville);
		
		return villes;
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(@RequestParam(required = false,value="Code_commune_INSEE")String codeINSEE,
					@RequestParam(required = false,value="Nom_commune")String nom,
					@RequestParam(required = false,value="Code_postal")String codePostal,
					@RequestParam(required = false,value="Libelle_acheminement")String libelleAcheminement,
					@RequestParam(required = false,value="Ligne_5")String ligne_5,
					@RequestParam(required = false,value="Latitude")String latitude,
					@RequestParam(required = false,value="Longitude")String longitude) throws SQLException, Exception
	{
		System.out.println("Appel DELETE");
		
		VilleFranceDAO villeFranceDAO = new VilleFranceDAO();
		
		VilleFrance ville = new VilleFrance(codeINSEE,nom,codePostal,libelleAcheminement,ligne_5,latitude,longitude);
						
		villeFranceDAO.supprimer(ville);
		
		System.out.println("La ville "+ ville.toString() +" a bien été supprimée");
		
	}
	
	@RequestMapping(value="/post",method=RequestMethod.POST)
	@ResponseBody
	public void post(@RequestParam(required = false,value="Code_commune_INSEE")String codeINSEE,
					@RequestParam(required = false,value="Nom_commune")String nom,
					@RequestParam(required = false,value="Code_postal")String codePostal,
					@RequestParam(required = false,value="Libelle_acheminement")String libelleAcheminement,
					@RequestParam(required = false,value="Ligne_5")String ligne_5,
					@RequestParam(required = false,value="Latitude")String latitude,
					@RequestParam(required = false,value="Longitude")String longitude) throws SQLException, Exception
	{
		System.out.println("Appel POST");
		
		VilleFranceDAO villeFranceDAO = new VilleFranceDAO();
		
		VilleFrance ville = new VilleFrance(codeINSEE,nom,codePostal,libelleAcheminement,ligne_5,latitude,longitude);
						
		villeFranceDAO.creer(ville);
		
		System.out.println("La ville "+ ville.toString() +" a bien été créée");
		
	}
	
	@RequestMapping(value="/put",method=RequestMethod.PUT)
	@ResponseBody
	public void put(@RequestParam(required = false,value="Code_commune_INSEE")String codeINSEE,
					@RequestParam(required = false,value="Nom_commune")String nom,
					@RequestParam(required = false,value="Code_postal")String codePostal,
					@RequestParam(required = false,value="Libelle_acheminement")String libelleAcheminement,
					@RequestParam(required = false,value="Ligne_5")String ligne_5,
					@RequestParam(required = false,value="Latitude")String latitude,
					@RequestParam(required = false,value="Longitude")String longitude) throws SQLException, Exception
	{
		System.out.println("Appel PUT");
		
		VilleFranceDAO villeFranceDAO = new VilleFranceDAO();
		
		VilleFrance ville = new VilleFrance(codeINSEE,nom,codePostal,libelleAcheminement,ligne_5,latitude,longitude);
						
		villeFranceDAO.modifier(ville);
		
		System.out.println("La ville "+ ville.toString() +" a bien été modifiée");
		
	}
	
	

}

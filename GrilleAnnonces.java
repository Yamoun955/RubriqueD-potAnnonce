package com.test.servlets;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GrilleAnnonces {
	public List<Annonce> recupererAnnonces(){
		
		List<Annonce> annonces=new ArrayList<Annonce>();
		
		//chargement du driver
		
		try {
			Class.forName("org.postgresql.Driver");
			} catch(ClassNotFoundException e) {}
		//CONNEXION A LA BASE
		
		Connection connexion=null;
		Statement statement=null;
		ResultSet result=null;
		
		try
		{
			connexion = DriverManager.getConnection("jdbc:postgresql:MasterAnnonce","postgres","yani");
			statement = connexion.createStatement();
			result=statement.executeQuery("SELECT * FROM annonce;");
			
			while(result.next()) {
				String title =result.getString("title");
				String description= result.getString("description");
				String adress= result.getString("adress");
				String mail= result.getString("mail");
				Date date=result.getDate("date");
				
				Annonce annonce=new Annonce();
				annonce.setTitle(title);
				annonce.setDescription(description);
				annonce.setAdress(adress);
				annonce.setMail(mail);
				annonce.setDate(date);
				annonces.add(annonce);
			}
		}catch(SQLException e) {}
		finally {
			try {
				if(result!=null) result.close();
				if(statement!=null) statement.close();
				if(connexion!=null) connexion.close();
				}catch(SQLException e) {}
		}	
			
		return annonces;	
		}
		public void ajouterAnnonce(Annonce annonce) {
			
			try {
				Class.forName("org.postgresql.Driver");
				} catch(ClassNotFoundException e) {}
			Connection connexion=null;
			Statement statement=null;
			ResultSet result=null;
			try
			{
				connexion = DriverManager.getConnection("jdbc:postgresql:MasterAnnonce","postgres","yani");
			}catch(SQLException e) {}
			
			try {
				PreparedStatement preparedstatement=connexion.prepareStatement("INSERT INTO annonce(title,description,adress,mail,date)VALUES(?,?,?,?,NOW());");
				preparedstatement.setString(1, annonce.getTitle());
				preparedstatement.setString(2, annonce.getDescription());
				preparedstatement.setString(3, annonce.getAdress());
				preparedstatement.setString(4, annonce.getMail());
				
				preparedstatement.executeUpdate();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	


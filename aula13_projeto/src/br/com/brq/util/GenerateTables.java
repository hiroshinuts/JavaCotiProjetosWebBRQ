package br.com.brq.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GenerateTables {

	public static void main(String[] args) {
		
		try{
			
			Configuration cfg = new AnnotationConfiguration();
			cfg.configure("br/com/brq/config/mysql_hibernate.cfg.xml");
			
			SchemaExport s = new SchemaExport(cfg);
			s.create(true, true);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}

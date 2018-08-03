package com.algaworks.curso.jpa.criteria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Categoria;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

public class TesteCascate {
	
	private static EntityManagerFactory factory;
	private EntityManager manager;
	
	
	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}	
	
	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}
	
	@After
	public void tearDown() {
		this.manager.close();
	}
	
	
	/*
	
	@Test
	public void testeCascata() {
		
		Carro carro = new Carro();
		carro.setCor("Preto");
		carro.setPlaca("ZZZ-9999");
		
		ModeloCarro modelo = new ModeloCarro();
		modelo.setCategoria(Categoria.ESPORTIVO);
		modelo.setDescricao("Audi");
		carro.setModelo(modelo);
		
		this.manager.getTransaction().begin();
		this.manager.merge(carro);
		this.manager.getTransaction().commit();
		
	}
	
	*/
	

}

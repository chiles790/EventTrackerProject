package com.skilldistillery.fitness.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExerciseTest {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static Exercise ex;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("FitnessPu");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		ex = em.find(Exercise.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		ex = null;
	}

	@Test
	void test() {
		assertNotNull(ex);
		assertEquals("Running", ex.getName());
	}

}

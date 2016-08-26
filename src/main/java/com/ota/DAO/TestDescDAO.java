package com.ota.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.ota.model.Candidate;
import com.ota.model.TestExam;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TestDescDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<TestExam> getTestDesc() {

		// Create an Entity Manager
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search
				.getFullTextEntityManager(entityManager);

		// Create Query Builder
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
				.forEntity(TestExam.class).get();

		// Create a select * query
		org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

		// Execute the query
		org.hibernate.search.jpa.FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query,
				TestExam.class);
		// return the result
		return jpaQuery.getResultList();
	}

	public Candidate getCandidate(String username, String pwd) {
		// Create an Entity Manager
		FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search
				.getFullTextEntityManager(entityManager);

		// Create Query Builder
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
				.forEntity(Candidate.class).get();

		// Create a select * query
		org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

		// Execute the query
		org.hibernate.search.jpa.FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query,
				Candidate.class);
		// return the result
		List<Candidate> candidateList = jpaQuery.getResultList();
		if (candidateList == null || candidateList.size() == 0)
			return null;
		else

			return candidateList.get(0);
	}
}

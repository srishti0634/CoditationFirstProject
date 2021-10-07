package io.coditation.systems;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Authors,Integer> {
	
	@Query("select a from Authors a where a.authorName = ?1")
	List<Authors> findByAuthorName(String authorName);
	
}

package io.coditation.systems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Authors,Integer> {
//	@Query("SELECT a FROM Authors a WHERE a.authorName = ?1")
//	public Authors findAuthorByName(String authors);
}

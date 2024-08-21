package br.com.caelestis.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.caelestis.api.domain.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {

}

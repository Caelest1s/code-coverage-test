package br.com.caelestis.api.services;

import java.util.List;

import br.com.caelestis.api.domain.Usuario;

public interface UserService {

    Usuario findById(Integer id);

    List<Usuario> findAll();
}

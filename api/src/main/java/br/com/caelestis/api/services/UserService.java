package br.com.caelestis.api.services;

import br.com.caelestis.api.domain.Usuario;

public interface UserService {

    Usuario findById(Integer id);
}

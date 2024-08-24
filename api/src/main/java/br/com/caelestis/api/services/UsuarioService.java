package br.com.caelestis.api.services;

import java.util.List;

import br.com.caelestis.api.domain.Usuario;
import br.com.caelestis.api.domain.dto.UsuarioDTO;

public interface UsuarioService {

    Usuario findById(Integer id);

    List<Usuario> findAll();

    Usuario create(UsuarioDTO obj);

    Usuario update(UsuarioDTO obj);

    void delete(Integer id);
}

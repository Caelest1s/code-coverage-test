package br.com.caelestis.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.caelestis.api.domain.Usuario;
import br.com.caelestis.api.domain.dto.UsuarioDTO;
import br.com.caelestis.api.repositories.UsuarioRepository;
import br.com.caelestis.api.services.UserService;
import br.com.caelestis.api.services.exceptions.DataIntegratyViolationException;
import br.com.caelestis.api.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Usuario findById(Integer id) {
        Optional<Usuario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> result = repository.findAll();
        return result;
    }

    @Override
    public Usuario create(UsuarioDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, Usuario.class));
    }

    private void findByEmail(UsuarioDTO obj) {
        Optional<Usuario> usuario = repository.findByEmail(obj.getEmail());
        if (usuario.isPresent() && !usuario.get().getId().equals(obj.getId())) {
            throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
        }
    }

    @Override
    public Usuario update(UsuarioDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, Usuario.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }

}

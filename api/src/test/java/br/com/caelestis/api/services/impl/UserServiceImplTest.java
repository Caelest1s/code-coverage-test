package br.com.caelestis.api.services.impl;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.caelestis.api.domain.Usuario;
import br.com.caelestis.api.domain.dto.UsuarioDTO;
import br.com.caelestis.api.repositories.UsuarioRepository;

@SpringBootTest
public class UserServiceImplTest {

    private static final Integer ID = 1;
    private static final String NAME = "Jefferson";
    private static final String EMAIL = "jef@gmail.com";
    private static final String PASSWORD = "123456";

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UsuarioRepository repository;

    @Mock
    private ModelMapper mapper;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;
    private Optional<Usuario> optionalUsuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsuario();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(optionalUsuario);
        Usuario response = service.findById(ID);

        assertNotNull(response);
        assertEquals(Usuario.class, response.getClass());
        assertEquals(ID, response.getId());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUsuario() {
        usuario = new Usuario(ID, NAME, EMAIL, PASSWORD);
        usuarioDTO = new UsuarioDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUsuario = Optional.of(new Usuario(ID, NAME, EMAIL, PASSWORD));
    }
}

package br.com.caelestis.api.resources;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.caelestis.api.domain.Usuario;
import br.com.caelestis.api.domain.dto.UsuarioDTO;
import br.com.caelestis.api.services.impl.UsuarioServiceImpl;

@SpringBootTest
public class UsuarioResourceTest {

    private static final Integer ID = 1;
    private static final String NAME = "testname";
    private static final String EMAIL = "teste@teste.com";
    private static final String PASSWORD = "123";

    @InjectMocks
    private UsuarioResource resource;

    @Mock
    private UsuarioServiceImpl service;

    @Mock
    private ModelMapper mapper;

    private Usuario usuario;
    private UsuarioDTO dto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsuario();
    }

    private void startUsuario() {
        usuario = new Usuario(ID, NAME, EMAIL, PASSWORD);
        dto = new UsuarioDTO(ID, NAME, EMAIL, PASSWORD);
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void create() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}

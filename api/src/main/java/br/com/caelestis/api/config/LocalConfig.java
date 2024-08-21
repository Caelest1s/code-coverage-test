package br.com.caelestis.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.caelestis.api.domain.Usuario;
import br.com.caelestis.api.repositories.UsuarioRepository;
import jakarta.annotation.PostConstruct;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UsuarioRepository repository;

    @PostConstruct
    public void startDB() {
        Usuario usuario = new Usuario(null, "Jefferson", "jef@gmail.com", "123456");
        Usuario usuario2 = new Usuario(null, "Ana", "ana@gmail.com", "123");
        repository.saveAll(List.of(usuario, usuario2));
    }
}

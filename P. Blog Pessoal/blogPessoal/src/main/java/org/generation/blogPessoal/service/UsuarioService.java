package org.generation.blogPessoal.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.model.UsuarioLogin;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

//A Classe UsuarioService é responsável por manipular as regras de negócio do usuário no sistema. 
//Esta Classe deve ser anotada com a anotação @Service,para que o Spring identifique que é uma Classe que serviço.

@Service
public class UsuarioService {

// CADASTRAR O USUARIO PELA 'senha' E PELO 'usuario' OU NÃO CADASTRAR
	@Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> cadastrarUsuario(Usuario usuario) {

        if (usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
            return Optional.empty();

        usuario.setSenha(criptografarSenha(usuario.getSenha()));

        return Optional.of(usuarioRepository.save(usuario));
    
    }
    
// ATUALIZAR USUARIO PELO 'id' E PELO 'usuario' OU NÃO ATUALIZAR
    
    public Optional<Usuario> atualizarUsuario(Usuario usuario) {
        
        if(usuarioRepository.findById(usuario.getId()).isPresent()) {

            Optional<Usuario> buscaUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());

            if ( (buscaUsuario.isPresent()) && ( buscaUsuario.get().getId() != usuario.getId()))
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

            usuario.setSenha(criptografarSenha(usuario.getSenha()));

            return Optional.ofNullable(usuarioRepository.save(usuario));
            
        }

        return Optional.empty();
    
    }   
    
// AUTENTICAR USUARIO 
    
    public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin) {

        Optional<Usuario> usuario = usuarioRepository.findByUsuario(usuarioLogin.get().getUsuario());

        if (usuario.isPresent()) {

            if (compararSenhas(usuarioLogin.get().getSenha(), usuario.get().getSenha())) {

                usuarioLogin.get().setId(usuario.get().getId());
                usuarioLogin.get().setNome(usuario.get().getNome());
                usuarioLogin.get().setFoto(usuario.get().getFoto());
                usuarioLogin.get().setToken(gerarBasicToken(usuarioLogin.get().getUsuario(),        usuarioLogin.get().getSenha()));
                usuarioLogin.get().setSenha(usuario.get().getSenha());

                return usuarioLogin;

            }
        }   

        return Optional.empty();
        
    }
    
// CRIPTOGRAFAR SENHA
    
    private String criptografarSenha(String senha) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        return encoder.encode(senha);

    }
    
 // COMPARAR SENHAS  
    
    private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        return encoder.matches(senhaDigitada, senhaBanco);

    }
    
// CRIAR TOKEN
    
    private String gerarBasicToken(String usuario, String senha) {

        String token = usuario + ":" + senha;
        byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
        return "Basic " + new String(tokenBase64);

    }
    
    
//Observe que foram criados os métodos cadastrarUsuario() e atualizarUsuario() , que criptografam a senha e impedem a duplicação do usuário no Banco de dados.
//O Método autenticarUsuario() , além de autenticar o usuário no sistema, ele compara a senha digitada pelo usuário com uma senha persistente no Banco de dados e gera o Token do usuário.
// Foram criados ainda 3 métodos auxiliares: criptografarSenha(), comparandoSenhas() e gerarBasicToken() , para realizar funções específicas na classe de serviço.
}

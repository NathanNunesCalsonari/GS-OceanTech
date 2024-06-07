package br.com.fiap.oceantech.service;

import br.com.fiap.oceantech.dto.UsuarioDTO;
import br.com.fiap.oceantech.entity.Usuario;
import br.com.fiap.oceantech.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UsuarioDTO> listarTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> encontrarUsuarioPorId(Long usuarioId) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        return usuario.map(value -> modelMapper.map(value, UsuarioDTO.class));
    }

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario.setDataCriacao(new Date()); // Definindo a data de criação como a data atual
        usuario = usuarioRepository.save(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public void deletarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}

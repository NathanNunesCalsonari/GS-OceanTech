package br.com.fiap.oceantech.controller;

import br.com.fiap.oceantech.dto.UsuarioDTO;
import br.com.fiap.oceantech.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarTodosUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obterUsuarioPorId(@PathVariable(value = "id") Long usuarioId) {
        Optional<UsuarioDTO> usuario = usuarioService.encontrarUsuarioPorId(usuarioId);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO novoUsuario = usuarioService.salvarUsuario(usuarioDTO);
        return ResponseEntity.ok().body(novoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable(value = "id") Long usuarioId,
                                                       @Valid @RequestBody UsuarioDTO usuarioDTO) {
        Optional<UsuarioDTO> usuario = usuarioService.encontrarUsuarioPorId(usuarioId);
        if (usuario.isPresent()) {
            usuarioDTO.setId(usuarioId);
            UsuarioDTO usuarioAtualizado = usuarioService.salvarUsuario(usuarioDTO);
            return ResponseEntity.ok(usuarioAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable(value = "id") Long usuarioId) {
        usuarioService.deletarUsuario(usuarioId);
        return ResponseEntity.ok().build();
    }
}

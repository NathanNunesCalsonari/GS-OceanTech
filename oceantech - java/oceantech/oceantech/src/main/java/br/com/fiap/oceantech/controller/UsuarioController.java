package br.com.fiap.oceantech.controller;

import br.com.fiap.oceantech.dto.UsuarioDTO;
import br.com.fiap.oceantech.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<UsuarioDTO> usuarios = usuarioService.listarTodosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/listar";
    }

    @GetMapping("/{id}")
    public String obterUsuarioPorId(@PathVariable(value = "id") Long usuarioId, Model model) {
        Optional<UsuarioDTO> usuario = usuarioService.encontrarUsuarioPorId(usuarioId);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuarios/detalhes";
        } else {
            return "error/404"; // Redireciona para uma página de erro 404 se o usuário não for encontrado
        }
    }

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return "usuarios/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@ModelAttribute UsuarioDTO usuarioDTO) {
        usuarioService.salvarUsuario(usuarioDTO);
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable(value = "id") Long usuarioId, Model model) {
        Optional<UsuarioDTO> usuario = usuarioService.encontrarUsuarioPorId(usuarioId);
        if (usuario.isPresent()) {
            model.addAttribute("usuarioDTO", usuario.get());
            return "usuarios/editar";
        } else {
            return "error/404"; // Redireciona para uma página de erro 404 se o usuário não for encontrado
        }
    }

    @PostMapping("/editar/{id}")
    public String atualizarUsuario(@PathVariable(value = "id") Long usuarioId, @ModelAttribute UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(usuarioId);
        usuarioService.salvarUsuario(usuarioDTO);
        return "redirect:/usuarios/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable(value = "id") Long usuarioId) {
        usuarioService.deletarUsuario(usuarioId);
        return "redirect:/usuarios/listar";
    }
}

package br.com.fiap.oceantech.controller;

import br.com.fiap.oceantech.dto.PlataformaDTO;
import br.com.fiap.oceantech.service.PlataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/plataformas")
public class PlataformaController {

    @Autowired
    private PlataformaService plataformaService;

    @GetMapping("/listar")
    public String listarPlataformas(Model model) {
        List<PlataformaDTO> plataformas = plataformaService.listarTodasPlataformas();
        model.addAttribute("plataformas", plataformas);
        return "plataformas/listar";  // Renderiza o template "listar.html"
    }

    @GetMapping("/{id}")
    public String obterPlataformaPorId(@PathVariable(value = "id") Long plataformaId, Model model) {
        Optional<PlataformaDTO> plataforma = plataformaService.encontrarPlataformaPorId(plataformaId);
        if (plataforma.isPresent()) {
            model.addAttribute("plataforma", plataforma.get());
            return "plataformas/detalhes";  // Renderiza o template "detalhes.html"
        } else {
            return "error/404";  // Renderiza uma página de erro 404
        }
    }

    @GetMapping("/cadastrar")
    public String mostrarFormCadastro(Model model) {
        model.addAttribute("plataformaDTO", new PlataformaDTO());
        return "plataformas/cadastrar";  // Renderiza o template "cadastrar.html"
    }

    @PostMapping("/cadastrar")
    public String cadastrarPlataforma(@Valid @ModelAttribute PlataformaDTO plataformaDTO,
                                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "plataformas/cadastrar";  // Retorna ao formulário em caso de erro de validação
        }
        plataformaService.salvarPlataforma(plataformaDTO);
        return "redirect:/plataformas/listar";  // Redireciona para a lista após o cadastro
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormEdicao(@PathVariable("id") Long plataformaId, Model model) {
        Optional<PlataformaDTO> plataforma = plataformaService.encontrarPlataformaPorId(plataformaId);
        if (plataforma.isPresent()) {
            model.addAttribute("plataformaDTO", plataforma.get());
            return "plataformas/editar";  // Renderiza o template "editar.html"
        } else {
            return "error/404";  // Renderiza uma página de erro 404
        }
    }

    @PostMapping("/editar/{id}")
    public String atualizarPlataforma(@PathVariable("id") Long plataformaId,
                                      @Valid @ModelAttribute PlataformaDTO plataformaDTO,
                                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "plataformas/editar";  // Retorna ao formulário em caso de erro de validação
        }
        plataformaDTO.setId(plataformaId);
        plataformaService.salvarPlataforma(plataformaDTO);
        return "redirect:/plataformas/listar";  // Redireciona para a lista após a atualização
    }

    @GetMapping("/deletar/{id}")
    public String deletarPlataforma(@PathVariable("id") Long plataformaId) {
        plataformaService.deletarPlataforma(plataformaId);
        return "redirect:/plataformas/listar";  // Redireciona para a lista após a exclusão
    }
}

package br.com.fiap.oceantech.controller;

import br.com.fiap.oceantech.dto.PlataformaDTO;
import br.com.fiap.oceantech.service.PlataformaService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plataformas")
public class PlataformaController {

    @Autowired
    private PlataformaService plataformaService;

    @GetMapping("/listar")
    public List<PlataformaDTO> listarPlataformas() {
        return plataformaService.listarTodasPlataformas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlataformaDTO> obterPlataformaPorId(@PathVariable(value = "id") Long plataformaId) {
        Optional<PlataformaDTO> plataforma = plataformaService.encontrarPlataformaPorId(plataformaId);
        return plataforma.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PlataformaDTO> cadastrarPlataforma(@Valid @RequestBody PlataformaDTO plataformaDTO) {
        PlataformaDTO novaPlataforma = plataformaService.salvarPlataforma(plataformaDTO);
        return ResponseEntity.ok().body(novaPlataforma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlataformaDTO> atualizarPlataforma(@PathVariable(value = "id") Long plataformaId,
                                                             @Valid @RequestBody PlataformaDTO plataformaDTO) {
        Optional<PlataformaDTO> plataforma = plataformaService.encontrarPlataformaPorId(plataformaId);
        if (plataforma.isPresent()) {
            plataformaDTO.setId(plataformaId);  // Ensure the ID is set before saving
            PlataformaDTO plataformaAtualizada = plataformaService.salvarPlataforma(plataformaDTO);
            return ResponseEntity.ok(plataformaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPlataforma(@PathVariable(value = "id") Long plataformaId) {
        plataformaService.deletarPlataforma(plataformaId);
        return ResponseEntity.ok().build();
    }
}

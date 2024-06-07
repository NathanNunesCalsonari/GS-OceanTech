package br.com.fiap.oceantech.service;

import br.com.fiap.oceantech.dto.PlataformaDTO;
import br.com.fiap.oceantech.entity.Plataforma;
import br.com.fiap.oceantech.repository.PlataformaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlataformaService {

    @Autowired
    private PlataformaRepository plataformaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PlataformaDTO> listarTodasPlataformas() {
        List<Plataforma> plataformas = plataformaRepository.findAll();
        return plataformas.stream()
                .map(plataforma -> modelMapper.map(plataforma, PlataformaDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<PlataformaDTO> encontrarPlataformaPorId(Long plataformaId) {
        Optional<Plataforma> plataforma = plataformaRepository.findById(plataformaId);
        return plataforma.map(value -> modelMapper.map(value, PlataformaDTO.class));
    }

    public PlataformaDTO salvarPlataforma(PlataformaDTO plataformaDTO) {
        Plataforma plataforma = modelMapper.map(plataformaDTO, Plataforma.class);
        plataforma = plataformaRepository.save(plataforma);
        return modelMapper.map(plataforma, PlataformaDTO.class);
    }

    public void deletarPlataforma(Long plataformaId) {
        plataformaRepository.deleteById(plataformaId);
    }
}

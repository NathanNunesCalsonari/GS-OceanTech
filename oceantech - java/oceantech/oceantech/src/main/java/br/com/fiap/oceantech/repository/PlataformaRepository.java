package br.com.fiap.oceantech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.oceantech.entity.Plataforma;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long> {
}

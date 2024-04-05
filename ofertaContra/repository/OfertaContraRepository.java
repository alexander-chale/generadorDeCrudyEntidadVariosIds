package com.bcv.cusg.ofertaContra.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bcv.cusg.ofertaContra.entity.OfertaContra;
import com.bcv.cusg.ofertaContra.entity.OfertaContraId;

@Repository
public interface OfertaContraRepository extends JpaRepository<OfertaContra, OfertaContraId> {


}

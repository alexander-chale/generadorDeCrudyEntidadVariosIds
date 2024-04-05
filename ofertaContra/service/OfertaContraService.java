package com.bcv.cusg.ofertaContra.service;

import com.bcv.cusg.ofertaContra.entity.OfertaContra;
import com.bcv.cusg.ofertaContra.entity.OfertaContraId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface OfertaContraService {

   public Page<OfertaContra> findALL(Pageable pageable) throws Exception;

}

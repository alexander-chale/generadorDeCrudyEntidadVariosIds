package com.bcv.cusg.ofertaContra.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bcv.cusg.ofertaContra.entity.OfertaContra;
import com.bcv.cusg.ofertaContra.entity.OfertaContraId;

import jakarta.transaction.Transactional;

import com.bcv.cusg.ofertaContra.repository.OfertaContraRepository;
import com.bcv.cusg.ofertaContra.service.OfertaContraService;

@Service
public class OfertaContraServiceImpl implements OfertaContraService {

   @Autowired
   private OfertaContraRepository ofertaContraRepository;

   @Override
   public Page<OfertaContra> findALL(Pageable pageable) throws Exception {
      try {
          Page<OfertaContra> entities = ofertaContraRepository.findAll(pageable);
          return entities;
      } catch (Exception e) {
          throw new Exception(e.getMessage());
      }
   }

}

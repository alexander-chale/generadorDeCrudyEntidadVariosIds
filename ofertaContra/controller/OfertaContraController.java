package com.bcv.cusg.ofertaContra.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcv.cusg.ofertaContra.entity.OfertaContra;
import com.bcv.cusg.ofertaContra.entity.OfertaContraId;
import com.bcv.cusg.ofertaContra.entity.OfertaContra;
import com.bcv.cusg.ofertaContra.entity.OfertaContraId;
import com.bcv.cusg.ofertaContra.service.impl.OfertaContraService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/ofertaContra")
public class OfertaContraController {

   @Autowired
   private OfertaContraService ofertaContraService;

   @GetMapping("/paged")
   public ResponseEntity<?> getAll(Pageable pageable) {
      try {
         return ResponseEntity.status(HttpStatus.OK).body(ofertaContraService.findALL(pageable));
      } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("{\"error\":\"Error. Por favor intente más tarde.\"}");
      }
   }


}

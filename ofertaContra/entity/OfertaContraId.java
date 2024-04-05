package com.bcv.cusg.ofertaContra.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString


public class OfertaContraId implements Serializable {

   private static final long serialVersionUID = 1L;

   @Column(name = "co_rif_usua_cont", nullable = false, updatable = false)
   private String coRifUsuaCont;

   @Column(name = "co_oferta_serv", nullable = false, updatable = false)
   private Long coOfertaServ;

}

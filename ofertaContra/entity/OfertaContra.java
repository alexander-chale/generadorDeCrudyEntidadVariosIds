package com.bcv.cusg.ofertaContra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(schema = "cusg", name = "oferta_contra")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class OfertaContra {

   @EmbeddedId
   private OfertaContraId id;

   @Column(nullable = false, length = 11)
   private Long coOfertaServ;

   @Column(nullable = false, length = 14)
   private String coRifUsuaCont;

   @Column(length = 200)
   private String txDetOferta;

   @JsonIgnore
   @ManyToOne(fetch = FetchType.LAZY)
   @MapsId("coRifUsuaCont")
   @JoinColumn(name = "co_rif_usua_cont", nullable = false)
   private Contraparte coRifUsuaCont;

   @JsonIgnore
   @ManyToOne(fetch = FetchType.LAZY)
   @MapsId("coOfertaServ")
   @JoinColumn(name = "co_oferta_serv", nullable = false)
   private OfertaServicio coOfertaServ;

}

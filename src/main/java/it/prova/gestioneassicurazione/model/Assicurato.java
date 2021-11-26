package it.prova.gestioneassicurazione.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import it.prova.gestioneassicurazione.generated.Assicurati;

@Entity
@Table(name = "assicurato")
public class Assicurato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "{nome.notblank}")
	@Column(name = "nome")
	private String nome;

	@NotBlank(message = "{cognome.notblank}")
	@Column(name = "cognome")
	private String cognome;

	@NotNull(message = "{dataNascita.notnull}")
	@Column(name = "data_nascita")
	private Date dataNascita;

	@NotNull(message = "{numeroSinistri.notnull}")
	@Min(0)
	@Column(name = "numero_sinistri")
	private Integer numeroSinistri;

	@NotBlank(message = "{codiceFiscale.notblank}")
	@Column(name = "codice_fiscale")
	private String codiceFiscale;

	public Assicurato() {
		super();
	}

	public Assicurato(@NotBlank(message = "{nome.notblank}") String nome,
			@NotBlank(message = "{cognome.notblank}") String cognome,
			@NotNull(message = "{dataNascita.notnull}") Date dataNascita,
			@NotNull(message = "{numeroSinistri.notnull}") @Min(0) Integer numeroSinistri,
			@NotBlank(message = "{codiceFiscale.notblank}") String codiceFiscale) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.numeroSinistri = numeroSinistri;
		this.codiceFiscale = codiceFiscale;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Integer getNumeroSinistri() {
		return numeroSinistri;
	}

	public void setNumeroSinistri(Integer numeroSinistri) {
		this.numeroSinistri = numeroSinistri;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	public static List<Assicurato> convertToModelList(List<Assicurati.Assicurato> list) {
		List<Assicurato> listCoverted = new ArrayList<Assicurato>();
		
		for (Assicurati.Assicurato assicurato : list) {
			Assicurato temp = new Assicurato(assicurato.getNome(), assicurato.getCognome(), assicurato.getDatadinascita(), 
					assicurato.getNumerosinistri(),
					assicurato.getCodicefiscale());
			listCoverted.add(temp);
		}
		return listCoverted;
	}
	
	public static Assicurati convertToAssicurati(List<Assicurato> list) {
		Assicurati assicurati = new Assicurati();
		for (Assicurato assicurato : list) {
			Assicurati.Assicurato temp = new Assicurati.Assicurato(assicurato.getNome(), assicurato.getCognome(), 
					assicurato.getDataNascita(), assicurato.getCodiceFiscale(), assicurato.getNumeroSinistri());
			assicurati.getAssicurato().add(temp);
		}
		return assicurati;
	}

}
package br.com.rbc.biblioteca.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String titulo;
	private String autor;
	private String editora;
	private String area;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataAquisicao;
	private String precoLivro;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Calendar getDataAquisicao() {
		return dataAquisicao;
	}
	public void setDataAquisicao(Calendar dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}
	public String getPrecoLivro() {
		return precoLivro;
	}
	public void setPrecoLivro(String precoLivro) {
		this.precoLivro = precoLivro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}

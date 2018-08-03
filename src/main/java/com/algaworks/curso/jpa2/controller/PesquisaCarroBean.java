package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelolazy.LazyCarroDataModel;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaCarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	CarroDAO carroDAO;
	
	private LazyCarroDataModel lazyCarros;
	
	private List<Carro> carros = new ArrayList<>();
	
	private Carro carroSelecionado;
	private Carro carroSelecionadoExclusao;
	
	public List<Carro> getCarros() {
		return carros;
	}
	
	public void excluir() {
		try {
			carroDAO.excluir(carroSelecionadoExclusao);
			this.carros.remove(carroSelecionadoExclusao);
			FacesUtil.addSuccessMessage("Carro placa " + carroSelecionadoExclusao.getPlaca() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}
	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}

	@PostConstruct
	public void inicializar() {
		//carros = carroDAO.buscarTodos();
		lazyCarros = new LazyCarroDataModel(carroDAO);
	}
	
	public void buscarCarroComAcessorios() {
		carroSelecionado = carroDAO.buscarCarroComAcessorios(carroSelecionado.getCodigo());
	}
	
	@Transactional
	public void buscarCarroFoto() {
		carroSelecionado = carroDAO.buscarCarroComFoto(carroSelecionado.getCodigo());
	}

	public LazyCarroDataModel getLazyCarros() {
		return lazyCarros;
	}

	public Carro getCarroSelecionadoExclusao() {
		return carroSelecionadoExclusao;
	}

	public void setCarroSelecionadoExclusao(Carro carroSelecionadoExclusao) {
		this.carroSelecionadoExclusao = carroSelecionadoExclusao;
	}
	
	


	
	
	
}

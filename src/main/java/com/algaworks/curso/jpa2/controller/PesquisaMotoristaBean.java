package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.MotoristaDAO;
import com.algaworks.curso.jpa2.modelo.Motorista;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaMotoristaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	MotoristaDAO MotoristaDAO;
	
	private List<Motorista> Motoristas = new ArrayList<>();
	
	private Motorista MotoristaSelecionado;
	
	public List<Motorista> getMotoristas() {
		return Motoristas;
	}
	
	public void excluir() {
		try {
			MotoristaDAO.excluir(MotoristaSelecionado);
			this.Motoristas.remove(MotoristaSelecionado);
			FacesUtil.addSuccessMessage("Funcionário " + MotoristaSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Motorista getMotoristaSelecionado() {
		return MotoristaSelecionado;
	}
	public void setMotoristaSelecionado(Motorista MotoristaSelecionado) {
		this.MotoristaSelecionado = MotoristaSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		Motoristas = MotoristaDAO.buscarTodos();
	}
}


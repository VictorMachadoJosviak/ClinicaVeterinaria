package com.up.clinicaveterinaria.mb;

import java.util.List;

import com.up.clinicaveterinaria.facade.AnimalFacade;
import com.up.clinicaveterinaria.facade.DonoFacade;
import com.up.clinicaveterinaria.model.Animal;
import com.up.clinicaveterinaria.model.Dono;
import com.up.clinicaveterinaria.util.JSFMessageUtil;
import com.up.clinicaveterinaria.util.PropertiesUtil;

public class CadastroAnimaisMB {

	private AnimalFacade animalFacade = new AnimalFacade();
	private List<Animal> animais;
	private List<Dono> donosPossiveis;
	
	private Animal animalEdicao;

	public CadastroAnimaisMB() {
		this.carregarListaAnimais();
		this.carregarListaDonos();
	}

	private void carregarListaAnimais() {
		animais = animalFacade.listAll();
	}
	
	private void carregarListaDonos() {
		donosPossiveis = (new DonoFacade()).listAll();
	}

	public List<Dono> getDonosPossiveis() {
		return donosPossiveis;
	}

	public void setDonosPossiveis(List<Dono> donosPossiveis) {
		this.donosPossiveis = donosPossiveis;
	}

	public AnimalFacade getAnimalFacade() {
		return animalFacade;
	}

	public void setAnimalFacade(AnimalFacade animalFacade) {
		this.animalFacade = animalFacade;
	}

	public Animal getAnimalEdicao() {
		return animalEdicao;
	}

	public void setAnimalEdicao(Animal animalEdicao) {
		this.animalEdicao = animalEdicao;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	
	public void excluirAnimal() {
		try {
			animalFacade.delete(animalEdicao.getId());
			this.carregarListaAnimais();
		}catch(Exception e) {
			JSFMessageUtil.sendErrorMessageToUser
				(PropertiesUtil.getInstance().get("msgFalhaExcluirAnimal"), e);
		}
	}
	
	public void salvarAlteracoesAnimal() {
		try {
			animalFacade.update(animalEdicao);
			this.carregarListaAnimais();
		}catch(Exception e) {
			e.printStackTrace();//logar
		}
	}
}
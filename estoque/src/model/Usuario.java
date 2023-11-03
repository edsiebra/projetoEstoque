package model;

import java.util.Date;

public class Usuario {

	private Long id;
	private String login;
	private String senha;
	private Date dataAtivacao;
	private Date dataDesativacao;
	private Long funcionarioId;
		
	public Usuario() {
	}

	public Usuario(Long id, String login, String senha, Date dataAtivacao, Date dataDesativacao, Long funcionarioId) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.dataAtivacao = dataAtivacao;
		this.dataDesativacao = dataDesativacao;
		this.funcionarioId = funcionarioId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataAtivacao() {
		return dataAtivacao;
	}

	public void setDataAtivacao(Date dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}

	public Date getDataDesativacao() {
		return dataDesativacao;
	}

	public void setDataDesativacao(Date dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	
	
}

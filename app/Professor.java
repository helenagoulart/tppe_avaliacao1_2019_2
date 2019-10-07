package app;

import exceptions.DadosProfessorIncompletosException;

public class Professor {

	private String nome;
	private String matricula;
	private String email;

	public Professor(String nome, String matricula, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
	}

	public static Professor obterProfessor(String nome, String matricula, String email) throws DadosProfessorIncompletosException {
		Professor p = null;
		
		if (nome == null || nome.equalsIgnoreCase("") ||
			matricula == null || matricula.equalsIgnoreCase("") || 
			email == null || email.equalsIgnoreCase("")) {
			throwProfessorMessage(nome, matricula, email);
		} else 
			p = new Professor(nome, matricula, email);
		
		return p;
	}

	private static void throwProfessorMessage(String nome, String matricula, String email)
			throws DadosProfessorIncompletosException {
		StringBuilder builder = new StringBuilder();
		builder.append("Dados informados para Professor estão incompletos:");
		builder.append(nome == null ? "Nome: " + nome : null);
		builder.append(matricula == null ? "Matricula: " + matricula : null);
		builder.append(email == null ? "Email: " + email : null);
		throw new DadosProfessorIncompletosException(builder.toString());
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getEmail() {
		return email;
	}
	
	

}

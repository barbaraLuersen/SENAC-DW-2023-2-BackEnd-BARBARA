package br.sc.senac.dw.exemplos.dw.exception;

public class CampoInvalidoException extends Exception {

	public CampoInvalidoException(String mensagem, Exception e) {
		super(mensagem, e);
	}

	public CampoInvalidoException(String mensagem) {
		super(mensagem);
	}
}

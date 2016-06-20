package br.com.brq.security;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Criptografia {

	// método para encriptar senha em MD5..
	public static String encriptarSenha(String senha) throws Exception {

		// criando um algoritmo de criptografia MD5/SHA1
		MessageDigest m = MessageDigest.getInstance("MD5");

		// preparando a senha para ser criptografada
		m.update(senha.getBytes(), 0, senha.length());

		// fazendo a criptografia e retornando o resultado..
		return new BigInteger(1, m.digest()).toString(16);

	}

}

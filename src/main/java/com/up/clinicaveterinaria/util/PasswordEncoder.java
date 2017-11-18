package com.up.clinicaveterinaria.util;

import java.security.MessageDigest;
import java.util.Base64;

public class PasswordEncoder {

	private String byteToBase64(byte[] bt) throws Exception {
		String returnString = Base64.getEncoder().encodeToString(bt);//por não ser urlSafe, é adicionado um '=' no fim da String para padding
		return returnString.substring(0, returnString.length() - 1);//removendo o '=' do fim da string (o = indica o fim da string no base64)
	}

	public String codificar(String senha, String sal) throws Exception {
		String encodedPassword = null;
		byte[] saltBytes = sal.getBytes("UTF-8");

		MessageDigest digest = MessageDigest.getInstance("SHA-256");//Quem usar MD5 está reprovado na disciplina!
		digest.reset();
		digest.update(saltBytes);

		byte[] btPass = digest.digest(senha.getBytes("UTF-8"));//temos um vetor de 32 bytes.

		//Não desejamos armazenar em binário (byte) diretamente no banco, então codificamos em base64. Em base64, cada 6 bits são representados em um char
		encodedPassword = byteToBase64(btPass);

		return encodedPassword;
	}
}
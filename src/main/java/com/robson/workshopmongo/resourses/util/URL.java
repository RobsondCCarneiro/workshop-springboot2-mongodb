/*
 * Classe com o parametro que irá decodificar o parametro de URL.
 * O Javascript tem uma função para codificar, por exemplo:
 * --> encodeURIComponent("bom dia") --> é impresso: "bom%20dia"
 * De acordo com o protocolo HTTP, a UTL seria assim:
 * --> http://localhost::8080/posts/titlesearch?text=bom%20dia
 *Onde titlesearch é o nome da variavel do caminho e após o '?' vem a mensagem que será feita a comparação
 *onde text é o nome do parametro.
 *http não aceita caracteres especiais (incluindo o espaço)
 */

package com.robson.workshopmongo.resourses.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date convertDate(String textDate, Date defaultValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(textDate);
		} catch (ParseException e) {
			return defaultValue;
		}
	}
}

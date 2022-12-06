package br.com.transcendance.api.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

import br.com.transcendance.api.exception.ValidacaoException;

public class ModelUtil {

	public static String padronizaString(String s) {
		return s == null ? null : s.toUpperCase();
	}

	// remove acentuação das palavras
	public static String trocaCarscteresEspeciais(String texto) {
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
		texto = texto.replaceAll("[^\\p{ASCII}]", "");
		return texto;
	}

	public static String semAcento(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		str = pattern.matcher(nfdNormalizedString).replaceAll("");
		return str.replaceAll("'", " ");
	}

	public static void validaColunaUnica(long idFront, long idDB, String sFront, String sBD) {

		sFront = ModelUtil.semAcento(ModelUtil.padronizaString(sFront));
		sBD = ModelUtil.semAcento(ModelUtil.padronizaString(sBD));

		if (idFront > 0) {
			if (sBD.equalsIgnoreCase(sFront) && idFront != idDB) {
				throw new ValidacaoException("duplicate key value violates unique constraint");
			}
		} else {
			if (sBD.equalsIgnoreCase(sFront)) {
				throw new ValidacaoException("duplicate key value violates unique constraint");
			}
		}

	}

}

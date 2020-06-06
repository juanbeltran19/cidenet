/**
 * Copyright (c) 2020 Cidenet
 * <br><A HREF=https://www.cidenet.com.co></a></br>
 * Todos los derechos reservados.
 */
package co.com.cidenet.sito.util;

import sun.misc.BASE64Decoder;
/**
 * Clase utilidad para manejo de seguridad
 *
 * @version
 * @author juanpbeltran <br>
 *         <b>Fecha de desarrollo : </b> 05/06/2020 <br>
 *         <b>Fecha de modificacion : </b> 00/00/0000
 */
@SuppressWarnings("restriction")
public class WebUtilUsuarios {

	private WebUtilUsuarios() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Metodo que se encarga de decodificar un texto
	 * retorna un texo plano decodificado  
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 05/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @param cadenaCodificada objeto de tipo String
	 * 
	 * @return texto de tipo String
	 * @return null de tipo String
	 */	
	public static String decodeBase64(String cadenaCodificada) {
		try {
			if (cadenaCodificada == null)
				cadenaCodificada = "";

			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decodedBytes = decoder.decodeBuffer(cadenaCodificada);

			String decodedString = new String(decodedBytes);
			decodedString = decodedString.replace("||n||", "Ã±").replace("||N||", "Ã‘").replace("||!||", "Â¡")
					.replace("||?||", "Â¿").replace("||uu||", "Ã¼").replace("||UU||", "Ãš").replace("||.||", ".");
			decodedString = decodedString.replace("||i||", "Ã­").replace("||a||", "Ã¡").replace("||e||", "Ã©")
					.replace("||o||", "Ã³").replace("||u||", "Ãº");
			decodedString = decodedString.replace("||I||", "Ã").replace("||A||", "Ã").replace("||E||", "Ã‰")
					.replace("||O||", "Ã“").replace("||U||", "Ãš");

			return replacePalabraClaves(decodedString);
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * Metodo que se encarga de convertir y reemplazar un texto
	 * retorna un texto modificado
	 * 
	 * @author juanpbeltran <br>
	 *         <b>Fecha de desarrollo : </b> 05/06/2020 <br>
	 *         <b>Fecha de modificacion : </b> 00/00/0000
	 * 
	 * @param texto objeto de tipo String
	 * 
	 * @return texto de tipo String
	 * 
	 */	
	public static String replacePalabraClaves(String texto) {
		texto.toUpperCase().replace("ACCESS", "").replace("ACCOUNT", "").replace("ACTIVATE", "").replace("ADD", "")
				.replace("ADVISE", "").replace("AFTER", "").replace("ALL_ROWS", "").replace("ALLOCATE", "")
				.replace("ALTER", "").replace("ANALYZE", "").replace("ANY", "").replace("ARCHIVE", "")
				.replace("ARCHIVELOG", "").replace("ARRAY", "").replace("AUTHENTICATED", "")
				.replace("AUTHORIZATION", "").replace("AUTOEXTEND", "").replace("AUTOMATIC", "").replace("BACKUP", "")
				.replace("BECOME", "").replace("BEFORE", "").replace("BEGIN", "").replace("BFILE", "")
				.replace("COLUMN", "").replace("COLUMNS", "").replace("CONSTRAINT", "").replace("EXECUTE IMMEDIATE", "")
				.replace("CURSOR", "").replace("DROP", "").replace("DECLARE", "").replace("CYCLE", "")
				.replace("FROM", "").replace("DANGLING", "").replace("WHERE", "").replace("DELETE", "")
				.replace("UPDATE", "").replace("SELECT", "").replace("FROM", "").replace("DUAL", "").replace(";", "")
				.replace(".", "").replace("CREATE", "").replace("DROP", "").replace("ALTER", "").replace("RENAME", "")
				.replace("TRUNCATE", "").replace("TABLE", "").replace("VALUES", "").replace("DATABASE", "")
				.replace("DEBUG", "").replace("DISTINCT", "").replace("EXECUTE", "").replace("INSERT", "")
				.replace("PROCEDURE", "").replace("REPLACE", "").replace("ROW", "").replace("SELECT", "")
				.replace("SESSION", "").replace("SPLIT", "").replace("STRUCTURE", "").replace("SYSDBA", "")
				.replace("SYSOPER", "").replace("SYSTEM", "").replace("TABLE", "").replace("TABLES", "")
				.replace("TABLESPACE", "").replace("TRIGGERS", "").replace("UPDATE", "").replace("VIEW", "")
				.replace("WITH", "").replace("WHERE", "").replace("CHR", "");
		return texto;

	}
}
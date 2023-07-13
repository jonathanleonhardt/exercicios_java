package exercicios.hamburgueria.utils;

import java.util.Objects;

public class ApoioUtil {

	public static boolean isStringEmpty( String texto ) {
		return 	Objects.isNull( texto ) ||
				texto == "";
	}
	
}

package utils;
import java.util.InputMismatchException;

public class ValidationDocuments {

	public static boolean validationCPF(String cpf) {

		String texto = cpf;
		texto = texto.replace(".", "");
		texto = texto.replace("-", "");

		if (texto.equals("00000000000") || texto.equals("11111111111") || texto.equals("22222222222")
				|| texto.equals("33333333333") || texto.equals("44444444444") || texto.equals("55555555555")
				|| texto.equals("66666666666") || texto.equals("77777777777") || texto.equals("88888888888")
				|| texto.equals("99999999999") || texto.length() != 11) {
			return false;
		}

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {

				num = (int) (texto.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (texto.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == texto.charAt(9)) && (dig11 == texto.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}

	}

	public static boolean validationCNPJ(String cnpj) {

		String texto = cnpj;
		texto = texto.replace(".", "");
		texto = texto.replace("-", "");
		texto = texto.replace("/", "");

		if (texto.equals("00000000000000") || texto.equals("11111111111111") || texto.equals("22222222222222")
				|| texto.equals("33333333333333") || texto.equals("44444444444444") || texto.equals("55555555555555")
				|| texto.equals("66666666666666") || texto.equals("77777777777777") || texto.equals("88888888888888")
				|| texto.equals("99999999999999") || (texto.length() != 14)) {
			return (false);
		}

		char dig13, dig14;
		int sm, i, r, num, peso;

		try {
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {

				num = (int) (texto.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (texto.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			if ((dig13 == texto.charAt(12)) && (dig14 == texto.charAt(13)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}

	}
	
	public static boolean validarCNS(String cns) {
		
		if (cns.equals("000000000000000") || cns.equals("111111111111111") || cns.equals("222222222222222")
				|| cns.equals("333333333333333") || cns.equals("444444444444444") || cns.equals("555555555555555")
				|| cns.equals("666666666666666") || cns.equals("777777777777777") || cns.equals("888888888888888")
				|| cns.equals("999999999999996") || (cns.length() != 15)) {
			return (false);
		}
		
		if(cns.substring(0, 1).equals("1") || cns.substring(0, 1).equals("2")) {
			
			float soma;
			float resto, dv;
			String pis = new String("");
			String resultado = new String("");
			pis = cns.substring(0,11);

			soma = ((Integer.valueOf(pis.substring(0,1)).intValue()) * 15) +
			((Integer.valueOf(pis.substring(1,2)).intValue()) * 14) +
			((Integer.valueOf(pis.substring(2,3)).intValue()) * 13) +
			((Integer.valueOf(pis.substring(3,4)).intValue()) * 12) +
			((Integer.valueOf(pis.substring(4,5)).intValue()) * 11) +
			((Integer.valueOf(pis.substring(5,6)).intValue()) * 10) +
			((Integer.valueOf(pis.substring(6,7)).intValue()) * 9) +
			((Integer.valueOf(pis.substring(7,8)).intValue()) * 8) +
			((Integer.valueOf(pis.substring(8,9)).intValue()) * 7) +
			((Integer.valueOf(pis.substring(9,10)).intValue()) * 6) +
			((Integer.valueOf(pis.substring(10,11)).intValue()) * 5);

			resto = soma % 11;
			dv = 11 - resto;

			if (dv == 11){
			dv = 0;
			}

			if (dv == 10){
			soma = ((Integer.valueOf(pis.substring(0,1)).intValue()) * 15) +
			((Integer.valueOf(pis.substring(1,2)).intValue()) * 14) +
			((Integer.valueOf(pis.substring(2,3)).intValue()) * 13) +
			((Integer.valueOf(pis.substring(3,4)).intValue()) * 12) +
			((Integer.valueOf(pis.substring(4,5)).intValue()) * 11) +
			((Integer.valueOf(pis.substring(5,6)).intValue()) * 10) +
			((Integer.valueOf(pis.substring(6,7)).intValue()) * 9) +
			((Integer.valueOf(pis.substring(7,8)).intValue()) * 8) +
			((Integer.valueOf(pis.substring(8,9)).intValue()) * 7) +
			((Integer.valueOf(pis.substring(9,10)).intValue()) * 6) +
			((Integer.valueOf(pis.substring(10,11)).intValue()) * 5) + 2;

			resto = soma % 11;
			dv = 11 - resto;
			resultado = pis + "001" + String.valueOf((int)dv);
			}else {
			resultado = pis + "000" + String.valueOf((int)dv);
			}

			if (! cns.equals(resultado)){
			return(false);
			}else {
			return(true);
			}
			
		} else {
			float resto,soma;

			soma = ((Integer.valueOf(cns.substring(0,1)).intValue()) * 15) +
			((Integer.valueOf(cns.substring(1,2)).intValue()) * 14) +
			((Integer.valueOf(cns.substring(2,3)).intValue()) * 13) +
			((Integer.valueOf(cns.substring(3,4)).intValue()) * 12) +
			((Integer.valueOf(cns.substring(4,5)).intValue()) * 11) +
			((Integer.valueOf(cns.substring(5,6)).intValue()) * 10) +
			((Integer.valueOf(cns.substring(6,7)).intValue()) * 9) +
			((Integer.valueOf(cns.substring(7,8)).intValue()) * 8) +
			((Integer.valueOf(cns.substring(8,9)).intValue()) * 7) +
			((Integer.valueOf(cns.substring(9,10)).intValue()) * 6) +
			((Integer.valueOf(cns.substring(10,11)).intValue()) * 5) +
			((Integer.valueOf(cns.substring(11,12)).intValue()) * 4) +
			((Integer.valueOf(cns.substring(12,13)).intValue()) * 3) +
			((Integer.valueOf(cns.substring(13,14)).intValue()) * 2) +
			((Integer.valueOf(cns.substring(14,15)).intValue()) * 1);

			resto = soma % 11;

			if (resto != 0){
			return(false);
			}else {
			return(true);}
		}
		
	}
	
}

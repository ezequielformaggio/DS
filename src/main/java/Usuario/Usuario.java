package Usuario;

import ChequeoClave.ChequeadorDeClaves;
import ChequeoClave.ClaveInseguraException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Usuario {
  String user;
  String password;

  public String getPassword() {
    return password;
  }

  public void chequearCalidadDecontrasenia(String nuevaContrasenia) {
    if (!ChequeadorDeClaves.getChequeadorDeClavesInstance().esClaveSegura(nuevaContrasenia)) {
      throw new ClaveInseguraException("La clave es insegura");
    }
  }

  public void transformarContraseña(String user, String password) {
    chequearCalidadDecontrasenia(password);
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(password.getBytes());
      byte[] bytes = md.digest();
      StringBuilder sb = new StringBuilder();
      for (byte aByte : bytes) {
        sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
      }
      this.password = sb.toString();
    } catch (NoSuchAlgorithmException e) {
       throw new ContraseniaInvalida("Constrasenia invalida", e);
    }
    this.user = user;
  }

}

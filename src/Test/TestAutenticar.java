package Test;

import Auth.Autenticador;

public class TestAutenticar {
    public static void testing(){
        System.out.println(Autenticador.getInstance().autenticar("rr@consorcios.com", "rr@consorcios.com"));
        Autenticador.getInstance().editarPassword("rr@consorcios.com","123");
        System.out.println(Autenticador.getInstance().autenticar("rr@consorcios.com", "123"));

        System.out.println(Autenticador.getInstance().autenticar("admin@consorcios.com", "admin@consorcios.com"));
        Autenticador.getInstance().eliminarCredencial("admin@consorcios.com");
        System.out.println(Autenticador.getInstance().autenticar("admin@consorcios.com", "admin@consorcios.com"));
    }
}

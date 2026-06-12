package model;
import java.util.*;

public class UserRepository {
    private List<User> usuarios = new ArrayList<>();

    public void salvar(User user){
        usuarios.add(user);
    }

    public User buscarPorEmail(String email) {
        for (User u : usuarios) {
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    public boolean emailJaExiste(String email) {
        return buscarPorEmail(email) != null;
    }
}

package controller;

import model.UserRepository;
import model.User;

public class AuthController {
    private UserRepository repositorio = new UserRepository();
    private User usuarioLogado = null;

    public boolean login(String email, String senha) {
        if (email.isEmpty() || senha.isEmpty()){
            return false;
        }
        User user = repositorio.buscarPorEmail(email);

        if (user == null) {
            return false;
        }

        if (user.getSenha().equals(senha)){
            return true;
        }

        usuarioLogado = user;
        return false;
    }

    public String registrar(String nome, String email, String senha) {
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty())
            return "Preencha todos os campos!";

        if (repositorio.emailJaExiste(email))
            return "E-mail já cadastrado!";

        repositorio.salvar(new User(nome, email, senha));
        return "ok";
    }

    public void logout() {
        usuarioLogado = null;
    }

    public User getUsuarioLogado() {
        return usuarioLogado;
    }
}

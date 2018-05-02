package br.com.systemdelivery.systemdelivery.service;

import br.com.systemdelivery.systemdelivery.entity.Usuario;
import java.io.Serializable;
import java.util.List;

public interface UsuarioService extends Serializable {
    
    public List<Usuario> listar(int offset, int quantidade);
    
    public Usuario obter(Long codigoProduto);
    
    public void incluir(Usuario usuario);
    
    public void alterar(Usuario usuario);
    
    public void remover(Long codigoUsuario);
    
    public List<Usuario> pesquisar(String pesquisa);
}

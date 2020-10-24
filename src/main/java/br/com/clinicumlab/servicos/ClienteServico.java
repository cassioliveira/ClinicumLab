package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.ClienteDao;
import br.com.clinicumlab.enumeracao.Estados;
import br.com.clinicumlab.modelo.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.Getter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class ClienteServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ClienteDao clienteDao;
    
    @Getter
    private List<Estados> estados;

    public ClienteServico() {
        estados = new ArrayList<>();
        estados = Arrays.asList(Estados.values());
    }

    @Transactional
    public void salvar(Cliente cliente)   {
        if (cliente.getId() == null) {
            cliente.setCadastro(new Date());
        }
        this.clienteDao.save(cliente);
    }

    @Transactional
    public void deletar(Cliente cliente){
        clienteDao.delete(findById(cliente.getId()));
    }

    public Cliente findById(Long id) {
        return clienteDao.porId(id);
    }

    public List<Cliente> todos() {
        return clienteDao.todos();
    }

}

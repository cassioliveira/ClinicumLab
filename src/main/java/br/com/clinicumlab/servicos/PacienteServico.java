package br.com.clinicumlab.servicos;

import br.com.clinicumlab.dao.PacienteDao;
import br.com.clinicumlab.enumeracao.Estados;
import br.com.clinicumlab.modelo.Paciente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import lombok.Getter;

/**
 *
 * @author elisangela <elysangeladesouza@gmail.com>
 */
public class PacienteServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private PacienteDao pacienteDao;

    @Getter
    private List<Estados> estados;

    public PacienteServico() {
        estados = new ArrayList<>();
        estados = Arrays.asList(Estados.values());
    }

    @Transactional
    public void salvar(Paciente paciente) {
        if (paciente.getId() == null) {
            paciente.setCadastro(new Date());
        } else {
            paciente.setAtualizacao(new Date());
        }
        this.pacienteDao.save(paciente);
    }

    @Transactional
    public void deletar(Paciente paciente) {
        pacienteDao.delete(findById(paciente.getId()));
    }

    public Paciente findById(Long id) {
        return pacienteDao.porId(id);
    }

    public List<Paciente> todos() {
        return pacienteDao.todos();
    }

//    public long idade(Paciente paciente) {
//        Calendar dataNascimento = Calendar.getInstance();
//        dataNascimento.setTime(paciente.getDataNascimento());
//        int dia = dataNascimento.get(Calendar.DAY_OF_MONTH);
//        int mes = dataNascimento.get(Calendar.MONTH);
//        int ano = dataNascimento.get(Calendar.YEAR);
//        
//        dataNascimento.set(Calendar.DAY_OF_MONTH, dia);
//        dataNascimento.set(Calendar.MONTH, mes);
//        dataNascimento.set(Calendar.YEAR, ano);
//        
//        Calendar hoje = Calendar.getInstance();
//        
//        long idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);
//        
//        return idade;
//    }
}

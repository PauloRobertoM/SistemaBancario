package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.PessoaJuridicaDao;
import edu.ifrn.poo.sistemaBancario.dominio.PessoaJuridica;
import java.sql.SQLException;

public class ControladorPessoaJuridica {
    public void cadastrarPessoaJuridica (PessoaJuridica pj) throws ClassNotFoundException, SQLException {
        PessoaJuridicaDao pessoaJuridica_dao = new PessoaJuridicaDao();   
        pessoaJuridica_dao.inserir(pj);
    }
}

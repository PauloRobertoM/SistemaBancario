package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.PessoaFisicaDao;
import edu.ifrn.poo.sistemaBancario.dominio.PessoaFisica;
import java.sql.SQLException;

public class ControladorPessoaFisica {
     public void cadastrarPessoaFisica (PessoaFisica pf) throws ClassNotFoundException, SQLException {
        PessoaFisicaDao pessoaFisica_dao = new PessoaFisicaDao();   
        pessoaFisica_dao.inserir(pf);
    }
}

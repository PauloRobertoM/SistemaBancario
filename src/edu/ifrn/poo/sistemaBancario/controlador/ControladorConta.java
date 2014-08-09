package edu.ifrn.poo.sistemaBancario.controlador;

import edu.ifrn.poo.sistemaBancario.dao.ContaDao;
import edu.ifrn.poo.sistemaBancario.dominio.Conta;
import java.sql.SQLException;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class ControladorConta {
    //public void cadastrarConta(int numero, boolean ativa, double saldo) throws ClassNotFoundException, SQLException {
        //ContaDao conta_dao = new ContaDao();
        //conta_dao.inserir(numero, ativa, saldo);          
    //}
    
    public void cadastrarConta(Conta c) throws ClassNotFoundException, SQLException {
        ContaDao conta_dao = new ContaDao();
        conta_dao.inserir(c);           
    }
    
    public void verConta(Conta c) throws ClassNotFoundException, SQLException {
        ContaDao conta_dao = new ContaDao();
        conta_dao.listarConta();
    }
    
    public DefaultTableModel listarConta() throws ClassNotFoundException, SQLException {
        DefaultTableModel dft = new DefaultTableModel();
        ContaDao dao = new ContaDao(); 
        
        Iterator<Conta> it = dao.listarConta().iterator();
        Conta c;
       while(it.hasNext()) {
          c = it.next();
          //procurar componente...
         dft.addColumn(c.getNumero());
         dft.addColumn(c.getAtiva());
         dft.addColumn(c.getSaldo());
//         dft.addColumn(c.getCliente().getNome());
//         dft.addColumn(c.getCliente().getTelefone());
//         dft.addColumn(c.getCliente().getEmail());
//         dft.getTableModelListeners();
        }
       
        //dft.addColumn("Data de Vencimento", dao.listarDataVenc());
        //dft.addColumn("Categoria", dao.listarCategoria());
        return dft;
    }
    
   
}
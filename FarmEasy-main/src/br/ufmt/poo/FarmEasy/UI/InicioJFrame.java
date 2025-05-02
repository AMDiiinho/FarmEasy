/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.ufmt.poo.FarmEasy.UI;

import br.ufmt.poo.FarmEasy.services.AbrigoService;
import javax.swing.JOptionPane;
import br.ufmt.poo.FarmEasy.services.SiloService;
import br.ufmt.poo.FarmEasy.services.impl.AbrigoServiceImpl;
import br.ufmt.poo.FarmEasy.services.impl.ProdutoServiceImpl;
import br.ufmt.poo.FarmEasy.services.ProdutoService;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import br.ufmt.poo.FarmEasy.UI.DTOs.SiloDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.ProdutoDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.AbrigoDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.AnimalDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.UsuarioDTO;
import br.ufmt.poo.FarmEasy.persistencias.AbrigoPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.AnimalPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.ProdutoPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.SiloPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.UsuarioPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.impl.AbrigoPersistenciaImpl;
import br.ufmt.poo.FarmEasy.persistencias.impl.AnimalPersistenciaImpl;
import br.ufmt.poo.FarmEasy.persistencias.impl.ProdutoPersistenciaImpl;
import br.ufmt.poo.FarmEasy.persistencias.impl.SiloPersistenciaImpl;
import br.ufmt.poo.FarmEasy.persistencias.impl.UsuarioPersistenciaImpl;
import br.ufmt.poo.FarmEasy.services.AnimalService;
import br.ufmt.poo.FarmEasy.services.UsuarioService;
import br.ufmt.poo.FarmEasy.services.impl.AnimalServiceImpl;
import br.ufmt.poo.FarmEasy.services.impl.SiloServiceImpl;
import br.ufmt.poo.FarmEasy.services.impl.UsuarioServiceImpl;

/**
 *
 * @author arthurmarques
 */
public class InicioJFrame extends javax.swing.JFrame {

    /**
     * Creates new form menuJFrame
     */
    public InicioJFrame() {

        initComponents();
        atualizarTabelaProdutos();
        atualizarTabelaSilos();
        carregarComboBoxIdSilos();
        carregarComboBoxProdutos();
        carregarComboBoxRacas();
        carregarComboBoxIdAbrigos();
    }

    private void atualizarTabelaAnimais(String tipoAnimal) {

        AnimalService animalServiceGalinha = new AnimalServiceImpl();

        List<AnimalDTO> listaGalinhas = animalServiceGalinha.listar(tipoAnimal);

        DefaultTableModel dfmGalinhas = (DefaultTableModel) galinhasjTable.getModel();
        int linhasGalinhas = dfmGalinhas.getRowCount();
        for (int i = 0; i < linhasGalinhas; i++) {
            dfmGalinhas.removeRow(0);

        }

        for (AnimalDTO animalDTO : listaGalinhas) {
            Object[] linhaGalinha = new Object[4];
            linhaGalinha[0] = animalDTO.getId();
            linhaGalinha[1] = animalDTO.getRaca();
            linhaGalinha[2] = animalDTO.getQuantidade();
            linhaGalinha[3] = animalDTO.getValor();

            dfmGalinhas.addRow(linhaGalinha);

        }

        AnimalService animalServicePorco = new AnimalServiceImpl();

        List<AnimalDTO> listaPorcos = animalServicePorco.listar(tipoAnimal);

        DefaultTableModel dfmPorcos = (DefaultTableModel) porcosjTable.getModel();
        int linhasPorcos = dfmPorcos.getRowCount();
        for (int i = 0; i < linhasPorcos; i++) {
            dfmPorcos.removeRow(0);

        }

        for (AnimalDTO animalDTO : listaPorcos) {
            Object[] linhaPorco = new Object[4];
            linhaPorco[0] = animalDTO.getId();
            linhaPorco[1] = animalDTO.getRaca();
            linhaPorco[2] = animalDTO.getQuantidade();
            linhaPorco[3] = animalDTO.getValor();

            dfmPorcos.addRow(linhaPorco);

        }

        AnimalService animalServiceOvelha = new AnimalServiceImpl();

        List<AnimalDTO> listaOvelhas = animalServiceOvelha.listar(tipoAnimal);

        DefaultTableModel dfmOvelhas = (DefaultTableModel) ovelhasjTable.getModel();
        int linhasOvelhas = dfmOvelhas.getRowCount();
        for (int i = 0; i < linhasOvelhas; i++) {
            dfmOvelhas.removeRow(0);

        }

        for (AnimalDTO animalDTO : listaOvelhas) {
            Object[] linhaOvelha = new Object[4];
            linhaOvelha[0] = animalDTO.getId();
            linhaOvelha[1] = animalDTO.getRaca();
            linhaOvelha[2] = animalDTO.getQuantidade();
            linhaOvelha[3] = animalDTO.getValor();

            dfmOvelhas.addRow(linhaOvelha);

        }

        AnimalService animalServiceVaca = new AnimalServiceImpl();

        List<AnimalDTO> listaVacas = animalServiceVaca.listar(tipoAnimal);

        DefaultTableModel dfmVacas = (DefaultTableModel) vacasjTable.getModel();
        int linhasVacas = dfmVacas.getRowCount();
        for (int i = 0; i < linhasVacas; i++) {
            dfmVacas.removeRow(0);

        }

        for (AnimalDTO animalDTO : listaVacas) {
            Object[] linhaVaca = new Object[4];
            linhaVaca[0] = animalDTO.getId();
            linhaVaca[1] = animalDTO.getRaca();
            linhaVaca[2] = animalDTO.getQuantidade();
            linhaVaca[3] = animalDTO.getValor();

            dfmVacas.addRow(linhaVaca);

        }
    }

    private void atualizarTabelaAbrigo(String tipoAbrigo) {

        AbrigoService serviceAbrigo = new AbrigoServiceImpl();

        List<AbrigoDTO> listaAbrigos = serviceAbrigo.listar(tipoAbrigo);

        DefaultTableModel dfmAbrigoGalinheiro = (DefaultTableModel) galinheirosjTable.getModel();
        int linhasAbrigoGalinheiro = dfmAbrigoGalinheiro.getRowCount();
        for (int i = 0; i < linhasAbrigoGalinheiro; i++) {
            dfmAbrigoGalinheiro.removeRow(0);

        }

        for (AbrigoDTO abrigoDTO : listaAbrigos) {
            Object[] linhaAbrigo = new Object[3];
            linhaAbrigo[0] = abrigoDTO.getId();
            linhaAbrigo[1] = abrigoDTO.getQtdAnimais();
            linhaAbrigo[2] = abrigoDTO.getCapacidade();

            dfmAbrigoGalinheiro.addRow(linhaAbrigo);

        }

        DefaultTableModel dfmAbrigoChiqueiro = (DefaultTableModel) chiqueirosjTable.getModel();
        int linhasAbrigoChiqueiro = dfmAbrigoChiqueiro.getRowCount();
        for (int i = 0; i < linhasAbrigoChiqueiro; i++) {
            dfmAbrigoChiqueiro.removeRow(0);

        }

        for (AbrigoDTO abrigoDTO : listaAbrigos) {
            Object[] linhaAbrigo = new Object[3];
            linhaAbrigo[0] = abrigoDTO.getId();
            linhaAbrigo[1] = abrigoDTO.getQtdAnimais();
            linhaAbrigo[2] = abrigoDTO.getCapacidade();

            dfmAbrigoChiqueiro.addRow(linhaAbrigo);

        }

        DefaultTableModel dfmAbrigoAprisco = (DefaultTableModel) apriscosjTable.getModel();
        int linhasAbrigoAprisco = dfmAbrigoAprisco.getRowCount();
        for (int i = 0; i < linhasAbrigoAprisco; i++) {
            dfmAbrigoAprisco.removeRow(0);

        }

        for (AbrigoDTO abrigoDTO : listaAbrigos) {
            Object[] linhaAbrigo = new Object[3];
            linhaAbrigo[0] = abrigoDTO.getId();
            linhaAbrigo[1] = abrigoDTO.getQtdAnimais();
            linhaAbrigo[2] = abrigoDTO.getCapacidade();

            dfmAbrigoAprisco.addRow(linhaAbrigo);

        }

        DefaultTableModel dfmAbrigoCurral = (DefaultTableModel) curraisjTable.getModel();
        int linhasAbrigoCurral = dfmAbrigoCurral.getRowCount();
        for (int i = 0; i < linhasAbrigoCurral; i++) {
            dfmAbrigoCurral.removeRow(0);

        }

        for (AbrigoDTO abrigoDTO : listaAbrigos) {
            Object[] linhaAbrigo = new Object[3];
            linhaAbrigo[0] = abrigoDTO.getId();
            linhaAbrigo[1] = abrigoDTO.getQtdAnimais();
            linhaAbrigo[2] = abrigoDTO.getCapacidade();

            dfmAbrigoCurral.addRow(linhaAbrigo);

        }
    }

    private void atualizarTabelaProdutos() {

        ProdutoService produtoService = new ProdutoServiceImpl();
        List<ProdutoDTO> listaProdutos = produtoService.listar();

        DefaultTableModel dfmProduto = (DefaultTableModel) produtosjTable.getModel();
        int linhasProduto = dfmProduto.getRowCount();
        for (int i = 0; i < linhasProduto; i++) {
            dfmProduto.removeRow(0);
        }

        for (ProdutoDTO produtoDTO : listaProdutos) {
            Object[] linhaProduto = new Object[4];
            linhaProduto[0] = produtoDTO.getId();
            linhaProduto[1] = produtoDTO.getNome();
            linhaProduto[2] = produtoDTO.getEstoque();
            linhaProduto[3] = produtoDTO.getValor();

            dfmProduto.addRow(linhaProduto);
        }               
    }
    
    private void atualizarTabelaSilos(){
        
        SiloService siloService = new SiloServiceImpl();
        List<SiloDTO> listaSilos = siloService.listar();

        DefaultTableModel dfmSilo = (DefaultTableModel) silosjTable.getModel();
        int linhasSilo = dfmSilo.getRowCount();
        for (int i = 0; i < linhasSilo; i++) {
            dfmSilo.removeRow(0);
        }

        for (SiloDTO siloDTO : listaSilos) {
            Object[] linhaProduto = new Object[4];
            linhaProduto[0] = siloDTO.getId();
            linhaProduto[1] = siloDTO.getQtdProdutos();
            linhaProduto[2] = siloDTO.getCapacidade();

            dfmSilo.addRow(linhaProduto);
        } 
        
    }
    
    private void atualizarTabelaRacas(String tipoAnimal){
        
        AnimalService animalServiceGalinha = new AnimalServiceImpl();
        List<AnimalDTO> listaGalinhas = animalServiceGalinha.listar(tipoAnimal);

        DefaultTableModel dfmGalinha = (DefaultTableModel) galinhasjTable.getModel();
        int linhasGalinha = dfmGalinha.getRowCount();
        for (int i = 0; i < linhasGalinha; i++) {
            dfmGalinha.removeRow(0);
        }

        for (AnimalDTO animalDTO : listaGalinhas) {
            Object[] linhaGalinha = new Object[4];
            linhaGalinha[0] = animalDTO.getId();
            linhaGalinha[1] = animalDTO.getRaca();
            linhaGalinha[2] = animalDTO.getQuantidade();
            linhaGalinha[3] = animalDTO.getValor();
                    
            dfmGalinha.addRow(linhaGalinha);
        }
        
        AnimalService animalServicePorco = new AnimalServiceImpl();
        List<AnimalDTO> listaPorcos = animalServicePorco.listar(tipoAnimal);

        DefaultTableModel dfmPorco = (DefaultTableModel) porcosjTable.getModel();
        int linhasPorco = dfmPorco.getRowCount();
        for (int i = 0; i < linhasPorco; i++) {
            dfmPorco.removeRow(0);
        }

        for (AnimalDTO animalDTO : listaPorcos) {
            Object[] linhaPorco = new Object[4];
            linhaPorco[0] = animalDTO.getId();
            linhaPorco[1] = animalDTO.getRaca();
            linhaPorco[2] = animalDTO.getQuantidade();
            linhaPorco[3] = animalDTO.getValor();
                    
            dfmPorco.addRow(linhaPorco);
        }
        
        AnimalService animalServiceOvelha = new AnimalServiceImpl();
        List<AnimalDTO> listaOvelhas = animalServiceOvelha.listar(tipoAnimal);

        DefaultTableModel dfmOvelha = (DefaultTableModel) ovelhasjTable.getModel();
        int linhasOvelha = dfmOvelha.getRowCount();
        for (int i = 0; i < linhasOvelha; i++) {
            dfmOvelha.removeRow(0);
        }

        for (AnimalDTO animalDTO : listaOvelhas) {
            Object[] linhaOvelha = new Object[4];
            linhaOvelha[0] = animalDTO.getId();
            linhaOvelha[1] = animalDTO.getRaca();
            linhaOvelha[2] = animalDTO.getQuantidade();
            linhaOvelha[3] = animalDTO.getValor();
                    
            dfmOvelha.addRow(linhaOvelha);
        }
        
        AnimalService animalServiceVaca = new AnimalServiceImpl();
        List<AnimalDTO> listaVacas = animalServiceVaca.listar(tipoAnimal);

        DefaultTableModel dfmVaca = (DefaultTableModel) vacasjTable.getModel();
        int linhasVaca = dfmVaca.getRowCount();
        for (int i = 0; i < linhasVaca; i++) {
            dfmVaca.removeRow(0);
        }

        for (AnimalDTO animalDTO : listaVacas) {
            Object[] linhaVaca = new Object[4];
            linhaVaca[0] = animalDTO.getId();
            linhaVaca[1] = animalDTO.getRaca();
            linhaVaca[2] = animalDTO.getQuantidade();
            linhaVaca[3] = animalDTO.getValor();
                    
            dfmVaca.addRow(linhaVaca);
        }
        
    }
    
    private void carregarComboBoxProdutos(){
        
        ProdutoService produtoService = new ProdutoServiceImpl();
        List<ProdutoDTO> listaProdutos = produtoService.listar();
        produtojComboBox.removeAllItems();

        for (ProdutoDTO produtoDTO : listaProdutos) {
            produtojComboBox.addItem(produtoDTO.getNome());
        }
    }
    
    private void carregarComboBoxIdSilos(){
        
    SiloService siloService = new SiloServiceImpl();
        List<SiloDTO> listaSilos = siloService.listar();
        IDsilojComboBox.removeAllItems();

        for (SiloDTO siloDTO : listaSilos) {
            IDsilojComboBox.addItem(siloDTO.getId());
        }
    }
    
    private void carregarComboBoxRacas() {
              
        AnimalService animalServiceGalinha = new AnimalServiceImpl();
        List<AnimalDTO> listaGalinhas = animalServiceGalinha.listar("Galinha");
        racaGalinhajComboBox.removeAllItems();
        
        for (AnimalDTO animalDTO : listaGalinhas){
            
           racaGalinhajComboBox.addItem(animalDTO.getRaca());
      
        }
                
        
        AnimalService animalServicePorco = new AnimalServiceImpl();
        List<AnimalDTO> listaPorcos = animalServicePorco.listar("Porco");   
        racaPorcojComboBox.removeAllItems();
        
        for (AnimalDTO animalDTO : listaPorcos){
            
           racaPorcojComboBox.addItem(animalDTO.getRaca());
        }
        
        AnimalService animalServiceOvelha = new AnimalServiceImpl();
        List<AnimalDTO> listaOvelhas = animalServiceOvelha.listar("Ovelha");
        corEntradaOvelhajComboBox.removeAllItems();
        
        for (AnimalDTO animalDTO : listaOvelhas){
            
           corEntradaOvelhajComboBox.addItem(animalDTO.getRaca());
        }
        
        AnimalService animalServiceVaca = new AnimalServiceImpl();
        List<AnimalDTO> listaVacas = animalServiceVaca.listar("Vaca");
        racaVacajComboBox.removeAllItems();
        
        for (AnimalDTO animalDTO : listaVacas){
            
           racaVacajComboBox.addItem(animalDTO.getRaca());
        }
        
    }
    
    private void carregarComboBoxIdAbrigos(){
        
        AbrigoService abrigoServiceGalinheiro = new AbrigoServiceImpl();
        List<AbrigoDTO> listaAbrigoGalinheiro = abrigoServiceGalinheiro.listar("Galinheiro");
        idGalinheirojComboBox.removeAllItems();

        for (AbrigoDTO abrigoDTO : listaAbrigoGalinheiro) {
            idGalinheirojComboBox.addItem(abrigoDTO.getId());
        }
        
        AbrigoService abrigoServiceAprisco = new AbrigoServiceImpl();
        List<AbrigoDTO> listaAbrigoAprisco = abrigoServiceAprisco.listar("Aprisco");
        idApriscojComboBox.removeAllItems();

        for (AbrigoDTO abrigoDTO : listaAbrigoAprisco) {
            idApriscojComboBox.addItem(abrigoDTO.getId());
        }             
        
        AbrigoService abrigoServiceChiqueiro = new AbrigoServiceImpl();
        List<AbrigoDTO> listaAbrigoChiqueiro = abrigoServiceChiqueiro.listar("Chiqueiro");
        idChiqueirojComboBox.removeAllItems();

        for (AbrigoDTO abrigoDTO : listaAbrigoChiqueiro) {
            idChiqueirojComboBox.addItem(abrigoDTO.getId());
        }
        
        AbrigoService abrigoServiceCurral = new AbrigoServiceImpl();
        List<AbrigoDTO> listaAbrigoCurral = abrigoServiceCurral.listar("Curral");
        idCurraljComboBox.removeAllItems();

        for (AbrigoDTO abrigoDTO : listaAbrigoCurral) {
            idCurraljComboBox.addItem(abrigoDTO.getId());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controlejPanel = new javax.swing.JPanel();
        loginjPanel = new javax.swing.JPanel();
        usuariojTextField = new javax.swing.JTextField();
        senhajTextField = new javax.swing.JTextField();
        usuariojLabel = new javax.swing.JLabel();
        senhajLabel = new javax.swing.JLabel();
        entrarjButton = new javax.swing.JButton();
        cadastrarContajButton = new javax.swing.JButton();
        menuPrincipaljPanel = new javax.swing.JPanel();
        sairjButton = new javax.swing.JButton();
        produtosjButton = new javax.swing.JButton();
        plantacoesjButton = new javax.swing.JButton();
        animaisjButton = new javax.swing.JButton();
        menuAnimaisjPanel = new javax.swing.JPanel();
        voltarMenuAnimaisjButton = new javax.swing.JButton();
        galinhasjButton = new javax.swing.JButton();
        porcosjButton = new javax.swing.JButton();
        vacasjButton = new javax.swing.JButton();
        ovelhasjButton = new javax.swing.JButton();
        abrigosjLabel = new javax.swing.JLabel();
        galinhasjPanel = new javax.swing.JPanel();
        galinhasjScrollPane = new javax.swing.JScrollPane();
        galinhasjTable = new javax.swing.JTable();
        voltarGalinhajButton = new javax.swing.JButton();
        abrigosGalinhasjLabel = new javax.swing.JLabel();
        idGalinhajLabel = new javax.swing.JLabel();
        nomeGalinhajLabel = new javax.swing.JLabel();
        valorGalinhajLabel = new javax.swing.JLabel();
        valorGalinhajTextField = new javax.swing.JTextField();
        idGalinhajTextField = new javax.swing.JTextField();
        salvarGalinhajButton = new javax.swing.JButton();
        cancelarGalinhajButton = new javax.swing.JButton();
        tituloCadastroGalinhasjLabel1 = new javax.swing.JLabel();
        racaGalinhajTextField = new javax.swing.JTextField();
        consultarGalinheirosjButton = new javax.swing.JButton();
        galinhasArmazenamentojPanel = new javax.swing.JPanel();
        galinheirosjScrollPane = new javax.swing.JScrollPane();
        galinheirosjTable = new javax.swing.JTable();
        voltarGalinheirosjButton = new javax.swing.JButton();
        idGalinheirojLabel = new javax.swing.JLabel();
        capacidadeGalinheirojLabel = new javax.swing.JLabel();
        idGalinheirojTextField = new javax.swing.JTextField();
        salvarGalinheirojButton = new javax.swing.JButton();
        cancelarGalinheirosjButton = new javax.swing.JButton();
        tituloCadastroGalinheirosjLabel = new javax.swing.JLabel();
        capacidadeGalinheirojSpinner = new javax.swing.JSpinner();
        tituloEntradaGalinhasjLabel = new javax.swing.JLabel();
        racajLabel = new javax.swing.JLabel();
        quantidadeEntradaGalinhajLabel = new javax.swing.JLabel();
        idGalinheirojComboBox = new javax.swing.JComboBox<>();
        quantidadeEntradaGalinhasjSpinner = new javax.swing.JSpinner();
        idGalinheirojLabel1 = new javax.swing.JLabel();
        racaGalinhajComboBox = new javax.swing.JComboBox<>();
        cancelarEntradaGalinhasjButton = new javax.swing.JButton();
        registrarEntradaGalinhasjButton = new javax.swing.JButton();
        tabelaGalinheirosjLabel = new javax.swing.JLabel();
        porcosjPanel = new javax.swing.JPanel();
        porcosjScrollPane = new javax.swing.JScrollPane();
        porcosjTable = new javax.swing.JTable();
        voltarPorcosjButton = new javax.swing.JButton();
        racasPorcosjLabel = new javax.swing.JLabel();
        idPorcojLabel = new javax.swing.JLabel();
        nomePorcojLabel = new javax.swing.JLabel();
        racaPorcojTextField = new javax.swing.JTextField();
        idPorcojTextField = new javax.swing.JTextField();
        salvarPorcojButton = new javax.swing.JButton();
        cancelarPorcojButton = new javax.swing.JButton();
        tituloCadastroPorcojLabel = new javax.swing.JLabel();
        valorPorcojLabel = new javax.swing.JLabel();
        valorPorcojTextField = new javax.swing.JTextField();
        consultarChiqueirosjButton = new javax.swing.JButton();
        porcosArmazenamentojPanel = new javax.swing.JPanel();
        chiqueirosjScrollPane = new javax.swing.JScrollPane();
        chiqueirosjTable = new javax.swing.JTable();
        voltarChiqueirosjButton1 = new javax.swing.JButton();
        idChiqueirosjLabel = new javax.swing.JLabel();
        capacidadeChiqueirosjLabel = new javax.swing.JLabel();
        idChiqueirojTextField = new javax.swing.JTextField();
        salvarChiqueirosjButton = new javax.swing.JButton();
        cancelarChiqueirojButton = new javax.swing.JButton();
        tituloCadastroChiqueirosjLabel = new javax.swing.JLabel();
        capacidadeChiqueirojSpinner = new javax.swing.JSpinner();
        tituloEntradaChiqueirosjLabel = new javax.swing.JLabel();
        racaPorcojLabel = new javax.swing.JLabel();
        quantidadeEntradaPorcojLabel = new javax.swing.JLabel();
        idChiqueirojComboBox = new javax.swing.JComboBox<>();
        quantidadeEntradaPorcosjSpinner = new javax.swing.JSpinner();
        idEntradaChiqueirojLabel = new javax.swing.JLabel();
        racaPorcojComboBox = new javax.swing.JComboBox<>();
        cancelarEntradaPorcosjButton = new javax.swing.JButton();
        registrarEntradaPorcosjButton = new javax.swing.JButton();
        tabelaPorcosjLabel = new javax.swing.JLabel();
        ovelhasjPanel = new javax.swing.JPanel();
        ovelhasjScrollPane = new javax.swing.JScrollPane();
        ovelhasjTable = new javax.swing.JTable();
        voltarOvelhasjButton = new javax.swing.JButton();
        abrigosOvelhasjLabel = new javax.swing.JLabel();
        idOvelhajLabel = new javax.swing.JLabel();
        corOvelhajLabel = new javax.swing.JLabel();
        idOvelhajTextField = new javax.swing.JTextField();
        salvarOvelhajButton = new javax.swing.JButton();
        cancelarOvelhajButton = new javax.swing.JButton();
        tituloCadastroOvelhasjLabel = new javax.swing.JLabel();
        valorOvelhajLabel = new javax.swing.JLabel();
        valorOvelhajTextField = new javax.swing.JTextField();
        consultarApriscosjButton = new javax.swing.JButton();
        corOvelhajTextField = new javax.swing.JTextField();
        ovelhasArmazenamentojPanel = new javax.swing.JPanel();
        apriscosjScrollPane = new javax.swing.JScrollPane();
        apriscosjTable = new javax.swing.JTable();
        voltarApriscosjButton = new javax.swing.JButton();
        idApriscojLabel = new javax.swing.JLabel();
        capacidadeApriscojLabel = new javax.swing.JLabel();
        idApriscojTextField = new javax.swing.JTextField();
        salvarApriscojButton = new javax.swing.JButton();
        cancelarApriscojButton = new javax.swing.JButton();
        tituloCadastroApriscosjLabel = new javax.swing.JLabel();
        capacidadeApriscojSpinner = new javax.swing.JSpinner();
        tituloEntradaOvelhasjLabel = new javax.swing.JLabel();
        racaOvelhasjLabel = new javax.swing.JLabel();
        quantidadeEntradaOvelhajLabel = new javax.swing.JLabel();
        idApriscojComboBox = new javax.swing.JComboBox<>();
        quantidadeEntradaOvelhasjSpinner = new javax.swing.JSpinner();
        idEntradaApriscojLabel = new javax.swing.JLabel();
        corEntradaOvelhajComboBox = new javax.swing.JComboBox<>();
        cancelarEntradaOvelhasjButton = new javax.swing.JButton();
        registrarEntradaOvelhasjButton = new javax.swing.JButton();
        tabelaOvelhasjLabel = new javax.swing.JLabel();
        vacasjPanel = new javax.swing.JPanel();
        vacasjScrollPane = new javax.swing.JScrollPane();
        vacasjTable = new javax.swing.JTable();
        voltarVacasjButton = new javax.swing.JButton();
        vacasjLabel = new javax.swing.JLabel();
        idVacajLabel = new javax.swing.JLabel();
        nomeVacajLabel = new javax.swing.JLabel();
        racaVacajTextField = new javax.swing.JTextField();
        idVacajTextField = new javax.swing.JTextField();
        salvarVacajButton = new javax.swing.JButton();
        cancelarVacajButton = new javax.swing.JButton();
        tituloCadastroVacasjLabel = new javax.swing.JLabel();
        valorVacajTextField = new javax.swing.JTextField();
        valorVacajLabel = new javax.swing.JLabel();
        consultarCurraisjButton = new javax.swing.JButton();
        vacasArmazenamentojPanel = new javax.swing.JPanel();
        curraisjScrollPane = new javax.swing.JScrollPane();
        curraisjTable = new javax.swing.JTable();
        voltarCurraisjButton = new javax.swing.JButton();
        idCurraljLabel = new javax.swing.JLabel();
        capacidadeCurraljLabel = new javax.swing.JLabel();
        idCurraljTextField = new javax.swing.JTextField();
        salvarCurraljButton = new javax.swing.JButton();
        cancelarCurraljButton = new javax.swing.JButton();
        tituloCadastroCurraisjLabel = new javax.swing.JLabel();
        capacidadeCurraljSpinner = new javax.swing.JSpinner();
        tituloEntradaCurraisjLabel = new javax.swing.JLabel();
        racaVacajLabel = new javax.swing.JLabel();
        quantidadeEntradaVacajLabel = new javax.swing.JLabel();
        idCurraljComboBox = new javax.swing.JComboBox<>();
        quantidadeEntradaVacasjSpinner = new javax.swing.JSpinner();
        idChiqueirojLabel = new javax.swing.JLabel();
        racaVacajComboBox = new javax.swing.JComboBox<>();
        cancelarEntradaVacasjButton = new javax.swing.JButton();
        registrarEntradaVacasjButton = new javax.swing.JButton();
        tabelaCurraisjLabel = new javax.swing.JLabel();
        silosjPanel = new javax.swing.JPanel();
        silosjScrollPane = new javax.swing.JScrollPane();
        silosjTable = new javax.swing.JTable();
        voltarSilosjButton = new javax.swing.JButton();
        idSilojLabel = new javax.swing.JLabel();
        capacidadeSilojLabel = new javax.swing.JLabel();
        idSilojTextField = new javax.swing.JTextField();
        salvarSilojButton = new javax.swing.JButton();
        cancelarSilojButton = new javax.swing.JButton();
        tituloCadastroSilosjLabel = new javax.swing.JLabel();
        capacidadeSilojSpinner = new javax.swing.JSpinner();
        tituloCadastroSilosjLabel1 = new javax.swing.JLabel();
        produtojLabel = new javax.swing.JLabel();
        quantidadeEntradajLabel = new javax.swing.JLabel();
        IDsilojComboBox = new javax.swing.JComboBox<>();
        quantidadeEntradaProdutojSpinner = new javax.swing.JSpinner();
        iDsilojLabel = new javax.swing.JLabel();
        produtojComboBox = new javax.swing.JComboBox<>();
        cancelarEntradajButton = new javax.swing.JButton();
        registrarEntradajButton = new javax.swing.JButton();
        tabelaSilosjLabel = new javax.swing.JLabel();
        produtosjPanel = new javax.swing.JPanel();
        produtosjScrollPane = new javax.swing.JScrollPane();
        produtosjTable = new javax.swing.JTable();
        voltarProdutosjButton = new javax.swing.JButton();
        produtosjLabel = new javax.swing.JLabel();
        idProdutojLabel = new javax.swing.JLabel();
        idProdutojTextField = new javax.swing.JTextField();
        salvarProdutojButton = new javax.swing.JButton();
        cancelarProdutojButton = new javax.swing.JButton();
        tituloCadastroProdutosjLabel = new javax.swing.JLabel();
        nomeProdutojLabel = new javax.swing.JLabel();
        nomeProdutojTextField = new javax.swing.JTextField();
        valorProdutojLabel = new javax.swing.JLabel();
        consultarArmazenamentojButton = new javax.swing.JButton();
        valorProdutojTextField = new javax.swing.JTextField();
        cadastrojPanel = new javax.swing.JPanel();
        cadastrojLabel = new javax.swing.JLabel();
        nomejTextField = new javax.swing.JTextField();
        CPFjFormattedTextField = new javax.swing.JFormattedTextField();
        cadastroUsuariojTextField = new javax.swing.JTextField();
        cadastroSenhajTextField = new javax.swing.JTextField();
        nomejLabel = new javax.swing.JLabel();
        telefonejFormattedTextField = new javax.swing.JFormattedTextField();
        telefonejLabel = new javax.swing.JLabel();
        CPFjLabel = new javax.swing.JLabel();
        cadastroUsuariojLabel = new javax.swing.JLabel();
        cadastroSenhajLabel = new javax.swing.JLabel();
        confirmarjButton = new javax.swing.JButton();
        voltarjButton = new javax.swing.JButton();
        DDDjFormattedTextField = new javax.swing.JFormattedTextField();
        idUsuariojLabel = new javax.swing.JLabel();
        idUsuariojTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        controlejPanel.setBackground(new java.awt.Color(204, 204, 204));
        controlejPanel.setLayout(new java.awt.CardLayout());

        loginjPanel.setBackground(new java.awt.Color(0, 255, 153));

        usuariojLabel.setText("Usuário:");

        senhajLabel.setText("Senha:");

        entrarjButton.setText("Entrar");
        entrarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarjButtonActionPerformed(evt);
            }
        });

        cadastrarContajButton.setText("Cadastrar conta");
        cadastrarContajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarContajButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginjPanelLayout = new javax.swing.GroupLayout(loginjPanel);
        loginjPanel.setLayout(loginjPanelLayout);
        loginjPanelLayout.setHorizontalGroup(
            loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginjPanelLayout.createSequentialGroup()
                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginjPanelLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(senhajLabel)
                            .addComponent(usuariojLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(senhajTextField)
                            .addComponent(usuariojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(loginjPanelLayout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(entrarjButton))
                    .addGroup(loginjPanelLayout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(cadastrarContajButton)))
                .addContainerGap(342, Short.MAX_VALUE))
        );
        loginjPanelLayout.setVerticalGroup(
            loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginjPanelLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuariojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuariojLabel))
                .addGap(18, 18, 18)
                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhajLabel))
                .addGap(22, 22, 22)
                .addComponent(entrarjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(cadastrarContajButton)
                .addGap(47, 47, 47))
        );

        controlejPanel.add(loginjPanel, "card11");

        menuPrincipaljPanel.setBackground(new java.awt.Color(0, 255, 153));

        sairjButton.setText("Sair");
        sairjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairjButtonActionPerformed(evt);
            }
        });

        produtosjButton.setText("Produtos");
        produtosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtosjButtonActionPerformed(evt);
            }
        });

        plantacoesjButton.setText("Plantações");
        plantacoesjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plantacoesjButtonActionPerformed(evt);
            }
        });

        animaisjButton.setText("Animais");
        animaisjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animaisjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPrincipaljPanelLayout = new javax.swing.GroupLayout(menuPrincipaljPanel);
        menuPrincipaljPanel.setLayout(menuPrincipaljPanelLayout);
        menuPrincipaljPanelLayout.setHorizontalGroup(
            menuPrincipaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPrincipaljPanelLayout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addGroup(menuPrincipaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, menuPrincipaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(plantacoesjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(produtosjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(animaisjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sairjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(340, Short.MAX_VALUE))
        );
        menuPrincipaljPanelLayout.setVerticalGroup(
            menuPrincipaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPrincipaljPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(animaisjButton)
                .addGap(42, 42, 42)
                .addComponent(plantacoesjButton)
                .addGap(43, 43, 43)
                .addComponent(produtosjButton)
                .addGap(51, 51, 51)
                .addComponent(sairjButton)
                .addGap(109, 109, 109))
        );

        controlejPanel.add(menuPrincipaljPanel, "card3");

        menuAnimaisjPanel.setBackground(new java.awt.Color(0, 255, 153));

        voltarMenuAnimaisjButton.setText("<<<");
        voltarMenuAnimaisjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarMenuAnimaisjButtonActionPerformed(evt);
            }
        });

        galinhasjButton.setText("Galinhas");
        galinhasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                galinhasjButtonActionPerformed(evt);
            }
        });

        porcosjButton.setText("Porcos");
        porcosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porcosjButtonActionPerformed(evt);
            }
        });

        vacasjButton.setText("Vacas");
        vacasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vacasjButtonActionPerformed(evt);
            }
        });

        ovelhasjButton.setText("Ovelhas");
        ovelhasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovelhasjButtonActionPerformed(evt);
            }
        });

        abrigosjLabel.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
        abrigosjLabel.setText("Animais");

        javax.swing.GroupLayout menuAnimaisjPanelLayout = new javax.swing.GroupLayout(menuAnimaisjPanel);
        menuAnimaisjPanel.setLayout(menuAnimaisjPanelLayout);
        menuAnimaisjPanelLayout.setHorizontalGroup(
            menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuAnimaisjPanelLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuAnimaisjPanelLayout.createSequentialGroup()
                        .addComponent(abrigosjLabel)
                        .addGap(234, 234, 234))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuAnimaisjPanelLayout.createSequentialGroup()
                        .addGroup(menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(menuAnimaisjPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(voltarMenuAnimaisjButton))
                            .addGroup(menuAnimaisjPanelLayout.createSequentialGroup()
                                .addComponent(galinhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(porcosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(ovelhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addComponent(vacasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49))))
        );
        menuAnimaisjPanelLayout.setVerticalGroup(
            menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuAnimaisjPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(abrigosjLabel)
                .addGap(111, 111, 111)
                .addGroup(menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(porcosjButton)
                    .addComponent(galinhasjButton)
                    .addComponent(ovelhasjButton)
                    .addComponent(vacasjButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(voltarMenuAnimaisjButton)
                .addGap(37, 37, 37))
        );

        controlejPanel.add(menuAnimaisjPanel, "card4");

        galinhasjPanel.setBackground(new java.awt.Color(0, 255, 153));

        galinhasjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Raça", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        galinhasjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                galinhasjTableMouseClicked(evt);
            }
        });
        galinhasjScrollPane.setViewportView(galinhasjTable);

        voltarGalinhajButton.setText("<<<");
        voltarGalinhajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarGalinhajButtonActionPerformed(evt);
            }
        });

        abrigosGalinhasjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        abrigosGalinhasjLabel.setText("Raças");

        idGalinhajLabel.setText("ID:");

        nomeGalinhajLabel.setText("Nome da raça:");

        valorGalinhajLabel.setText("Valor:");

        idGalinhajTextField.setEditable(false);

        salvarGalinhajButton.setText("Salvar");
        salvarGalinhajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarGalinhajButtonActionPerformed(evt);
            }
        });

        cancelarGalinhajButton.setText("Cancelar");
        cancelarGalinhajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarGalinhajButtonActionPerformed(evt);
            }
        });

        tituloCadastroGalinhasjLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloCadastroGalinhasjLabel1.setText("Cadastro de raça de galinha");

        consultarGalinheirosjButton.setText("Consultar galinheiros");
        consultarGalinheirosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarGalinheirosjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout galinhasjPanelLayout = new javax.swing.GroupLayout(galinhasjPanel);
        galinhasjPanel.setLayout(galinhasjPanelLayout);
        galinhasjPanelLayout.setHorizontalGroup(
            galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(galinhasjPanelLayout.createSequentialGroup()
                .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, galinhasjPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltarGalinhajButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, galinhasjPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(abrigosGalinhasjLabel)
                            .addComponent(galinhasjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloCadastroGalinhasjLabel1)
                            .addGroup(galinhasjPanelLayout.createSequentialGroup()
                                .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idGalinhajLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nomeGalinhajLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(valorGalinhajLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(consultarGalinheirosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(idGalinhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(galinhasjPanelLayout.createSequentialGroup()
                                            .addComponent(cancelarGalinhajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(salvarGalinhajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(racaGalinhajTextField)
                                        .addComponent(valorGalinhajTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(66, 66, 66))
        );
        galinhasjPanelLayout.setVerticalGroup(
            galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(galinhasjPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abrigosGalinhasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCadastroGalinhasjLabel1))
                .addGap(21, 21, 21)
                .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(galinhasjPanelLayout.createSequentialGroup()
                        .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idGalinhajLabel)
                            .addComponent(idGalinhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeGalinhajLabel)
                            .addComponent(racaGalinhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorGalinhajLabel)
                            .addComponent(valorGalinhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarGalinhajButton)
                            .addComponent(salvarGalinhajButton))
                        .addGap(43, 43, 43)
                        .addComponent(consultarGalinheirosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(galinhasjScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(voltarGalinhajButton)
                .addGap(58, 58, 58))
        );

        controlejPanel.add(galinhasjPanel, "card5");

        galinhasArmazenamentojPanel.setBackground(new java.awt.Color(0, 255, 153));

        galinheirosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "qtdGalinhas", "Capacidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        galinheirosjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                galinheirosjTableMouseClicked(evt);
            }
        });
        galinheirosjScrollPane.setViewportView(galinheirosjTable);

        voltarGalinheirosjButton.setText("<<<");
        voltarGalinheirosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarGalinheirosjButtonActionPerformed(evt);
            }
        });

        idGalinheirojLabel.setText("ID:");

        capacidadeGalinheirojLabel.setText("Capacidade:");

        idGalinheirojTextField.setEditable(false);

        salvarGalinheirojButton.setText("Salvar");
        salvarGalinheirojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarGalinheirojButtonActionPerformed(evt);
            }
        });

        cancelarGalinheirosjButton.setText("Cancelar");
        cancelarGalinheirosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarGalinheirosjButtonActionPerformed(evt);
            }
        });

        tituloCadastroGalinheirosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloCadastroGalinheirosjLabel.setText("Novo galinheiro");

        tituloEntradaGalinhasjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloEntradaGalinhasjLabel.setText("Registrar entrada de galinhas");

        racajLabel.setText("Raça:");

        quantidadeEntradaGalinhajLabel.setText("Quantidade:");

        idGalinheirojComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Nenhum>" }));

        idGalinheirojLabel1.setText("ID Galinheiro:");

        racaGalinhajComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"<Nenhum>", "Leite", "Ovo"}));

        cancelarEntradaGalinhasjButton.setText("Cancelar");
        cancelarEntradaGalinhasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEntradaGalinhasjButtonActionPerformed(evt);
            }
        });

        registrarEntradaGalinhasjButton.setText("Registrar");
        registrarEntradaGalinhasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarEntradaGalinhasjButtonActionPerformed(evt);
            }
        });

        tabelaGalinheirosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tabelaGalinheirosjLabel.setText("Galinheiros");

        javax.swing.GroupLayout galinhasArmazenamentojPanelLayout = new javax.swing.GroupLayout(galinhasArmazenamentojPanel);
        galinhasArmazenamentojPanel.setLayout(galinhasArmazenamentojPanelLayout);
        galinhasArmazenamentojPanelLayout.setHorizontalGroup(
            galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, galinhasArmazenamentojPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(galinhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idGalinheirojLabel)
                            .addComponent(capacidadeGalinheirojLabel))
                        .addGap(12, 12, 12)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(capacidadeGalinheirojSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(idGalinheirojTextField)))
                    .addComponent(tituloEntradaGalinhasjLabel)
                    .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(galinhasArmazenamentojPanelLayout.createSequentialGroup()
                            .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(idGalinheirojLabel1)
                                .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantidadeEntradaGalinhajLabel)
                                    .addComponent(racajLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(racaGalinhajComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantidadeEntradaGalinhasjSpinner)
                                .addComponent(idGalinheirojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, galinhasArmazenamentojPanelLayout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(cancelarEntradaGalinhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(registrarEntradaGalinhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(galinhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addComponent(cancelarGalinheirosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(salvarGalinheirojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tituloCadastroGalinheirosjLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(galinhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(voltarGalinheirosjButton))
                    .addComponent(tabelaGalinheirosjLabel)
                    .addComponent(galinheirosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        galinhasArmazenamentojPanelLayout.setVerticalGroup(
            galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(galinhasArmazenamentojPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloCadastroGalinheirosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabelaGalinheirosjLabel))
                .addGap(21, 21, 21)
                .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(galinhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idGalinheirojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idGalinheirojLabel))
                        .addGap(18, 18, 18)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(capacidadeGalinheirojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capacidadeGalinheirojLabel))
                        .addGap(18, 18, 18)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salvarGalinheirojButton)
                            .addComponent(cancelarGalinheirosjButton))
                        .addGap(47, 47, 47)
                        .addComponent(tituloEntradaGalinhasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(racajLabel)
                            .addComponent(racaGalinhajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantidadeEntradaGalinhajLabel)
                            .addComponent(quantidadeEntradaGalinhasjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idGalinheirojLabel1)
                            .addComponent(idGalinheirojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(galinheirosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(galinhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registrarEntradaGalinhasjButton)
                            .addComponent(cancelarEntradaGalinhasjButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, galinhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(voltarGalinheirosjButton)
                        .addGap(38, 38, 38))))
        );

        controlejPanel.add(galinhasArmazenamentojPanel, "card5");

        porcosjPanel.setBackground(new java.awt.Color(0, 255, 153));

        porcosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Raça", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        porcosjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                porcosjTableMouseClicked(evt);
            }
        });
        porcosjScrollPane.setViewportView(porcosjTable);

        voltarPorcosjButton.setText("<<<");
        voltarPorcosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarPorcosjButtonActionPerformed(evt);
            }
        });

        racasPorcosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        racasPorcosjLabel.setText("Raças");

        idPorcojLabel.setText("ID:");

        nomePorcojLabel.setText("Nome da raça:");

        idPorcojTextField.setEditable(false);

        salvarPorcojButton.setText("Salvar");
        salvarPorcojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarPorcojButtonActionPerformed(evt);
            }
        });

        cancelarPorcojButton.setText("Cancelar");
        cancelarPorcojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPorcojButtonActionPerformed(evt);
            }
        });

        tituloCadastroPorcojLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloCadastroPorcojLabel.setText("Cadastro de raça porco");

        valorPorcojLabel.setText("Valor:");

        consultarChiqueirosjButton.setText("Consultar chiqueiros");
        consultarChiqueirosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarChiqueirosjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout porcosjPanelLayout = new javax.swing.GroupLayout(porcosjPanel);
        porcosjPanel.setLayout(porcosjPanelLayout);
        porcosjPanelLayout.setHorizontalGroup(
            porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(porcosjPanelLayout.createSequentialGroup()
                .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, porcosjPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltarPorcosjButton))
                    .addGroup(porcosjPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(porcosjPanelLayout.createSequentialGroup()
                                .addComponent(racasPorcosjLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE))
                            .addGroup(porcosjPanelLayout.createSequentialGroup()
                                .addComponent(porcosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(63, 63, 63)))
                        .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(porcosjPanelLayout.createSequentialGroup()
                                .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idPorcojLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nomePorcojLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idPorcojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(racaPorcojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tituloCadastroPorcojLabel)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, porcosjPanelLayout.createSequentialGroup()
                                .addComponent(valorPorcojLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(porcosjPanelLayout.createSequentialGroup()
                                        .addComponent(cancelarPorcojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(salvarPorcojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(valorPorcojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(consultarChiqueirosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(47, 47, 47)))
                .addGap(32, 32, 32))
        );
        porcosjPanelLayout.setVerticalGroup(
            porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(porcosjPanelLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(racasPorcosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCadastroPorcojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(porcosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(porcosjPanelLayout.createSequentialGroup()
                        .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idPorcojLabel)
                            .addComponent(idPorcojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomePorcojLabel)
                            .addComponent(racaPorcojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorPorcojLabel)
                            .addComponent(valorPorcojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarPorcojButton)
                            .addComponent(salvarPorcojButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(consultarChiqueirosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(voltarPorcosjButton)
                .addGap(27, 27, 27))
        );

        controlejPanel.add(porcosjPanel, "card5");

        porcosArmazenamentojPanel.setBackground(new java.awt.Color(0, 255, 153));

        chiqueirosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "qtdPorcos", "Capacidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        chiqueirosjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chiqueirosjTableMouseClicked(evt);
            }
        });
        chiqueirosjScrollPane.setViewportView(chiqueirosjTable);

        voltarChiqueirosjButton1.setText("<<<");
        voltarChiqueirosjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarChiqueirosjButton1ActionPerformed(evt);
            }
        });

        idChiqueirosjLabel.setText("ID:");

        capacidadeChiqueirosjLabel.setText("Capacidade:");

        idChiqueirojTextField.setEditable(false);

        salvarChiqueirosjButton.setText("Salvar");
        salvarChiqueirosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarChiqueirosjButtonActionPerformed(evt);
            }
        });

        cancelarChiqueirojButton.setText("Cancelar");
        cancelarChiqueirojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarChiqueirojButtonActionPerformed(evt);
            }
        });

        tituloCadastroChiqueirosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloCadastroChiqueirosjLabel.setText("Novo chiqueiro");

        tituloEntradaChiqueirosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloEntradaChiqueirosjLabel.setText("Registrar entrada de porcos");

        racaPorcojLabel.setText("Raça:");

        quantidadeEntradaPorcojLabel.setText("Quantidade:");

        idChiqueirojComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        idEntradaChiqueirojLabel.setText("ID Chiqueiro:");

        racaPorcojComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"<Nenhum>", "Leite", "Ovo"}));

        cancelarEntradaPorcosjButton.setText("Cancelar");
        cancelarEntradaPorcosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEntradaPorcosjButtonActionPerformed(evt);
            }
        });

        registrarEntradaPorcosjButton.setText("Registrar");
        registrarEntradaPorcosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarEntradaPorcosjButtonActionPerformed(evt);
            }
        });

        tabelaPorcosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tabelaPorcosjLabel.setText("Chiqueiros");

        javax.swing.GroupLayout porcosArmazenamentojPanelLayout = new javax.swing.GroupLayout(porcosArmazenamentojPanel);
        porcosArmazenamentojPanel.setLayout(porcosArmazenamentojPanelLayout);
        porcosArmazenamentojPanelLayout.setHorizontalGroup(
            porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, porcosArmazenamentojPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idChiqueirosjLabel)
                            .addComponent(capacidadeChiqueirosjLabel))
                        .addGap(12, 12, 12)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(capacidadeChiqueirojSpinner)
                            .addComponent(idChiqueirojTextField))
                        .addGap(200, 200, 200))
                    .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloEntradaChiqueirosjLabel)
                            .addComponent(tituloCadastroChiqueirosjLabel)
                            .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                                .addComponent(cancelarChiqueirojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(salvarChiqueirosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                                    .addComponent(cancelarEntradaPorcosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(registrarEntradaPorcosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                                    .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(idEntradaChiqueirojLabel)
                                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quantidadeEntradaPorcojLabel)
                                            .addComponent(racaPorcojLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(racaPorcojComboBox, 0, 152, Short.MAX_VALUE)
                                        .addComponent(quantidadeEntradaPorcosjSpinner)
                                        .addComponent(idChiqueirojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(164, 164, 164)))
                .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(voltarChiqueirosjButton1))
                    .addComponent(tabelaPorcosjLabel)
                    .addComponent(chiqueirosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        porcosArmazenamentojPanelLayout.setVerticalGroup(
            porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloCadastroChiqueirosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabelaPorcosjLabel))
                .addGap(21, 21, 21)
                .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idChiqueirojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idChiqueirosjLabel))
                        .addGap(18, 18, 18)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(capacidadeChiqueirojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capacidadeChiqueirosjLabel))
                        .addGap(18, 18, 18)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarChiqueirojButton)
                            .addComponent(salvarChiqueirosjButton))
                        .addGap(41, 41, 41)
                        .addComponent(tituloEntradaChiqueirosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(racaPorcojLabel)
                            .addComponent(racaPorcojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantidadeEntradaPorcojLabel)
                            .addComponent(quantidadeEntradaPorcosjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idEntradaChiqueirojLabel)
                            .addComponent(idChiqueirojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(chiqueirosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(voltarChiqueirosjButton1))
                    .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarEntradaPorcosjButton)
                            .addComponent(registrarEntradaPorcosjButton))))
                .addGap(38, 38, 38))
        );

        controlejPanel.add(porcosArmazenamentojPanel, "card5");

        ovelhasjPanel.setBackground(new java.awt.Color(0, 255, 153));

        ovelhasjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Cor", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ovelhasjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ovelhasjTableMouseClicked(evt);
            }
        });
        ovelhasjScrollPane.setViewportView(ovelhasjTable);

        voltarOvelhasjButton.setText("<<<");
        voltarOvelhasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarOvelhasjButtonActionPerformed(evt);
            }
        });

        abrigosOvelhasjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        abrigosOvelhasjLabel.setText("Apriscos");

        idOvelhajLabel.setText("ID:");

        corOvelhajLabel.setText("Cor:");

        idOvelhajTextField.setEditable(false);

        salvarOvelhajButton.setText("Salvar");
        salvarOvelhajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarOvelhajButtonActionPerformed(evt);
            }
        });

        cancelarOvelhajButton.setText("Cancelar");
        cancelarOvelhajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarOvelhajButtonActionPerformed(evt);
            }
        });

        tituloCadastroOvelhasjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloCadastroOvelhasjLabel.setText("Cadastro de ovelhas");

        valorOvelhajLabel.setText("Valor:");

        valorOvelhajTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorOvelhajTextFieldActionPerformed(evt);
            }
        });

        consultarApriscosjButton.setText("Consultar apriscos");
        consultarApriscosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarApriscosjButtonActionPerformed(evt);
            }
        });

        corOvelhajTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corOvelhajTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ovelhasjPanelLayout = new javax.swing.GroupLayout(ovelhasjPanel);
        ovelhasjPanel.setLayout(ovelhasjPanelLayout);
        ovelhasjPanelLayout.setHorizontalGroup(
            ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ovelhasjPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(abrigosOvelhasjLabel)
                    .addComponent(ovelhasjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ovelhasjPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(idOvelhajLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idOvelhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloCadastroOvelhasjLabel))
                        .addGap(103, 103, 103))
                    .addGroup(ovelhasjPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(corOvelhajLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(valorOvelhajLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(valorOvelhajTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(consultarApriscosjButton, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ovelhasjPanelLayout.createSequentialGroup()
                                .addComponent(cancelarOvelhajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(salvarOvelhajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(corOvelhajTextField))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ovelhasjPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltarOvelhasjButton)
                .addGap(52, 52, 52))
        );
        ovelhasjPanelLayout.setVerticalGroup(
            ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ovelhasjPanelLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abrigosOvelhasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCadastroOvelhasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ovelhasjPanelLayout.createSequentialGroup()
                        .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idOvelhajLabel)
                            .addComponent(idOvelhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(corOvelhajLabel)
                            .addComponent(corOvelhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorOvelhajLabel)
                            .addComponent(valorOvelhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarOvelhajButton)
                            .addComponent(salvarOvelhajButton))
                        .addGap(43, 43, 43)
                        .addComponent(consultarApriscosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ovelhasjScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(voltarOvelhasjButton)
                .addGap(54, 54, 54))
        );

        controlejPanel.add(ovelhasjPanel, "card5");

        ovelhasArmazenamentojPanel.setBackground(new java.awt.Color(0, 255, 153));

        apriscosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "qtdOvelhas", "Capacidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        apriscosjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apriscosjTableMouseClicked(evt);
            }
        });
        apriscosjScrollPane.setViewportView(apriscosjTable);

        voltarApriscosjButton.setText("<<<");
        voltarApriscosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarApriscosjButtonActionPerformed(evt);
            }
        });

        idApriscojLabel.setText("ID:");

        capacidadeApriscojLabel.setText("Capacidade:");

        idApriscojTextField.setEditable(false);

        salvarApriscojButton.setText("Salvar");
        salvarApriscojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarApriscojButtonActionPerformed(evt);
            }
        });

        cancelarApriscojButton.setText("Cancelar");
        cancelarApriscojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarApriscojButtonActionPerformed(evt);
            }
        });

        tituloCadastroApriscosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloCadastroApriscosjLabel.setText("Novo aprisco");

        tituloEntradaOvelhasjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloEntradaOvelhasjLabel.setText("Registrar entrada de ovelhas");

        racaOvelhasjLabel.setText("Cor:");

        quantidadeEntradaOvelhajLabel.setText("Quantidade:");

        idApriscojComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idApriscojComboBoxActionPerformed(evt);
            }
        });

        idEntradaApriscojLabel.setText("ID Aprisco:");

        corEntradaOvelhajComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"<Nenhum>", "Leite", "Ovo"}));

        cancelarEntradaOvelhasjButton.setText("Cancelar");
        cancelarEntradaOvelhasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEntradaOvelhasjButtonActionPerformed(evt);
            }
        });

        registrarEntradaOvelhasjButton.setText("Registrar");
        registrarEntradaOvelhasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarEntradaOvelhasjButtonActionPerformed(evt);
            }
        });

        tabelaOvelhasjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tabelaOvelhasjLabel.setText("Apriscos");

        javax.swing.GroupLayout ovelhasArmazenamentojPanelLayout = new javax.swing.GroupLayout(ovelhasArmazenamentojPanel);
        ovelhasArmazenamentojPanel.setLayout(ovelhasArmazenamentojPanelLayout);
        ovelhasArmazenamentojPanelLayout.setHorizontalGroup(
            ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloEntradaOvelhasjLabel)
                    .addGroup(ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idEntradaApriscojLabel)
                            .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(quantidadeEntradaOvelhajLabel)
                                .addComponent(racaOvelhasjLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(corEntradaOvelhajComboBox, 0, 154, Short.MAX_VALUE)
                            .addComponent(quantidadeEntradaOvelhasjSpinner)
                            .addComponent(idApriscojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tituloCadastroApriscosjLabel)
                    .addGroup(ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addComponent(cancelarEntradaOvelhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(registrarEntradaOvelhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(capacidadeApriscojLabel)
                            .addComponent(idApriscojLabel))
                        .addGap(12, 12, 12)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idApriscojTextField)
                            .addGroup(ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                                .addComponent(capacidadeApriscojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addComponent(cancelarApriscojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(salvarApriscojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(voltarApriscosjButton))
                    .addComponent(tabelaOvelhasjLabel)
                    .addComponent(apriscosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        ovelhasArmazenamentojPanelLayout.setVerticalGroup(
            ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloCadastroApriscosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabelaOvelhasjLabel))
                .addGap(18, 18, 18)
                .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idApriscojLabel)
                            .addComponent(idApriscojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(capacidadeApriscojLabel)
                            .addComponent(capacidadeApriscojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salvarApriscojButton)
                            .addComponent(cancelarApriscojButton))
                        .addGap(47, 47, 47)
                        .addComponent(tituloEntradaOvelhasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(racaOvelhasjLabel)
                            .addComponent(corEntradaOvelhajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantidadeEntradaOvelhajLabel)
                            .addComponent(quantidadeEntradaOvelhasjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idEntradaApriscojLabel)
                            .addComponent(idApriscojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(apriscosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarEntradaOvelhasjButton)
                            .addComponent(registrarEntradaOvelhasjButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(voltarApriscosjButton)
                        .addGap(38, 38, 38))))
        );

        controlejPanel.add(ovelhasArmazenamentojPanel, "card5");

        vacasjPanel.setBackground(new java.awt.Color(0, 255, 153));

        vacasjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Raça", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        vacasjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vacasjTableMouseClicked(evt);
            }
        });
        vacasjScrollPane.setViewportView(vacasjTable);

        voltarVacasjButton.setText("<<<");
        voltarVacasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarVacasjButtonActionPerformed(evt);
            }
        });

        vacasjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        vacasjLabel.setText("Vacas");

        idVacajLabel.setText("ID:");

        nomeVacajLabel.setText("Nome da raça:");

        idVacajTextField.setEditable(false);

        salvarVacajButton.setText("Salvar");
        salvarVacajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarVacajButtonActionPerformed(evt);
            }
        });

        cancelarVacajButton.setText("Cancelar");
        cancelarVacajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarVacajButtonActionPerformed(evt);
            }
        });

        tituloCadastroVacasjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloCadastroVacasjLabel.setText("Cadastro de raças de vacas");

        valorVacajLabel.setText("Valor:");

        consultarCurraisjButton.setText("Consultar currais");
        consultarCurraisjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarCurraisjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vacasjPanelLayout = new javax.swing.GroupLayout(vacasjPanel);
        vacasjPanel.setLayout(vacasjPanelLayout);
        vacasjPanelLayout.setHorizontalGroup(
            vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vacasjPanelLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vacasjPanelLayout.createSequentialGroup()
                        .addComponent(voltarVacasjButton)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vacasjPanelLayout.createSequentialGroup()
                        .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vacasjLabel)
                            .addComponent(vacasjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(vacasjPanelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(tituloCadastroVacasjLabel))
                            .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(consultarCurraisjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(vacasjPanelLayout.createSequentialGroup()
                                    .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(idVacajLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(nomeVacajLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(valorVacajLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(idVacajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(racaVacajTextField)
                                        .addGroup(vacasjPanelLayout.createSequentialGroup()
                                            .addComponent(cancelarVacajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(salvarVacajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(valorVacajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(64, 64, 64))))
        );
        vacasjPanelLayout.setVerticalGroup(
            vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vacasjPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vacasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCadastroVacasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vacasjPanelLayout.createSequentialGroup()
                        .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idVacajLabel)
                            .addComponent(idVacajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeVacajLabel)
                            .addComponent(racaVacajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorVacajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorVacajLabel))
                        .addGap(18, 18, 18)
                        .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarVacajButton)
                            .addComponent(salvarVacajButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(consultarCurraisjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(vacasjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(64, 64, 64)
                .addComponent(voltarVacasjButton)
                .addGap(27, 27, 27))
        );

        controlejPanel.add(vacasjPanel, "card5");

        vacasArmazenamentojPanel.setBackground(new java.awt.Color(0, 255, 153));

        curraisjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "qtdVacas", "Capacidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        curraisjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                curraisjTableMouseClicked(evt);
            }
        });
        curraisjScrollPane.setViewportView(curraisjTable);

        voltarCurraisjButton.setText("<<<");
        voltarCurraisjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarCurraisjButtonActionPerformed(evt);
            }
        });

        idCurraljLabel.setText("ID:");

        capacidadeCurraljLabel.setText("Capacidade:");

        idCurraljTextField.setEditable(false);

        salvarCurraljButton.setText("Salvar");
        salvarCurraljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarCurraljButtonActionPerformed(evt);
            }
        });

        cancelarCurraljButton.setText("Cancelar");
        cancelarCurraljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCurraljButtonActionPerformed(evt);
            }
        });

        tituloCadastroCurraisjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloCadastroCurraisjLabel.setText("Novo curral");

        tituloEntradaCurraisjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloEntradaCurraisjLabel.setText("Registrar entrada de vacas");

        racaVacajLabel.setText("Raça:");

        quantidadeEntradaVacajLabel.setText("Quantidade:");

        idCurraljComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        idChiqueirojLabel.setText("ID Chiqueiro:");

        racaVacajComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"<Nenhum>", "Leite", "Ovo"}));

        cancelarEntradaVacasjButton.setText("Cancelar");
        cancelarEntradaVacasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEntradaVacasjButtonActionPerformed(evt);
            }
        });

        registrarEntradaVacasjButton.setText("Registrar");
        registrarEntradaVacasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarEntradaVacasjButtonActionPerformed(evt);
            }
        });

        tabelaCurraisjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tabelaCurraisjLabel.setText("Currais");

        javax.swing.GroupLayout vacasArmazenamentojPanelLayout = new javax.swing.GroupLayout(vacasArmazenamentojPanel);
        vacasArmazenamentojPanel.setLayout(vacasArmazenamentojPanelLayout);
        vacasArmazenamentojPanelLayout.setHorizontalGroup(
            vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloEntradaCurraisjLabel)
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idChiqueirojLabel)
                            .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(quantidadeEntradaVacajLabel)
                                .addComponent(racaVacajLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(racaVacajComboBox, 0, 154, Short.MAX_VALUE)
                            .addComponent(quantidadeEntradaVacasjSpinner)
                            .addComponent(idCurraljComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tituloCadastroCurraisjLabel)
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addComponent(cancelarEntradaVacasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(registrarEntradaVacasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addComponent(cancelarCurraljButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(salvarCurraljButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idCurraljLabel)
                            .addComponent(capacidadeCurraljLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(capacidadeCurraljSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(idCurraljTextField))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(voltarCurraisjButton))
                    .addComponent(tabelaCurraisjLabel)
                    .addComponent(curraisjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        vacasArmazenamentojPanelLayout.setVerticalGroup(
            vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloCadastroCurraisjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabelaCurraisjLabel))
                .addGap(21, 21, 21)
                .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idCurraljTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idCurraljLabel))
                        .addGap(18, 18, 18)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(capacidadeCurraljLabel)
                            .addComponent(capacidadeCurraljSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarCurraljButton)
                            .addComponent(salvarCurraljButton))
                        .addGap(41, 41, 41)
                        .addComponent(tituloEntradaCurraisjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(racaVacajLabel)
                            .addComponent(racaVacajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantidadeEntradaVacajLabel)
                            .addComponent(quantidadeEntradaVacasjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idChiqueirojLabel)
                            .addComponent(idCurraljComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(curraisjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarEntradaVacasjButton)
                            .addComponent(registrarEntradaVacasjButton)))
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(voltarCurraisjButton)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        controlejPanel.add(vacasArmazenamentojPanel, "card5");

        silosjPanel.setBackground(new java.awt.Color(0, 255, 153));

        silosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "qtdProdutos", "Espaco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        silosjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                silosjTableMouseClicked(evt);
            }
        });
        silosjScrollPane.setViewportView(silosjTable);

        voltarSilosjButton.setText("<<<");
        voltarSilosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarSilosjButtonActionPerformed(evt);
            }
        });

        idSilojLabel.setText("ID:");

        capacidadeSilojLabel.setText("Capacidade:");

        idSilojTextField.setEditable(false);

        salvarSilojButton.setText("Salvar");
        salvarSilojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarSilojButtonActionPerformed(evt);
            }
        });

        cancelarSilojButton.setText("Cancelar");
        cancelarSilojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarSilojButtonActionPerformed(evt);
            }
        });

        tituloCadastroSilosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloCadastroSilosjLabel.setText("Novo silo");

        tituloCadastroSilosjLabel1.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloCadastroSilosjLabel1.setText("Registrar entrada de estoque");

        produtojLabel.setText("Produto:");

        quantidadeEntradajLabel.setText("Quantidade:");

        IDsilojComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        iDsilojLabel.setText("ID Silo:");

        produtojComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"<Nenhum>", "Leite", "Ovo"}));

        cancelarEntradajButton.setText("Cancelar");
        cancelarEntradajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEntradajButtonActionPerformed(evt);
            }
        });

        registrarEntradajButton.setText("Registrar");
        registrarEntradajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarEntradajButtonActionPerformed(evt);
            }
        });

        tabelaSilosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tabelaSilosjLabel.setText("Silos");

        javax.swing.GroupLayout silosjPanelLayout = new javax.swing.GroupLayout(silosjPanel);
        silosjPanel.setLayout(silosjPanelLayout);
        silosjPanelLayout.setHorizontalGroup(
            silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, silosjPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(silosjPanelLayout.createSequentialGroup()
                        .addComponent(tituloCadastroSilosjLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(silosjPanelLayout.createSequentialGroup()
                        .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cancelarSilojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(silosjPanelLayout.createSequentialGroup()
                                        .addComponent(capacidadeSilojLabel)
                                        .addGap(12, 12, 12)
                                        .addComponent(capacidadeSilojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(silosjPanelLayout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addComponent(salvarSilojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(silosjPanelLayout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(idSilojLabel)
                                    .addGap(12, 12, 12)
                                    .addComponent(idSilojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tituloCadastroSilosjLabel1)
                            .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(iDsilojLabel)
                                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantidadeEntradajLabel)
                                    .addComponent(produtojLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(silosjPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(cancelarEntradajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, silosjPanelLayout.createSequentialGroup()
                                    .addGap(150, 150, 150)
                                    .addComponent(registrarEntradajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(produtojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(quantidadeEntradaProdutojSpinner)
                                    .addComponent(IDsilojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)))
                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(silosjPanelLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(voltarSilosjButton))
                    .addComponent(tabelaSilosjLabel)
                    .addComponent(silosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        silosjPanelLayout.setVerticalGroup(
            silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(silosjPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloCadastroSilosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabelaSilosjLabel))
                .addGap(21, 21, 21)
                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(silosjPanelLayout.createSequentialGroup()
                        .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idSilojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idSilojLabel))
                        .addGap(18, 18, 18)
                        .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(capacidadeSilojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capacidadeSilojLabel))
                        .addGap(18, 18, 18)
                        .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarSilojButton)
                            .addComponent(salvarSilojButton))
                        .addGap(41, 41, 41)
                        .addComponent(tituloCadastroSilosjLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(produtojLabel)
                            .addComponent(produtojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantidadeEntradajLabel)
                            .addComponent(quantidadeEntradaProdutojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iDsilojLabel)
                            .addComponent(IDsilojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(silosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(silosjPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registrarEntradajButton)
                            .addComponent(cancelarEntradajButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, silosjPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(voltarSilosjButton)
                        .addGap(38, 38, 38))))
        );

        controlejPanel.add(silosjPanel, "card5");

        produtosjPanel.setBackground(new java.awt.Color(0, 255, 153));

        produtosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Estoque", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        produtosjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                produtosjTableMouseClicked(evt);
            }
        });
        produtosjScrollPane.setViewportView(produtosjTable);

        voltarProdutosjButton.setText("<<<");
        voltarProdutosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarProdutosjButtonActionPerformed(evt);
            }
        });

        produtosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        produtosjLabel.setText("Produtos");

        idProdutojLabel.setText("ID:");

        idProdutojTextField.setEditable(false);

        salvarProdutojButton.setText("Salvar");
        salvarProdutojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarProdutojButtonActionPerformed(evt);
            }
        });

        cancelarProdutojButton.setText("Cancelar");
        cancelarProdutojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarProdutojButtonActionPerformed(evt);
            }
        });

        tituloCadastroProdutosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tituloCadastroProdutosjLabel.setText("Adicionar novo produto");

        nomeProdutojLabel.setText("Nome:");

        valorProdutojLabel.setText("Valor:");

        consultarArmazenamentojButton.setText("Consultar armazenamento");
        consultarArmazenamentojButton.setPreferredSize(new java.awt.Dimension(198, 23));
        consultarArmazenamentojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarArmazenamentojButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout produtosjPanelLayout = new javax.swing.GroupLayout(produtosjPanel);
        produtosjPanel.setLayout(produtosjPanelLayout);
        produtosjPanelLayout.setHorizontalGroup(
            produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, produtosjPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltarProdutosjButton)
                .addGap(32, 32, 32))
            .addGroup(produtosjPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(produtosjLabel)
                    .addComponent(produtosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(consultarArmazenamentojButton, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloCadastroProdutosjLabel)
                    .addGroup(produtosjPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorProdutojLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeProdutojLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(produtosjPanelLayout.createSequentialGroup()
                                .addComponent(cancelarProdutojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(salvarProdutojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nomeProdutojTextField)
                            .addComponent(valorProdutojTextField)))
                    .addGroup(produtosjPanelLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(idProdutojLabel)
                        .addGap(18, 18, 18)
                        .addComponent(idProdutojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        produtosjPanelLayout.setVerticalGroup(
            produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(produtosjPanelLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(produtosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCadastroProdutosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(produtosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(produtosjPanelLayout.createSequentialGroup()
                        .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idProdutojLabel)
                            .addComponent(idProdutojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeProdutojLabel)
                            .addComponent(nomeProdutojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorProdutojLabel)
                            .addComponent(valorProdutojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarProdutojButton)
                            .addComponent(salvarProdutojButton))))
                .addGap(18, 18, 18)
                .addComponent(consultarArmazenamentojButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(voltarProdutosjButton)
                .addGap(27, 27, 27))
        );

        controlejPanel.add(produtosjPanel, "card5");

        cadastrojPanel.setBackground(new java.awt.Color(0, 255, 153));

        cadastrojLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        cadastrojLabel.setText("Realize seu novo cadastro");

        try {
            CPFjFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        nomejLabel.setText("Nome completo:");

        try {
            telefonejFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        telefonejLabel.setText("DDD e Telefone:");

        CPFjLabel.setText("CPF:");

        cadastroUsuariojLabel.setText("Usuário");

        cadastroSenhajLabel.setText("Senha:");

        confirmarjButton.setText("Confirmar");
        confirmarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarjButtonActionPerformed(evt);
            }
        });

        voltarjButton.setText("Voltar ao acesso");
        voltarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarjButtonActionPerformed(evt);
            }
        });

        try {
            DDDjFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        idUsuariojLabel.setText("ID:");

        idUsuariojTextField.setEditable(false);

        javax.swing.GroupLayout cadastrojPanelLayout = new javax.swing.GroupLayout(cadastrojPanel);
        cadastrojPanel.setLayout(cadastrojPanelLayout);
        cadastrojPanelLayout.setHorizontalGroup(
            cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrojPanelLayout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrojPanelLayout.createSequentialGroup()
                        .addComponent(cadastrojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadastrojPanelLayout.createSequentialGroup()
                            .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CPFjLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cadastroUsuariojLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cadastroSenhajLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(cadastrojPanelLayout.createSequentialGroup()
                                    .addComponent(telefonejLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DDDjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(nomejLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(idUsuariojLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CPFjFormattedTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telefonejFormattedTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nomejTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cadastroUsuariojTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cadastroSenhajTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idUsuariojTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addComponent(voltarjButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmarjButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(208, 208, 208))
        );
        cadastrojPanelLayout.setVerticalGroup(
            cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrojPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(cadastrojLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idUsuariojLabel)
                    .addComponent(idUsuariojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomejLabel))
                .addGap(18, 18, 18)
                .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonejFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefonejLabel)
                    .addComponent(DDDjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPFjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CPFjLabel))
                .addGap(18, 18, 18)
                .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastroUsuariojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastroUsuariojLabel))
                .addGap(18, 18, 18)
                .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastroSenhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastroSenhajLabel))
                .addGap(39, 39, 39)
                .addComponent(confirmarjButton)
                .addGap(18, 18, 18)
                .addComponent(voltarjButton)
                .addGap(41, 41, 41))
        );

        controlejPanel.add(cadastrojPanel, "card12");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlejPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlejPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarGalinhajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarGalinhajButtonActionPerformed
        cancelarGalinhajButtonActionPerformed(evt);
        controlejPanel.remove(galinhasjPanel);
        controlejPanel.add(menuAnimaisjPanel);
        menuAnimaisjPanel.setVisible(true);
        menuAnimaisjPanel.setVisible(false);
        
        racaGalinhajTextField.setText("");
        valorGalinhajTextField.setText("");
    }//GEN-LAST:event_voltarGalinhajButtonActionPerformed

    private void galinhasjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_galinhasjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_galinhasjTableMouseClicked

    private void ovelhasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovelhasjButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(ovelhasjPanel);
        ovelhasjPanel.setVisible(false);
        ovelhasjPanel.setVisible(true);

        String tipoAnimal = "Ovelha";
        atualizarTabelaAnimais(tipoAnimal);
    }//GEN-LAST:event_ovelhasjButtonActionPerformed

    private void vacasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vacasjButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(vacasjPanel);
        vacasjPanel.setVisible(true);
        vacasjPanel.setVisible(false);

        String tipoAnimal = "Vaca";
        atualizarTabelaAnimais(tipoAnimal);
    }//GEN-LAST:event_vacasjButtonActionPerformed

    private void porcosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porcosjButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(porcosjPanel);
        porcosjPanel.setVisible(false);
        porcosjPanel.setVisible(true);

        String tipoAnimal = "Porco";
        atualizarTabelaAnimais(tipoAnimal);
    }//GEN-LAST:event_porcosjButtonActionPerformed

    private void galinhasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_galinhasjButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(galinhasjPanel);
        galinhasjPanel.setVisible(false);
        galinhasjPanel.setVisible(true);

        String tipoAnimal = "Galinha";
        atualizarTabelaAnimais(tipoAnimal);

    }//GEN-LAST:event_galinhasjButtonActionPerformed

    private void voltarMenuAnimaisjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarMenuAnimaisjButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(menuPrincipaljPanel);
        menuPrincipaljPanel.setVisible(false);
        menuPrincipaljPanel.setVisible(true);
    }//GEN-LAST:event_voltarMenuAnimaisjButtonActionPerformed

    private void animaisjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animaisjButtonActionPerformed
        controlejPanel.removeAll();
        controlejPanel.add(menuAnimaisjPanel);
        menuAnimaisjPanel.setVisible(false);
        menuAnimaisjPanel.setVisible(true);
    }//GEN-LAST:event_animaisjButtonActionPerformed

    private void plantacoesjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plantacoesjButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plantacoesjButtonActionPerformed

    private void produtosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtosjButtonActionPerformed
        controlejPanel.removeAll();
        controlejPanel.add(produtosjPanel);
        produtosjPanel.setVisible(false);
        produtosjPanel.setVisible(true);

    }//GEN-LAST:event_produtosjButtonActionPerformed

    private void sairjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairjButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_sairjButtonActionPerformed

    private void salvarGalinhajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarGalinhajButtonActionPerformed

        String id = idGalinhajTextField.getText();
        String tipo = "Galinha";
        String nomeRaca = racaGalinhajTextField.getText();
        String quantidade = "0";
        String valorVenda = valorGalinhajTextField.getText();
               

        AnimalDTO animalDTO = new AnimalDTO(id, tipo, nomeRaca, quantidade, valorVenda);

        AnimalService animalService = new AnimalServiceImpl();

        try {
            animalService.salvar(animalDTO);
            atualizarTabelaRacas(tipo);
            cancelarGalinhajButtonActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Nova raça registrada com sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_salvarGalinhajButtonActionPerformed

    private void cancelarGalinhajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarGalinhajButtonActionPerformed
        racaGalinhajTextField.setText("");
        valorGalinhajTextField.setText("");

    }//GEN-LAST:event_cancelarGalinhajButtonActionPerformed

    private void porcosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_porcosjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_porcosjTableMouseClicked

    private void voltarPorcosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarPorcosjButtonActionPerformed
        cancelarPorcojButtonActionPerformed(evt);
        controlejPanel.remove(porcosjPanel);
        controlejPanel.add(menuAnimaisjPanel);
        menuAnimaisjPanel.setVisible(true);
        menuAnimaisjPanel.setVisible(false);
        
        racaGalinhajTextField.setText("");
        valorPorcojTextField.setText("");
    }//GEN-LAST:event_voltarPorcosjButtonActionPerformed

    private void salvarPorcojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarPorcojButtonActionPerformed

        String id = idPorcojTextField.getText();
        String tipo = "Porco";
        String nomeRaca = racaPorcojTextField.getText();
        String quantidade = "0";
        String valorVenda = valorPorcojTextField.getText();

        AnimalDTO animalDTO = new AnimalDTO(id, tipo, nomeRaca, quantidade, valorVenda);

        AnimalService animalService = new AnimalServiceImpl();

        try {
            animalService.salvar(animalDTO);
            atualizarTabelaRacas(tipo);
            cancelarPorcojButtonActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Nova raça registrada com sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_salvarPorcojButtonActionPerformed

    private void cancelarPorcojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPorcojButtonActionPerformed
        valorPorcojTextField.setText("");
        racaPorcojTextField.setText("");
    }//GEN-LAST:event_cancelarPorcojButtonActionPerformed

    private void ovelhasjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ovelhasjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ovelhasjTableMouseClicked

    private void voltarOvelhasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarOvelhasjButtonActionPerformed
        cancelarOvelhajButtonActionPerformed(evt);
        controlejPanel.remove(ovelhasjPanel);
        controlejPanel.add(menuAnimaisjPanel);
        menuAnimaisjPanel.setVisible(true);
        menuAnimaisjPanel.setVisible(false);
        
        corOvelhajTextField.setText("");
        valorOvelhajTextField.setText("");
    }//GEN-LAST:event_voltarOvelhasjButtonActionPerformed

    private void salvarOvelhajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarOvelhajButtonActionPerformed
        String id = idOvelhajTextField.getText();
        String tipo = "Ovelha";
        String cor = corOvelhajTextField.getText();
        String quantidade = "0";
        String valor = valorOvelhajTextField.getText();

        AnimalDTO animalDTO = new AnimalDTO(id, tipo, cor, quantidade, valor);

        AnimalService animalService = new AnimalServiceImpl();

        try {
            animalService.salvar(animalDTO);
            atualizarTabelaRacas(tipo);
            cancelarPorcojButtonActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Cor de ovelha registrada com sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }

    }//GEN-LAST:event_salvarOvelhajButtonActionPerformed

    private void cancelarOvelhajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarOvelhajButtonActionPerformed
        valorOvelhajTextField.setText("");
        corOvelhajTextField.setText("");
    }//GEN-LAST:event_cancelarOvelhajButtonActionPerformed

    private void vacasjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vacasjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_vacasjTableMouseClicked

    private void voltarVacasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarVacasjButtonActionPerformed
        cancelarVacajButtonActionPerformed(evt);
        controlejPanel.remove(vacasjPanel);
        controlejPanel.add(menuAnimaisjPanel);
        menuAnimaisjPanel.setVisible(true);
        menuAnimaisjPanel.setVisible(false);
        
        racaVacajTextField.setText("");
        valorVacajTextField.setText("");
    }//GEN-LAST:event_voltarVacasjButtonActionPerformed

    private void salvarVacajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarVacajButtonActionPerformed

        String id = idVacajTextField.getText();
        String tipo = "Vaca";
        String raca = racaVacajTextField.getText();
        String quantidade = "0";
        String valor = valorVacajTextField.getText();

        AnimalDTO animalDTO = new AnimalDTO(id, tipo, raca, quantidade, valor);

        AnimalService animalService = new AnimalServiceImpl();

        try {
            animalService.salvar(animalDTO);
            atualizarTabelaRacas(tipo);
            cancelarPorcojButtonActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Vaca registrada com sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }


    }//GEN-LAST:event_salvarVacajButtonActionPerformed

    private void cancelarVacajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarVacajButtonActionPerformed
        valorVacajTextField.setText("");
        racaVacajTextField.setText("");
    }//GEN-LAST:event_cancelarVacajButtonActionPerformed

    private void silosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_silosjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_silosjTableMouseClicked

    private void voltarSilosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarSilosjButtonActionPerformed
        capacidadeSilojSpinner.setValue(0);
        quantidadeEntradaProdutojSpinner.setValue(0);
        controlejPanel.remove(silosjPanel);
        controlejPanel.add(produtosjPanel);
        produtosjPanel.setVisible(false);
        produtosjPanel.setVisible(true);
    }//GEN-LAST:event_voltarSilosjButtonActionPerformed

    private void salvarSilojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarSilojButtonActionPerformed
        String id = idSilojTextField.getText();
        String qtdProdutos = "0";
        String capacidade = capacidadeSilojSpinner.getValue().toString();

        SiloDTO silo = new SiloDTO(id, qtdProdutos, capacidade);

        SiloService siloService = new SiloServiceImpl();

        try {
            siloService.salvar(silo);
            atualizarTabelaSilos();
            carregarComboBoxIdSilos();
            JOptionPane.showMessageDialog(this, "Silo salvo com sucesso!");
            capacidadeSilojSpinner.setValue(0);

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }

    }//GEN-LAST:event_salvarSilojButtonActionPerformed

    private void cancelarSilojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarSilojButtonActionPerformed
        capacidadeSilojSpinner.setValue(0);
    }//GEN-LAST:event_cancelarSilojButtonActionPerformed

    private void produtosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produtosjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_produtosjTableMouseClicked

    private void voltarProdutosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarProdutosjButtonActionPerformed
        nomeProdutojTextField.setText("");
        valorProdutojTextField.setText("");
        controlejPanel.remove(produtosjPanel);
        controlejPanel.add(menuPrincipaljPanel);
        menuPrincipaljPanel.setVisible(false);
        menuPrincipaljPanel.setVisible(true);

    }//GEN-LAST:event_voltarProdutosjButtonActionPerformed

    private void salvarProdutojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarProdutojButtonActionPerformed
        String id = idProdutojTextField.getText();
        String nome = nomeProdutojTextField.getText();
        String quantidade = "0";
        String valor = valorProdutojTextField.getText();

        ProdutoDTO produto = new ProdutoDTO(id, nome, quantidade, valor);

        ProdutoService produtoService = new ProdutoServiceImpl();

        try {
            produtoService.salvar(produto);
            atualizarTabelaProdutos();
            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }

    }//GEN-LAST:event_salvarProdutojButtonActionPerformed

    private void cancelarProdutojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarProdutojButtonActionPerformed
        nomeProdutojTextField.setText("");
        valorProdutojTextField.setText("");

    }//GEN-LAST:event_cancelarProdutojButtonActionPerformed

    private void consultarArmazenamentojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarArmazenamentojButtonActionPerformed
        controlejPanel.remove(produtosjPanel);
        controlejPanel.add(silosjPanel);
        silosjPanel.setVisible(false);
        silosjPanel.setVisible(true);
        
        carregarComboBoxIdSilos();
        carregarComboBoxProdutos();

    }//GEN-LAST:event_consultarArmazenamentojButtonActionPerformed

    private void entrarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarjButtonActionPerformed
        String usuario = usuariojTextField.getText();
        String senha = senhajTextField.getText();

        UsuarioPersistencia persistencia = new UsuarioPersistenciaImpl();

        boolean login = persistencia.login(usuario, senha);

        try {

            if (login) {
                controlejPanel.removeAll();
                controlejPanel.add(menuPrincipaljPanel);
                menuPrincipaljPanel.setVisible(false);
                menuPrincipaljPanel.setVisible(true);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
            throw new RuntimeException("Usuário e/ou senha incoreta!");
        }

    }//GEN-LAST:event_entrarjButtonActionPerformed

    private void confirmarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarjButtonActionPerformed

        String id = idUsuariojTextField.getText();
        String nome = nomejTextField.getText();
        String telefone = DDDjFormattedTextField.getText() + telefonejFormattedTextField.getText();
        String cpf = CPFjFormattedTextField.getText();
        String usuarioAcesso = cadastroUsuariojTextField.getText();
        String senha = cadastroSenhajTextField.getText();

        UsuarioDTO usuario = new UsuarioDTO(id, nome, telefone, cpf, usuarioAcesso, senha);

        UsuarioService usuarioService = new UsuarioServiceImpl();

        try {
            usuarioService.salvar(usuario);
            JOptionPane.showMessageDialog(this, "Cadastro completo! Volte à tela de login e acesse agora");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }

    }//GEN-LAST:event_confirmarjButtonActionPerformed

    private void voltarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarjButtonActionPerformed
        controlejPanel.remove(cadastrojPanel);
        controlejPanel.add(loginjPanel);
        loginjPanel.setVisible(false);
        loginjPanel.setVisible(true);    }//GEN-LAST:event_voltarjButtonActionPerformed

    private void cadastrarContajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarContajButtonActionPerformed
        controlejPanel.removeAll();
        controlejPanel.add(cadastrojPanel);
        cadastrojPanel.setVisible(false);
        cadastrojPanel.setVisible(true);
    }//GEN-LAST:event_cadastrarContajButtonActionPerformed

    private void registrarEntradajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarEntradajButtonActionPerformed

        String NomeProduto = produtojComboBox.getSelectedItem().toString();
        int quantidade = Integer.parseInt(quantidadeEntradaProdutojSpinner.getValue().toString());
        int siloId = Integer.parseInt(IDsilojComboBox.getSelectedItem().toString());

        SiloPersistencia siloPersistencia = new SiloPersistenciaImpl();

        siloPersistencia.entradaEstoque(siloId, quantidade);

        ProdutoPersistencia produtoPersistencia = new ProdutoPersistenciaImpl();

        produtoPersistencia.atualizarEstoque(NomeProduto, quantidade);
        
        atualizarTabelaSilos();
        atualizarTabelaProdutos();

    }//GEN-LAST:event_registrarEntradajButtonActionPerformed

    private void consultarGalinheirosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarGalinheirosjButtonActionPerformed
        controlejPanel.remove(galinhasjPanel);
        controlejPanel.add(galinhasArmazenamentojPanel);
        galinhasArmazenamentojPanel.setVisible(false);
        galinhasArmazenamentojPanel.setVisible(true);
        
        racaGalinhajTextField.setText("");
        valorGalinhajTextField.setText("");
        
        carregarComboBoxRacas();
        carregarComboBoxIdAbrigos();
        
        String tipoAbrigo = "Galinheiro";
        atualizarTabelaAbrigo(tipoAbrigo);


    }//GEN-LAST:event_consultarGalinheirosjButtonActionPerformed

    private void galinheirosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_galinheirosjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_galinheirosjTableMouseClicked

    private void voltarGalinheirosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarGalinheirosjButtonActionPerformed
        controlejPanel.remove(galinhasArmazenamentojPanel);
        controlejPanel.add(galinhasjPanel);
        galinhasjPanel.setVisible(false);
        galinhasjPanel.setVisible(true);     
        
        capacidadeGalinheirojSpinner.setValue(0);
        quantidadeEntradaGalinhasjSpinner.setValue(0);
    }//GEN-LAST:event_voltarGalinheirosjButtonActionPerformed

    private void salvarGalinheirojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarGalinheirojButtonActionPerformed

        String id = idGalinheirojTextField.getText();
        String tipo = "Galinheiro";
        String qtdAnimais = "0";
        String capacidade = capacidadeGalinheirojSpinner.getValue().toString();

        AbrigoDTO abrigoDTO = new AbrigoDTO(id, tipo, qtdAnimais, capacidade);

        //enviando para a service
        AbrigoService service = new AbrigoServiceImpl();
        try {
            service.salvar(abrigoDTO);
            atualizarTabelaAbrigo(tipo);
            carregarComboBoxIdAbrigos();            
            JOptionPane.showMessageDialog(this, "Novo " + tipo + " salvo com sucesso!");
            cancelarGalinheirosjButtonActionPerformed(evt);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }

    }//GEN-LAST:event_salvarGalinheirojButtonActionPerformed

    private void cancelarGalinheirosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarGalinheirosjButtonActionPerformed
        capacidadeGalinheirojSpinner.setValue(0);        
    }//GEN-LAST:event_cancelarGalinheirosjButtonActionPerformed

    private void registrarEntradaGalinhasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarEntradaGalinhasjButtonActionPerformed
        
        String racaAnimal = racaGalinhajComboBox.getSelectedItem().toString();
        int quantidade = Integer.parseInt(quantidadeEntradaGalinhasjSpinner.getValue().toString());
        int idGalinheiro = Integer.parseInt(idGalinheirojComboBox.getSelectedItem().toString());

        AbrigoPersistencia abrigoPersistencia = new AbrigoPersistenciaImpl();
        abrigoPersistencia.entradaAnimais(idGalinheiro, quantidade);
        
        AnimalPersistencia animalPersistencia = new AnimalPersistenciaImpl();        
        animalPersistencia.atualizarQtdAnimais(racaAnimal, quantidade);
        
        atualizarTabelaRacas("Galinha");
        atualizarTabelaAbrigo("Galinheiro");
        
    }//GEN-LAST:event_registrarEntradaGalinhasjButtonActionPerformed

    private void consultarChiqueirosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarChiqueirosjButtonActionPerformed
        
        controlejPanel.remove(porcosjPanel);
        controlejPanel.add(porcosArmazenamentojPanel);
        porcosArmazenamentojPanel.setVisible(false);
        porcosArmazenamentojPanel.setVisible(true);
        
        valorPorcojTextField.setText("");
        racaPorcojTextField.setText("");
        
        carregarComboBoxRacas();
        carregarComboBoxIdAbrigos();
  
        String tipoAbrigo = "Chiqueiro";
        atualizarTabelaAbrigo(tipoAbrigo);
        
        
    }//GEN-LAST:event_consultarChiqueirosjButtonActionPerformed

    private void consultarApriscosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarApriscosjButtonActionPerformed
        controlejPanel.remove(ovelhasjPanel);
        controlejPanel.add(ovelhasArmazenamentojPanel);
        ovelhasArmazenamentojPanel.setVisible(false);
        ovelhasArmazenamentojPanel.setVisible(true);
        
        valorOvelhajTextField.setText("");
        corOvelhajTextField.setText("");
        
        carregarComboBoxRacas();
        carregarComboBoxIdAbrigos();
  
        String tipoAbrigo = "Aprisco";
        atualizarTabelaAbrigo(tipoAbrigo);
    }//GEN-LAST:event_consultarApriscosjButtonActionPerformed

    private void valorOvelhajTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorOvelhajTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorOvelhajTextFieldActionPerformed

    private void consultarCurraisjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarCurraisjButtonActionPerformed
        controlejPanel.remove(vacasjPanel);
        controlejPanel.add(vacasArmazenamentojPanel);
        vacasArmazenamentojPanel.setVisible(false);
        vacasArmazenamentojPanel.setVisible(true);
        
        valorVacajTextField.setText("");
        racaVacajTextField.setText("");
        
        carregarComboBoxRacas();
        carregarComboBoxIdAbrigos();
        
        String tipoAbrigo = "Curral";
        atualizarTabelaAbrigo(tipoAbrigo);
     }//GEN-LAST:event_consultarCurraisjButtonActionPerformed

    private void chiqueirosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chiqueirosjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_chiqueirosjTableMouseClicked

    private void voltarChiqueirosjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarChiqueirosjButton1ActionPerformed
        controlejPanel.remove(porcosArmazenamentojPanel);
        controlejPanel.add(porcosjPanel);
        porcosjPanel.setVisible(false);
        porcosjPanel.setVisible(true);
        
        capacidadeChiqueirojSpinner.setValue(0);
        quantidadeEntradaPorcosjSpinner.setValue(0);
    }//GEN-LAST:event_voltarChiqueirosjButton1ActionPerformed

    private void salvarChiqueirosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarChiqueirosjButtonActionPerformed
        String id = idChiqueirojTextField.getText();
        String tipo = "Chiqueiro";
        String qtdAnimais = "0";
        String capacidade = capacidadeChiqueirojSpinner.getValue().toString();

        AbrigoDTO abrigoDTO = new AbrigoDTO(id, tipo, qtdAnimais, capacidade);

        //enviando para a service
        AbrigoService service = new AbrigoServiceImpl();
        try {
            service.salvar(abrigoDTO);
            atualizarTabelaAbrigo(tipo);
            carregarComboBoxIdAbrigos();            
            JOptionPane.showMessageDialog(this, "Novo " + tipo + " salvo com sucesso!");
            cancelarChiqueirojButtonActionPerformed(evt);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_salvarChiqueirosjButtonActionPerformed

    private void cancelarChiqueirojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarChiqueirojButtonActionPerformed
        capacidadeChiqueirojSpinner.setValue(0);
    }//GEN-LAST:event_cancelarChiqueirojButtonActionPerformed

    private void registrarEntradaPorcosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarEntradaPorcosjButtonActionPerformed
        String racaAnimal = racaPorcojComboBox.getSelectedItem().toString();
        int quantidade = Integer.parseInt(quantidadeEntradaPorcosjSpinner.getValue().toString());
        int idChiqueiro = Integer.parseInt(idChiqueirojComboBox.getSelectedItem().toString());

        AbrigoPersistencia abrigoPersistencia = new AbrigoPersistenciaImpl();
        abrigoPersistencia.entradaAnimais(idChiqueiro, quantidade);
        
        AnimalPersistencia animalPersistencia = new AnimalPersistenciaImpl();        
        animalPersistencia.atualizarQtdAnimais(racaAnimal, quantidade);
        
        atualizarTabelaRacas("Porco");
        atualizarTabelaAbrigo("Chiqueiro");
    }//GEN-LAST:event_registrarEntradaPorcosjButtonActionPerformed

    private void apriscosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apriscosjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_apriscosjTableMouseClicked

    private void voltarApriscosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarApriscosjButtonActionPerformed
        controlejPanel.remove(ovelhasArmazenamentojPanel);
        controlejPanel.add(ovelhasjPanel);
        ovelhasjPanel.setVisible(false);
        ovelhasjPanel.setVisible(true);
        
        capacidadeApriscojSpinner.setValue(0);
        quantidadeEntradaOvelhasjSpinner.setValue(0);
    }//GEN-LAST:event_voltarApriscosjButtonActionPerformed

    private void salvarApriscojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarApriscojButtonActionPerformed
        String id = idApriscojTextField.getText();
        String tipo = "Aprisco";
        String qtdAnimais = "0";
        String capacidade = capacidadeApriscojSpinner.getValue().toString();

        AbrigoDTO abrigoDTO = new AbrigoDTO(id, tipo, qtdAnimais, capacidade);

        //enviando para a service
        AbrigoService service = new AbrigoServiceImpl();
        try {
            service.salvar(abrigoDTO);
            atualizarTabelaAbrigo(tipo);
            carregarComboBoxIdAbrigos();            
            JOptionPane.showMessageDialog(this, "Novo " + tipo + " salvo com sucesso!");
            cancelarApriscojButtonActionPerformed(evt);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_salvarApriscojButtonActionPerformed

    private void cancelarApriscojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarApriscojButtonActionPerformed
        capacidadeApriscojSpinner.setValue(0);
    }//GEN-LAST:event_cancelarApriscojButtonActionPerformed

    private void registrarEntradaOvelhasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarEntradaOvelhasjButtonActionPerformed
        String racaAnimal = corEntradaOvelhajComboBox.getSelectedItem().toString();
        int quantidade = Integer.parseInt(quantidadeEntradaOvelhasjSpinner.getValue().toString());
        int idAprisco = Integer.parseInt(idApriscojComboBox.getSelectedItem().toString());

        AbrigoPersistencia abrigoPersistencia = new AbrigoPersistenciaImpl();
        abrigoPersistencia.entradaAnimais(idAprisco, quantidade);
        
        AnimalPersistencia animalPersistencia = new AnimalPersistenciaImpl();        
        animalPersistencia.atualizarQtdAnimais(racaAnimal, quantidade);
        
        atualizarTabelaRacas("Ovelha");
        atualizarTabelaAbrigo("Aprisco");
    }//GEN-LAST:event_registrarEntradaOvelhasjButtonActionPerformed

    private void curraisjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_curraisjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_curraisjTableMouseClicked

    private void voltarCurraisjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarCurraisjButtonActionPerformed
        controlejPanel.remove(vacasArmazenamentojPanel);
        controlejPanel.add(vacasjPanel);
        vacasjPanel.setVisible(false);
        vacasjPanel.setVisible(true);
        
        capacidadeCurraljSpinner.setValue(0);
        quantidadeEntradaVacasjSpinner.setValue(0);
    }//GEN-LAST:event_voltarCurraisjButtonActionPerformed

    private void cancelarCurraljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCurraljButtonActionPerformed
        capacidadeCurraljSpinner.setValue(0);
    }//GEN-LAST:event_cancelarCurraljButtonActionPerformed

    private void registrarEntradaVacasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarEntradaVacasjButtonActionPerformed
        String racaAnimal = racaVacajComboBox.getSelectedItem().toString();
        int quantidade = Integer.parseInt(quantidadeEntradaVacasjSpinner.getValue().toString());
        int idCurral = Integer.parseInt(idCurraljComboBox.getSelectedItem().toString());

        AbrigoPersistencia abrigoPersistencia = new AbrigoPersistenciaImpl();
        abrigoPersistencia.entradaAnimais(idCurral, quantidade);
        
        AnimalPersistencia animalPersistencia = new AnimalPersistenciaImpl();        
        animalPersistencia.atualizarQtdAnimais(racaAnimal, quantidade);
        
        atualizarTabelaRacas("Vaca");
        atualizarTabelaAbrigo("Curral");
    }//GEN-LAST:event_registrarEntradaVacasjButtonActionPerformed

    private void salvarCurraljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarCurraljButtonActionPerformed
        String id = idCurraljTextField.getText();
        String tipo = "Curral";
        String qtdAnimais = "0";
        String capacidade = capacidadeCurraljSpinner.getValue().toString();

        AbrigoDTO abrigoDTO = new AbrigoDTO(id, tipo, qtdAnimais, capacidade);

        //enviando para a service
        AbrigoService service = new AbrigoServiceImpl();
        try {
            service.salvar(abrigoDTO);
            atualizarTabelaAbrigo(tipo);
            carregarComboBoxIdAbrigos();            
            JOptionPane.showMessageDialog(this, "Novo " + tipo + " salvo com sucesso!");
            cancelarApriscojButtonActionPerformed(evt);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_salvarCurraljButtonActionPerformed

    private void idApriscojComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idApriscojComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idApriscojComboBoxActionPerformed

    private void corOvelhajTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corOvelhajTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_corOvelhajTextFieldActionPerformed

    private void cancelarEntradaGalinhasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEntradaGalinhasjButtonActionPerformed
        quantidadeEntradaGalinhasjSpinner.setValue(0);
    }//GEN-LAST:event_cancelarEntradaGalinhasjButtonActionPerformed

    private void cancelarEntradaPorcosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEntradaPorcosjButtonActionPerformed
        quantidadeEntradaPorcosjSpinner.setValue(0);
    }//GEN-LAST:event_cancelarEntradaPorcosjButtonActionPerformed

    private void cancelarEntradaOvelhasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEntradaOvelhasjButtonActionPerformed
        quantidadeEntradaOvelhasjSpinner.setValue(0);
    }//GEN-LAST:event_cancelarEntradaOvelhasjButtonActionPerformed

    private void cancelarEntradaVacasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEntradaVacasjButtonActionPerformed
        quantidadeEntradaVacasjSpinner.setValue(0);
    }//GEN-LAST:event_cancelarEntradaVacasjButtonActionPerformed

    private void cancelarEntradajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEntradajButtonActionPerformed
        quantidadeEntradaProdutojSpinner.setValue(0);
    }//GEN-LAST:event_cancelarEntradajButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CPFjFormattedTextField;
    private javax.swing.JLabel CPFjLabel;
    private javax.swing.JFormattedTextField DDDjFormattedTextField;
    private javax.swing.JComboBox<String> IDsilojComboBox;
    private javax.swing.JLabel abrigosGalinhasjLabel;
    private javax.swing.JLabel abrigosOvelhasjLabel;
    private javax.swing.JLabel abrigosjLabel;
    private javax.swing.JButton animaisjButton;
    private javax.swing.JScrollPane apriscosjScrollPane;
    private javax.swing.JTable apriscosjTable;
    private javax.swing.JButton cadastrarContajButton;
    private javax.swing.JLabel cadastroSenhajLabel;
    private javax.swing.JTextField cadastroSenhajTextField;
    private javax.swing.JLabel cadastroUsuariojLabel;
    private javax.swing.JTextField cadastroUsuariojTextField;
    private javax.swing.JLabel cadastrojLabel;
    private javax.swing.JPanel cadastrojPanel;
    private javax.swing.JButton cancelarApriscojButton;
    private javax.swing.JButton cancelarChiqueirojButton;
    private javax.swing.JButton cancelarCurraljButton;
    private javax.swing.JButton cancelarEntradaGalinhasjButton;
    private javax.swing.JButton cancelarEntradaOvelhasjButton;
    private javax.swing.JButton cancelarEntradaPorcosjButton;
    private javax.swing.JButton cancelarEntradaVacasjButton;
    private javax.swing.JButton cancelarEntradajButton;
    private javax.swing.JButton cancelarGalinhajButton;
    private javax.swing.JButton cancelarGalinheirosjButton;
    private javax.swing.JButton cancelarOvelhajButton;
    private javax.swing.JButton cancelarPorcojButton;
    private javax.swing.JButton cancelarProdutojButton;
    private javax.swing.JButton cancelarSilojButton;
    private javax.swing.JButton cancelarVacajButton;
    private javax.swing.JLabel capacidadeApriscojLabel;
    private javax.swing.JSpinner capacidadeApriscojSpinner;
    private javax.swing.JSpinner capacidadeChiqueirojSpinner;
    private javax.swing.JLabel capacidadeChiqueirosjLabel;
    private javax.swing.JLabel capacidadeCurraljLabel;
    private javax.swing.JSpinner capacidadeCurraljSpinner;
    private javax.swing.JLabel capacidadeGalinheirojLabel;
    private javax.swing.JSpinner capacidadeGalinheirojSpinner;
    private javax.swing.JLabel capacidadeSilojLabel;
    private javax.swing.JSpinner capacidadeSilojSpinner;
    private javax.swing.JScrollPane chiqueirosjScrollPane;
    private javax.swing.JTable chiqueirosjTable;
    private javax.swing.JButton confirmarjButton;
    private javax.swing.JButton consultarApriscosjButton;
    private javax.swing.JButton consultarArmazenamentojButton;
    private javax.swing.JButton consultarChiqueirosjButton;
    private javax.swing.JButton consultarCurraisjButton;
    private javax.swing.JButton consultarGalinheirosjButton;
    private javax.swing.JPanel controlejPanel;
    private javax.swing.JComboBox<String> corEntradaOvelhajComboBox;
    private javax.swing.JLabel corOvelhajLabel;
    private javax.swing.JTextField corOvelhajTextField;
    private javax.swing.JScrollPane curraisjScrollPane;
    private javax.swing.JTable curraisjTable;
    private javax.swing.JButton entrarjButton;
    private javax.swing.JPanel galinhasArmazenamentojPanel;
    private javax.swing.JButton galinhasjButton;
    private javax.swing.JPanel galinhasjPanel;
    private javax.swing.JScrollPane galinhasjScrollPane;
    private javax.swing.JTable galinhasjTable;
    private javax.swing.JScrollPane galinheirosjScrollPane;
    private javax.swing.JTable galinheirosjTable;
    private javax.swing.JLabel iDsilojLabel;
    private javax.swing.JComboBox<String> idApriscojComboBox;
    private javax.swing.JLabel idApriscojLabel;
    private javax.swing.JTextField idApriscojTextField;
    private javax.swing.JComboBox<String> idChiqueirojComboBox;
    private javax.swing.JLabel idChiqueirojLabel;
    private javax.swing.JTextField idChiqueirojTextField;
    private javax.swing.JLabel idChiqueirosjLabel;
    private javax.swing.JComboBox<String> idCurraljComboBox;
    private javax.swing.JLabel idCurraljLabel;
    private javax.swing.JTextField idCurraljTextField;
    private javax.swing.JLabel idEntradaApriscojLabel;
    private javax.swing.JLabel idEntradaChiqueirojLabel;
    private javax.swing.JLabel idGalinhajLabel;
    private javax.swing.JTextField idGalinhajTextField;
    private javax.swing.JComboBox<String> idGalinheirojComboBox;
    private javax.swing.JLabel idGalinheirojLabel;
    private javax.swing.JLabel idGalinheirojLabel1;
    private javax.swing.JTextField idGalinheirojTextField;
    private javax.swing.JLabel idOvelhajLabel;
    private javax.swing.JTextField idOvelhajTextField;
    private javax.swing.JLabel idPorcojLabel;
    private javax.swing.JTextField idPorcojTextField;
    private javax.swing.JLabel idProdutojLabel;
    private javax.swing.JTextField idProdutojTextField;
    private javax.swing.JLabel idSilojLabel;
    private javax.swing.JTextField idSilojTextField;
    private javax.swing.JLabel idUsuariojLabel;
    private javax.swing.JTextField idUsuariojTextField;
    private javax.swing.JLabel idVacajLabel;
    private javax.swing.JTextField idVacajTextField;
    private javax.swing.JPanel loginjPanel;
    private javax.swing.JPanel menuAnimaisjPanel;
    private javax.swing.JPanel menuPrincipaljPanel;
    private javax.swing.JLabel nomeGalinhajLabel;
    private javax.swing.JLabel nomePorcojLabel;
    private javax.swing.JLabel nomeProdutojLabel;
    private javax.swing.JTextField nomeProdutojTextField;
    private javax.swing.JLabel nomeVacajLabel;
    private javax.swing.JLabel nomejLabel;
    private javax.swing.JTextField nomejTextField;
    private javax.swing.JPanel ovelhasArmazenamentojPanel;
    private javax.swing.JButton ovelhasjButton;
    private javax.swing.JPanel ovelhasjPanel;
    private javax.swing.JScrollPane ovelhasjScrollPane;
    private javax.swing.JTable ovelhasjTable;
    private javax.swing.JButton plantacoesjButton;
    private javax.swing.JPanel porcosArmazenamentojPanel;
    private javax.swing.JButton porcosjButton;
    private javax.swing.JPanel porcosjPanel;
    private javax.swing.JScrollPane porcosjScrollPane;
    private javax.swing.JTable porcosjTable;
    private javax.swing.JComboBox<String> produtojComboBox;
    private javax.swing.JLabel produtojLabel;
    private javax.swing.JButton produtosjButton;
    private javax.swing.JLabel produtosjLabel;
    private javax.swing.JPanel produtosjPanel;
    private javax.swing.JScrollPane produtosjScrollPane;
    private javax.swing.JTable produtosjTable;
    private javax.swing.JLabel quantidadeEntradaGalinhajLabel;
    private javax.swing.JSpinner quantidadeEntradaGalinhasjSpinner;
    private javax.swing.JLabel quantidadeEntradaOvelhajLabel;
    private javax.swing.JSpinner quantidadeEntradaOvelhasjSpinner;
    private javax.swing.JLabel quantidadeEntradaPorcojLabel;
    private javax.swing.JSpinner quantidadeEntradaPorcosjSpinner;
    private javax.swing.JSpinner quantidadeEntradaProdutojSpinner;
    private javax.swing.JLabel quantidadeEntradaVacajLabel;
    private javax.swing.JSpinner quantidadeEntradaVacasjSpinner;
    private javax.swing.JLabel quantidadeEntradajLabel;
    private javax.swing.JComboBox<String> racaGalinhajComboBox;
    private javax.swing.JTextField racaGalinhajTextField;
    private javax.swing.JLabel racaOvelhasjLabel;
    private javax.swing.JComboBox<String> racaPorcojComboBox;
    private javax.swing.JLabel racaPorcojLabel;
    private javax.swing.JTextField racaPorcojTextField;
    private javax.swing.JComboBox<String> racaVacajComboBox;
    private javax.swing.JLabel racaVacajLabel;
    private javax.swing.JTextField racaVacajTextField;
    private javax.swing.JLabel racajLabel;
    private javax.swing.JLabel racasPorcosjLabel;
    private javax.swing.JButton registrarEntradaGalinhasjButton;
    private javax.swing.JButton registrarEntradaOvelhasjButton;
    private javax.swing.JButton registrarEntradaPorcosjButton;
    private javax.swing.JButton registrarEntradaVacasjButton;
    private javax.swing.JButton registrarEntradajButton;
    private javax.swing.JButton sairjButton;
    private javax.swing.JButton salvarApriscojButton;
    private javax.swing.JButton salvarChiqueirosjButton;
    private javax.swing.JButton salvarCurraljButton;
    private javax.swing.JButton salvarGalinhajButton;
    private javax.swing.JButton salvarGalinheirojButton;
    private javax.swing.JButton salvarOvelhajButton;
    private javax.swing.JButton salvarPorcojButton;
    private javax.swing.JButton salvarProdutojButton;
    private javax.swing.JButton salvarSilojButton;
    private javax.swing.JButton salvarVacajButton;
    private javax.swing.JLabel senhajLabel;
    private javax.swing.JTextField senhajTextField;
    private javax.swing.JPanel silosjPanel;
    private javax.swing.JScrollPane silosjScrollPane;
    private javax.swing.JTable silosjTable;
    private javax.swing.JLabel tabelaCurraisjLabel;
    private javax.swing.JLabel tabelaGalinheirosjLabel;
    private javax.swing.JLabel tabelaOvelhasjLabel;
    private javax.swing.JLabel tabelaPorcosjLabel;
    private javax.swing.JLabel tabelaSilosjLabel;
    private javax.swing.JFormattedTextField telefonejFormattedTextField;
    private javax.swing.JLabel telefonejLabel;
    private javax.swing.JLabel tituloCadastroApriscosjLabel;
    private javax.swing.JLabel tituloCadastroChiqueirosjLabel;
    private javax.swing.JLabel tituloCadastroCurraisjLabel;
    private javax.swing.JLabel tituloCadastroGalinhasjLabel1;
    private javax.swing.JLabel tituloCadastroGalinheirosjLabel;
    private javax.swing.JLabel tituloCadastroOvelhasjLabel;
    private javax.swing.JLabel tituloCadastroPorcojLabel;
    private javax.swing.JLabel tituloCadastroProdutosjLabel;
    private javax.swing.JLabel tituloCadastroSilosjLabel;
    private javax.swing.JLabel tituloCadastroSilosjLabel1;
    private javax.swing.JLabel tituloCadastroVacasjLabel;
    private javax.swing.JLabel tituloEntradaChiqueirosjLabel;
    private javax.swing.JLabel tituloEntradaCurraisjLabel;
    private javax.swing.JLabel tituloEntradaGalinhasjLabel;
    private javax.swing.JLabel tituloEntradaOvelhasjLabel;
    private javax.swing.JLabel usuariojLabel;
    private javax.swing.JTextField usuariojTextField;
    private javax.swing.JPanel vacasArmazenamentojPanel;
    private javax.swing.JButton vacasjButton;
    private javax.swing.JLabel vacasjLabel;
    private javax.swing.JPanel vacasjPanel;
    private javax.swing.JScrollPane vacasjScrollPane;
    private javax.swing.JTable vacasjTable;
    private javax.swing.JLabel valorGalinhajLabel;
    private javax.swing.JTextField valorGalinhajTextField;
    private javax.swing.JLabel valorOvelhajLabel;
    private javax.swing.JTextField valorOvelhajTextField;
    private javax.swing.JLabel valorPorcojLabel;
    private javax.swing.JTextField valorPorcojTextField;
    private javax.swing.JLabel valorProdutojLabel;
    private javax.swing.JTextField valorProdutojTextField;
    private javax.swing.JLabel valorVacajLabel;
    private javax.swing.JTextField valorVacajTextField;
    private javax.swing.JButton voltarApriscosjButton;
    private javax.swing.JButton voltarChiqueirosjButton1;
    private javax.swing.JButton voltarCurraisjButton;
    private javax.swing.JButton voltarGalinhajButton;
    private javax.swing.JButton voltarGalinheirosjButton;
    private javax.swing.JButton voltarMenuAnimaisjButton;
    private javax.swing.JButton voltarOvelhasjButton;
    private javax.swing.JButton voltarPorcosjButton;
    private javax.swing.JButton voltarProdutosjButton;
    private javax.swing.JButton voltarSilosjButton;
    private javax.swing.JButton voltarVacasjButton;
    private javax.swing.JButton voltarjButton;
    // End of variables declaration//GEN-END:variables
}

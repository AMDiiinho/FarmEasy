/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.ufmt.poo.FarmEasy.UI;


import br.ufmt.poo.FarmEasy.services.AbrigoService;
import br.ufmt.poo.FarmEasy.services.impl.GalinhaServiceImpl;
import javax.swing.JOptionPane;
import br.ufmt.poo.FarmEasy.services.GalinhaService;
import br.ufmt.poo.FarmEasy.services.OvelhaService;
import br.ufmt.poo.FarmEasy.services.PorcoService;
import br.ufmt.poo.FarmEasy.services.VacaService;
import br.ufmt.poo.FarmEasy.services.SiloService;
import br.ufmt.poo.FarmEasy.services.impl.AbrigoServiceImpl;
import br.ufmt.poo.FarmEasy.services.impl.OvelhaServiceImpl;
import br.ufmt.poo.FarmEasy.services.impl.PorcoServiceImpl;
import br.ufmt.poo.FarmEasy.services.impl.VacaServiceImpl;
import br.ufmt.poo.FarmEasy.services.impl.SiloServiceImpl;
import br.ufmt.poo.FarmEasy.services.impl.ProdutoServiceImpl;
import br.ufmt.poo.FarmEasy.services.ProdutoService;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import br.ufmt.poo.FarmEasy.UI.DTOs.SiloDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.ProdutoDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.AbrigoDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.AnimalDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.GalinhaDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.OvelhaDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.PorcoDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.UsuarioDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.VacaDTO;
import br.ufmt.poo.FarmEasy.persistencias.ProdutoPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.SiloPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.UsuarioPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.impl.ProdutoPersistenciaImpl;
import br.ufmt.poo.FarmEasy.persistencias.impl.SiloPersistenciaImpl;
import br.ufmt.poo.FarmEasy.persistencias.impl.UsuarioPersistenciaImpl;
import br.ufmt.poo.FarmEasy.services.AnimalService;
import br.ufmt.poo.FarmEasy.services.UsuarioService;
import br.ufmt.poo.FarmEasy.services.impl.AnimalServiceImpl;
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
        atualizarTabela();     
        carregarSilos();
        carregarProdutos();
  
    }
    
    
    private void carregarTabelaAnimais(String tipoAnimal){
        
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
    }
    
    
    private void carregarTabelaAbrigo(String tipoAbrigo){
        
        AbrigoService serviceAbrigo = new AbrigoServiceImpl();
            
        List<AbrigoDTO> listaAbrigos = serviceAbrigo.listar(tipoAbrigo);
        
        DefaultTableModel dfmAbrigoGalinheiro = (DefaultTableModel) galinhasjTable.getModel();
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
        
        DefaultTableModel dfmAbrigoChiqueiro = (DefaultTableModel) porcosjTable.getModel();
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
    
    
    private void carregarSilos(){
        
        SiloService siloService = new SiloServiceImpl();
        List<SiloDTO> listaSilos = siloService.listar();
        IDsilojComboBox.removeAllItems();
        
        for (SiloDTO siloDTO : listaSilos){
            IDsilojComboBox.addItem(siloDTO.getId());
        }
        
    }
    
    private void carregarProdutos(){
        
        ProdutoService produtoService = new ProdutoServiceImpl();
        List<ProdutoDTO> listaProdutos = produtoService.listar();
        produtojComboBox.removeAllItems();
        
        for (ProdutoDTO produtoDTO : listaProdutos){
            produtojComboBox.addItem(produtoDTO.getNome());
        }
        
    }
    
    private void atualizarTabela(){

        ProdutoService produtoService = new ProdutoServiceImpl();
        List<ProdutoDTO> listaProdutos = produtoService.listar();
                
        DefaultTableModel dfmProduto = (DefaultTableModel) produtosjTable.getModel();
        int linhasProduto = dfmProduto.getRowCount();
        for(int i = 0; i < linhasProduto; i++){
            dfmProduto.removeRow(0);
        }
        
        for (ProdutoDTO produtoDTO : listaProdutos){
            Object[] linhaProduto = new Object[4];
            linhaProduto[0] = produtoDTO.getId();
            linhaProduto[1] = produtoDTO.getNome();
            linhaProduto[2] = produtoDTO.getEstoque();
            linhaProduto[3] = produtoDTO.getValor();
            
            dfmProduto.addRow(linhaProduto);
        }
        
        SiloService siloService = new SiloServiceImpl();
        List<SiloDTO> listaSilos = siloService.listar();
               
        DefaultTableModel dfmSilo = (DefaultTableModel) silosjTable.getModel();
        int linhasSilo = dfmSilo.getRowCount();
        for(int i = 0; i < linhasSilo; i++){
            dfmSilo.removeRow(0);
        }
        
        for (SiloDTO siloDTO : listaSilos){
            Object[] linhaProduto = new Object[4];
            linhaProduto[0] = siloDTO.getId();
            linhaProduto[1] = siloDTO.getQtdProdutos();
            linhaProduto[2] = siloDTO.getCapacidade();
            
            dfmSilo.addRow(linhaProduto);
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
        registrarNovoAbrigojButton = new javax.swing.JButton();
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
        nomeRacajTextField = new javax.swing.JTextField();
        conultarGalinheirosjButton = new javax.swing.JButton();
        registroAbrigosjPanel = new javax.swing.JPanel();
        registroAbrigosjLabel = new javax.swing.JLabel();
        tipoAbrigojLabel = new javax.swing.JLabel();
        tipoAbrigojComboBox = new javax.swing.JComboBox<>();
        espacojLabel = new javax.swing.JLabel();
        espacojSpinner = new javax.swing.JSpinner();
        regristroAbrigosSalvarjButton = new javax.swing.JButton();
        registroAbrigosCanceljButton = new javax.swing.JButton();
        idAbrigojLabel = new javax.swing.JLabel();
        IDjTextField = new javax.swing.JTextField();
        registroAbrigosVoltarjButton = new javax.swing.JButton();
        chiqueirosjPanel = new javax.swing.JPanel();
        chiqueirosjScrollPane = new javax.swing.JScrollPane();
        porcosjTable = new javax.swing.JTable();
        voltarChiqueirosjButton = new javax.swing.JButton();
        abrigosPorcosjLabel = new javax.swing.JLabel();
        idPorcojLabel = new javax.swing.JLabel();
        nomePorcojLabel = new javax.swing.JLabel();
        racaPorcojTextField = new javax.swing.JTextField();
        idPorcojTextField = new javax.swing.JTextField();
        salvarPorcojButton = new javax.swing.JButton();
        cancelarPorcojButton = new javax.swing.JButton();
        tituloCadastroPorcojLabel = new javax.swing.JLabel();
        valorPorcojLabel = new javax.swing.JLabel();
        valorPorcojTextField = new javax.swing.JTextField();
        apriscosjPanel = new javax.swing.JPanel();
        ovelhasjScrollPane = new javax.swing.JScrollPane();
        apriscosjTable = new javax.swing.JTable();
        voltarOvelhasjButton = new javax.swing.JButton();
        abrigosOvelhasjLabel = new javax.swing.JLabel();
        idOvelhajLabel = new javax.swing.JLabel();
        racaOvelhajLabel = new javax.swing.JLabel();
        idOvelhajTextField = new javax.swing.JTextField();
        corOvelhajComboBox = new javax.swing.JComboBox<>();
        salvarOvelhajButton = new javax.swing.JButton();
        cancelarOvelhajButton = new javax.swing.JButton();
        tituloCadastroOvelhasjLabel = new javax.swing.JLabel();
        valorOvelhajLabel = new javax.swing.JLabel();
        valorOvelhajTextField = new javax.swing.JTextField();
        curraisjPanel = new javax.swing.JPanel();
        vacasjScrollPane = new javax.swing.JScrollPane();
        curraisjTable = new javax.swing.JTable();
        voltarVacasjButton = new javax.swing.JButton();
        curraisVacasjLabel = new javax.swing.JLabel();
        idVacajLabel = new javax.swing.JLabel();
        nomeVacajLabel = new javax.swing.JLabel();
        nomeVacajTextField = new javax.swing.JTextField();
        idVacajTextField = new javax.swing.JTextField();
        salvarVacajButton = new javax.swing.JButton();
        cancelarVacajButton = new javax.swing.JButton();
        tituloCadastroVacasjLabel = new javax.swing.JLabel();
        valorVacajTextField = new javax.swing.JTextField();
        valorVacajLabel = new javax.swing.JLabel();
        armazenamentojPanel = new javax.swing.JPanel();
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
        quantidadeEntradajSpinner = new javax.swing.JSpinner();
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
                .addContainerGap(339, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
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
                .addContainerGap(337, Short.MAX_VALUE))
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

        registrarNovoAbrigojButton.setText("Registrar novo");
        registrarNovoAbrigojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarNovoAbrigojButtonActionPerformed(evt);
            }
        });

        abrigosjLabel.setFont(new java.awt.Font("Liberation Sans", 0, 48)); // NOI18N
        abrigosjLabel.setText("Animais");

        javax.swing.GroupLayout menuAnimaisjPanelLayout = new javax.swing.GroupLayout(menuAnimaisjPanel);
        menuAnimaisjPanel.setLayout(menuAnimaisjPanelLayout);
        menuAnimaisjPanelLayout.setHorizontalGroup(
            menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuAnimaisjPanelLayout.createSequentialGroup()
                .addGroup(menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(menuAnimaisjPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(registrarNovoAbrigojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(voltarMenuAnimaisjButton))
                    .addGroup(menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menuAnimaisjPanelLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(abrigosjLabel))
                        .addGroup(menuAnimaisjPanelLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(galinhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(porcosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ovelhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(vacasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        menuAnimaisjPanelLayout.setVerticalGroup(
            menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuAnimaisjPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(abrigosjLabel)
                .addGap(115, 115, 115)
                .addGroup(menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(porcosjButton)
                    .addComponent(galinhasjButton)
                    .addComponent(ovelhasjButton)
                    .addComponent(vacasjButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addGroup(menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltarMenuAnimaisjButton)
                    .addComponent(registrarNovoAbrigojButton))
                .addGap(32, 32, 32))
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

        conultarGalinheirosjButton.setText("Consultar galinheiros");
        conultarGalinheirosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conultarGalinheirosjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout galinhasjPanelLayout = new javax.swing.GroupLayout(galinhasjPanel);
        galinhasjPanel.setLayout(galinhasjPanelLayout);
        galinhasjPanelLayout.setHorizontalGroup(
            galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, galinhasjPanelLayout.createSequentialGroup()
                .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(galinhasjPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(voltarGalinhajButton))
                    .addGroup(galinhasjPanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(abrigosGalinhasjLabel)
                            .addComponent(galinhasjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(conultarGalinheirosjButton, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(galinhasjPanelLayout.createSequentialGroup()
                                .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idGalinhajLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nomeGalinhajLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(valorGalinhajLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idGalinhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(galinhasjPanelLayout.createSequentialGroup()
                                        .addComponent(cancelarGalinhajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(salvarGalinhajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(nomeRacajTextField)
                                    .addComponent(valorGalinhajTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tituloCadastroGalinhasjLabel1))))
                .addGap(66, 66, 66))
        );
        galinhasjPanelLayout.setVerticalGroup(
            galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(galinhasjPanelLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
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
                            .addComponent(nomeRacajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorGalinhajLabel)
                            .addComponent(valorGalinhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarGalinhajButton)
                            .addComponent(salvarGalinhajButton)))
                    .addComponent(galinhasjScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(conultarGalinheirosjButton)
                .addGap(22, 22, 22)
                .addComponent(voltarGalinhajButton)
                .addGap(58, 58, 58))
        );

        controlejPanel.add(galinhasjPanel, "card5");

        registroAbrigosjPanel.setBackground(new java.awt.Color(0, 255, 153));

        registroAbrigosjLabel.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        registroAbrigosjLabel.setText("Registrar novo abrigo:");

        tipoAbrigojLabel.setText("ID:");

        tipoAbrigojComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Nenhum>", "Galinheiro", "Chiqueiro", "Aprisco", "Curral" }));
        tipoAbrigojComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAbrigojComboBoxActionPerformed(evt);
            }
        });

        espacojLabel.setText("Espaço:");

        regristroAbrigosSalvarjButton.setText("Salvar");
        regristroAbrigosSalvarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regristroAbrigosSalvarjButtonActionPerformed(evt);
            }
        });

        registroAbrigosCanceljButton.setText("Cancelar");
        registroAbrigosCanceljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroAbrigosCanceljButtonActionPerformed(evt);
            }
        });

        idAbrigojLabel.setText("Tipo:");

        IDjTextField.setEditable(false);

        registroAbrigosVoltarjButton.setText("<<<");
        registroAbrigosVoltarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroAbrigosVoltarjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registroAbrigosjPanelLayout = new javax.swing.GroupLayout(registroAbrigosjPanel);
        registroAbrigosjPanel.setLayout(registroAbrigosjPanelLayout);
        registroAbrigosjPanelLayout.setHorizontalGroup(
            registroAbrigosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroAbrigosjPanelLayout.createSequentialGroup()
                .addGroup(registroAbrigosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registroAbrigosjPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(registroAbrigosjLabel))
                    .addGroup(registroAbrigosjPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(registroAbrigosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(espacojLabel)
                            .addComponent(tipoAbrigojLabel)
                            .addComponent(idAbrigojLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(registroAbrigosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tipoAbrigojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(espacojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDjTextField))))
                .addContainerGap(385, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registroAbrigosjPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(registroAbrigosVoltarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registroAbrigosCanceljButton)
                .addGap(18, 18, 18)
                .addComponent(regristroAbrigosSalvarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        registroAbrigosjPanelLayout.setVerticalGroup(
            registroAbrigosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registroAbrigosjPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(registroAbrigosjLabel)
                .addGap(29, 29, 29)
                .addGroup(registroAbrigosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoAbrigojLabel)
                    .addComponent(IDjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(registroAbrigosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoAbrigojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idAbrigojLabel))
                .addGap(18, 18, 18)
                .addGroup(registroAbrigosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(espacojLabel)
                    .addComponent(espacojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addGroup(registroAbrigosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registroAbrigosCanceljButton)
                    .addComponent(regristroAbrigosSalvarjButton)
                    .addComponent(registroAbrigosVoltarjButton))
                .addGap(33, 33, 33))
        );

        controlejPanel.add(registroAbrigosjPanel, "card9");

        chiqueirosjPanel.setBackground(new java.awt.Color(0, 255, 153));

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
        chiqueirosjScrollPane.setViewportView(porcosjTable);

        voltarChiqueirosjButton.setText("<<<");
        voltarChiqueirosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarChiqueirosjButtonActionPerformed(evt);
            }
        });

        abrigosPorcosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        abrigosPorcosjLabel.setText("Chiqueiros");

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

        javax.swing.GroupLayout chiqueirosjPanelLayout = new javax.swing.GroupLayout(chiqueirosjPanel);
        chiqueirosjPanel.setLayout(chiqueirosjPanelLayout);
        chiqueirosjPanelLayout.setHorizontalGroup(
            chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chiqueirosjPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltarChiqueirosjButton)
                .addGap(32, 32, 32))
            .addGroup(chiqueirosjPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(abrigosPorcosjLabel)
                    .addComponent(chiqueirosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(chiqueirosjPanelLayout.createSequentialGroup()
                        .addGroup(chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idPorcojLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomePorcojLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idPorcojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(racaPorcojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tituloCadastroPorcojLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chiqueirosjPanelLayout.createSequentialGroup()
                        .addComponent(valorPorcojLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chiqueirosjPanelLayout.createSequentialGroup()
                                .addComponent(cancelarPorcojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(salvarPorcojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(valorPorcojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(79, 79, 79))
        );
        chiqueirosjPanelLayout.setVerticalGroup(
            chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chiqueirosjPanelLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abrigosPorcosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCadastroPorcojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chiqueirosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(chiqueirosjPanelLayout.createSequentialGroup()
                        .addGroup(chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idPorcojLabel)
                            .addComponent(idPorcojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomePorcojLabel)
                            .addComponent(racaPorcojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorPorcojLabel)
                            .addComponent(valorPorcojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(chiqueirosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarPorcojButton)
                            .addComponent(salvarPorcojButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(voltarChiqueirosjButton)
                .addGap(27, 27, 27))
        );

        controlejPanel.add(chiqueirosjPanel, "card5");

        apriscosjPanel.setBackground(new java.awt.Color(0, 255, 153));

        apriscosjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "qtdAnimais", "Capacidade"
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
        ovelhasjScrollPane.setViewportView(apriscosjTable);

        voltarOvelhasjButton.setText("<<<");
        voltarOvelhasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarOvelhasjButtonActionPerformed(evt);
            }
        });

        abrigosOvelhasjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        abrigosOvelhasjLabel.setText("Apriscos");

        idOvelhajLabel.setText("ID:");

        racaOvelhajLabel.setText("Cor:");

        idOvelhajTextField.setEditable(false);

        corOvelhajComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Nenhum>", "Branca", "Marrom", "Preta", "Cinza", "Grisalho", "Amarelo", "Ocre" }));
        corOvelhajComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corOvelhajComboBoxActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout apriscosjPanelLayout = new javax.swing.GroupLayout(apriscosjPanel);
        apriscosjPanel.setLayout(apriscosjPanelLayout);
        apriscosjPanelLayout.setHorizontalGroup(
            apriscosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, apriscosjPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltarOvelhasjButton)
                .addGap(32, 32, 32))
            .addGroup(apriscosjPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(apriscosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(abrigosOvelhasjLabel)
                    .addComponent(ovelhasjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(apriscosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idOvelhajLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(racaOvelhajLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(valorOvelhajLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(apriscosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(apriscosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(idOvelhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(corOvelhajComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(apriscosjPanelLayout.createSequentialGroup()
                            .addComponent(cancelarOvelhajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(salvarOvelhajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(valorOvelhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tituloCadastroOvelhasjLabel))
                .addGap(103, 103, 103))
        );
        apriscosjPanelLayout.setVerticalGroup(
            apriscosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apriscosjPanelLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(apriscosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abrigosOvelhasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCadastroOvelhasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(apriscosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ovelhasjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(apriscosjPanelLayout.createSequentialGroup()
                        .addGroup(apriscosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idOvelhajLabel)
                            .addComponent(idOvelhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(apriscosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(racaOvelhajLabel)
                            .addComponent(corOvelhajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(apriscosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorOvelhajLabel)
                            .addComponent(valorOvelhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(apriscosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarOvelhajButton)
                            .addComponent(salvarOvelhajButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(voltarOvelhasjButton)
                .addGap(27, 27, 27))
        );

        controlejPanel.add(apriscosjPanel, "card5");

        curraisjPanel.setBackground(new java.awt.Color(0, 255, 153));

        curraisjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "qtdAnimais", "Capacidade"
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
        vacasjScrollPane.setViewportView(curraisjTable);

        voltarVacasjButton.setText("<<<");
        voltarVacasjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarVacasjButtonActionPerformed(evt);
            }
        });

        curraisVacasjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        curraisVacasjLabel.setText("Currais");

        idVacajLabel.setText("ID:");

        nomeVacajLabel.setText("Nome:");

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
        tituloCadastroVacasjLabel.setText("Cadastro de vacas");

        valorVacajLabel.setText("Valor:");

        javax.swing.GroupLayout curraisjPanelLayout = new javax.swing.GroupLayout(curraisjPanel);
        curraisjPanel.setLayout(curraisjPanelLayout);
        curraisjPanelLayout.setHorizontalGroup(
            curraisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, curraisjPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltarVacasjButton)
                .addGap(32, 32, 32))
            .addGroup(curraisjPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(curraisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(curraisVacasjLabel)
                    .addComponent(vacasjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(curraisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(curraisjPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(tituloCadastroVacasjLabel))
                    .addGroup(curraisjPanelLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addGroup(curraisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idVacajLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nomeVacajLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(valorVacajLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(curraisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idVacajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeVacajTextField)
                            .addGroup(curraisjPanelLayout.createSequentialGroup()
                                .addComponent(cancelarVacajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(salvarVacajButton, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                            .addComponent(valorVacajTextField))))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        curraisjPanelLayout.setVerticalGroup(
            curraisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(curraisjPanelLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(curraisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curraisVacasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCadastroVacasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(curraisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vacasjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(curraisjPanelLayout.createSequentialGroup()
                        .addGroup(curraisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idVacajLabel)
                            .addComponent(idVacajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(curraisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeVacajLabel)
                            .addComponent(nomeVacajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(curraisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorVacajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorVacajLabel))
                        .addGap(57, 57, 57)
                        .addGroup(curraisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarVacajButton)
                            .addComponent(salvarVacajButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(voltarVacasjButton)
                .addGap(27, 27, 27))
        );

        controlejPanel.add(curraisjPanel, "card5");

        armazenamentojPanel.setBackground(new java.awt.Color(0, 255, 153));

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

        registrarEntradajButton.setText("Registrar");
        registrarEntradajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarEntradajButtonActionPerformed(evt);
            }
        });

        tabelaSilosjLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        tabelaSilosjLabel.setText("Silos");

        javax.swing.GroupLayout armazenamentojPanelLayout = new javax.swing.GroupLayout(armazenamentojPanel);
        armazenamentojPanel.setLayout(armazenamentojPanelLayout);
        armazenamentojPanelLayout.setHorizontalGroup(
            armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, armazenamentojPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(armazenamentojPanelLayout.createSequentialGroup()
                        .addComponent(tituloCadastroSilosjLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(armazenamentojPanelLayout.createSequentialGroup()
                        .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cancelarSilojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(armazenamentojPanelLayout.createSequentialGroup()
                                        .addComponent(capacidadeSilojLabel)
                                        .addGap(12, 12, 12)
                                        .addComponent(capacidadeSilojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(armazenamentojPanelLayout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addComponent(salvarSilojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(armazenamentojPanelLayout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(idSilojLabel)
                                    .addGap(12, 12, 12)
                                    .addComponent(idSilojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tituloCadastroSilosjLabel1)
                            .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(iDsilojLabel)
                                .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantidadeEntradajLabel)
                                    .addComponent(produtojLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(armazenamentojPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(cancelarEntradajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, armazenamentojPanelLayout.createSequentialGroup()
                                    .addGap(150, 150, 150)
                                    .addComponent(registrarEntradajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(produtojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(quantidadeEntradajSpinner)
                                    .addComponent(IDsilojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)))
                .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(armazenamentojPanelLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(voltarSilosjButton))
                    .addComponent(tabelaSilosjLabel)
                    .addComponent(silosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        armazenamentojPanelLayout.setVerticalGroup(
            armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(armazenamentojPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloCadastroSilosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabelaSilosjLabel))
                .addGap(21, 21, 21)
                .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(armazenamentojPanelLayout.createSequentialGroup()
                        .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idSilojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idSilojLabel))
                        .addGap(18, 18, 18)
                        .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(capacidadeSilojSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capacidadeSilojLabel))
                        .addGap(18, 18, 18)
                        .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarSilojButton)
                            .addComponent(salvarSilojButton))
                        .addGap(41, 41, 41)
                        .addComponent(tituloCadastroSilosjLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(produtojLabel)
                            .addComponent(produtojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantidadeEntradajLabel)
                            .addComponent(quantidadeEntradajSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iDsilojLabel)
                            .addComponent(IDsilojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(silosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(armazenamentojPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(armazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registrarEntradajButton)
                            .addComponent(cancelarEntradajButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, armazenamentojPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(voltarSilosjButton)
                        .addGap(38, 38, 38))))
        );

        controlejPanel.add(armazenamentojPanel, "card5");

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
                .addContainerGap(191, Short.MAX_VALUE))
        );
        produtosjPanelLayout.setVerticalGroup(
            produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(produtosjPanelLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
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
                .addContainerGap(247, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
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

    private void registroAbrigosCanceljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroAbrigosCanceljButtonActionPerformed
        espacojSpinner.setValue(0);
        tipoAbrigojComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_registroAbrigosCanceljButtonActionPerformed

    private void regristroAbrigosSalvarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regristroAbrigosSalvarjButtonActionPerformed

        String id = IDjTextField.getText();
        String tipo = tipoAbrigojComboBox.getSelectedItem().toString();
        String capacidade = espacojSpinner.getValue().toString();



        AbrigoDTO abrigoDTO = new AbrigoDTO(id, tipo, capacidade);
            
        //enviando para a service
        AbrigoService service = new AbrigoServiceImpl();
        try {
            service.salvar(abrigoDTO);
            registroAbrigosCanceljButtonActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Salvo com sucesso!");             
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
          

            
        

    }//GEN-LAST:event_regristroAbrigosSalvarjButtonActionPerformed

    private void tipoAbrigojComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAbrigojComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoAbrigojComboBoxActionPerformed

    private void voltarGalinhajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarGalinhajButtonActionPerformed
        cancelarGalinhajButtonActionPerformed(evt);
        controlejPanel.remove(galinhasjPanel);
        controlejPanel.add(menuAnimaisjPanel);
        menuAnimaisjPanel.setVisible(true);
        menuAnimaisjPanel.setVisible(false);        
    }//GEN-LAST:event_voltarGalinhajButtonActionPerformed

    private void galinhasjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_galinhasjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_galinhasjTableMouseClicked

    private void registrarNovoAbrigojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarNovoAbrigojButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(registroAbrigosjPanel);
        registroAbrigosjPanel.setVisible(false);
        registroAbrigosjPanel.setVisible(true);
    }//GEN-LAST:event_registrarNovoAbrigojButtonActionPerformed

    private void ovelhasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovelhasjButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(apriscosjPanel);
        apriscosjPanel.setVisible(false);
        apriscosjPanel.setVisible(true);
        
        String tipoAbrigo = "Aprisco";
        carregarTabelaAbrigo(tipoAbrigo);
    }//GEN-LAST:event_ovelhasjButtonActionPerformed

    private void vacasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vacasjButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(curraisjPanel);
        curraisjPanel.setVisible(true);
        curraisjPanel.setVisible(false);
        
        String tipoAbrigo = "Curral";
        carregarTabelaAbrigo(tipoAbrigo);
    }//GEN-LAST:event_vacasjButtonActionPerformed

    private void porcosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porcosjButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(chiqueirosjPanel);
        chiqueirosjPanel.setVisible(false);
        chiqueirosjPanel.setVisible(true);
        
        String tipoAnimal = "Porco";
        carregarTabelaAnimais(tipoAnimal);
    }//GEN-LAST:event_porcosjButtonActionPerformed

    private void galinhasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_galinhasjButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(galinhasjPanel);
        galinhasjPanel.setVisible(false);
        galinhasjPanel.setVisible(true);
        
        String tipoAnimal = "Galinha";
        carregarTabelaAnimais(tipoAnimal);
        
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

    private void registroAbrigosVoltarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroAbrigosVoltarjButtonActionPerformed
        registroAbrigosCanceljButtonActionPerformed(evt);
        controlejPanel.remove(registroAbrigosjPanel);
        controlejPanel.add(menuAnimaisjPanel);
        menuAnimaisjPanel.setVisible(false);
        menuAnimaisjPanel.setVisible(true);
    }//GEN-LAST:event_registroAbrigosVoltarjButtonActionPerformed

    private void salvarGalinhajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarGalinhajButtonActionPerformed
        
        String id = idGalinhajTextField.getText();
        String tipo = "Galinha";
        String nomeRaca = nomeRacajTextField.getText();
        String quantidade = "0";
        String valorVenda = valorGalinhajTextField.getText();    
        
        AnimalDTO animalDTO = new AnimalDTO(id, tipo, nomeRaca, quantidade, valorVenda);
        
        AnimalService animalService = new AnimalServiceImpl();
        
     
        try {               
            animalService.salvar(animalDTO);
            cancelarGalinhajButtonActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Nova raça registrada com sucesso!");             
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_salvarGalinhajButtonActionPerformed

    private void cancelarGalinhajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarGalinhajButtonActionPerformed
        nomeRacajTextField.setText("");
        valorGalinhajTextField.setText("");
        //racaGalinhajComboBox.setSelectedIndex(0);
        //galinheirojComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_cancelarGalinhajButtonActionPerformed

    private void porcosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_porcosjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_porcosjTableMouseClicked

    private void voltarChiqueirosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarChiqueirosjButtonActionPerformed
        cancelarPorcojButtonActionPerformed(evt);
        controlejPanel.remove(chiqueirosjPanel);
        controlejPanel.add(menuAnimaisjPanel);
        menuAnimaisjPanel.setVisible(true);
        menuAnimaisjPanel.setVisible(false);
    }//GEN-LAST:event_voltarChiqueirosjButtonActionPerformed

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
            cancelarGalinhajButtonActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Nova raça registrada com sucesso!");             
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_salvarPorcojButtonActionPerformed

    private void cancelarPorcojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPorcojButtonActionPerformed
        valorPorcojTextField.setText("");
        racaPorcojTextField.setText("");
        //racaPorcojComboBox.setSelectedIndex(0);
        //chiqueirojComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_cancelarPorcojButtonActionPerformed

    private void apriscosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apriscosjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_apriscosjTableMouseClicked

    private void voltarOvelhasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarOvelhasjButtonActionPerformed
        cancelarOvelhajButtonActionPerformed(evt);
        controlejPanel.remove(apriscosjPanel);
        controlejPanel.add(menuAnimaisjPanel);
        menuAnimaisjPanel.setVisible(true);
        menuAnimaisjPanel.setVisible(false);  
    }//GEN-LAST:event_voltarOvelhasjButtonActionPerformed

    private void salvarOvelhajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarOvelhajButtonActionPerformed
        String id = idOvelhajTextField.getText();
        //String nome = nomeOvelhajTextField.getText();
        String cor = corOvelhajComboBox.getSelectedItem().toString();
        Double valor = Double.valueOf(valorOvelhajTextField.getText());
        
        //OvelhaDTO ovelha = new OvelhaDTO(id, nome, cor, valor);
        
        OvelhaService ovelhaService = new OvelhaServiceImpl();
        
        
        try{
            //ovelhaService.salvar(ovelha);
            cancelarOvelhajButtonActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Ovelha registrada com sucesso!");
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
        
    }//GEN-LAST:event_salvarOvelhajButtonActionPerformed

    private void cancelarOvelhajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarOvelhajButtonActionPerformed
        valorOvelhajTextField.setText("");
        //nomeOvelhajTextField.setText("");
        corOvelhajComboBox.setSelectedIndex(0);
        //apriscojComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_cancelarOvelhajButtonActionPerformed

    private void curraisjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_curraisjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_curraisjTableMouseClicked

    private void voltarVacasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarVacasjButtonActionPerformed
        cancelarVacajButtonActionPerformed(evt);
        controlejPanel.remove(curraisjPanel);
        controlejPanel.add(menuAnimaisjPanel);
        menuAnimaisjPanel.setVisible(true);
        menuAnimaisjPanel.setVisible(false);
    }//GEN-LAST:event_voltarVacasjButtonActionPerformed

    private void salvarVacajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarVacajButtonActionPerformed
        
        String id = idVacajTextField.getText();
        String nome = nomeVacajTextField.getText();
        //String raca = racaVacajComboBox.getSelectedItem().toString();
        Double valor = Double.valueOf(valorVacajTextField.getText());
        
        //VacaDTO vaca = new VacaDTO(id, nome, raca, valor);
        
        VacaService vacaService = new VacaServiceImpl();
      
        
        try{
            //vacaService.salvar(vaca);
            cancelarVacajButtonActionPerformed(evt);
            JOptionPane.showMessageDialog(this, "Vaca registrada com sucesso!");
        } catch(Exception erro){
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
        
        
    }//GEN-LAST:event_salvarVacajButtonActionPerformed

    private void cancelarVacajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarVacajButtonActionPerformed
        valorVacajTextField.setText("");
        nomeVacajTextField.setText("");
        //racaVacajComboBox.setSelectedIndex(0);
        //curraljComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_cancelarVacajButtonActionPerformed

    private void silosjTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_silosjTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_silosjTableMouseClicked

    private void voltarSilosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarSilosjButtonActionPerformed
        capacidadeSilojSpinner.setValue(0);
        controlejPanel.remove(armazenamentojPanel);
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
        
        try{
            siloService.salvar(silo);
            atualizarTabela();
            JOptionPane.showMessageDialog(this, "Silo salvo com sucesso!");
            capacidadeSilojSpinner.setValue(0);

        } catch(Exception erro){
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
        valorProdutojTextField.setText("0");        
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
        
        try{
            produtoService.salvar(produto);
            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
        } catch(Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }

    }//GEN-LAST:event_salvarProdutojButtonActionPerformed

    private void cancelarProdutojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarProdutojButtonActionPerformed
        nomeProdutojTextField.setText("");
        valorProdutojTextField.setText("0");
        
    }//GEN-LAST:event_cancelarProdutojButtonActionPerformed

    private void consultarArmazenamentojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarArmazenamentojButtonActionPerformed
        controlejPanel.remove(produtosjPanel);
        controlejPanel.add(armazenamentojPanel);
        armazenamentojPanel.setVisible(false);
        armazenamentojPanel.setVisible(true);
        

    }//GEN-LAST:event_consultarArmazenamentojButtonActionPerformed

    private void entrarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarjButtonActionPerformed
        String usuario = usuariojTextField.getText();
        String senha = senhajTextField.getText();
              
        UsuarioPersistencia persistencia = new UsuarioPersistenciaImpl();
        
        boolean login = persistencia.login(usuario, senha);
        
        try {
            
            if(login) {
                controlejPanel.removeAll();
                controlejPanel.add(menuPrincipaljPanel);
                menuPrincipaljPanel.setVisible(false);
                menuPrincipaljPanel.setVisible(true);
            }
        } catch (Exception erro){            
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
        
        try{
            usuarioService.salvar(usuario);
            JOptionPane.showMessageDialog(this, "Cadastro completo! Volte à tela de login e acesse agora");
        } catch(Exception erro) {
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
        int quantidade = Integer.parseInt(quantidadeEntradajSpinner.getValue().toString());
        int siloId = Integer.parseInt(IDsilojComboBox.getSelectedItem().toString()); 
        
           
        SiloPersistencia siloPersistencia = new SiloPersistenciaImpl();
        
        siloPersistencia.entradaEstoque(siloId, quantidade);
        
        ProdutoPersistencia produtoPersistencia = new ProdutoPersistenciaImpl();
        
        produtoPersistencia.atualizarEstoque(NomeProduto, quantidade);
        
        atualizarTabela();
                
    }//GEN-LAST:event_registrarEntradajButtonActionPerformed

    private void corOvelhajComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corOvelhajComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_corOvelhajComboBoxActionPerformed

    private void conultarGalinheirosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conultarGalinheirosjButtonActionPerformed
    }//GEN-LAST:event_conultarGalinheirosjButtonActionPerformed

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
    private javax.swing.JTextField IDjTextField;
    private javax.swing.JComboBox<String> IDsilojComboBox;
    private javax.swing.JLabel abrigosGalinhasjLabel;
    private javax.swing.JLabel abrigosOvelhasjLabel;
    private javax.swing.JLabel abrigosPorcosjLabel;
    private javax.swing.JLabel abrigosjLabel;
    private javax.swing.JButton animaisjButton;
    private javax.swing.JPanel apriscosjPanel;
    private javax.swing.JTable apriscosjTable;
    private javax.swing.JPanel armazenamentojPanel;
    private javax.swing.JButton cadastrarContajButton;
    private javax.swing.JLabel cadastroSenhajLabel;
    private javax.swing.JTextField cadastroSenhajTextField;
    private javax.swing.JLabel cadastroUsuariojLabel;
    private javax.swing.JTextField cadastroUsuariojTextField;
    private javax.swing.JLabel cadastrojLabel;
    private javax.swing.JPanel cadastrojPanel;
    private javax.swing.JButton cancelarEntradajButton;
    private javax.swing.JButton cancelarGalinhajButton;
    private javax.swing.JButton cancelarOvelhajButton;
    private javax.swing.JButton cancelarPorcojButton;
    private javax.swing.JButton cancelarProdutojButton;
    private javax.swing.JButton cancelarSilojButton;
    private javax.swing.JButton cancelarVacajButton;
    private javax.swing.JLabel capacidadeSilojLabel;
    private javax.swing.JSpinner capacidadeSilojSpinner;
    private javax.swing.JPanel chiqueirosjPanel;
    private javax.swing.JScrollPane chiqueirosjScrollPane;
    private javax.swing.JButton confirmarjButton;
    private javax.swing.JButton consultarArmazenamentojButton;
    private javax.swing.JPanel controlejPanel;
    private javax.swing.JButton conultarGalinheirosjButton;
    private javax.swing.JComboBox<String> corOvelhajComboBox;
    private javax.swing.JLabel curraisVacasjLabel;
    private javax.swing.JPanel curraisjPanel;
    private javax.swing.JTable curraisjTable;
    private javax.swing.JButton entrarjButton;
    private javax.swing.JLabel espacojLabel;
    private javax.swing.JSpinner espacojSpinner;
    private javax.swing.JButton galinhasjButton;
    private javax.swing.JPanel galinhasjPanel;
    private javax.swing.JScrollPane galinhasjScrollPane;
    private javax.swing.JTable galinhasjTable;
    private javax.swing.JLabel iDsilojLabel;
    private javax.swing.JLabel idAbrigojLabel;
    private javax.swing.JLabel idGalinhajLabel;
    private javax.swing.JTextField idGalinhajTextField;
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
    private javax.swing.JTextField nomeRacajTextField;
    private javax.swing.JLabel nomeVacajLabel;
    private javax.swing.JTextField nomeVacajTextField;
    private javax.swing.JLabel nomejLabel;
    private javax.swing.JTextField nomejTextField;
    private javax.swing.JButton ovelhasjButton;
    private javax.swing.JScrollPane ovelhasjScrollPane;
    private javax.swing.JButton plantacoesjButton;
    private javax.swing.JButton porcosjButton;
    private javax.swing.JTable porcosjTable;
    private javax.swing.JComboBox<String> produtojComboBox;
    private javax.swing.JLabel produtojLabel;
    private javax.swing.JButton produtosjButton;
    private javax.swing.JLabel produtosjLabel;
    private javax.swing.JPanel produtosjPanel;
    private javax.swing.JScrollPane produtosjScrollPane;
    private javax.swing.JTable produtosjTable;
    private javax.swing.JLabel quantidadeEntradajLabel;
    private javax.swing.JSpinner quantidadeEntradajSpinner;
    private javax.swing.JLabel racaOvelhajLabel;
    private javax.swing.JTextField racaPorcojTextField;
    private javax.swing.JButton registrarEntradajButton;
    private javax.swing.JButton registrarNovoAbrigojButton;
    private javax.swing.JButton registroAbrigosCanceljButton;
    private javax.swing.JButton registroAbrigosVoltarjButton;
    private javax.swing.JLabel registroAbrigosjLabel;
    private javax.swing.JPanel registroAbrigosjPanel;
    private javax.swing.JButton regristroAbrigosSalvarjButton;
    private javax.swing.JButton sairjButton;
    private javax.swing.JButton salvarGalinhajButton;
    private javax.swing.JButton salvarOvelhajButton;
    private javax.swing.JButton salvarPorcojButton;
    private javax.swing.JButton salvarProdutojButton;
    private javax.swing.JButton salvarSilojButton;
    private javax.swing.JButton salvarVacajButton;
    private javax.swing.JLabel senhajLabel;
    private javax.swing.JTextField senhajTextField;
    private javax.swing.JScrollPane silosjScrollPane;
    private javax.swing.JTable silosjTable;
    private javax.swing.JLabel tabelaSilosjLabel;
    private javax.swing.JFormattedTextField telefonejFormattedTextField;
    private javax.swing.JLabel telefonejLabel;
    private javax.swing.JComboBox<String> tipoAbrigojComboBox;
    private javax.swing.JLabel tipoAbrigojLabel;
    private javax.swing.JLabel tituloCadastroGalinhasjLabel1;
    private javax.swing.JLabel tituloCadastroOvelhasjLabel;
    private javax.swing.JLabel tituloCadastroPorcojLabel;
    private javax.swing.JLabel tituloCadastroProdutosjLabel;
    private javax.swing.JLabel tituloCadastroSilosjLabel;
    private javax.swing.JLabel tituloCadastroSilosjLabel1;
    private javax.swing.JLabel tituloCadastroVacasjLabel;
    private javax.swing.JLabel usuariojLabel;
    private javax.swing.JTextField usuariojTextField;
    private javax.swing.JButton vacasjButton;
    private javax.swing.JScrollPane vacasjScrollPane;
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
    private javax.swing.JButton voltarChiqueirosjButton;
    private javax.swing.JButton voltarGalinhajButton;
    private javax.swing.JButton voltarMenuAnimaisjButton;
    private javax.swing.JButton voltarOvelhasjButton;
    private javax.swing.JButton voltarProdutosjButton;
    private javax.swing.JButton voltarSilosjButton;
    private javax.swing.JButton voltarVacasjButton;
    private javax.swing.JButton voltarjButton;
    // End of variables declaration//GEN-END:variables
}

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
import br.ufmt.poo.FarmEasy.UI.DTOs.TransacaoDTO;
import br.ufmt.poo.FarmEasy.UI.DTOs.UsuarioDTO;
import br.ufmt.poo.FarmEasy.persistencias.AbrigoPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.AnimalPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.ProdutoPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.SiloPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.UsuarioPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.impl.AbrigoPersistenciaImpl;
import br.ufmt.poo.FarmEasy.persistencias.impl.AnimalPersistenciaImpl;
import br.ufmt.poo.FarmEasy.persistencias.impl.BancoDeDados;
import br.ufmt.poo.FarmEasy.persistencias.impl.ProdutoPersistenciaImpl;
import br.ufmt.poo.FarmEasy.persistencias.impl.SiloPersistenciaImpl;
import br.ufmt.poo.FarmEasy.persistencias.impl.UsuarioPersistenciaImpl;
import br.ufmt.poo.FarmEasy.services.AnimalService;
import br.ufmt.poo.FarmEasy.services.TransacaoService;
import br.ufmt.poo.FarmEasy.services.UsuarioService;
import br.ufmt.poo.FarmEasy.services.impl.AnimalServiceImpl;
import br.ufmt.poo.FarmEasy.services.impl.SiloServiceImpl;
import br.ufmt.poo.FarmEasy.services.impl.TransacaoServiceImpl;
import br.ufmt.poo.FarmEasy.services.impl.UsuarioServiceImpl;
import java.util.ArrayList;

/**
 *
 * @author arthurmarques
 */
public class InicioJFrame extends javax.swing.JFrame {

    /**
     * Creates new form menuJFrame
     */
    static int idUsuario;

    public InicioJFrame() {
        initComponents();
    }

    private void atualizarTabelaAnimais(int idUsuario, String tipoAnimal) {

        AnimalService animalServiceGalinha = new AnimalServiceImpl();

        List<AnimalDTO> listaGalinhas = animalServiceGalinha.listar(idUsuario, tipoAnimal);

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

        List<AnimalDTO> listaPorcos = animalServicePorco.listar(idUsuario, tipoAnimal);

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

        List<AnimalDTO> listaOvelhas = animalServiceOvelha.listar(idUsuario, tipoAnimal);

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

        List<AnimalDTO> listaVacas = animalServiceVaca.listar(idUsuario, tipoAnimal);

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

    private void atualizarTabelaAbrigo(int idUsuario, String tipoAbrigo) {

        AbrigoService serviceAbrigo = new AbrigoServiceImpl();

        List<AbrigoDTO> listaAbrigos = serviceAbrigo.listar(idUsuario, tipoAbrigo);

        switch (tipoAbrigo) {

            case ("Galinheiro"):

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
                break;

            case ("Chiqueiro"):

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
                break;

            case ("Aprisco"):
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
                break;

            case ("Curral"):

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

                break;
        }
    }

    private void atualizarTabelaProdutos(int idUsuario) {

        ProdutoService produtoService = new ProdutoServiceImpl();
        List<ProdutoDTO> listaProdutos = produtoService.listar(idUsuario);

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

    private void atualizarTabelaSilos(int idUsuario) {

        SiloService siloService = new SiloServiceImpl();
        List<SiloDTO> listaSilos = siloService.listar(idUsuario);

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

    private void atualizarTabelaRacas(String tipoAnimal) {

        AnimalService animalServiceGalinha = new AnimalServiceImpl();
        List<AnimalDTO> listaGalinhas = animalServiceGalinha.listar(idUsuario, tipoAnimal);

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
        List<AnimalDTO> listaPorcos = animalServicePorco.listar(idUsuario, tipoAnimal);

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
        List<AnimalDTO> listaOvelhas = animalServiceOvelha.listar(idUsuario, tipoAnimal);

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
        List<AnimalDTO> listaVacas = animalServiceVaca.listar(idUsuario, tipoAnimal);

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

    private void atualizarTabelaHistorico(int idUsuario) {

        TransacaoService transacaoService = new TransacaoServiceImpl();
        List<TransacaoDTO> listaTransacoes = transacaoService.listar(idUsuario);

        DefaultTableModel dfmTransacao = (DefaultTableModel) historicojTable.getModel();
        int linhasTransacao = dfmTransacao.getRowCount();
        for (int i = 0; i < linhasTransacao; i++) {
            dfmTransacao.removeRow(0);
        }

        for (TransacaoDTO transacaoDTO : listaTransacoes) {
            Object[] linhaTransacao = new Object[7];
            linhaTransacao[0] = transacaoDTO.getId();
            linhaTransacao[1] = transacaoDTO.getEntradaSaida();
            linhaTransacao[2] = transacaoDTO.getEntidade();
            linhaTransacao[3] = transacaoDTO.getTipoEntidade();
            linhaTransacao[4] = transacaoDTO.getQuantidade();
            linhaTransacao[5] = transacaoDTO.getIdArmazenamento();
            linhaTransacao[6] = transacaoDTO.getData();

            dfmTransacao.addRow(linhaTransacao);
        }

    }

    private void carregarComboBoxProdutos() {

        ProdutoService produtoService = new ProdutoServiceImpl();
        List<ProdutoDTO> listaProdutos = produtoService.listar(idUsuario);
        produtojComboBox.removeAllItems();

        for (ProdutoDTO produtoDTO : listaProdutos) {
            produtojComboBox.addItem(produtoDTO.getNome());
        }
    }

    private void carregarComboBoxIdSilos() {

        SiloService siloService = new SiloServiceImpl();
        List<SiloDTO> listaSilos = siloService.listar(idUsuario);
        IDsilojComboBox.removeAllItems();

        for (SiloDTO siloDTO : listaSilos) {
            IDsilojComboBox.addItem(siloDTO.getId());
        }
    }

    private void carregarComboBoxRacas() {

        AnimalService animalServiceGalinha = new AnimalServiceImpl();
        List<AnimalDTO> listaGalinhas = animalServiceGalinha.listar(idUsuario, "Galinha");
        racaGalinhajComboBox.removeAllItems();

        for (AnimalDTO animalDTO : listaGalinhas) {

            racaGalinhajComboBox.addItem(animalDTO.getRaca());

        }

        AnimalService animalServicePorco = new AnimalServiceImpl();
        List<AnimalDTO> listaPorcos = animalServicePorco.listar(idUsuario, "Porco");
        racaPorcojComboBox.removeAllItems();

        for (AnimalDTO animalDTO : listaPorcos) {

            racaPorcojComboBox.addItem(animalDTO.getRaca());
        }

        AnimalService animalServiceOvelha = new AnimalServiceImpl();
        List<AnimalDTO> listaOvelhas = animalServiceOvelha.listar(idUsuario, "Ovelha");
        corOvelhajComboBox.removeAllItems();

        for (AnimalDTO animalDTO : listaOvelhas) {

            corOvelhajComboBox.addItem(animalDTO.getRaca());
        }

        AnimalService animalServiceVaca = new AnimalServiceImpl();
        List<AnimalDTO> listaVacas = animalServiceVaca.listar(idUsuario, "Vaca");
        racaVacajComboBox.removeAllItems();

        for (AnimalDTO animalDTO : listaVacas) {

            racaVacajComboBox.addItem(animalDTO.getRaca());
        }

    }

    private void carregarComboBoxIdAbrigos(int idUsuario) {

        AbrigoService abrigoServiceGalinheiro = new AbrigoServiceImpl();
        List<AbrigoDTO> listaAbrigoGalinheiro = abrigoServiceGalinheiro.listar(idUsuario, "Galinheiro");
        idGalinheirojComboBox.removeAllItems();

        for (AbrigoDTO abrigoDTO : listaAbrigoGalinheiro) {
            idGalinheirojComboBox.addItem(abrigoDTO.getId());
        }

        AbrigoService abrigoServiceAprisco = new AbrigoServiceImpl();
        List<AbrigoDTO> listaAbrigoAprisco = abrigoServiceAprisco.listar(idUsuario, "Aprisco");
        idApriscojComboBox.removeAllItems();

        for (AbrigoDTO abrigoDTO : listaAbrigoAprisco) {
            idApriscojComboBox.addItem(abrigoDTO.getId());
        }

        AbrigoService abrigoServiceChiqueiro = new AbrigoServiceImpl();
        List<AbrigoDTO> listaAbrigoChiqueiro = abrigoServiceChiqueiro.listar(idUsuario, "Chiqueiro");
        idChiqueirojComboBox.removeAllItems();

        for (AbrigoDTO abrigoDTO : listaAbrigoChiqueiro) {
            idChiqueirojComboBox.addItem(abrigoDTO.getId());
        }

        AbrigoService abrigoServiceCurral = new AbrigoServiceImpl();
        List<AbrigoDTO> listaAbrigoCurral = abrigoServiceCurral.listar(idUsuario, "Curral");
        idCurraljComboBox.removeAllItems();

        for (AbrigoDTO abrigoDTO : listaAbrigoCurral) {
            idCurraljComboBox.addItem(abrigoDTO.getId());
        }
    }

    private void carregarComboBoxFiltroIdArmazenamentos(int idUsuario, String entidade) {

        if (entidade.equals("Produto")) {

            idArmazenamentojComboBox.removeAllItems();
            idArmazenamentojComboBox.addItem("<Nenhum>");

            SiloService siloService = new SiloServiceImpl();
            List<SiloDTO> listaSilos = siloService.listar(idUsuario);

            for (SiloDTO siloDTO : listaSilos) {
                idArmazenamentojComboBox.addItem(siloDTO.getId());
            }

        } else if (entidade.equals("Galinha")) {

            idArmazenamentojComboBox.removeAllItems();
            idArmazenamentojComboBox.addItem("<Nenhum>");

            AbrigoService abrigoServiceGalinheiro = new AbrigoServiceImpl();
            List<AbrigoDTO> listaAbrigoGalinheiro = abrigoServiceGalinheiro.listar(idUsuario, "Galinheiro");

            for (AbrigoDTO abrigoDTO : listaAbrigoGalinheiro) {
                idArmazenamentojComboBox.addItem(abrigoDTO.getId());
            }
        } else if (entidade.equals("Ovelha")) {

            idArmazenamentojComboBox.removeAllItems();
            idArmazenamentojComboBox.addItem("<Nenhum>");

            AbrigoService abrigoServiceAprisco = new AbrigoServiceImpl();
            List<AbrigoDTO> listaAbrigoAprisco = abrigoServiceAprisco.listar(idUsuario, "Aprisco");

            for (AbrigoDTO abrigoDTO : listaAbrigoAprisco) {
                idArmazenamentojComboBox.addItem(abrigoDTO.getId());
            }
        } else if (entidade.equals("Porco")) {

            idArmazenamentojComboBox.removeAllItems();
            idArmazenamentojComboBox.addItem("<Nenhum>");

            AbrigoService abrigoServiceChiqueiro = new AbrigoServiceImpl();
            List<AbrigoDTO> listaAbrigoChiqueiro = abrigoServiceChiqueiro.listar(idUsuario, "Chiqueiro");

            for (AbrigoDTO abrigoDTO : listaAbrigoChiqueiro) {
                idArmazenamentojComboBox.addItem(abrigoDTO.getId());
            }

        } else if (entidade.equals("Vaca")) {

            idArmazenamentojComboBox.removeAllItems();
            idArmazenamentojComboBox.addItem("<Nenhum>");

            AbrigoService abrigoServiceCurral = new AbrigoServiceImpl();
            List<AbrigoDTO> listaAbrigoCurral = abrigoServiceCurral.listar(idUsuario, "Curral");

            for (AbrigoDTO abrigoDTO : listaAbrigoCurral) {
                idArmazenamentojComboBox.addItem(abrigoDTO.getId());
            }

        }
    }

    private void carregarComboBoxFiltroTipoEntidade(int idUsuario, String entidade) {

        if (!entidade.equals("<Nenhum>")) {

            switch (entidade) {

                case ("Produto"):
                    
                    tipoEntidadejComboBox.removeAllItems();
                    tipoEntidadejComboBox.addItem("<Nenhum>");
                    
                    ProdutoService produtoService = new ProdutoServiceImpl();
                    List<ProdutoDTO> listaProdutos = produtoService.listar(idUsuario);

                    for (ProdutoDTO produtoDTO : listaProdutos) {
                        tipoEntidadejComboBox.addItem(produtoDTO.getNome());
                    }

                    break;

                case ("Galinha"):
                    
                    tipoEntidadejComboBox.removeAllItems();
                    tipoEntidadejComboBox.addItem("<Nenhum>");
                    
                    AnimalService animalServiceGalinha = new AnimalServiceImpl();
                    List<AnimalDTO> listaGalinhas = animalServiceGalinha.listar(idUsuario, "Galinha");

                    for (AnimalDTO animalDTO : listaGalinhas) {

                        tipoEntidadejComboBox.addItem(animalDTO.getRaca());

                    }

                    break;

                case ("Porco"):
                    
                    tipoEntidadejComboBox.removeAllItems();
                    tipoEntidadejComboBox.addItem("<Nenhum>");
                    
                    AnimalService animalServicePorco = new AnimalServiceImpl();
                    List<AnimalDTO> listaPorcos = animalServicePorco.listar(idUsuario, "Porco");

                    for (AnimalDTO animalDTO : listaPorcos) {

                        tipoEntidadejComboBox.addItem(animalDTO.getRaca());
                    }

                    break;

                case ("Ovelha"):
                    
                    tipoEntidadejComboBox.removeAllItems();
                    tipoEntidadejComboBox.addItem("<Nenhum>");
                    
                    AnimalService animalServiceOvelha = new AnimalServiceImpl();
                    List<AnimalDTO> listaOvelhas = animalServiceOvelha.listar(idUsuario, "Ovelha");

                    for (AnimalDTO animalDTO : listaOvelhas) {

                        tipoEntidadejComboBox.addItem(animalDTO.getRaca());
                    }

                    break;

                case ("Vaca"):
                    
                    tipoEntidadejComboBox.removeAllItems();
                    tipoEntidadejComboBox.addItem("<Nenhum>");
                    
                    AnimalService animalServiceVaca = new AnimalServiceImpl();
                    List<AnimalDTO> listaVacas = animalServiceVaca.listar(idUsuario, "Vaca");

                    for (AnimalDTO animalDTO : listaVacas) {

                        tipoEntidadejComboBox.addItem(animalDTO.getRaca());
                    }

                    break;
            }
        }
    }

    private void aplicarFiltrosHistorico(int idUsuario) {

        List<String> filtros = new ArrayList();
        filtros.add(entradaSaidajComboBox.getSelectedItem().toString());
        filtros.add(entidadejComboBox.getSelectedItem().toString());
        filtros.add(tipoEntidadejComboBox.getSelectedItem().toString());
        filtros.add(idArmazenamentojComboBox.getSelectedItem().toString());
        filtros.add(diajComboBox.getSelectedItem().toString());

        TransacaoService transacaoService = new TransacaoServiceImpl();
        List<TransacaoDTO> listaTransacoes = transacaoService.listarFiltros(idUsuario, filtros);

        DefaultTableModel dfmTransacao = (DefaultTableModel) historicojTable.getModel();
        int linhasTransacao = dfmTransacao.getRowCount();
        for (int i = 0; i < linhasTransacao; i++) {
            dfmTransacao.removeRow(0);
        }

        for (TransacaoDTO transacaoDTO : listaTransacoes) {
            Object[] linhaTransacao = new Object[7];
            linhaTransacao[0] = transacaoDTO.getId();
            linhaTransacao[1] = transacaoDTO.getEntradaSaida();
            linhaTransacao[2] = transacaoDTO.getEntidade();
            linhaTransacao[3] = transacaoDTO.getTipoEntidade();
            linhaTransacao[4] = transacaoDTO.getQuantidade();
            linhaTransacao[5] = transacaoDTO.getIdArmazenamento();
            linhaTransacao[6] = transacaoDTO.getData();

            dfmTransacao.addRow(linhaTransacao);
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
        jLabel1 = new javax.swing.JLabel();
        menuPrincipaljPanel = new javax.swing.JPanel();
        sairjButton = new javax.swing.JButton();
        produtosjButton = new javax.swing.JButton();
        historicojButton = new javax.swing.JButton();
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
        removerRacaGalinhajButton = new javax.swing.JButton();
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
        quantidadeGalinhasjSpinner = new javax.swing.JSpinner();
        idGalinheirojLabel1 = new javax.swing.JLabel();
        racaGalinhajComboBox = new javax.swing.JComboBox<>();
        cancelarEntradaGalinhasjButton = new javax.swing.JButton();
        registrarEntradaGalinhasjButton = new javax.swing.JButton();
        tabelaGalinheirosjLabel = new javax.swing.JLabel();
        removerGalinheirojButton = new javax.swing.JButton();
        operacaoGalinhasjLabel = new javax.swing.JLabel();
        operacaoGalinhajComboBox = new javax.swing.JComboBox<>();
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
        removerRacaPorcojButton = new javax.swing.JButton();
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
        quantidadePorcosjSpinner = new javax.swing.JSpinner();
        idEntradaChiqueirojLabel = new javax.swing.JLabel();
        racaPorcojComboBox = new javax.swing.JComboBox<>();
        cancelarEntradaPorcosjButton = new javax.swing.JButton();
        registrarEntradaPorcosjButton = new javax.swing.JButton();
        tabelaPorcosjLabel = new javax.swing.JLabel();
        removerChiqueirojButton = new javax.swing.JButton();
        operacaoPorcosjComboBox = new javax.swing.JComboBox<>();
        operacaoPorcosjLabel = new javax.swing.JLabel();
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
        removerRacaOvelhajButton = new javax.swing.JButton();
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
        quantidadeOvelhasjSpinner = new javax.swing.JSpinner();
        idEntradaApriscojLabel = new javax.swing.JLabel();
        corOvelhajComboBox = new javax.swing.JComboBox<>();
        cancelarEntradaOvelhasjButton = new javax.swing.JButton();
        registrarEntradaOvelhasjButton = new javax.swing.JButton();
        tabelaOvelhasjLabel = new javax.swing.JLabel();
        removerApriscojButton = new javax.swing.JButton();
        operacaoOvelhasjComboBox = new javax.swing.JComboBox<>();
        operacaoOvelhasjLabel = new javax.swing.JLabel();
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
        removerRacaVacajButton = new javax.swing.JButton();
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
        quantidadeVacasjSpinner = new javax.swing.JSpinner();
        idChiqueirojLabel = new javax.swing.JLabel();
        racaVacajComboBox = new javax.swing.JComboBox<>();
        cancelarEntradaVacasjButton = new javax.swing.JButton();
        registrarEntradaVacasjButton = new javax.swing.JButton();
        tabelaCurraisjLabel = new javax.swing.JLabel();
        removerCurraljButton = new javax.swing.JButton();
        operacaoVacasjLabel = new javax.swing.JLabel();
        operacaoVacasjComboBox = new javax.swing.JComboBox<>();
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
        quantidadeProdutosjSpinner = new javax.swing.JSpinner();
        iDsilojLabel = new javax.swing.JLabel();
        produtojComboBox = new javax.swing.JComboBox<>();
        cancelarEntradajButton = new javax.swing.JButton();
        registrarEntradajButton = new javax.swing.JButton();
        tabelaSilosjLabel = new javax.swing.JLabel();
        removerSilojButton = new javax.swing.JButton();
        operacaoProdutojComboBox = new javax.swing.JComboBox<>();
        operacaoProdutojLabel = new javax.swing.JLabel();
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
        removerProdutojButton = new javax.swing.JButton();
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
        idUsuariojLabel = new javax.swing.JLabel();
        idUsuariojTextField = new javax.swing.JTextField();
        historicojPanel = new javax.swing.JPanel();
        historicojScrollPane = new javax.swing.JScrollPane();
        historicojTable = new javax.swing.JTable();
        filtrosjLabel = new javax.swing.JLabel();
        entradaSaidajComboBox = new javax.swing.JComboBox<>();
        entidadejComboBox = new javax.swing.JComboBox<>();
        idArmazenamentojComboBox = new javax.swing.JComboBox<>();
        diajComboBox = new javax.swing.JComboBox<>();
        entradaSaidajLabel = new javax.swing.JLabel();
        entidadejLabel = new javax.swing.JLabel();
        tipoEntidadejLabel = new javax.swing.JLabel();
        idArmazenamentojLabel = new javax.swing.JLabel();
        diajLabel = new javax.swing.JLabel();
        voltarHistoricojButton = new javax.swing.JButton();
        aplicarFiltrosjButton = new javax.swing.JButton();
        tipoEntidadejComboBox = new javax.swing.JComboBox<>();

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

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel1.setText("Farm Easy");

        javax.swing.GroupLayout loginjPanelLayout = new javax.swing.GroupLayout(loginjPanel);
        loginjPanel.setLayout(loginjPanelLayout);
        loginjPanelLayout.setHorizontalGroup(
            loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginjPanelLayout.createSequentialGroup()
                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginjPanelLayout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loginjPanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(entrarjButton))
                            .addGroup(loginjPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(cadastrarContajButton))
                            .addGroup(loginjPanelLayout.createSequentialGroup()
                                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(senhajLabel)
                                    .addComponent(usuariojLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(senhajTextField)
                                    .addComponent(usuariojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(loginjPanelLayout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(343, Short.MAX_VALUE))
        );
        loginjPanelLayout.setVerticalGroup(
            loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginjPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addGap(81, 81, 81)
                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuariojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuariojLabel))
                .addGap(18, 18, 18)
                .addGroup(loginjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhajLabel))
                .addGap(22, 22, 22)
                .addComponent(entrarjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(cadastrarContajButton)
                .addGap(60, 60, 60))
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

        historicojButton.setText("Histórico de transações");
        historicojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historicojButtonActionPerformed(evt);
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
                .addGap(321, 321, 321)
                .addGroup(menuPrincipaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(animaisjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sairjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(produtosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historicojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(326, Short.MAX_VALUE))
        );
        menuPrincipaljPanelLayout.setVerticalGroup(
            menuPrincipaljPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPrincipaljPanelLayout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(animaisjButton)
                .addGap(37, 37, 37)
                .addComponent(produtosjButton)
                .addGap(37, 37, 37)
                .addComponent(historicojButton)
                .addGap(40, 40, 40)
                .addComponent(sairjButton)
                .addContainerGap(143, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(voltarMenuAnimaisjButton)
                    .addGroup(menuAnimaisjPanelLayout.createSequentialGroup()
                        .addComponent(abrigosjLabel)
                        .addGap(592, 592, 592)))
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuAnimaisjPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(galinhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(porcosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(ovelhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(vacasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        menuAnimaisjPanelLayout.setVerticalGroup(
            menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuAnimaisjPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(abrigosjLabel)
                .addGap(128, 128, 128)
                .addGroup(menuAnimaisjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(porcosjButton)
                    .addComponent(galinhasjButton)
                    .addComponent(ovelhasjButton)
                    .addComponent(vacasjButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
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

        removerRacaGalinhajButton.setText("Remover raça");
        removerRacaGalinhajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerRacaGalinhajButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout galinhasjPanelLayout = new javax.swing.GroupLayout(galinhasjPanel);
        galinhasjPanel.setLayout(galinhasjPanelLayout);
        galinhasjPanelLayout.setHorizontalGroup(
            galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(galinhasjPanelLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voltarGalinhajButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, galinhasjPanelLayout.createSequentialGroup()
                        .addGroup(galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(abrigosGalinhasjLabel)
                            .addComponent(galinhasjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(removerRacaGalinhajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(69, 69, 69)
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
                .addGap(95, 95, 95))
        );
        galinhasjPanelLayout.setVerticalGroup(
            galinhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(galinhasjPanelLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removerRacaGalinhajButton)
                .addGap(20, 20, 20)
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
        tituloEntradaGalinhasjLabel.setText("Registrar transacao de galinhas");

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

        removerGalinheirojButton.setText("Remover abrigo");
        removerGalinheirojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerGalinheirojButtonActionPerformed(evt);
            }
        });

        operacaoGalinhasjLabel.setText("Operação");

        operacaoGalinhajComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saída" }));

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
                    .addGroup(galinhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addComponent(cancelarGalinheirosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(salvarGalinheirojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tituloCadastroGalinheirosjLabel)
                    .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(galinhasArmazenamentojPanelLayout.createSequentialGroup()
                            .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(idGalinheirojLabel1)
                                .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantidadeEntradaGalinhajLabel)
                                    .addComponent(racajLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(operacaoGalinhasjLabel))
                            .addGap(14, 14, 14)
                            .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(racaGalinhajComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantidadeGalinhasjSpinner)
                                .addComponent(idGalinheirojComboBox, 0, 138, Short.MAX_VALUE)
                                .addComponent(operacaoGalinhajComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, galinhasArmazenamentojPanelLayout.createSequentialGroup()
                            .addComponent(cancelarEntradaGalinhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(registrarEntradaGalinhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabelaGalinheirosjLabel)
                    .addComponent(galinheirosjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(removerGalinheirojButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(voltarGalinheirosjButton)
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
                .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(galinhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addComponent(galinheirosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removerGalinheirojButton)
                            .addComponent(voltarGalinheirosjButton)))
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
                        .addGap(32, 32, 32)
                        .addComponent(tituloEntradaGalinhasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(operacaoGalinhasjLabel)
                            .addComponent(operacaoGalinhajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(racajLabel)
                            .addComponent(racaGalinhajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantidadeEntradaGalinhajLabel)
                            .addComponent(quantidadeGalinhasjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idGalinheirojLabel1)
                            .addComponent(idGalinheirojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(galinhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registrarEntradaGalinhasjButton)
                            .addComponent(cancelarEntradaGalinhasjButton))))
                .addContainerGap(45, Short.MAX_VALUE))
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

        removerRacaPorcojButton.setText("Remover raça");
        removerRacaPorcojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerRacaPorcojButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout porcosjPanelLayout = new javax.swing.GroupLayout(porcosjPanel);
        porcosjPanel.setLayout(porcosjPanelLayout);
        porcosjPanelLayout.setHorizontalGroup(
            porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(porcosjPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltarPorcosjButton)
                .addGap(32, 32, 32))
            .addGroup(porcosjPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(removerRacaPorcojButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(porcosjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                    .addComponent(racasPorcosjLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
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
                .addGap(80, 80, 80))
        );
        porcosjPanelLayout.setVerticalGroup(
            porcosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(porcosjPanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(removerRacaPorcojButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
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

        removerChiqueirojButton.setText("Remover chiqueiro");
        removerChiqueirojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerChiqueirojButtonActionPerformed(evt);
            }
        });

        operacaoPorcosjComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saída" }));

        operacaoPorcosjLabel.setText("Operação");

        javax.swing.GroupLayout porcosArmazenamentojPanelLayout = new javax.swing.GroupLayout(porcosArmazenamentojPanel);
        porcosArmazenamentojPanel.setLayout(porcosArmazenamentojPanelLayout);
        porcosArmazenamentojPanelLayout.setHorizontalGroup(
            porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
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
                        .addGap(97, 97, 97))
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
                                        .addComponent(operacaoPorcosjLabel)
                                        .addComponent(idEntradaChiqueirojLabel)
                                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quantidadeEntradaPorcojLabel)
                                            .addComponent(racaPorcojLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(operacaoPorcosjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(racaPorcojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(quantidadePorcosjSpinner)
                                        .addComponent(idChiqueirojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabelaPorcosjLabel)
                    .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(removerChiqueirojButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chiqueirosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(voltarChiqueirosjButton1)))
                .addGap(40, 40, 40))
        );
        porcosArmazenamentojPanelLayout.setVerticalGroup(
            porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloCadastroChiqueirosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabelaPorcosjLabel))
                .addGap(21, 21, 21)
                .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloEntradaChiqueirosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(operacaoPorcosjLabel)
                            .addComponent(operacaoPorcosjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(racaPorcojLabel)
                            .addComponent(racaPorcojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantidadeEntradaPorcojLabel)
                            .addComponent(quantidadePorcosjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idEntradaChiqueirojLabel)
                            .addComponent(idChiqueirojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(chiqueirosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarEntradaPorcosjButton)
                            .addComponent(registrarEntradaPorcosjButton)))
                    .addGroup(porcosArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(porcosArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removerChiqueirojButton)
                            .addComponent(voltarChiqueirosjButton1))))
                .addContainerGap(70, Short.MAX_VALUE))
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

        removerRacaOvelhajButton.setText("Remover ovelha");
        removerRacaOvelhajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerRacaOvelhajButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ovelhasjPanelLayout = new javax.swing.GroupLayout(ovelhasjPanel);
        ovelhasjPanel.setLayout(ovelhasjPanelLayout);
        ovelhasjPanelLayout.setHorizontalGroup(
            ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ovelhasjPanelLayout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ovelhasjPanelLayout.createSequentialGroup()
                        .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(abrigosOvelhasjLabel)
                            .addComponent(ovelhasjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(removerRacaOvelhajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(85, 85, 85)
                        .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloCadastroOvelhasjLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ovelhasjPanelLayout.createSequentialGroup()
                                .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(idOvelhajLabel)
                                    .addComponent(corOvelhajLabel)
                                    .addComponent(valorOvelhajLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(valorOvelhajTextField)
                                    .addComponent(consultarApriscosjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ovelhasjPanelLayout.createSequentialGroup()
                                        .addComponent(cancelarOvelhajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(salvarOvelhajButton, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                    .addComponent(corOvelhajTextField)
                                    .addComponent(idOvelhajTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ovelhasjPanelLayout.createSequentialGroup()
                        .addComponent(voltarOvelhasjButton)
                        .addGap(52, 52, 52))))
        );
        ovelhasjPanelLayout.setVerticalGroup(
            ovelhasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ovelhasjPanelLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(removerRacaOvelhajButton)
                .addGap(11, 11, 11)
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

        corOvelhajComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"<Nenhum>", "Leite", "Ovo"}));

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

        removerApriscojButton.setText("Remover aprisco");
        removerApriscojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerApriscojButtonActionPerformed(evt);
            }
        });

        operacaoOvelhasjComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saída" }));

        operacaoOvelhasjLabel.setText("Operação");

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
                                .addComponent(racaOvelhasjLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(operacaoOvelhasjLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(corOvelhajComboBox, 0, 154, Short.MAX_VALUE)
                            .addComponent(quantidadeOvelhasjSpinner)
                            .addComponent(idApriscojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(operacaoOvelhasjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tituloCadastroApriscosjLabel)
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
                        .addComponent(salvarApriscojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addComponent(cancelarEntradaOvelhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(registrarEntradaOvelhasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addComponent(tabelaOvelhasjLabel)
                        .addGap(179, 179, 179))
                    .addGroup(ovelhasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(removerApriscojButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(apriscosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(voltarApriscosjButton)
                        .addGap(45, 45, 45))))
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
                    .addComponent(apriscosjScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloEntradaOvelhasjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(operacaoOvelhasjLabel)
                            .addComponent(operacaoOvelhasjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(racaOvelhasjLabel)
                            .addComponent(corOvelhajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantidadeEntradaOvelhajLabel)
                            .addComponent(quantidadeOvelhasjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idEntradaApriscojLabel)
                            .addComponent(idApriscojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ovelhasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarEntradaOvelhasjButton)
                    .addComponent(registrarEntradaOvelhasjButton)
                    .addComponent(removerApriscojButton)
                    .addComponent(voltarApriscosjButton))
                .addContainerGap(32, Short.MAX_VALUE))
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

        removerRacaVacajButton.setText("Remover raça");
        removerRacaVacajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerRacaVacajButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout vacasjPanelLayout = new javax.swing.GroupLayout(vacasjPanel);
        vacasjPanel.setLayout(vacasjPanelLayout);
        vacasjPanelLayout.setHorizontalGroup(
            vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vacasjPanelLayout.createSequentialGroup()
                .addContainerGap(758, Short.MAX_VALUE)
                .addComponent(voltarVacasjButton)
                .addGap(32, 32, 32))
            .addGroup(vacasjPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(removerRacaVacajButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vacasjLabel)
                    .addComponent(vacasjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        vacasjPanelLayout.setVerticalGroup(
            vacasjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vacasjPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(consultarCurraisjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(vacasjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(removerRacaVacajButton)
                .addGap(4, 4, 4)
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

        removerCurraljButton.setText("Remover curral");
        removerCurraljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerCurraljButtonActionPerformed(evt);
            }
        });

        operacaoVacasjLabel.setText("Operação");

        operacaoVacasjComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saída" }));

        javax.swing.GroupLayout vacasArmazenamentojPanelLayout = new javax.swing.GroupLayout(vacasArmazenamentojPanel);
        vacasArmazenamentojPanel.setLayout(vacasArmazenamentojPanelLayout);
        vacasArmazenamentojPanelLayout.setHorizontalGroup(
            vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idChiqueirojLabel)
                            .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(quantidadeEntradaVacajLabel)
                                .addComponent(racaVacajLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(operacaoVacasjLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(racaVacajComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantidadeVacasjSpinner)
                            .addComponent(idCurraljComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(operacaoVacasjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(tituloCadastroCurraisjLabel)
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
                            .addComponent(capacidadeCurraljSpinner)
                            .addComponent(idCurraljTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addComponent(cancelarEntradaVacasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(registrarEntradaVacasjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(tituloEntradaCurraisjLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addComponent(tabelaCurraisjLabel)
                        .addGap(200, 200, 200))
                    .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(removerCurraljButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(curraisjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(voltarCurraisjButton)))
                .addGap(44, 44, 44))
        );
        vacasArmazenamentojPanelLayout.setVerticalGroup(
            vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vacasArmazenamentojPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloCadastroCurraisjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabelaCurraisjLabel))
                .addGap(21, 21, 21)
                .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloEntradaCurraisjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(operacaoVacasjLabel)
                            .addComponent(operacaoVacasjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(racaVacajLabel)
                            .addComponent(racaVacajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantidadeEntradaVacajLabel)
                            .addComponent(quantidadeVacasjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idChiqueirojLabel)
                            .addComponent(idCurraljComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(curraisjScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(vacasArmazenamentojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarEntradaVacasjButton)
                    .addComponent(registrarEntradaVacasjButton)
                    .addComponent(removerCurraljButton)
                    .addComponent(voltarCurraisjButton))
                .addContainerGap(52, Short.MAX_VALUE))
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
        tituloCadastroSilosjLabel1.setText("Registrar entrada de produtos");

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

        removerSilojButton.setText("Remover silo");
        removerSilojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerSilojButtonActionPerformed(evt);
            }
        });

        operacaoProdutojComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saída" }));

        operacaoProdutojLabel.setText("Operação:");

        javax.swing.GroupLayout silosjPanelLayout = new javax.swing.GroupLayout(silosjPanel);
        silosjPanel.setLayout(silosjPanelLayout);
        silosjPanelLayout.setHorizontalGroup(
            silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(silosjPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloCadastroSilosjLabel)
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
                    .addGroup(silosjPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(cancelarEntradajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, silosjPanelLayout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(registrarEntradajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(silosjPanelLayout.createSequentialGroup()
                            .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(iDsilojLabel)
                                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quantidadeEntradajLabel)
                                    .addComponent(produtojLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(operacaoProdutojLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(produtojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantidadeProdutosjSpinner)
                                .addComponent(IDsilojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(operacaoProdutojComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(tituloCadastroSilosjLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tabelaSilosjLabel)
                    .addComponent(silosjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(removerSilojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(voltarSilosjButton)
                .addGap(34, 34, 34))
        );
        silosjPanelLayout.setVerticalGroup(
            silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(silosjPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloCadastroSilosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabelaSilosjLabel))
                .addGap(21, 21, 21)
                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloCadastroSilosjLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(operacaoProdutojLabel)
                            .addComponent(operacaoProdutojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(produtojLabel)
                            .addComponent(produtojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantidadeEntradajLabel)
                            .addComponent(quantidadeProdutosjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(iDsilojLabel)
                            .addComponent(IDsilojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(silosjScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(silosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrarEntradajButton)
                    .addComponent(cancelarEntradajButton)
                    .addComponent(removerSilojButton)
                    .addComponent(voltarSilosjButton))
                .addContainerGap(51, Short.MAX_VALUE))
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

        valorProdutojTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorProdutojTextFieldActionPerformed(evt);
            }
        });

        removerProdutojButton.setText("Remover produto");
        removerProdutojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerProdutojButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout produtosjPanelLayout = new javax.swing.GroupLayout(produtosjPanel);
        produtosjPanel.setLayout(produtosjPanelLayout);
        produtosjPanelLayout.setHorizontalGroup(
            produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, produtosjPanelLayout.createSequentialGroup()
                .addContainerGap(758, Short.MAX_VALUE)
                .addComponent(voltarProdutosjButton)
                .addGap(32, 32, 32))
            .addGroup(produtosjPanelLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(removerProdutojButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(produtosjLabel)
                    .addComponent(produtosjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, produtosjPanelLayout.createSequentialGroup()
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
                                    .addComponent(valorProdutojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(produtosjPanelLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(idProdutojLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(idProdutojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, produtosjPanelLayout.createSequentialGroup()
                        .addComponent(consultarArmazenamentojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))))
        );
        produtosjPanelLayout.setVerticalGroup(
            produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(produtosjPanelLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(produtosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCadastroProdutosjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(produtosjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addComponent(salvarProdutojButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(consultarArmazenamentojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(removerProdutojButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            telefonejFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
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

        idUsuariojLabel.setText("ID:");

        idUsuariojTextField.setEditable(false);

        javax.swing.GroupLayout cadastrojPanelLayout = new javax.swing.GroupLayout(cadastrojPanel);
        cadastrojPanel.setLayout(cadastrojPanelLayout);
        cadastrojPanelLayout.setHorizontalGroup(
            cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrojPanelLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(voltarjButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmarjButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrojPanelLayout.createSequentialGroup()
                        .addComponent(cadastrojLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrojPanelLayout.createSequentialGroup()
                        .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(telefonejLabel)
                            .addComponent(CPFjLabel)
                            .addComponent(cadastroUsuariojLabel)
                            .addComponent(cadastroSenhajLabel)
                            .addComponent(nomejLabel)
                            .addComponent(idUsuariojLabel))
                        .addGap(18, 18, 18)
                        .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CPFjFormattedTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefonejFormattedTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomejTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastroUsuariojTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastroSenhajTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idUsuariojTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        cadastrojPanelLayout.setVerticalGroup(
            cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrojPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(cadastrojLabel)
                .addGap(30, 30, 30)
                .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idUsuariojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idUsuariojLabel))
                .addGap(18, 18, 18)
                .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomejLabel))
                .addGap(18, 18, 18)
                .addGroup(cadastrojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonejFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefonejLabel))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(confirmarjButton)
                .addGap(18, 18, 18)
                .addComponent(voltarjButton)
                .addGap(49, 49, 49))
        );

        controlejPanel.add(cadastrojPanel, "card12");

        historicojPanel.setBackground(new java.awt.Color(0, 255, 153));

        historicojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Entrada/saída", "Entidade", "Tipo_entidade", "Quantidade", "ID_armazenamento", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        historicojScrollPane.setViewportView(historicojTable);

        filtrosjLabel.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        filtrosjLabel.setText("Filtros");

        entradaSaidajComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Nenhum>", "entrada", "saida" }));

        entidadejComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entidadejComboBoxActionPerformed(evt);
            }
        });

        idArmazenamentojComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        diajComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Nenhum>", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        entradaSaidajLabel.setText("Entrada/saída:");

        entidadejLabel.setText("Entidade:");

        tipoEntidadejLabel.setText("Tipo_entidade:");

        idArmazenamentojLabel.setText("ID_armazenamento:");

        diajLabel.setText("Dia");

        voltarHistoricojButton.setText("<<<");
        voltarHistoricojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarHistoricojButtonActionPerformed(evt);
            }
        });

        aplicarFiltrosjButton.setText("Aplicar filtros");
        aplicarFiltrosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarFiltrosjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout historicojPanelLayout = new javax.swing.GroupLayout(historicojPanel);
        historicojPanel.setLayout(historicojPanelLayout);
        historicojPanelLayout.setHorizontalGroup(
            historicojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historicojPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(historicojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(historicojPanelLayout.createSequentialGroup()
                        .addGroup(historicojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(entradaSaidajComboBox, 0, 144, Short.MAX_VALUE)
                            .addComponent(entidadejComboBox, 0, 144, Short.MAX_VALUE)
                            .addComponent(filtrosjLabel)
                            .addComponent(idArmazenamentojComboBox, 0, 144, Short.MAX_VALUE)
                            .addComponent(diajComboBox, 0, 144, Short.MAX_VALUE)
                            .addComponent(entradaSaidajLabel)
                            .addComponent(entidadejLabel)
                            .addComponent(tipoEntidadejLabel)
                            .addComponent(idArmazenamentojLabel)
                            .addComponent(diajLabel)
                            .addComponent(tipoEntidadejComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(historicojScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(historicojPanelLayout.createSequentialGroup()
                        .addComponent(aplicarFiltrosjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 597, Short.MAX_VALUE)
                        .addComponent(voltarHistoricojButton)))
                .addGap(27, 27, 27))
        );
        historicojPanelLayout.setVerticalGroup(
            historicojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historicojPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(historicojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(historicojPanelLayout.createSequentialGroup()
                        .addComponent(filtrosjLabel)
                        .addGap(22, 22, 22)
                        .addComponent(entradaSaidajLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entradaSaidajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(entidadejLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(entidadejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tipoEntidadejLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoEntidadejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(idArmazenamentojLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idArmazenamentojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(diajLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(historicojScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(historicojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltarHistoricojButton)
                    .addComponent(aplicarFiltrosjButton))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        controlejPanel.add(historicojPanel, "card16");

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
        atualizarTabelaAnimais(idUsuario, tipoAnimal);
    }//GEN-LAST:event_ovelhasjButtonActionPerformed

    private void vacasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vacasjButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(vacasjPanel);
        vacasjPanel.setVisible(true);
        vacasjPanel.setVisible(false);

        String tipoAnimal = "Vaca";
        atualizarTabelaAnimais(idUsuario, tipoAnimal);
    }//GEN-LAST:event_vacasjButtonActionPerformed

    private void porcosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porcosjButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(porcosjPanel);
        porcosjPanel.setVisible(false);
        porcosjPanel.setVisible(true);

        String tipoAnimal = "Porco";
        atualizarTabelaAnimais(idUsuario, tipoAnimal);
    }//GEN-LAST:event_porcosjButtonActionPerformed

    private void galinhasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_galinhasjButtonActionPerformed
        controlejPanel.remove(menuAnimaisjPanel);
        controlejPanel.add(galinhasjPanel);
        galinhasjPanel.setVisible(false);
        galinhasjPanel.setVisible(true);

        String tipoAnimal = "Galinha";
        atualizarTabelaAnimais(idUsuario, tipoAnimal);

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

    private void historicojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historicojButtonActionPerformed
        controlejPanel.removeAll();
        controlejPanel.add(historicojPanel);
        historicojPanel.setVisible(false);
        historicojPanel.setVisible(true);
        atualizarTabelaHistorico(idUsuario);
        idArmazenamentojComboBox.removeAllItems();
        idArmazenamentojComboBox.addItem("<Nenhum>");

        entidadejComboBox.addItem("<Nenhum>");
        entidadejComboBox.addItem("Produto");
        entidadejComboBox.addItem("Galinha");
        entidadejComboBox.addItem("Porco");
        entidadejComboBox.addItem("Ovelha");
        entidadejComboBox.addItem("Vaca");
        String entidade = entidadejComboBox.getSelectedItem().toString();
        tipoEntidadejComboBox.addItem("<Nenhum>");
        carregarComboBoxFiltroTipoEntidade(idUsuario, entidade);

    }//GEN-LAST:event_historicojButtonActionPerformed

    private void produtosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtosjButtonActionPerformed
        controlejPanel.removeAll();
        controlejPanel.add(produtosjPanel);
        produtosjPanel.setVisible(false);
        produtosjPanel.setVisible(true);
        atualizarTabelaProdutos(idUsuario);

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

        AnimalDTO animalDTO = new AnimalDTO(id, idUsuario + "", tipo, nomeRaca, quantidade, valorVenda);

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

        AnimalDTO animalDTO = new AnimalDTO(id, idUsuario + "", tipo, nomeRaca, quantidade, valorVenda);

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

        AnimalDTO animalDTO = new AnimalDTO(id, idUsuario + "", tipo, cor, quantidade, valor);

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

        AnimalDTO animalDTO = new AnimalDTO(id, idUsuario + "", tipo, raca, quantidade, valor);

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
        quantidadeProdutosjSpinner.setValue(0);
        controlejPanel.remove(silosjPanel);
        controlejPanel.add(produtosjPanel);
        produtosjPanel.setVisible(false);
        produtosjPanel.setVisible(true);
    }//GEN-LAST:event_voltarSilosjButtonActionPerformed

    private void salvarSilojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarSilojButtonActionPerformed
        String id = idSilojTextField.getText();
        String qtdProdutos = "0";
        String capacidade = capacidadeSilojSpinner.getValue().toString();

        SiloDTO silo = new SiloDTO(id, idUsuario + "", qtdProdutos, capacidade);

        SiloService siloService = new SiloServiceImpl();

        try {
            siloService.salvar(silo);
            atualizarTabelaSilos(idUsuario);
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

        ProdutoDTO produto = new ProdutoDTO(id, idUsuario + "", nome, quantidade, valor);

        ProdutoService produtoService = new ProdutoServiceImpl();

        try {
            produtoService.salvar(produto);
            cancelarProdutojButtonActionPerformed(evt);
            atualizarTabelaProdutos(idUsuario);
            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
        } catch (Exception erro) {
            erro.printStackTrace();
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
        atualizarTabelaSilos(idUsuario);

    }//GEN-LAST:event_consultarArmazenamentojButtonActionPerformed

    private void entrarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarjButtonActionPerformed
        String usuario = usuariojTextField.getText();
        String senha = senhajTextField.getText();

        UsuarioPersistencia persistencia = new UsuarioPersistenciaImpl();

        int idAcesso = persistencia.login(usuario, senha);

        try {

            if (idAcesso != 0) {
                controlejPanel.removeAll();
                controlejPanel.add(menuPrincipaljPanel);
                menuPrincipaljPanel.setVisible(false);
                menuPrincipaljPanel.setVisible(true);

                idUsuario = idAcesso;
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro);
            throw new RuntimeException("Usuário e/ou senha incoreta!");
        }

    }//GEN-LAST:event_entrarjButtonActionPerformed

    private void confirmarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarjButtonActionPerformed

        String telefone = telefonejFormattedTextField.getText();
        String id = idUsuariojTextField.getText();
        String nome = nomejTextField.getText();
        String cpf = CPFjFormattedTextField.getText();
        String usuario = cadastroUsuariojTextField.getText();
        String senha = cadastroSenhajTextField.getText();

        if (usuario.length() > 40) {
            JOptionPane.showMessageDialog(this, "Nome de usuário muito grande!");
            throw new RuntimeException("Nome de usuário muito grande!");
        } else if (senha.length() > 20) {
            JOptionPane.showMessageDialog(this, "Senha muito grande!");
            throw new RuntimeException("Senha muito grande!");
        }

        UsuarioDTO usuariodto = new UsuarioDTO(id, nome, telefone, cpf, usuario, senha);
        UsuarioService usuarioService = new UsuarioServiceImpl();

        try {
            usuarioService.salvar(usuariodto);
            JOptionPane.showMessageDialog(this, "Cadastro completo! Volte à tela de login e acesse agora");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Por favor preencha todos os campos para finalizar seu cadastro");
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

        String operacao = operacaoProdutojComboBox.getSelectedItem().toString();

        if (operacao.equals("Entrada")) {

            try {

                int quantidade = Integer.parseInt(quantidadeProdutosjSpinner.getValue().toString());

                if (produtojComboBox.getItemCount() != 0 && IDsilojComboBox.getItemCount() != 0) {

                    int idSilo = Integer.parseInt(IDsilojComboBox.getSelectedItem().toString());
                    String tipoProduto = produtojComboBox.getSelectedItem().toString();

                    SiloPersistencia siloPersistencia = new SiloPersistenciaImpl();

                    if (siloPersistencia.entradaSaidaEstoque(idSilo, quantidade, operacao).equals("Entrou")) {
                        ProdutoPersistencia produtoPersistencia = new ProdutoPersistenciaImpl();
                        produtoPersistencia.atualizarEstoque(tipoProduto, quantidade, "Entrou");

                        BancoDeDados bd = new BancoDeDados();

                        try {
                            String sqlHistTransacao = "INSERT INTO tb_historico_transacoes (idUsuario, entrada_saida, entidade, tipo_entidade, quantidade,"
                                    + " id_armazenamento) VALUES ('" + idUsuario + "',  'entrada', 'Produto', '"
                                    + tipoProduto + "', '" + quantidade + "', '" + idSilo + "');";
                            bd.executarQuery(sqlHistTransacao);
                        } catch (Exception erro) {

                        }
                    }

                } else {
                    throw new RuntimeException("Antes de registrar uma entrada ou saída, verifique se você selecionou um silo e"
                            + " um tipo de produto");
                }

                atualizarTabelaProdutos(idUsuario);
                atualizarTabelaSilos(idUsuario);

            } catch (Exception erro) {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(this, erro.getMessage());
            }
        } else {

            try {
                int quantidade = Integer.parseInt(quantidadeProdutosjSpinner.getValue().toString());

                if (produtojComboBox.getItemCount() != 0 && IDsilojComboBox.getItemCount() != 0) {

                    int idSilo = Integer.parseInt(IDsilojComboBox.getSelectedItem().toString());
                    String tipoProduto = produtojComboBox.getSelectedItem().toString();

                    SiloPersistencia siloPersistencia = new SiloPersistenciaImpl();

                    if (siloPersistencia.entradaSaidaEstoque(idSilo, quantidade, operacao).equals("Saiu")) {
                        ProdutoPersistencia produtoPersistencia = new ProdutoPersistenciaImpl();
                        produtoPersistencia.atualizarEstoque(tipoProduto, quantidade, "Saiu");

                        BancoDeDados bd = new BancoDeDados();

                        try {
                            String sqlHistTransacao = "INSERT INTO tb_historico_transacoes (idUsuario, entrada_saida, entidade, tipo_entidade, quantidade,"
                                    + " id_armazenamento) VALUES ('" + idUsuario + "',  'saída', 'Produto', '"
                                    + tipoProduto + "', '" + quantidade + "', '" + idSilo + "');";
                            bd.executarQuery(sqlHistTransacao);
                        } catch (Exception erro) {

                        }
                    }

                } else {
                    throw new RuntimeException("Antes de registrar uma entrada ou saída, verifique"
                            + " se você selecionou um silo e um tipo de produto");
                }

                atualizarTabelaProdutos(idUsuario);
                atualizarTabelaSilos(idUsuario);

            } catch (Exception erro) {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(this, erro.getMessage());
            }
        }
    }//GEN-LAST:event_registrarEntradajButtonActionPerformed

    private void consultarGalinheirosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarGalinheirosjButtonActionPerformed
        controlejPanel.remove(galinhasjPanel);
        controlejPanel.add(galinhasArmazenamentojPanel);
        galinhasArmazenamentojPanel.setVisible(false);
        galinhasArmazenamentojPanel.setVisible(true);

        racaGalinhajTextField.setText("");
        valorGalinhajTextField.setText("");

        carregarComboBoxRacas();
        carregarComboBoxIdAbrigos(idUsuario);

        String tipoAbrigo = "Galinheiro";
        atualizarTabelaAbrigo(idUsuario, tipoAbrigo);


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
        quantidadeGalinhasjSpinner.setValue(0);
    }//GEN-LAST:event_voltarGalinheirosjButtonActionPerformed

    private void salvarGalinheirojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarGalinheirojButtonActionPerformed

        String id = idGalinheirojTextField.getText();
        String tipo = "Galinheiro";
        String qtdAnimais = "0";
        String capacidade = capacidadeGalinheirojSpinner.getValue().toString();

        AbrigoDTO abrigoDTO = new AbrigoDTO(id, idUsuario + "", tipo, qtdAnimais, capacidade);

        //enviando para a service
        AbrigoService service = new AbrigoServiceImpl();
        try {
            service.salvar(abrigoDTO);
            atualizarTabelaAbrigo(idUsuario, tipo);
            carregarComboBoxIdAbrigos(idUsuario);
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

        String operacao = operacaoGalinhajComboBox.getSelectedItem().toString();

        if (operacao.equals("Entrada")) {

            try {

                String tipoAnimal = "Galinha";
                int quantidade = Integer.parseInt(quantidadeGalinhasjSpinner.getValue().toString());
                String tipoAbrigo = "Galinheiro";

                if (racaGalinhajComboBox.getItemCount() != 0 && idGalinheirojComboBox.getItemCount() != 0) {

                    int idGalinheiro = Integer.parseInt(idGalinheirojComboBox.getSelectedItem().toString());
                    String racaAnimal = racaGalinhajComboBox.getSelectedItem().toString();

                    AbrigoPersistencia abrigoPersistencia = new AbrigoPersistenciaImpl();

                    if (abrigoPersistencia.entradaSaidaAnimais(idGalinheiro, quantidade, operacao).equals("Entrou")) {
                        AnimalPersistencia animalPersistencia = new AnimalPersistenciaImpl();
                        animalPersistencia.atualizarQtdAnimais(racaAnimal, quantidade, "Entrou");

                        BancoDeDados bd = new BancoDeDados();

                        try {
                            String sqlHistTransacao = "INSERT INTO tb_historico_transacoes (idUsuario, entrada_saida, entidade, tipo_entidade, quantidade,"
                                    + " id_armazenamento) VALUES ('" + idUsuario + "',  'entrada', '" + tipoAnimal + "', '"
                                    + racaAnimal + "', '" + quantidade + "', '" + idGalinheiro + "');";
                            bd.executarQuery(sqlHistTransacao);
                        } catch (Exception erro) {

                        }
                    }

                } else {
                    throw new RuntimeException("Antes de registrar uma entrada ou saída, verifique se você selecionou um abrigo e uma raça de animal");
                }

                atualizarTabelaRacas(tipoAnimal);
                atualizarTabelaAbrigo(idUsuario, tipoAbrigo);

            } catch (Exception erro) {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(this, erro.getMessage());
            }
        } else {
            String tipoAnimal = "Galinha";
            int quantidade = Integer.parseInt(quantidadeGalinhasjSpinner.getValue().toString());
            String tipoAbrigo = "Galinheiro";

            if (racaGalinhajComboBox.getItemCount() != 0 && idGalinheirojComboBox.getItemCount() != 0) {

                int idGalinheiro = Integer.parseInt(idGalinheirojComboBox.getSelectedItem().toString());
                String racaAnimal = racaGalinhajComboBox.getSelectedItem().toString();

                AbrigoPersistencia abrigoPersistencia = new AbrigoPersistenciaImpl();

                if (abrigoPersistencia.entradaSaidaAnimais(idGalinheiro, quantidade, operacao).equals("Saiu")) {
                    AnimalPersistencia animalPersistencia = new AnimalPersistenciaImpl();
                    animalPersistencia.atualizarQtdAnimais(racaAnimal, quantidade, "Saiu");

                    BancoDeDados bd = new BancoDeDados();

                    try {
                        String sqlHistTransacao = "INSERT INTO tb_historico_transacoes (idUsuario, entrada_saida, entidade, tipo_entidade, quantidade,"
                                + " id_armazenamento) VALUES ('" + idUsuario + "',  'saída', '" + tipoAnimal + "', '"
                                + racaAnimal + "', '" + quantidade + "', '" + idGalinheiro + "');";
                        bd.executarQuery(sqlHistTransacao);
                    } catch (Exception erro) {

                    }
                } else {

                    JOptionPane.showMessageDialog(this, "Falha ao remover animais do abrigo!");
                    throw new RuntimeException("Falha ao remover animais do abrigo!");

                }
            } else {
                JOptionPane.showMessageDialog(this, "Antes de registrar uma entrada ou saída, verifique se você selecionou um abrigo e uma raça de animal");
            }
            atualizarTabelaRacas(tipoAnimal);
            atualizarTabelaAbrigo(idUsuario, tipoAbrigo);
        }
    }//GEN-LAST:event_registrarEntradaGalinhasjButtonActionPerformed

    private void consultarChiqueirosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarChiqueirosjButtonActionPerformed

        controlejPanel.remove(porcosjPanel);
        controlejPanel.add(porcosArmazenamentojPanel);
        porcosArmazenamentojPanel.setVisible(false);
        porcosArmazenamentojPanel.setVisible(true);

        valorPorcojTextField.setText("");
        racaPorcojTextField.setText("");

        carregarComboBoxRacas();
        carregarComboBoxIdAbrigos(idUsuario);

        String tipoAbrigo = "Chiqueiro";
        atualizarTabelaAbrigo(idUsuario, tipoAbrigo);


    }//GEN-LAST:event_consultarChiqueirosjButtonActionPerformed

    private void consultarApriscosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarApriscosjButtonActionPerformed
        controlejPanel.remove(ovelhasjPanel);
        controlejPanel.add(ovelhasArmazenamentojPanel);
        ovelhasArmazenamentojPanel.setVisible(false);
        ovelhasArmazenamentojPanel.setVisible(true);

        valorOvelhajTextField.setText("");
        corOvelhajTextField.setText("");

        carregarComboBoxRacas();
        carregarComboBoxIdAbrigos(idUsuario);

        String tipoAbrigo = "Aprisco";
        atualizarTabelaAbrigo(idUsuario, tipoAbrigo);
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
        carregarComboBoxIdAbrigos(idUsuario);

        String tipoAbrigo = "Curral";
        atualizarTabelaAbrigo(idUsuario, tipoAbrigo);
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
        quantidadePorcosjSpinner.setValue(0);
    }//GEN-LAST:event_voltarChiqueirosjButton1ActionPerformed

    private void salvarChiqueirosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarChiqueirosjButtonActionPerformed
        String id = idChiqueirojTextField.getText();
        String tipo = "Chiqueiro";
        String qtdAnimais = "0";
        String capacidade = capacidadeChiqueirojSpinner.getValue().toString();

        AbrigoDTO abrigoDTO = new AbrigoDTO(id, idUsuario + "", tipo, qtdAnimais, capacidade);

        //enviando para a service
        AbrigoService service = new AbrigoServiceImpl();
        try {
            service.salvar(abrigoDTO);
            atualizarTabelaAbrigo(idUsuario, tipo);
            carregarComboBoxIdAbrigos(idUsuario);
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

        String operacao = operacaoPorcosjComboBox.getSelectedItem().toString();

        if (operacao.equals("Entrada")) {

            try {

                String tipoAnimal = "Porco";
                int quantidade = Integer.parseInt(quantidadePorcosjSpinner.getValue().toString());
                String tipoAbrigo = "Chiqueiro";

                if (racaPorcojComboBox.getItemCount() != 0 && idChiqueirojComboBox.getItemCount() != 0) {

                    int idChiqueiro = Integer.parseInt(idChiqueirojComboBox.getSelectedItem().toString());
                    String racaAnimal = racaPorcojComboBox.getSelectedItem().toString();

                    AbrigoPersistencia abrigoPersistencia = new AbrigoPersistenciaImpl();

                    if (abrigoPersistencia.entradaSaidaAnimais(idChiqueiro, quantidade, operacao).equals("Entrou")) {
                        AnimalPersistencia animalPersistencia = new AnimalPersistenciaImpl();
                        animalPersistencia.atualizarQtdAnimais(racaAnimal, quantidade, "Entrou");

                        BancoDeDados bd = new BancoDeDados();

                        try {
                            String sqlHistTransacao = "INSERT INTO tb_historico_transacoes (idUsuario, entrada_saida, entidade, tipo_entidade, quantidade,"
                                    + " id_armazenamento) VALUES ('" + idUsuario + "',  'entrada', '" + tipoAnimal + "', '"
                                    + racaAnimal + "', '" + quantidade + "', '" + idChiqueiro + "');";
                            bd.executarQuery(sqlHistTransacao);
                        } catch (Exception erro) {

                        }
                    }

                } else {
                    throw new RuntimeException("Antes de registrar uma entrada ou saída, verifique se você selecionou um abrigo e uma raça de animal");
                }

                atualizarTabelaRacas(tipoAnimal);
                atualizarTabelaAbrigo(idUsuario, tipoAbrigo);

            } catch (Exception erro) {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(this, erro.getMessage());
            }
        } else {
            String tipoAnimal = "Porco";
            int quantidade = Integer.parseInt(quantidadePorcosjSpinner.getValue().toString());
            String tipoAbrigo = "Chiqueiro";

            if (racaPorcojComboBox.getItemCount() != 0 && idChiqueirojComboBox.getItemCount() != 0) {

                int idChiqueiro = Integer.parseInt(idChiqueirojComboBox.getSelectedItem().toString());
                String racaAnimal = racaPorcojComboBox.getSelectedItem().toString();

                AbrigoPersistencia abrigoPersistencia = new AbrigoPersistenciaImpl();

                if (abrigoPersistencia.entradaSaidaAnimais(idChiqueiro, quantidade, operacao).equals("Saiu")) {
                    AnimalPersistencia animalPersistencia = new AnimalPersistenciaImpl();
                    animalPersistencia.atualizarQtdAnimais(racaAnimal, quantidade, "Saiu");

                    BancoDeDados bd = new BancoDeDados();

                    try {
                        String sqlHistTransacao = "INSERT INTO tb_historico_transacoes (idUsuario, entrada_saida, entidade, tipo_entidade, quantidade,"
                                + " id_armazenamento) VALUES ('" + idUsuario + "',  'saída', '" + tipoAnimal + "', '"
                                + racaAnimal + "', '" + quantidade + "', '" + idChiqueiro + "');";
                        bd.executarQuery(sqlHistTransacao);
                    } catch (Exception erro) {

                    }
                } else {

                    JOptionPane.showMessageDialog(this, "Falha ao remover animais do abrigo!");
                    throw new RuntimeException("Falha ao remover animais do abrigo!");

                }
            } else {
                JOptionPane.showMessageDialog(this, "Antes de registrar uma entrada ou saída, verifique se você selecionou um abrigo e uma raça de animal");
            }
            atualizarTabelaRacas(tipoAnimal);
            atualizarTabelaAbrigo(idUsuario, tipoAbrigo);
        }
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
        quantidadeOvelhasjSpinner.setValue(0);
    }//GEN-LAST:event_voltarApriscosjButtonActionPerformed

    private void salvarApriscojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarApriscojButtonActionPerformed
        String id = idApriscojTextField.getText();
        String tipo = "Aprisco";
        String qtdAnimais = "0";
        String capacidade = capacidadeApriscojSpinner.getValue().toString();

        AbrigoDTO abrigoDTO = new AbrigoDTO(id, idUsuario + "", tipo, qtdAnimais, capacidade);

        //enviando para a service
        AbrigoService service = new AbrigoServiceImpl();
        try {
            service.salvar(abrigoDTO);
            atualizarTabelaAbrigo(idUsuario, tipo);
            carregarComboBoxIdAbrigos(idUsuario);
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

        String operacao = operacaoOvelhasjComboBox.getSelectedItem().toString();

        if (operacao.equals("Entrada")) {

            try {

                String tipoAnimal = "Ovelha";
                int quantidade = Integer.parseInt(quantidadeOvelhasjSpinner.getValue().toString());
                String tipoAbrigo = "Aprisco";

                if (corOvelhajComboBox.getItemCount() != 0 && idApriscojComboBox.getItemCount() != 0) {

                    int idAprisco = Integer.parseInt(idApriscojComboBox.getSelectedItem().toString());
                    String racaAnimal = corOvelhajComboBox.getSelectedItem().toString();

                    AbrigoPersistencia abrigoPersistencia = new AbrigoPersistenciaImpl();

                    if (abrigoPersistencia.entradaSaidaAnimais(idAprisco, quantidade, operacao).equals("Entrou")) {
                        AnimalPersistencia animalPersistencia = new AnimalPersistenciaImpl();
                        animalPersistencia.atualizarQtdAnimais(racaAnimal, quantidade, "Entrou");

                        BancoDeDados bd = new BancoDeDados();

                        try {
                            String sqlHistTransacao = "INSERT INTO tb_historico_transacoes (idUsuario, entrada_saida, entidade, tipo_entidade, quantidade,"
                                    + " id_armazenamento) VALUES ('" + idUsuario + "',  'entrada', '" + tipoAnimal + "', '"
                                    + racaAnimal + "', '" + quantidade + "', '" + idAprisco + "');";
                            bd.executarQuery(sqlHistTransacao);
                        } catch (Exception erro) {

                        }
                    }

                } else {
                    throw new RuntimeException("Antes de registrar uma entrada ou saída, verifique se você selecionou um abrigo e uma raça de animal");
                }

                atualizarTabelaRacas(tipoAnimal);
                atualizarTabelaAbrigo(idUsuario, tipoAbrigo);

            } catch (Exception erro) {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(this, erro.getMessage());
            }
        } else {
            String tipoAnimal = "Ovelha";
            int quantidade = Integer.parseInt(quantidadeOvelhasjSpinner.getValue().toString());
            String tipoAbrigo = "Aprisco";

            if (corOvelhajComboBox.getItemCount() != 0 && idApriscojComboBox.getItemCount() != 0) {

                int idAprisco = Integer.parseInt(idApriscojComboBox.getSelectedItem().toString());
                String racaAnimal = corOvelhajComboBox.getSelectedItem().toString();

                AbrigoPersistencia abrigoPersistencia = new AbrigoPersistenciaImpl();

                if (abrigoPersistencia.entradaSaidaAnimais(idAprisco, quantidade, operacao).equals("Saiu")) {
                    AnimalPersistencia animalPersistencia = new AnimalPersistenciaImpl();
                    animalPersistencia.atualizarQtdAnimais(racaAnimal, quantidade, "Saiu");

                    BancoDeDados bd = new BancoDeDados();

                    try {
                        String sqlHistTransacao = "INSERT INTO tb_historico_transacoes (idUsuario, entrada_saida, entidade, tipo_entidade, quantidade,"
                                + " id_armazenamento) VALUES ('" + idUsuario + "',  'saída', '" + tipoAnimal + "', '"
                                + racaAnimal + "', '" + quantidade + "', '" + idAprisco + "');";
                        bd.executarQuery(sqlHistTransacao);
                    } catch (Exception erro) {

                    }
                } else {

                    JOptionPane.showMessageDialog(this, "Falha ao remover animais do abrigo!");
                    throw new RuntimeException("Falha ao remover animais do abrigo!");

                }
            } else {
                JOptionPane.showMessageDialog(this, "Antes de registrar uma entrada ou saída, verifique se você selecionou um abrigo e uma raça de animal");
            }
            atualizarTabelaRacas(tipoAnimal);
            atualizarTabelaAbrigo(idUsuario, tipoAbrigo);
        }
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
        quantidadeVacasjSpinner.setValue(0);
    }//GEN-LAST:event_voltarCurraisjButtonActionPerformed

    private void cancelarCurraljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCurraljButtonActionPerformed
        capacidadeCurraljSpinner.setValue(0);
    }//GEN-LAST:event_cancelarCurraljButtonActionPerformed

    private void registrarEntradaVacasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarEntradaVacasjButtonActionPerformed

        String operacao = operacaoVacasjComboBox.getSelectedItem().toString();

        if (operacao.equals("Entrada")) {

            try {

                String tipoAnimal = "Vaca";
                int quantidade = Integer.parseInt(quantidadeVacasjSpinner.getValue().toString());
                String tipoAbrigo = "Curral";

                if (racaVacajComboBox.getItemCount() != 0 && idCurraljComboBox.getItemCount() != 0) {

                    int idCurral = Integer.parseInt(idCurraljComboBox.getSelectedItem().toString());
                    String racaAnimal = racaVacajComboBox.getSelectedItem().toString();

                    AbrigoPersistencia abrigoPersistencia = new AbrigoPersistenciaImpl();

                    if (abrigoPersistencia.entradaSaidaAnimais(idCurral, quantidade, operacao).equals("Entrou")) {
                        AnimalPersistencia animalPersistencia = new AnimalPersistenciaImpl();
                        animalPersistencia.atualizarQtdAnimais(racaAnimal, quantidade, "Entrou");

                        BancoDeDados bd = new BancoDeDados();

                        try {
                            String sqlHistTransacao = "INSERT INTO tb_historico_transacoes (idUsuario, entrada_saida, entidade, tipo_entidade, quantidade,"
                                    + " id_armazenamento) VALUES ('" + idUsuario + "',  'entrada', '" + tipoAnimal + "', '"
                                    + racaAnimal + "', '" + quantidade + "', '" + idCurral + "');";
                            bd.executarQuery(sqlHistTransacao);
                        } catch (Exception erro) {

                        }
                    }

                } else {
                    throw new RuntimeException("Antes de registrar uma entrada ou saída, verifique se você selecionou um abrigo e uma raça de animal");
                }

                atualizarTabelaRacas(tipoAnimal);
                atualizarTabelaAbrigo(idUsuario, tipoAbrigo);

            } catch (Exception erro) {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(this, erro.getMessage());
            }
        } else {
            String tipoAnimal = "Vaca";
            int quantidade = Integer.parseInt(quantidadeVacasjSpinner.getValue().toString());
            String tipoAbrigo = "Curral";

            if (racaVacajComboBox.getItemCount() != 0 && idCurraljComboBox.getItemCount() != 0) {

                int idCurral = Integer.parseInt(idCurraljComboBox.getSelectedItem().toString());
                String racaAnimal = racaVacajComboBox.getSelectedItem().toString();

                AbrigoPersistencia abrigoPersistencia = new AbrigoPersistenciaImpl();

                if (abrigoPersistencia.entradaSaidaAnimais(idCurral, quantidade, operacao).equals("Saiu")) {
                    AnimalPersistencia animalPersistencia = new AnimalPersistenciaImpl();
                    animalPersistencia.atualizarQtdAnimais(racaAnimal, quantidade, "Saiu");

                    BancoDeDados bd = new BancoDeDados();

                    try {
                        String sqlHistTransacao = "INSERT INTO tb_historico_transacoes (idUsuario, entrada_saida, entidade, tipo_entidade, quantidade,"
                                + " id_armazenamento) VALUES ('" + idUsuario + "',  'saída', '" + tipoAnimal + "', '"
                                + racaAnimal + "', '" + quantidade + "', '" + idCurral + "');";
                        bd.executarQuery(sqlHistTransacao);
                    } catch (Exception erro) {

                    }
                } else {

                    JOptionPane.showMessageDialog(this, "Falha ao remover animais do abrigo!");
                    throw new RuntimeException("Falha ao remover animais do abrigo!");

                }
            } else {
                JOptionPane.showMessageDialog(this, "Antes de registrar uma entrada ou saída, verifique se você selecionou um abrigo e uma raça de animal");
            }
            atualizarTabelaRacas(tipoAnimal);
            atualizarTabelaAbrigo(idUsuario, tipoAbrigo);
        }
    }//GEN-LAST:event_registrarEntradaVacasjButtonActionPerformed

    private void salvarCurraljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarCurraljButtonActionPerformed
        String id = idCurraljTextField.getText();
        String tipo = "Curral";
        String qtdAnimais = "0";
        String capacidade = capacidadeCurraljSpinner.getValue().toString();

        AbrigoDTO abrigoDTO = new AbrigoDTO(id, idUsuario + "", tipo, qtdAnimais, capacidade);

        //enviando para a service
        AbrigoService service = new AbrigoServiceImpl();
        try {
            service.salvar(abrigoDTO);
            atualizarTabelaAbrigo(idUsuario, tipo);
            carregarComboBoxIdAbrigos(idUsuario);
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
        quantidadeGalinhasjSpinner.setValue(0);
    }//GEN-LAST:event_cancelarEntradaGalinhasjButtonActionPerformed

    private void cancelarEntradaPorcosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEntradaPorcosjButtonActionPerformed
        quantidadePorcosjSpinner.setValue(0);
    }//GEN-LAST:event_cancelarEntradaPorcosjButtonActionPerformed

    private void cancelarEntradaOvelhasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEntradaOvelhasjButtonActionPerformed
        quantidadeOvelhasjSpinner.setValue(0);
    }//GEN-LAST:event_cancelarEntradaOvelhasjButtonActionPerformed

    private void cancelarEntradaVacasjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEntradaVacasjButtonActionPerformed
        quantidadeVacasjSpinner.setValue(0);
    }//GEN-LAST:event_cancelarEntradaVacasjButtonActionPerformed

    private void cancelarEntradajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEntradajButtonActionPerformed
        quantidadeProdutosjSpinner.setValue(0);
    }//GEN-LAST:event_cancelarEntradajButtonActionPerformed

    private void valorProdutojTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorProdutojTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorProdutojTextFieldActionPerformed

    private void voltarHistoricojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarHistoricojButtonActionPerformed
        controlejPanel.remove(historicojPanel);
        controlejPanel.add(menuPrincipaljPanel);
        menuPrincipaljPanel.setVisible(false);
        menuPrincipaljPanel.setVisible(true);
        entidadejComboBox.removeAllItems();
        tipoEntidadejComboBox.removeAllItems();
    }//GEN-LAST:event_voltarHistoricojButtonActionPerformed

    private void aplicarFiltrosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarFiltrosjButtonActionPerformed
        aplicarFiltrosHistorico(idUsuario);
    }//GEN-LAST:event_aplicarFiltrosjButtonActionPerformed

    private void entidadejComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entidadejComboBoxActionPerformed

        String entidade = entidadejComboBox.getSelectedItem().toString();

        if (entidade.equals("Produto")) {
            carregarComboBoxFiltroTipoEntidade(idUsuario, entidade);
            carregarComboBoxFiltroIdArmazenamentos(idUsuario, entidade);

        } else if (entidade.equals("Galinha") || entidade.equals("Porco") || entidade.equals("Ovelha")
                || entidade.equals("Vaca")) {
            carregarComboBoxFiltroTipoEntidade(idUsuario, entidade);
            carregarComboBoxFiltroIdArmazenamentos(idUsuario, entidade);
        }


    }//GEN-LAST:event_entidadejComboBoxActionPerformed

    private void removerGalinheirojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerGalinheirojButtonActionPerformed

        int total = galinheirosjTable.getSelectedRowCount();
        if (total <= 0) {
            JOptionPane.showMessageDialog(galinheirosjTable, "Por favor selecione as linhas a serem removidas!");
            return;
        }
        try {
            int[] linhas = galinheirosjTable.getSelectedRows();
            AbrigoService service = new AbrigoServiceImpl();
            for (int linha : linhas) {
                String id = (String) galinheirosjTable.getValueAt(linha, 0);
                AbrigoDTO dto = new AbrigoDTO(id, null, null, null, null);
                service.remover(dto);
            }
            JOptionPane.showMessageDialog(galinheirosjTable, "Registros removidos com sucesso!");
            String tipoAbrigo = "Galinheiro";
            atualizarTabelaAbrigo(idUsuario, tipoAbrigo);
            String tipoAnimal = "Galinha";
            atualizarTabelaAnimais(idUsuario, tipoAnimal);
            carregarComboBoxIdAbrigos(idUsuario);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(galinheirosjTable, erro.getMessage());
        }
    }//GEN-LAST:event_removerGalinheirojButtonActionPerformed

    private void removerChiqueirojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerChiqueirojButtonActionPerformed

        int total = chiqueirosjTable.getSelectedRowCount();
        if (total <= 0) {
            JOptionPane.showMessageDialog(chiqueirosjTable, "Por favor selecione as linhas a serem removidas!");
            return;
        }
        try {
            int[] linhas = chiqueirosjTable.getSelectedRows();
            AbrigoService service = new AbrigoServiceImpl();
            for (int linha : linhas) {
                String id = (String) chiqueirosjTable.getValueAt(linha, 0);
                AbrigoDTO dto = new AbrigoDTO(id, null, null, null, null);
                service.remover(dto);
            }
            JOptionPane.showMessageDialog(chiqueirosjTable, "Registros removidos com sucesso!");
            String tipoAbrigo = "Chiqueiro";
            atualizarTabelaAbrigo(idUsuario, tipoAbrigo);
            String tipoAnimal = "Porco";
            atualizarTabelaAnimais(idUsuario, tipoAnimal);
            carregarComboBoxIdAbrigos(idUsuario);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(chiqueirosjTable, erro.getMessage());
        }

    }//GEN-LAST:event_removerChiqueirojButtonActionPerformed

    private void removerApriscojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerApriscojButtonActionPerformed

        int total = apriscosjTable.getSelectedRowCount();
        if (total <= 0) {
            JOptionPane.showMessageDialog(apriscosjTable, "Por favor selecione as linhas a serem removidas!");
            return;
        }
        try {
            int[] linhas = apriscosjTable.getSelectedRows();
            AbrigoService service = new AbrigoServiceImpl();
            for (int linha : linhas) {
                String id = (String) apriscosjTable.getValueAt(linha, 0);
                AbrigoDTO dto = new AbrigoDTO(id, null, null, null, null);
                service.remover(dto);
            }
            JOptionPane.showMessageDialog(apriscosjTable, "Registros removidos com sucesso!");
            String tipoAbrigo = "Aprisco";
            atualizarTabelaAbrigo(idUsuario, tipoAbrigo);
            String tipoAnimal = "Ovelha";
            atualizarTabelaAnimais(idUsuario, tipoAnimal);
            carregarComboBoxIdAbrigos(idUsuario);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(chiqueirosjTable, erro.getMessage());
        }
            }//GEN-LAST:event_removerApriscojButtonActionPerformed

    private void removerCurraljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerCurraljButtonActionPerformed

        int total = curraisjTable.getSelectedRowCount();
        if (total <= 0) {
            JOptionPane.showMessageDialog(curraisjTable, "Por favor selecione as linhas a serem removidas!");
            return;
        }
        try {
            int[] linhas = curraisjTable.getSelectedRows();
            AbrigoService service = new AbrigoServiceImpl();
            for (int linha : linhas) {
                String id = (String) curraisjTable.getValueAt(linha, 0);
                AbrigoDTO dto = new AbrigoDTO(id, null, null, null, null);
                service.remover(dto);
            }
            JOptionPane.showMessageDialog(curraisjTable, "Registros removidos com sucesso!");
            String tipoAbrigo = "Curral";
            atualizarTabelaAbrigo(idUsuario, tipoAbrigo);
            String tipoAnimal = "Vaca";
            atualizarTabelaAnimais(idUsuario, tipoAnimal);
            carregarComboBoxIdAbrigos(idUsuario);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(curraisjTable, erro.getMessage());
        }

    }//GEN-LAST:event_removerCurraljButtonActionPerformed

    private void removerSilojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerSilojButtonActionPerformed
        int total = silosjTable.getSelectedRowCount();
        if (total <= 0) {
            JOptionPane.showMessageDialog(silosjTable, "Por favor selecione as linhas a serem removidas!");
            return;
        }
        try {
            int[] linhas = silosjTable.getSelectedRows();
            SiloService service = new SiloServiceImpl();
            for (int linha : linhas) {
                String id = (String) silosjTable.getValueAt(linha, 0);
                SiloDTO dto = new SiloDTO(id, null, null, null);
                service.remover(dto);
            }
            JOptionPane.showMessageDialog(silosjTable, "Registros removidos com sucesso!");
            atualizarTabelaSilos(idUsuario);
            atualizarTabelaProdutos(idUsuario);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(silosjTable, erro.getMessage());
        }
    }//GEN-LAST:event_removerSilojButtonActionPerformed

    private void removerRacaGalinhajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerRacaGalinhajButtonActionPerformed

        int total = galinhasjTable.getSelectedRowCount();
        if (total <= 0) {
            JOptionPane.showMessageDialog(galinhasjTable, "Por favor selecione as linhas a serem removidas!");
            return;
        }
        try {
            int[] linhas = galinhasjTable.getSelectedRows();
            AnimalService service = new AnimalServiceImpl();
            for (int linha : linhas) {
                String id = (String) galinhasjTable.getValueAt(linha, 0);
                AnimalDTO dto = new AnimalDTO(id, null, null, null, null, null);
                service.remover(dto);
            }
            JOptionPane.showMessageDialog(galinhasjTable, "Registros removidos com sucesso!");

            String tipoAnimal = "Galinha";
            atualizarTabelaRacas(tipoAnimal);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(galinhasjTable, erro.getMessage());
        }
    }//GEN-LAST:event_removerRacaGalinhajButtonActionPerformed

    private void removerRacaPorcojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerRacaPorcojButtonActionPerformed
        int total = porcosjTable.getSelectedRowCount();
        if (total <= 0) {
            JOptionPane.showMessageDialog(porcosjTable, "Por favor selecione as linhas a serem removidas!");
            return;
        }
        try {
            int[] linhas = porcosjTable.getSelectedRows();
            AnimalService service = new AnimalServiceImpl();
            for (int linha : linhas) {
                String id = (String) porcosjTable.getValueAt(linha, 0);
                AnimalDTO dto = new AnimalDTO(id, null, null, null, null, null);
                service.remover(dto);
            }
            JOptionPane.showMessageDialog(porcosjTable, "Registros removidos com sucesso!");

            String tipoAnimal = "Porco";
            atualizarTabelaRacas(tipoAnimal);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(porcosjTable, erro.getMessage());
        }
    }//GEN-LAST:event_removerRacaPorcojButtonActionPerformed

    private void removerRacaOvelhajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerRacaOvelhajButtonActionPerformed
        int total = ovelhasjTable.getSelectedRowCount();
        if (total <= 0) {
            JOptionPane.showMessageDialog(ovelhasjTable, "Por favor selecione as linhas a serem removidas!");
            return;
        }
        try {
            int[] linhas = ovelhasjTable.getSelectedRows();
            AnimalService service = new AnimalServiceImpl();
            for (int linha : linhas) {
                String id = (String) ovelhasjTable.getValueAt(linha, 0);
                AnimalDTO dto = new AnimalDTO(id, null, null, null, null, null);
                service.remover(dto);
            }
            JOptionPane.showMessageDialog(ovelhasjTable, "Registros removidos com sucesso!");

            String tipoAnimal = "Ovelha";
            atualizarTabelaRacas(tipoAnimal);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(ovelhasjTable, erro.getMessage());
        }
    }//GEN-LAST:event_removerRacaOvelhajButtonActionPerformed

    private void removerRacaVacajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerRacaVacajButtonActionPerformed
        int total = vacasjTable.getSelectedRowCount();
        if (total <= 0) {
            JOptionPane.showMessageDialog(vacasjTable, "Por favor selecione as linhas a serem removidas!");
            return;
        }
        try {
            int[] linhas = vacasjTable.getSelectedRows();
            AnimalService service = new AnimalServiceImpl();
            for (int linha : linhas) {
                String id = (String) vacasjTable.getValueAt(linha, 0);
                AnimalDTO dto = new AnimalDTO(id, null, null, null, null, null);
                service.remover(dto);
            }
            JOptionPane.showMessageDialog(vacasjTable, "Registros removidos com sucesso!");

            String tipoAnimal = "Vaca";
            atualizarTabelaRacas(tipoAnimal);
            atualizarTabelaSilos(idUsuario);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(vacasjTable, erro.getMessage());
        }
    }//GEN-LAST:event_removerRacaVacajButtonActionPerformed

    private void removerProdutojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerProdutojButtonActionPerformed
        int total = produtosjTable.getSelectedRowCount();
        if (total <= 0) {
            JOptionPane.showMessageDialog(produtosjTable, "Por favor selecione as linhas a serem removidas!");
            return;
        }
        try {
            int[] linhas = produtosjTable.getSelectedRows();
            ProdutoService service = new ProdutoServiceImpl();
            for (int linha : linhas) {
                String id = (String) produtosjTable.getValueAt(linha, 0);
                ProdutoDTO dto = new ProdutoDTO(id, null, null, null, null);
                service.remover(dto);
            }
            JOptionPane.showMessageDialog(produtosjTable, "Registros removidos com sucesso!");

            atualizarTabelaProdutos(idUsuario);
        } catch (Exception erro) {
            erro.printStackTrace();
            JOptionPane.showMessageDialog(produtosjTable, erro.getMessage());
        }
    }//GEN-LAST:event_removerProdutojButtonActionPerformed

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
    private javax.swing.JComboBox<String> IDsilojComboBox;
    private javax.swing.JLabel abrigosGalinhasjLabel;
    private javax.swing.JLabel abrigosOvelhasjLabel;
    private javax.swing.JLabel abrigosjLabel;
    private javax.swing.JButton animaisjButton;
    private javax.swing.JButton aplicarFiltrosjButton;
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
    private javax.swing.JComboBox<String> corOvelhajComboBox;
    private javax.swing.JLabel corOvelhajLabel;
    private javax.swing.JTextField corOvelhajTextField;
    private javax.swing.JScrollPane curraisjScrollPane;
    private javax.swing.JTable curraisjTable;
    private javax.swing.JComboBox<String> diajComboBox;
    private javax.swing.JLabel diajLabel;
    private javax.swing.JComboBox<String> entidadejComboBox;
    private javax.swing.JLabel entidadejLabel;
    private javax.swing.JComboBox<String> entradaSaidajComboBox;
    private javax.swing.JLabel entradaSaidajLabel;
    private javax.swing.JButton entrarjButton;
    private javax.swing.JLabel filtrosjLabel;
    private javax.swing.JPanel galinhasArmazenamentojPanel;
    private javax.swing.JButton galinhasjButton;
    private javax.swing.JPanel galinhasjPanel;
    private javax.swing.JScrollPane galinhasjScrollPane;
    private javax.swing.JTable galinhasjTable;
    private javax.swing.JScrollPane galinheirosjScrollPane;
    private javax.swing.JTable galinheirosjTable;
    private javax.swing.JButton historicojButton;
    private javax.swing.JPanel historicojPanel;
    private javax.swing.JScrollPane historicojScrollPane;
    private javax.swing.JTable historicojTable;
    private javax.swing.JLabel iDsilojLabel;
    private javax.swing.JComboBox<String> idApriscojComboBox;
    private javax.swing.JLabel idApriscojLabel;
    private javax.swing.JTextField idApriscojTextField;
    private javax.swing.JComboBox<String> idArmazenamentojComboBox;
    private javax.swing.JLabel idArmazenamentojLabel;
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
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JComboBox<String> operacaoGalinhajComboBox;
    private javax.swing.JLabel operacaoGalinhasjLabel;
    private javax.swing.JComboBox<String> operacaoOvelhasjComboBox;
    private javax.swing.JLabel operacaoOvelhasjLabel;
    private javax.swing.JComboBox<String> operacaoPorcosjComboBox;
    private javax.swing.JLabel operacaoPorcosjLabel;
    private javax.swing.JComboBox<String> operacaoProdutojComboBox;
    private javax.swing.JLabel operacaoProdutojLabel;
    private javax.swing.JComboBox<String> operacaoVacasjComboBox;
    private javax.swing.JLabel operacaoVacasjLabel;
    private javax.swing.JPanel ovelhasArmazenamentojPanel;
    private javax.swing.JButton ovelhasjButton;
    private javax.swing.JPanel ovelhasjPanel;
    private javax.swing.JScrollPane ovelhasjScrollPane;
    private javax.swing.JTable ovelhasjTable;
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
    private javax.swing.JLabel quantidadeEntradaOvelhajLabel;
    private javax.swing.JLabel quantidadeEntradaPorcojLabel;
    private javax.swing.JLabel quantidadeEntradaVacajLabel;
    private javax.swing.JLabel quantidadeEntradajLabel;
    private javax.swing.JSpinner quantidadeGalinhasjSpinner;
    private javax.swing.JSpinner quantidadeOvelhasjSpinner;
    private javax.swing.JSpinner quantidadePorcosjSpinner;
    private javax.swing.JSpinner quantidadeProdutosjSpinner;
    private javax.swing.JSpinner quantidadeVacasjSpinner;
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
    private javax.swing.JButton removerApriscojButton;
    private javax.swing.JButton removerChiqueirojButton;
    private javax.swing.JButton removerCurraljButton;
    private javax.swing.JButton removerGalinheirojButton;
    private javax.swing.JButton removerProdutojButton;
    private javax.swing.JButton removerRacaGalinhajButton;
    private javax.swing.JButton removerRacaOvelhajButton;
    private javax.swing.JButton removerRacaPorcojButton;
    private javax.swing.JButton removerRacaVacajButton;
    private javax.swing.JButton removerSilojButton;
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
    private javax.swing.JComboBox<String> tipoEntidadejComboBox;
    private javax.swing.JLabel tipoEntidadejLabel;
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
    private javax.swing.JButton voltarHistoricojButton;
    private javax.swing.JButton voltarMenuAnimaisjButton;
    private javax.swing.JButton voltarOvelhasjButton;
    private javax.swing.JButton voltarPorcosjButton;
    private javax.swing.JButton voltarProdutosjButton;
    private javax.swing.JButton voltarSilosjButton;
    private javax.swing.JButton voltarVacasjButton;
    private javax.swing.JButton voltarjButton;
    // End of variables declaration//GEN-END:variables
}

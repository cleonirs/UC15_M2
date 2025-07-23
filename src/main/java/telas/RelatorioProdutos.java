package telas;

import modelo.Produto;
import jpa.ProdutoJPA;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RelatorioProdutos extends javax.swing.JFrame {

    public RelatorioProdutos() {
        initComponents();
    }

    private DefaultTableModel montarTabela(List<Produto> listaProduto) {
        String[] colunas = {"ID", "Codigo", "Descrição", "Cod Barras", "Categoria", "Origem",
            "NCM", "CEST", "CST Entrada", "CST Saida",
            "Aliq ICMS Entrada", "Aliq ICMS Saida", "Aliq Pis Cofins",
            "Aliq FCP"};
        DefaultTableModel tabela = new DefaultTableModel();
        tabela.setColumnIdentifiers(colunas);

        for (int i = 0; listaProduto.size() > i; i++) {
            Produto produto = listaProduto.get(i);

            String[] linha = {
                Integer.toString(produto.getId()),
                produto.getCodigo(),
                produto.getDescricao(),
                produto.getCodigoBarras(),
                Integer.toString(produto.getCategoriaId()),
                Integer.toString(produto.getOrigemId()),
                Integer.toString(produto.getNcmId()),
                Integer.toString(produto.getCestId()),
                Integer.toString(produto.getCstEntradaId()),
                Integer.toString(produto.getCstSaidaId()),
                Integer.toString(produto.getAliquotaIcmsEntradaId()),
                Integer.toString(produto.getAliquotaIcmsSaidaId()),
                Integer.toString(produto.getAliquotaPisId()),
                Integer.toString(produto.getAliquotaFCPId())
            };
            tabela.addRow(linha);
        }
        return tabela;
    }

    private String getIdItemSelecionado() {
        int posicao = jtableProdutos.getSelectedRow();
        if (posicao == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um item da tabela!");
        }
        return (String) jtableProdutos.getValueAt(posicao, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableProdutos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmenuCadastro = new javax.swing.JMenu();
        jmenuAliquotaFCP = new javax.swing.JMenuItem();
        jmenuAliquotaICMS = new javax.swing.JMenuItem();
        jmenuAliquotaPISCOFINS = new javax.swing.JMenuItem();
        jmenuCategoria = new javax.swing.JMenuItem();
        jmenuCEST = new javax.swing.JMenuItem();
        jmenuCST = new javax.swing.JMenuItem();
        jmenuNCM = new javax.swing.JMenuItem();
        jmenuOrigem = new javax.swing.JMenuItem();
        jmenuProduto = new javax.swing.JMenuItem();
        jmenuRelatorio = new javax.swing.JMenu();
        jmenuProdutos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("RELATORIO DE PRODUTOS");

        btnExcluir.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jtableProdutos.setModel(montarTabela(ProdutoJPA.listar()));
        jScrollPane1.setViewportView(jtableProdutos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 258, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(260, 260, 260))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(btnExcluir)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jmenuCadastro.setText("Cadastro");
        jmenuCadastro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jmenuAliquotaFCP.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jmenuAliquotaFCP.setText("Aliquota FCP");
        jmenuAliquotaFCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuAliquotaFCPActionPerformed(evt);
            }
        });
        jmenuCadastro.add(jmenuAliquotaFCP);

        jmenuAliquotaICMS.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jmenuAliquotaICMS.setText("Aliquota ICMS");
        jmenuAliquotaICMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuAliquotaICMSActionPerformed(evt);
            }
        });
        jmenuCadastro.add(jmenuAliquotaICMS);

        jmenuAliquotaPISCOFINS.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jmenuAliquotaPISCOFINS.setText("Aliquota PIS e COFINS");
        jmenuAliquotaPISCOFINS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuAliquotaPISCOFINSActionPerformed(evt);
            }
        });
        jmenuCadastro.add(jmenuAliquotaPISCOFINS);

        jmenuCategoria.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jmenuCategoria.setText("Categoria");
        jmenuCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuCategoriaActionPerformed(evt);
            }
        });
        jmenuCadastro.add(jmenuCategoria);

        jmenuCEST.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jmenuCEST.setText("CEST");
        jmenuCEST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuCESTActionPerformed(evt);
            }
        });
        jmenuCadastro.add(jmenuCEST);

        jmenuCST.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jmenuCST.setText("CST");
        jmenuCST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuCSTActionPerformed(evt);
            }
        });
        jmenuCadastro.add(jmenuCST);

        jmenuNCM.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jmenuNCM.setText("NCM");
        jmenuNCM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuNCMActionPerformed(evt);
            }
        });
        jmenuCadastro.add(jmenuNCM);

        jmenuOrigem.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jmenuOrigem.setText("Origem");
        jmenuOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuOrigemActionPerformed(evt);
            }
        });
        jmenuCadastro.add(jmenuOrigem);

        jmenuProduto.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jmenuProduto.setText("Produto");
        jmenuProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuProdutoActionPerformed(evt);
            }
        });
        jmenuCadastro.add(jmenuProduto);

        jMenuBar1.add(jmenuCadastro);

        jmenuRelatorio.setText("Relatório");
        jmenuRelatorio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        jmenuProdutos.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jmenuProdutos.setText("Produtos");
        jmenuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuProdutosActionPerformed(evt);
            }
        });
        jmenuRelatorio.add(jmenuProdutos);

        jMenuBar1.add(jmenuRelatorio);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmenuOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuOrigemActionPerformed
        CadastroOrigem cadOrig = new CadastroOrigem();
        cadOrig.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuOrigemActionPerformed

    private void jmenuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuProdutosActionPerformed
        RelatorioProdutos rtProd = new RelatorioProdutos();
        rtProd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuProdutosActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        ProdutoJPA.excluir(Integer.parseInt(getIdItemSelecionado()));
        jtableProdutos.setModel(montarTabela(ProdutoJPA.listar()));
        jScrollPane1.setViewportView(jtableProdutos);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jmenuAliquotaFCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuAliquotaFCPActionPerformed
        CadastroFcp cadFCP = new CadastroFcp();
        cadFCP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuAliquotaFCPActionPerformed

    private void jmenuAliquotaICMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuAliquotaICMSActionPerformed
        CadastroIcms cadICMS = new CadastroIcms();
        cadICMS.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuAliquotaICMSActionPerformed

    private void jmenuAliquotaPISCOFINSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuAliquotaPISCOFINSActionPerformed
        CadastroPis cadPis = new CadastroPis();
        cadPis.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuAliquotaPISCOFINSActionPerformed

    private void jmenuCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuCategoriaActionPerformed
        CadastroCategoria cadCat = new CadastroCategoria();
        cadCat.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuCategoriaActionPerformed

    private void jmenuCESTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuCESTActionPerformed
        CadastroCest cadCest = new CadastroCest();
        cadCest.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuCESTActionPerformed

    private void jmenuCSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuCSTActionPerformed
        CadastroCst cadCst = new CadastroCst();
        cadCst.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuCSTActionPerformed

    private void jmenuNCMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuNCMActionPerformed
        CadastroNcm cadNcm = new CadastroNcm();
        cadNcm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuNCMActionPerformed

    private void jmenuProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuProdutoActionPerformed
        CadastroProduto cadProd = new CadastroProduto();
        cadProd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jmenuAliquotaFCP;
    private javax.swing.JMenuItem jmenuAliquotaICMS;
    private javax.swing.JMenuItem jmenuAliquotaPISCOFINS;
    private javax.swing.JMenuItem jmenuCEST;
    private javax.swing.JMenuItem jmenuCST;
    private javax.swing.JMenu jmenuCadastro;
    private javax.swing.JMenuItem jmenuCategoria;
    private javax.swing.JMenuItem jmenuNCM;
    private javax.swing.JMenuItem jmenuOrigem;
    private javax.swing.JMenuItem jmenuProduto;
    private javax.swing.JMenuItem jmenuProdutos;
    private javax.swing.JMenu jmenuRelatorio;
    private javax.swing.JTable jtableProdutos;
    // End of variables declaration//GEN-END:variables
}

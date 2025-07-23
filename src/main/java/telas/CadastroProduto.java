package telas;

import modelo.Produto;
import jpa.ProdutoJPA;
import javax.swing.JOptionPane;

public class CadastroProduto extends javax.swing.JFrame {

    public CadastroProduto() {
        initComponents();
    }

    private Produto produtoEdicao = null;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodBarras = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtOrigem = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNcm = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCest = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCstEntrada = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCstSaida = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIcmsEntrada = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtIcmsSaida = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPisCofins = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtFcp = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
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
        jLabel1.setText("CADASTRO DE PRODUTO");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel2.setText("Codigo");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setText("Código de Barras");

        txtCodBarras.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtCodBarras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCodigo.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtCodigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel4.setText("Descrição");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel5.setText("Origem");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel6.setText("Categoria");

        txtDescricao.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtDescricao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtOrigem.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtOrigem.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtCategoria.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtCategoria.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel7.setText("NCM");

        txtNcm.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtNcm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel8.setText("CEST");

        txtCest.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtCest.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel9.setText("CST entrada");

        txtCstEntrada.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtCstEntrada.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel10.setText("CST Saida");

        txtCstSaida.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtCstSaida.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel11.setText("ICMS entrada");

        txtIcmsEntrada.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtIcmsEntrada.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel12.setText("ICMS saida");

        txtIcmsSaida.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtIcmsSaida.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel13.setText("PIS COFINS");

        txtPisCofins.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtPisCofins.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel14.setText("FCP");

        txtFcp.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtFcp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSalvar.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPisCofins, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(txtIcmsEntrada))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtFcp, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(238, 238, 238))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtCstEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(txtNcm, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCategoria, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(238, 238, 238))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtCstSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtCest, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtIcmsSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(30, 30, 30)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo)
                            .addComponent(txtDescricao))))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(249, 249, 249))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrigem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtNcm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCstSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtCstEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIcmsSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(txtIcmsEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFcp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(txtPisCofins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(30, 30, 30))
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
            .addGap(0, 836, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 8, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 11, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 11, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmenuOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuOrigemActionPerformed
        CadastroOrigem cadOrig = new CadastroOrigem();
        cadOrig.setVisible(true);
    }//GEN-LAST:event_jmenuOrigemActionPerformed

    private void jmenuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuProdutosActionPerformed
        RelatorioProdutos rtProd = new RelatorioProdutos();
        rtProd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmenuProdutosActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Produto produto = new Produto();
        produto.setCodigo(txtCodigo.getText());
        produto.setDescricao(txtDescricao.getText());
        produto.setCodigoBarras(txtCodBarras.getText());
        produto.setCategoriaId(Integer.parseInt(txtCategoria.getText()));
        produto.setOrigemId(Integer.parseInt(txtOrigem.getText()));
        produto.setNcmId(Integer.parseInt(txtNcm.getText()));
        produto.setCestId(Integer.parseInt(txtCest.getText()));
        produto.setCstEntradaId(Integer.parseInt(txtCstEntrada.getText()));
        produto.setCstSaidaId(Integer.parseInt(txtCstSaida.getText()));
        produto.setAliquotaIcmsEntradaId(Integer.parseInt(txtIcmsEntrada.getText()));
        produto.setAliquotaIcmsSaidaId(Integer.parseInt(txtIcmsSaida.getText()));
        produto.setAliquotaPisId(Integer.parseInt(txtPisCofins.getText()));
        produto.setAliquotaFCPId(Integer.parseInt(txtFcp.getText()));

        ProdutoJPA.cadastrar(produto);
        JOptionPane.showMessageDialog(null, "Produto cadastrada com sucesso!");

        txtCodigo.setText("");
        txtDescricao.setText("");
        txtCodBarras.setText("");
        txtCategoria.setText("");
        txtOrigem.setText("");
        txtNcm.setText("");
        txtCest.setText("");
        txtCstEntrada.setText("");
        txtCstSaida.setText("");
        txtIcmsEntrada.setText("");
        txtIcmsSaida.setText("");
        txtPisCofins.setText("");
        txtFcp.setText("");
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCest;
    private javax.swing.JTextField txtCodBarras;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCstEntrada;
    private javax.swing.JTextField txtCstSaida;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtFcp;
    private javax.swing.JTextField txtIcmsEntrada;
    private javax.swing.JTextField txtIcmsSaida;
    private javax.swing.JTextField txtNcm;
    private javax.swing.JTextField txtOrigem;
    private javax.swing.JTextField txtPisCofins;
    // End of variables declaration//GEN-END:variables
}

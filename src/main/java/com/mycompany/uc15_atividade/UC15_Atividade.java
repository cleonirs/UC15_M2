package com.mycompany.uc15_atividade;

import util.JPAUtil;

public class UC15_Atividade {

    public static void main(String[] args) {
        JPAUtil.conectar();
        JPAUtil.desconectar();
    }
}

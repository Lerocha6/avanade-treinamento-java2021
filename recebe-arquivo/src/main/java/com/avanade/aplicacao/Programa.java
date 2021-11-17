package com.avanade.aplicacao;

import com.avanade.aplicacao.servicos.ServicoProcessarArquivo;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j @Builder
public class Programa {

   public static void main (String[] args){

        if (args.length == 0) {
            System.out.println("Parâmetro caminho obrigatório");
            System.out.println("Uso: ");
            System.out.println("java Programa [CAMINHO]");
            System.exit(-1);
            return;
        }
        log.info("Iniciando aplicação...");
        Programa programa = new Programa();
        programa.iniciar(args[0]);

    }



    public void iniciar(String caminhoDirEntrada) {
        ServicoProcessarArquivo servico = new ServicoProcessarArquivo(caminhoDirEntrada);
        servico.executar();
    }
}

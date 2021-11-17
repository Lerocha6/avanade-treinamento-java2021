package com.avanade.aplicacao;

import com.avanade.aplicacao.servicos.ServicoProcessarArquivo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;

public class Programa {

    public static void main (String[] args){

        if (args.length == 0) {
            System.out.println("Parâmetro caminho obrigatório");
            System.out.println("Uso: ");
            System.out.println("java Programa [CAMINHO]");
            System.exit(-1);
            return;
        }

        System.out.println("Iniciando aplicação...");
        Programa programa = new Programa();
        programa.iniciar(args[0]);

    }



    public void iniciar(String caminhoDirEntrada) {
        ServicoProcessarArquivo servico = new ServicoProcessarArquivo(caminhoDirEntrada);
        servico.executar();
    }
}

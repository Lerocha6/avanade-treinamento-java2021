package com.avanade.aplicacao.servicos;

import com.avanade.aplicacao.Programa;
import com.avanade.aplicacao.validacoes.ValidarArquivos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class ServicoProcessarArquivo {

    private static final Logger LOG = LoggerFactory.getLogger(ServicoProcessarArquivo.class);

    private final Path dirEntrada;
    private final List<String> lstArquivos;

    public ServicoProcessarArquivo (String caminhoDirEntrada) {
        ValidarArquivos validacao = new ValidarArquivos();
        dirEntrada = validacao.validarDirEntrada(caminhoDirEntrada);
        lstArquivos = validacao.getLstArquivos();
    }

    public void executar() {
        if (lstArquivos.isEmpty()){
           LOG.info("Não há arquivos para processamento!");
           return;
        }

      ServicoLerArquivo servico = new ServicoLerArquivo();
       lstArquivos.forEach((arquivo) ->{
           String caminhoArquivo = dirEntrada.toString() + File.separator + arquivo;
           LOG.info("Processando arquivo {}", caminhoArquivo);

           List<String> linhas = servico.executar(caminhoArquivo);
           if (linhas.isEmpty()){
               LOG.info("Não há registros no arquivo {}", caminhoArquivo);
               return;
           }

           LOG.info("Encontradas [{}] linhas no arquivo {}",linhas.size(), caminhoArquivo);

        });

    }
}

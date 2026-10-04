package br.com.nonnapizza.dao;

import br.com.nonnapizza.model.Produtos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProdutosDao {

    public void inserirProduto(Produtos produtos){
        String SQL = "INSERT INTO PRODUTOS(NOME, TIPO, VALOR, DESCRICAO) VALUES (?, ?, ?, ?);";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, produtos.getNome());
            preparedStatement.setString(2, produtos.getTipo());
            preparedStatement.setFloat(3, produtos.getValor());
            preparedStatement.setString(4, produtos.getDescricao());

            preparedStatement.execute();

            System.out.println("Inserido com sucesso!");

            connection.close();

        }catch (Exception e){
            System.out.println("Erro ao inserir produto!" + e.getMessage());
        }
    }
}

package br.com.nonnapizza.dao;

import br.com.nonnapizza.model.Endereco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EnderecoDao {

    public void criarEndereco(Endereco endereco) {
            String SQL = "INSERT INTO ENDERECO (RUA, NUMERO, COMPLEMENTO, CEP, BAIRRO, CIDADE) VALUES (?,?,?,?,?,?)";

            try {

                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

                PreparedStatement preparedStatement = connection.prepareStatement(SQL);

                preparedStatement.setString(1, endereco.getRua());
                preparedStatement.setString(2, endereco.getNumero());
                preparedStatement.setString(3, endereco.getComplemento());
                preparedStatement.setString(4, endereco.getCep());
                preparedStatement.setString(5, endereco.getBairro());
                preparedStatement.setString(6, endereco.getCidade());
                preparedStatement.execute();

                System.out.println("Sucesso ao criar o endereço");

                connection.close();

            }catch (Exception e){
                System.out.println("Falha ao conectar no banco de dados" + e.getMessage());
            }
    }
}

package br.com.nonnapizza.dao;

import br.com.nonnapizza.model.Pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PizzaDao {

    public void inserirPizza(Pizza pizza){
        String SQL = "INSERT INTO PIZZAS(SABOR, TIPO, VALOR, DESCRICAO) VALUES (?, ?, ?, ?);";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            System.out.println("Conectado com sucesso!");

            preparedStatement.setString(1, pizza.getSabor());
            preparedStatement.setString(2, pizza.getTipo());
            preparedStatement.setFloat(3, pizza.getValor());
            preparedStatement.setString(4, pizza.getDescricao());

            preparedStatement.execute();

            System.out.println("Pizza criada com sucesso!");

            connection.close();
        }
        catch (Exception e){
            System.out.println("Erro ao inserir Pizza: " + e.getMessage());
        }
    }

    public List<Pizza> listarPizzas(){
        String SQL = "SELECT * FROM PIZZAS";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Pizza> pizzas = new ArrayList<>();

            while (resultSet.next()) {

                Pizza pizza = new Pizza();

                String sabores = resultSet.getString("sabor");
                pizza.setSabor(sabores);

                pizzas.add(pizza);
            }

            System.out.println("Sucesso ao consultar Pizzas!");
            connection.close();

            return pizzas;
        }catch (Exception e){
            System.out.println("Erro ao listar pizzas: " + e.getMessage());
        }

        return Collections.emptyList();
    }
}

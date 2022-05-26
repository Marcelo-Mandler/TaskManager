/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Project;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class ProjectController {
    public void save(Project project) throws ClassNotFoundException {
        String sql = "INSERT INTO projects (name, description, creation_date, "
                + "update_date) VALUES (?, ?, ?, ?)";
        
        Connection connection = null;       
        PreparedStatement statement = null;
        
        try {
            //criando conexão com banco de dados tabela projects
            connection = ConnectionFactory.getConnection();
            
            //preparando a query
            statement = connection.prepareStatement(sql);
            
            //setando os valores 
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreationDate().getTime()));
            statement.setDate(4, new Date(project.getUpdateDate().getTime()));
            
            //executando a query
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o projeto " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
    }
        
    }
    
    public void update(Project project) throws ClassNotFoundException {
        String sql = "UPDATE projects SET "
                + "name = ?, "
                + "description = ?, "
                + "creation_date = ?, "
                + "update_date = ?, "
                + "WHERE id = ? ";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreationDate().getTime()));
            statement.setDate(4, new Date(project.getUpdateDate().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o projeto " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void deleteById(int projectId) throws ClassNotFoundException {
        String sql = "DELETE FROM projects WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //criação da conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //preparando a query
            statement = connection.prepareStatement(sql);
            
            //setando valor na query
            statement.setInt(1, projectId);
            
            //executando a query
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar o projeto " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public List<Project> getAll() throws ClassNotFoundException {
        String sql = "SELECT * FROM projects";
        
        //lista de projetos que será devolvida quando a chamada do método acontecer
        List<Project> projects = new ArrayList<Project>();
         
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
         
        try {
            //criação da conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //preparando a query
            statement = connection.prepareStatement(sql);
            
            //valor retornado pela execução da query
            resultSet = statement.executeQuery();
            
            //enquanto houver valor a ser percorrido no resultSet
            while(resultSet.next()){
                Project projeto = new Project();
                projeto.setName(resultSet.getString("name"));
                projeto.setDescription(resultSet.getString("description"));
                projeto.setCreationDate(resultSet.getDate("creation_date"));
                projeto.setUpdateDate(resultSet.getDate("update_date"));
                projeto.setId(resultSet.getInt("id"));
                
                projects.add(projeto);
                
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir o projeto " + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        //retorna a lista de projetos que foi criado e carregado no banco de dados
        return projects;
    }
}

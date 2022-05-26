/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Task;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcelo
 */
public class TaskController {
    public void save(Task task) {
        String sql = "INSERT INTO tasks (idProject, name, description, "
                + "completed, notes, deadline, creation_date, update_date)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new java.sql.Date(task.getDeadLine().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreationDate().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdateDate().getTime()));
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a tarefa " + ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
           
    }
    }
    
    public void update(Task task) {
        String sql = "UPDATE tasks SET idProject = ?, name = ?, description = ?,"
                + " completed = ?, notes = ?, deadline = ?, creation_date = ?, "
                + "update_date = ? WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores do statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new java.sql.Date(task.getDeadLine().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreationDate().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdateDate().getTime()));
            statement.setInt(9, task.getId());
            
            //Executando a query
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar a tarefa " + ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
           
    }
    }
    
    public void removeById(int taskId) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Criação da conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores
            statement.setInt(1, taskId);
            
            //Executando a query
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar a tarefa " + ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }
    }
    
    public List<Task> getAll(int id) {
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        
        //lista de tarefa que será devolvida quando a chamada do método acontecer
        List<Task> tasks = new ArrayList();
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            //criação da conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //preparando a query
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, id);
            //valor retornado pela execução da query
            resultSet = statement.executeQuery();
            
            //enquanto houver valor a ser percorrido no resultSet
            while (resultSet.next()) {
                Task tarefa = new Task();
                tarefa.setId(resultSet.getInt("id"));
                tarefa.setIdProject(resultSet.getInt("idProject"));
                tarefa.setName(resultSet.getString("name"));
                tarefa.setDescription(resultSet.getString("description"));
                tarefa.setCompleted(resultSet.getBoolean("completed"));
                tarefa.setNotes(resultSet.getString("notes"));
                tarefa.setDeadLine(resultSet.getDate("deadline"));
                tarefa.setCreationDate(resultSet.getDate("creation_date"));
                tarefa.setUpdateDate(resultSet.getDate("update_date"));
                
                tasks.add(tarefa);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar as tarefas." + ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(statement != null) {
                    statement.close();
                }
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
    }
        //retorna a lista de tarefa que foi criada e carregada do banco de dados
        return tasks;
    }

    /*public List<Task> getByProjectId(int id) {
        String sql = "SELECT * FROM tasks WHERW idProject = ?";

        List<Task> tasks = new ArrayList();

        Connection connection = null;
        PreparedStatement statement = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Task task = new Task();
                
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setCompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadLine(resultSet.getDate("deadline"));
                task.setCreationDate(resultSet.getDate("creation_date"));
                task.setUpdateDate(resultSet.getDate("update_date"));
                
                tasks.add(task);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar as tarefas", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }  
        return tasks;
        }*/
        
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controller.ProjectController;
import Controller.TaskController;
import Model.Project;
import Model.Task;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
       
        ProjectController projectController = new ProjectController();
        Project project = new Project();
        project.setName("Nome do projeto testado2.");
        project.setDescription("Descrição do projeto desenvolvido.");
        projectController.save(project);
        
        project.setName("Mudar o noe do projeto.");
        projectController.update(project);
        
        List<Project> projects = projectController.getAll();
        System.out.println("Total de projeto: "+ projects.size());
        
       /* TaskController taskController = new TaskController();
        Task task = new Task();
        
        task.setIdProject(1);
        task.setName("Criar telas de aplicação.");
        task.setDescription("Criando as telas de aplicação do Task Manager App.");
        task.setNotes("Sem notas");
        task.setCompleted(false);
        task.setDeadLine(new Date());
        
        taskController.save(task);
        
        task.setName("Alterar tela de aplicação.");
        taskController.update(task);
        List<Task> tasks = taskController.getAll();
        
        System.out.println("Total de tarefas: "+ tasks.size());*/
        
    }
    
}

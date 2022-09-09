package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author Ana�sa
 */
public class TaskController {
    
     public void save(Task task) {
         //
     String sql = "INSERT INTO tasks(idProject"
             + "name,"
             + "description,"
             + "completed," 
             + "notes,"
             + "deadline,"
             + "createdAt," 
             + "updatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

     Connection connection = null;
     PreparedStatement statement = null; 
         
            try {
            connection  = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);    
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7,new Date(task.getCreatedAt().getTime()));
            statement.setDate(8,new Date(task.getUpdatedAt().getTime()));
            statement.execute();
                   
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa " 
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection,statement);
            }
     }
     
           
        }
/*            
       public void update(Task task) {
       String sql = "UPDATE tasks SET"
+ "idProject = ?, "
+ "name = ?, "
+ "description = ?, "
+ "notes = ?, "
+ "completed = ?, "
+ "deadline = ?, "
+ "createdAt = ?, "
+ "updatedAt = ? "
+ "WHERE id = ?";

Connection connection= null;
PreparedStatement statement = null;

try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setInt     (1, task.getIdProject());
            statement.setString  (1, task.getName());
            statement.setString  (1, task.getDescription());
            statement.setString  (1, task.getNotes());
            statement.setBoolean (1, task.isCompleted());
            statement.setDate    (1, new Date(task.getDeadline().getTime()));            
            statement.setDate    (1, new Date(task.getCreatedAt().getTime()));
            statement.setDate    (1, new Date(task.getUpdatedAt().getTime()));
            statement.execute();

        } catch (Exception ex) {
        throw new RuntimeException("Erro ao deletar a tarefa" + ex.getMessage(), ex);

}
          
     public void removeById(int taskId) throws SQLException{         
        String sql = "DELETE FROM tasks WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a tarefa" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection,statement);
        }

    }
    

     public List<Task> getAll(int idProject){
         
        String sql = "SELECT * FROM tasks WHERW idProject = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rset = null;
        

        List<Task> tasks = new ArrayList<Task>();

        try {
            connection  = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);    
            statement.setInt(1, IdProject);
            statement.executeQuery();
         
        while(resulteSet.next()){

         Task task = new Task();
         task.setId(resultSet.getInt("id"));
         task.setIdProject(resultSet.getInt("IdProject"));
         task.setName(resultSet.getString("name"));
         task.setDescription(resultSet.getString("description"));
         task.setNotes(resultSet.getString("notes"));
         task.setIsCompleted(resultSet.getBoolean("completed"));
         task.setDeadline(resultSet.getDate("deadline"));
         task.setCreatedAt(resultSet.getDate("createdAt"));
         task.setUpdatedAt(resultSet.getDate("updatedAt"));
         tasks.add(task);
                   
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a tarefa " 
                    + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection,statement,resultSet);
            }

     return tasks;
}
*/

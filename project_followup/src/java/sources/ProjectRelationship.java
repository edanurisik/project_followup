/**
 *
 * @author edanur
 */

package sources;

import java.sql.Date;


public class ProjectRelationship {
    public int id;
    public int user_id;
    public int project_id;

    public ProjectRelationship() {
    }

    public ProjectRelationship(int id, int project_id, int user_id) {
        this.id = id;
        this.user_id = user_id;
        this.project_id = project_id;
       
    }

    public ProjectRelationship(int project_id, int user_id) {
        this.user_id = user_id;
        this.project_id = project_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getProjectId() {
        return project_id;
    }

    public void setProjectId(int project_id) {
        this.project_id = project_id;
    }

   
    

}

/**
 *
 * @author edanur
 */

package sources;

import java.sql.Date;


public class Project {
    public int id;
    public String subject;
    public String description;
    public Date start_date;
    public Date end_date;

    public Project() {
    }

    public Project(int project_id, String subject, String description, Date start_date, Date end_date) {
        this.id = project_id;
        this.subject = subject;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Project(String subject, String description, Date start_date, Date end_date) {
        this.subject = subject;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int project_id) {
        this.id = project_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Project{" + "project_id=" + id + ", subject=" + subject + ", description=" + description + ", start_date=" + start_date + ", end_date=" + end_date + '}';
    }

   
    

}

package kata6;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ToDo {

    public int id;
    public String todo;
    public boolean completed;
    public int userid;
    
    public ToDo(){
    }

    @Override
    public String toString(){
        return "ToDo{ id = "+ id + ", todo = " + todo + ", completed = " + completed +  ", userid = " + userid +"}";
    }

}
